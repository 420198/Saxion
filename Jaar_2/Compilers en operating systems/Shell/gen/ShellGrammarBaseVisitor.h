
// Generated from /home/waro/School/Jaar 2/kwartiel 3/Compilers en operating systems/Shell/ShellGrammar.g4 by ANTLR 4.6

#pragma once


#include "antlr4-runtime.h"
#include "ShellGrammarVisitor.h"


/**
 * This class provides an empty implementation of ShellGrammarVisitor, which can be
 * extended to create a visitor which only needs to handle a subset of the available methods.
 */
class  ShellGrammarBaseVisitor : public ShellGrammarVisitor {
public:

  virtual antlrcpp::Any visitShaell(ShellGrammarParser::ShaellContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual antlrcpp::Any visitSimpleC(ShellGrammarParser::SimpleCContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual antlrcpp::Any visitPipeC(ShellGrammarParser::PipeCContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual antlrcpp::Any visitSimplecommand(ShellGrammarParser::SimplecommandContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual antlrcpp::Any visitPipecommand(ShellGrammarParser::PipecommandContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual antlrcpp::Any visitIoredirect(ShellGrammarParser::IoredirectContext *ctx) override {
    return visitChildren(ctx);
  }


};

