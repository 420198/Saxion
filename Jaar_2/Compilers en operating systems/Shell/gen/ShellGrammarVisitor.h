
// Generated from /home/waro/School/Jaar 2/kwartiel 3/Compilers en operating systems/Shell/ShellGrammar.g4 by ANTLR 4.6

#pragma once


#include "antlr4-runtime.h"
#include "ShellGrammarParser.h"



/**
 * This class defines an abstract visitor for a parse tree
 * produced by ShellGrammarParser.
 */
class  ShellGrammarVisitor : public antlr4::tree::AbstractParseTreeVisitor {
public:

  /**
   * Visit parse trees produced by ShellGrammarParser.
   */
    virtual antlrcpp::Any visitShaell(ShellGrammarParser::ShaellContext *context) = 0;

    virtual antlrcpp::Any visitSimpleC(ShellGrammarParser::SimpleCContext *context) = 0;

    virtual antlrcpp::Any visitPipeC(ShellGrammarParser::PipeCContext *context) = 0;

    virtual antlrcpp::Any visitSimplecommand(ShellGrammarParser::SimplecommandContext *context) = 0;

    virtual antlrcpp::Any visitPipecommand(ShellGrammarParser::PipecommandContext *context) = 0;

    virtual antlrcpp::Any visitIoredirect(ShellGrammarParser::IoredirectContext *context) = 0;


};

