#ifndef SHELL_MYVISITOR_H
#define SHELL_MYVISITOR_H


#include "../gen/ShellGrammarVisitor.h"
#include "../gen/ShellGrammarBaseVisitor.h"

class MyVisitor : public ShellGrammarBaseVisitor{
private:
    ShellGrammarParser::SimplecommandContext *ct;
    char* finalArguments[1024];

    std::vector<std::string> history;

    int totalArgumentSize;

    std::string temporaryArguments[];
public:

    MyVisitor();

    antlrcpp::Any visitSimplecommand(ShellGrammarParser::SimplecommandContext *ctx) override;
    antlrcpp::Any visitIoredirect(ShellGrammarParser::IoredirectContext *ctx) override;
    antlrcpp::Any visitPipecommand(ShellGrammarParser::PipecommandContext *ctx) override;

    void LaunchIORedirection(pid_t pid, ShellGrammarParser::IoredirectContext *ctx, int type, int _flags, ...);
};


#endif //SHELL_MYVISITOR_H
