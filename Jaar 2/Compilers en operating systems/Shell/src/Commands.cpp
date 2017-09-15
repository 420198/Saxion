//
// Created by Frank Grevelink on 23/06/2017.
//
#include <iostream>
#include <unistd.h>
#include <cstring>
#include <regex>
#include <fcntl.h>
#include <string>
#include <pwd.h>
#include <sys/wait.h>

using namespace std;

#include "Commands.h"

/**
 * Changes the directory, goes to the home folder when no folder is given
 * @param pid
 * @param folder
 */
void Commands::changeDirectory(int pid, std::vector<antlr4::Token * > vector) {

    char* folder;
    if(vector.size() > 0){
        folder = (char*) vector.at(0)->getText().c_str();
    } else { //when there is no folder, go to home directory
        struct passwd *pw = getpwuid(getuid());
        folder = pw->pw_dir;
    }

    if (pid == 0) {
        if(chdir(folder) != 0){
            perror("Directory not found");
        }
    } else if (pid > 0) {
        int status;
        waitpid(pid, &status, 0);
        if (status != 0) {
            perror("Something went wrong");
        }
    } else {
        perror("PID failed");
        exit(1);
    }
}

/**
 * Clears the commandline
 */
void Commands::clearCommandLine() {
    std::cout << "\x1B[2J\x1B[H";
}

/**
 * Exits the commandline with code 0
 */
void Commands::exitCommandLine() {
    exit(0);
}

/**
 * Executes a binary file from a folder or in PATH
 * @param pid
 * @param arguments
 */
void Commands::executeBinary(int pid, char **arguments) {
    if (pid == 0) {
        if (execvp(arguments[0], arguments) == -1) {
            std::cerr << "Executed program with an error" << std::endl;
        }
    } else if (pid > 0) {
        int status;
        waitpid(pid, &status, 0);
        if (status != 0) {
            std::cerr << "Something went horribly wrong" << std::endl;
        }
    } else {
        perror("pid failed");
        exit(1);
    }
}