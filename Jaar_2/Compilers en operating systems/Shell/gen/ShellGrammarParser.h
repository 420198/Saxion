
// Generated from /home/waro/School/Jaar 2/kwartiel 3/Compilers en operating systems/Shell/ShellGrammar.g4 by ANTLR 4.6

#pragma once


#include "antlr4-runtime.h"




class  ShellGrammarParser : public antlr4::Parser {
public:
  enum {
    T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, STRING = 7, 
    WS = 8
  };

  enum {
    RuleShaell = 0, RuleCommand = 1, RuleSimplecommand = 2, RulePipecommand = 3, 
    RuleIoredirect = 4
  };

  ShellGrammarParser(antlr4::TokenStream *input);
  ~ShellGrammarParser();

  virtual std::string getGrammarFileName() const override;
  virtual const antlr4::atn::ATN& getATN() const override { return _atn; };
  virtual const std::vector<std::string>& getTokenNames() const override { return _tokenNames; }; // deprecated: use vocabulary instead.
  virtual const std::vector<std::string>& getRuleNames() const override;
  virtual antlr4::dfa::Vocabulary& getVocabulary() const override;


  class ShaellContext;
  class CommandContext;
  class SimplecommandContext;
  class PipecommandContext;
  class IoredirectContext; 

  class  ShaellContext : public antlr4::ParserRuleContext {
  public:
    ShaellContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    CommandContext *command();

    virtual antlrcpp::Any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  ShaellContext* shaell();

  class  CommandContext : public antlr4::ParserRuleContext {
  public:
    CommandContext(antlr4::ParserRuleContext *parent, size_t invokingState);
   
    CommandContext() : antlr4::ParserRuleContext() { }
    void copyFrom(CommandContext *context);
    using antlr4::ParserRuleContext::copyFrom;

    virtual size_t getRuleIndex() const override;

   
  };

  class  PipeCContext : public CommandContext {
  public:
    PipeCContext(CommandContext *ctx);

    PipecommandContext *pipecommand();
    virtual antlrcpp::Any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  class  SimpleCContext : public CommandContext {
  public:
    SimpleCContext(CommandContext *ctx);

    SimplecommandContext *simplecommand();
    virtual antlrcpp::Any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
  };

  CommandContext* command();

  class  SimplecommandContext : public antlr4::ParserRuleContext {
  public:
    antlr4::Token *programName = nullptr;;
    antlr4::Token *stringToken = nullptr;;
    std::vector<antlr4::Token *> test;;
    ShellGrammarParser::IoredirectContext *ior = nullptr;;
    SimplecommandContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    std::vector<antlr4::tree::TerminalNode *> STRING();
    antlr4::tree::TerminalNode* STRING(size_t i);
    std::vector<IoredirectContext *> ioredirect();
    IoredirectContext* ioredirect(size_t i);

    virtual antlrcpp::Any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  SimplecommandContext* simplecommand();

  class  PipecommandContext : public antlr4::ParserRuleContext {
  public:
    ShellGrammarParser::PipecommandContext *pipec = nullptr;;
    ShellGrammarParser::SimplecommandContext *leftc = nullptr;;
    ShellGrammarParser::SimplecommandContext *rightc = nullptr;;
    PipecommandContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    SimplecommandContext *simplecommand();
    PipecommandContext *pipecommand();

    virtual antlrcpp::Any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  PipecommandContext* pipecommand();
  PipecommandContext* pipecommand(int precedence);
  class  IoredirectContext : public antlr4::ParserRuleContext {
  public:
    antlr4::Token *op = nullptr;;
    antlr4::Token *path = nullptr;;
    IoredirectContext(antlr4::ParserRuleContext *parent, size_t invokingState);
    virtual size_t getRuleIndex() const override;
    antlr4::tree::TerminalNode *STRING();

    virtual antlrcpp::Any accept(antlr4::tree::ParseTreeVisitor *visitor) override;
   
  };

  IoredirectContext* ioredirect();


  virtual bool sempred(antlr4::RuleContext *_localctx, size_t ruleIndex, size_t predicateIndex) override;
  bool pipecommandSempred(PipecommandContext *_localctx, size_t predicateIndex);

private:
  static std::vector<antlr4::dfa::DFA> _decisionToDFA;
  static antlr4::atn::PredictionContextCache _sharedContextCache;
  static std::vector<std::string> _ruleNames;
  static std::vector<std::string> _tokenNames;

  static std::vector<std::string> _literalNames;
  static std::vector<std::string> _symbolicNames;
  static antlr4::dfa::Vocabulary _vocabulary;
  static antlr4::atn::ATN _atn;
  static std::vector<uint16_t> _serializedATN;


  struct Initializer {
    Initializer();
  };
  static Initializer _init;
};

