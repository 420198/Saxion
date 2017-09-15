//
// Created by Frank Grevelink on 23/06/2017.
//

#ifndef SHELL_COMMANDS_H
#define SHELL_COMMANDS_H


#include <Token.h>

class Commands {
public:
    static void changeDirectory(int pid, std::vector<antlr4::Token * > vector);
    static void executeBinary(int pid, char* arguments[]);
    static void clearCommandLine();
    static void exitCommandLine();
};


#endif //SHELL_COMMANDS_H
