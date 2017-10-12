//
// Created by stijn on 31-3-17.
//

#include "MyVisitor.h"
#include "Helpers.h"
#include "Commands.h"
#include <iostream>
#include <unistd.h>
#include <cstring>
#include <regex>
#include <fcntl.h>
#include <string>
#include <sys/wait.h>
using namespace std;

#define PIPE_READ 0
#define PIPE_WRITE 1

MyVisitor::MyVisitor() {}
antlrcpp::Any MyVisitor::visitSimplecommand(ShellGrammarParser::SimplecommandContext *ctx) {

    //if there are parameters, lets put them in the array
    totalArgumentSize = (int) ctx->test.size() + 2;
    char* finalArguments[totalArgumentSize];

    string temporaryArguments[totalArgumentSize];

    //make some strings out of it
    temporaryArguments[0] = ctx->programName->getText();
    for (int i = 0; i < ctx->test.size(); ++i) {
        temporaryArguments[i + 1] = ctx->test.at(i)->getText();
    }

    //build it into a char* array
    for (int j = 0; j < totalArgumentSize; ++j) {
        if(temporaryArguments[j] == "") {
            finalArguments[j] = NULL;
        } else {
            finalArguments[j] = (char*) temporaryArguments[j].c_str();
        }
    }

    //make a fork
    pid_t pid = fork();

    //if there is an ioredirect we'll visit that
    if (ctx->ior != nullptr){
        this->ct = ctx;
        visitIoredirect(ctx->ior);
    }
    //if there is not an ioredirect the user probably wants to use another function or launch a program
    else {
        if (ctx->programName->getText() == "clear") { //clear commandline
            Commands::clearCommandLine();
        }
        else if (ctx->programName->getText() == "exit") { //exit the shell
            Commands::exitCommandLine();
        }
        else if(ctx->programName->getText() == "cd") { //change directory
            Commands::changeDirectory(pid, ctx->test);
        }
        else { //execute a program
            Commands::executeBinary(pid, finalArguments);
        }
    }

    return ShellGrammarBaseVisitor::visitSimplecommand(ctx);
}

antlrcpp::Any MyVisitor::visitIoredirect(ShellGrammarParser::IoredirectContext *ctx) {
    pid_t pid = fork();

    if (pid == 0) {
        if (ctx->op->getText() == ">") {
            LaunchIORedirection(pid, ctx, STDOUT_FILENO, O_CREAT | O_APPEND | O_WRONLY);
        }
        else if (ctx->op->getText() == ">>") {
            LaunchIORedirection(pid, ctx, STDOUT_FILENO, O_CREAT | O_TRUNC | O_WRONLY);
        }
        else if (ctx->op->getText() == "2>") {
            LaunchIORedirection(pid, ctx, STDERR_FILENO, O_CREAT | O_APPEND | O_WRONLY);
        }
        else if (ctx->op->getText() == "<<") {
            LaunchIORedirection(pid, ctx, STDIN_FILENO, O_CREAT | O_APPEND | O_RDONLY);
        }
        else if (ctx->op->getText() == "<") {
            LaunchIORedirection(pid, ctx, STDIN_FILENO, O_CREAT | O_TRUNC | O_RDONLY);
        }
        else {
            perror("Incorrect IORedirect");
        }
    }
    else {
        int stat;
        waitpid(pid, &stat, 0);
    }

    return ShellGrammarBaseVisitor::visitIoredirect(ctx);
}

antlrcpp::Any MyVisitor::visitPipecommand(ShellGrammarParser::PipecommandContext *ctx) {
    int stdinpipe[2];
    int stdoutpipe[2];
    pid_t pid;

    if (pipe(stdinpipe) < 0) {
        perror("allocating pipe for child input redirect");
        return -1;
    }

    if (pipe(stdoutpipe) < 0) {
        close(stdinpipe[PIPE_READ]);
        close(stdinpipe[PIPE_WRITE]);
        return -1;
    }

    pid = fork();

    if(pid == 0){
        // redirect stdin
        if (dup2(stdinpipe[PIPE_READ], STDIN_FILENO) == -1 || dup2(stdoutpipe[PIPE_WRITE], STDOUT_FILENO) == -1 || dup2(stdoutpipe[PIPE_WRITE], STDERR_FILENO) == -1) {
            perror("redirecting stdin");
            return -1;
        }

        // all these are for use by parent only
        close(stdinpipe[PIPE_READ]);
        close(stdinpipe[PIPE_WRITE]);
        close(stdoutpipe[PIPE_READ]);
        close(stdoutpipe[PIPE_WRITE]);

        visitSimplecommand(ctx->rightc);

    } else if (pid > 0) {
        close(stdinpipe[PIPE_READ]);
        close(stdoutpipe[PIPE_WRITE]);
        //parent
        if(ctx->pipec != nullptr){
            visitPipecommand(ctx->pipec);
        }else if(ctx->leftc != nullptr){
            visitSimplecommand(ctx->leftc);
        }else{
            printf("Incorrect pipe\n");
        }
        close(stdinpipe[PIPE_WRITE]);
        close(stdoutpipe[PIPE_READ]);
    } else {
        close(stdinpipe[PIPE_READ]);
        close(stdinpipe[PIPE_WRITE]);
        close(stdoutpipe[PIPE_READ]);
        close(stdoutpipe[PIPE_WRITE]);
    }

    return ShellGrammarBaseVisitor::visitPipecommand(ctx);
}

void MyVisitor::LaunchIORedirection(pid_t pid, ShellGrammarParser::IoredirectContext *ctx, int type, int _flags, ...) {
    int fd = open(ctx->path->getText().c_str(), _flags);

    dup2(fd, type);

    //get arguments
    char* finalArguments[totalArgumentSize];
    string temporaryArguments[totalArgumentSize];

    //make some strings out of it
    temporaryArguments[0] = ct->programName->getText();
    for (int i = 0; i < ct->test.size(); ++i) {
        temporaryArguments[i + 1] = ct->test.at(i)->getText();
    }

    //build it into a char* array
    for (int j = 0; j < totalArgumentSize; ++j) {
        if(temporaryArguments[j] == "") {
            finalArguments[j] = NULL;
        } else {
            finalArguments[j] = (char*) temporaryArguments[j].c_str();
        }
    }

    Commands::executeBinary(pid, finalArguments);

    close(fd);
}
