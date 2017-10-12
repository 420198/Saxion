#include <iostream>
#include <ANTLRInputStream.h>
#include <CommonTokenStream.h>
#include <tree/ParseTree.h>
#include <unistd.h>
#include "../gen/ShellGrammarLexer.h"
#include "../gen/ShellGrammarParser.h"
#include "MyVisitor.h"
#include <stdlib.h>

int main() {
    std::string input;
    std::vector<std::string> history;
    for(;;){

        char cwd[1024];
        char hostname[1024];

        getcwd(cwd, sizeof(cwd));
        gethostname(hostname, sizeof(hostname));

        std::cout << hostname << ": \"" << cwd << "\" " << std::endl;

        // Read some line of input....
        std::getline (std::cin, input);

        if(input.substr(0, 7) == "repeat "){
            input = history.at(input.back() - '0');
        }

        if(input == "history"){
            for (int i = 0; i < history.size(); ++i) {
                std::cout << i << " : " << history.at(i) << std::endl;
            }
            std::cout << "Repeat command with : repeat <number>" << std::endl;
        }
        else if(input != "" && input.substr(0, 6) != "repeat") {
            // Put it in the history
            if(history.size() < 9) {
                history.push_back(input);
            } else {
                history.erase(history.begin()); //remove the first one
                history.push_back(input);
            }

            // Create input stream, create lexer and use lexer to create stream of tokens
            antlr4::ANTLRInputStream inputStream(input);
            ShellGrammarLexer lexer(&inputStream);
            antlr4::CommonTokenStream tokens(&lexer);

            // Create parser
            ShellGrammarParser parser(&tokens);
            antlr4::tree::ParseTree *parseTree = parser.command();

            // Then, visit your tree
            MyVisitor visitor;
            visitor.visit(parseTree);
        }
    }
    return 0;
}