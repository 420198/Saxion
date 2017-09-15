
// Generated from /home/waro/School/Jaar 2/kwartiel 3/Compilers en operating systems/Shell/ShellGrammar.g4 by ANTLR 4.6


#include "ShellGrammarVisitor.h"

#include "ShellGrammarParser.h"


using namespace antlrcpp;
using namespace antlr4;

ShellGrammarParser::ShellGrammarParser(TokenStream *input) : Parser(input) {
  _interpreter = new atn::ParserATNSimulator(this, _atn, _decisionToDFA, _sharedContextCache);
}

ShellGrammarParser::~ShellGrammarParser() {
  delete _interpreter;
}

std::string ShellGrammarParser::getGrammarFileName() const {
  return "ShellGrammar.g4";
}

const std::vector<std::string>& ShellGrammarParser::getRuleNames() const {
  return _ruleNames;
}

dfa::Vocabulary& ShellGrammarParser::getVocabulary() const {
  return _vocabulary;
}


//----------------- ShaellContext ------------------------------------------------------------------

ShellGrammarParser::ShaellContext::ShaellContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

ShellGrammarParser::CommandContext* ShellGrammarParser::ShaellContext::command() {
  return getRuleContext<ShellGrammarParser::CommandContext>(0);
}


size_t ShellGrammarParser::ShaellContext::getRuleIndex() const {
  return ShellGrammarParser::RuleShaell;
}

antlrcpp::Any ShellGrammarParser::ShaellContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<ShellGrammarVisitor*>(visitor))
    return parserVisitor->visitShaell(this);
  else
    return visitor->visitChildren(this);
}

ShellGrammarParser::ShaellContext* ShellGrammarParser::shaell() {
  ShaellContext *_localctx = _tracker.createInstance<ShaellContext>(_ctx, getState());
  enterRule(_localctx, 0, ShellGrammarParser::RuleShaell);

  auto onExit = finally([=] {
    exitRule();
  });
  try {
    enterOuterAlt(_localctx, 1);
    setState(10);
    command();
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- CommandContext ------------------------------------------------------------------

ShellGrammarParser::CommandContext::CommandContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}


size_t ShellGrammarParser::CommandContext::getRuleIndex() const {
  return ShellGrammarParser::RuleCommand;
}

void ShellGrammarParser::CommandContext::copyFrom(CommandContext *ctx) {
  ParserRuleContext::copyFrom(ctx);
}

//----------------- PipeCContext ------------------------------------------------------------------

ShellGrammarParser::PipecommandContext* ShellGrammarParser::PipeCContext::pipecommand() {
  return getRuleContext<ShellGrammarParser::PipecommandContext>(0);
}

ShellGrammarParser::PipeCContext::PipeCContext(CommandContext *ctx) { copyFrom(ctx); }

antlrcpp::Any ShellGrammarParser::PipeCContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<ShellGrammarVisitor*>(visitor))
    return parserVisitor->visitPipeC(this);
  else
    return visitor->visitChildren(this);
}
//----------------- SimpleCContext ------------------------------------------------------------------

ShellGrammarParser::SimplecommandContext* ShellGrammarParser::SimpleCContext::simplecommand() {
  return getRuleContext<ShellGrammarParser::SimplecommandContext>(0);
}

ShellGrammarParser::SimpleCContext::SimpleCContext(CommandContext *ctx) { copyFrom(ctx); }

antlrcpp::Any ShellGrammarParser::SimpleCContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<ShellGrammarVisitor*>(visitor))
    return parserVisitor->visitSimpleC(this);
  else
    return visitor->visitChildren(this);
}
ShellGrammarParser::CommandContext* ShellGrammarParser::command() {
  CommandContext *_localctx = _tracker.createInstance<CommandContext>(_ctx, getState());
  enterRule(_localctx, 2, ShellGrammarParser::RuleCommand);

  auto onExit = finally([=] {
    exitRule();
  });
  try {
    setState(14);
    _errHandler->sync(this);
    switch (getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 0, _ctx)) {
    case 1: {
      _localctx = dynamic_cast<CommandContext *>(_tracker.createInstance<ShellGrammarParser::SimpleCContext>(_localctx));
      enterOuterAlt(_localctx, 1);
      setState(12);
      simplecommand();
      break;
    }

    case 2: {
      _localctx = dynamic_cast<CommandContext *>(_tracker.createInstance<ShellGrammarParser::PipeCContext>(_localctx));
      enterOuterAlt(_localctx, 2);
      setState(13);
      pipecommand(0);
      break;
    }

    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- SimplecommandContext ------------------------------------------------------------------

ShellGrammarParser::SimplecommandContext::SimplecommandContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

std::vector<tree::TerminalNode *> ShellGrammarParser::SimplecommandContext::STRING() {
  return getTokens(ShellGrammarParser::STRING);
}

tree::TerminalNode* ShellGrammarParser::SimplecommandContext::STRING(size_t i) {
  return getToken(ShellGrammarParser::STRING, i);
}

std::vector<ShellGrammarParser::IoredirectContext *> ShellGrammarParser::SimplecommandContext::ioredirect() {
  return getRuleContexts<ShellGrammarParser::IoredirectContext>();
}

ShellGrammarParser::IoredirectContext* ShellGrammarParser::SimplecommandContext::ioredirect(size_t i) {
  return getRuleContext<ShellGrammarParser::IoredirectContext>(i);
}


size_t ShellGrammarParser::SimplecommandContext::getRuleIndex() const {
  return ShellGrammarParser::RuleSimplecommand;
}

antlrcpp::Any ShellGrammarParser::SimplecommandContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<ShellGrammarVisitor*>(visitor))
    return parserVisitor->visitSimplecommand(this);
  else
    return visitor->visitChildren(this);
}

ShellGrammarParser::SimplecommandContext* ShellGrammarParser::simplecommand() {
  SimplecommandContext *_localctx = _tracker.createInstance<SimplecommandContext>(_ctx, getState());
  enterRule(_localctx, 4, ShellGrammarParser::RuleSimplecommand);

  auto onExit = finally([=] {
    exitRule();
  });
  try {
    size_t alt;
    enterOuterAlt(_localctx, 1);
    setState(16);
    dynamic_cast<SimplecommandContext *>(_localctx)->programName = match(ShellGrammarParser::STRING);
    setState(20);
    _errHandler->sync(this);
    alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 1, _ctx);
    while (alt != 2 && alt != atn::ATN::INVALID_ALT_NUMBER) {
      if (alt == 1) {
        setState(17);
        dynamic_cast<SimplecommandContext *>(_localctx)->stringToken = match(ShellGrammarParser::STRING);
        dynamic_cast<SimplecommandContext *>(_localctx)->test.push_back(dynamic_cast<SimplecommandContext *>(_localctx)->stringToken); 
      }
      setState(22);
      _errHandler->sync(this);
      alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 1, _ctx);
    }
    setState(26);
    _errHandler->sync(this);
    alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 2, _ctx);
    while (alt != 2 && alt != atn::ATN::INVALID_ALT_NUMBER) {
      if (alt == 1) {
        setState(23);
        dynamic_cast<SimplecommandContext *>(_localctx)->ior = ioredirect(); 
      }
      setState(28);
      _errHandler->sync(this);
      alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 2, _ctx);
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

//----------------- PipecommandContext ------------------------------------------------------------------

ShellGrammarParser::PipecommandContext::PipecommandContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

ShellGrammarParser::SimplecommandContext* ShellGrammarParser::PipecommandContext::simplecommand() {
  return getRuleContext<ShellGrammarParser::SimplecommandContext>(0);
}

ShellGrammarParser::PipecommandContext* ShellGrammarParser::PipecommandContext::pipecommand() {
  return getRuleContext<ShellGrammarParser::PipecommandContext>(0);
}


size_t ShellGrammarParser::PipecommandContext::getRuleIndex() const {
  return ShellGrammarParser::RulePipecommand;
}

antlrcpp::Any ShellGrammarParser::PipecommandContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<ShellGrammarVisitor*>(visitor))
    return parserVisitor->visitPipecommand(this);
  else
    return visitor->visitChildren(this);
}


ShellGrammarParser::PipecommandContext* ShellGrammarParser::pipecommand() {
   return pipecommand(0);
}

ShellGrammarParser::PipecommandContext* ShellGrammarParser::pipecommand(int precedence) {
  ParserRuleContext *parentContext = _ctx;
  size_t parentState = getState();
  ShellGrammarParser::PipecommandContext *_localctx = _tracker.createInstance<PipecommandContext>(_ctx, parentState);
  ShellGrammarParser::PipecommandContext *previousContext = _localctx;
  size_t startState = 6;
  enterRecursionRule(_localctx, 6, ShellGrammarParser::RulePipecommand, precedence);

    

  auto onExit = finally([=] {
    unrollRecursionContexts(parentContext);
  });
  try {
    size_t alt;
    enterOuterAlt(_localctx, 1);
    setState(30);
    dynamic_cast<PipecommandContext *>(_localctx)->leftc = simplecommand();
    _ctx->stop = _input->LT(-1);
    setState(37);
    _errHandler->sync(this);
    alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 3, _ctx);
    while (alt != 2 && alt != atn::ATN::INVALID_ALT_NUMBER) {
      if (alt == 1) {
        if (!_parseListeners.empty())
          triggerExitRuleEvent();
        previousContext = _localctx;
        _localctx = _tracker.createInstance<PipecommandContext>(parentContext, parentState);
        _localctx->pipec = previousContext;
        pushNewRecursionContext(_localctx, startState, RulePipecommand);
        setState(32);

        if (!(precpred(_ctx, 1))) throw FailedPredicateException(this, "precpred(_ctx, 1)");
        setState(33);
        match(ShellGrammarParser::T__0);
        setState(34);
        dynamic_cast<PipecommandContext *>(_localctx)->rightc = simplecommand(); 
      }
      setState(39);
      _errHandler->sync(this);
      alt = getInterpreter<atn::ParserATNSimulator>()->adaptivePredict(_input, 3, _ctx);
    }
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }
  return _localctx;
}

//----------------- IoredirectContext ------------------------------------------------------------------

ShellGrammarParser::IoredirectContext::IoredirectContext(ParserRuleContext *parent, size_t invokingState)
  : ParserRuleContext(parent, invokingState) {
}

tree::TerminalNode* ShellGrammarParser::IoredirectContext::STRING() {
  return getToken(ShellGrammarParser::STRING, 0);
}


size_t ShellGrammarParser::IoredirectContext::getRuleIndex() const {
  return ShellGrammarParser::RuleIoredirect;
}

antlrcpp::Any ShellGrammarParser::IoredirectContext::accept(tree::ParseTreeVisitor *visitor) {
  if (auto parserVisitor = dynamic_cast<ShellGrammarVisitor*>(visitor))
    return parserVisitor->visitIoredirect(this);
  else
    return visitor->visitChildren(this);
}

ShellGrammarParser::IoredirectContext* ShellGrammarParser::ioredirect() {
  IoredirectContext *_localctx = _tracker.createInstance<IoredirectContext>(_ctx, getState());
  enterRule(_localctx, 8, ShellGrammarParser::RuleIoredirect);

  auto onExit = finally([=] {
    exitRule();
  });
  try {
    setState(50);
    _errHandler->sync(this);
    switch (_input->LA(1)) {
      case ShellGrammarParser::T__1: {
        enterOuterAlt(_localctx, 1);
        setState(40);
        dynamic_cast<IoredirectContext *>(_localctx)->op = match(ShellGrammarParser::T__1);
        setState(41);
        dynamic_cast<IoredirectContext *>(_localctx)->path = match(ShellGrammarParser::STRING);
        break;
      }

      case ShellGrammarParser::T__2: {
        enterOuterAlt(_localctx, 2);
        setState(42);
        dynamic_cast<IoredirectContext *>(_localctx)->op = match(ShellGrammarParser::T__2);
        setState(43);
        dynamic_cast<IoredirectContext *>(_localctx)->path = match(ShellGrammarParser::STRING);
        break;
      }

      case ShellGrammarParser::T__3: {
        enterOuterAlt(_localctx, 3);
        setState(44);
        dynamic_cast<IoredirectContext *>(_localctx)->op = match(ShellGrammarParser::T__3);
        setState(45);
        dynamic_cast<IoredirectContext *>(_localctx)->path = match(ShellGrammarParser::STRING);
        break;
      }

      case ShellGrammarParser::T__4: {
        enterOuterAlt(_localctx, 4);
        setState(46);
        dynamic_cast<IoredirectContext *>(_localctx)->op = match(ShellGrammarParser::T__4);
        setState(47);
        dynamic_cast<IoredirectContext *>(_localctx)->path = match(ShellGrammarParser::STRING);
        break;
      }

      case ShellGrammarParser::T__5: {
        enterOuterAlt(_localctx, 5);
        setState(48);
        dynamic_cast<IoredirectContext *>(_localctx)->op = match(ShellGrammarParser::T__5);
        setState(49);
        dynamic_cast<IoredirectContext *>(_localctx)->path = match(ShellGrammarParser::STRING);
        break;
      }

    default:
      throw NoViableAltException(this);
    }
   
  }
  catch (RecognitionException &e) {
    _errHandler->reportError(this, e);
    _localctx->exception = std::current_exception();
    _errHandler->recover(this, _localctx->exception);
  }

  return _localctx;
}

bool ShellGrammarParser::sempred(RuleContext *context, size_t ruleIndex, size_t predicateIndex) {
  switch (ruleIndex) {
    case 3: return pipecommandSempred(dynamic_cast<PipecommandContext *>(context), predicateIndex);

  default:
    break;
  }
  return true;
}

bool ShellGrammarParser::pipecommandSempred(PipecommandContext *_localctx, size_t predicateIndex) {
  switch (predicateIndex) {
    case 0: return precpred(_ctx, 1);

  default:
    break;
  }
  return true;
}

// Static vars and initialization.
std::vector<dfa::DFA> ShellGrammarParser::_decisionToDFA;
atn::PredictionContextCache ShellGrammarParser::_sharedContextCache;

// We own the ATN which in turn owns the ATN states.
atn::ATN ShellGrammarParser::_atn;
std::vector<uint16_t> ShellGrammarParser::_serializedATN;

std::vector<std::string> ShellGrammarParser::_ruleNames = {
  "shaell", "command", "simplecommand", "pipecommand", "ioredirect"
};

std::vector<std::string> ShellGrammarParser::_literalNames = {
  "", "'|'", "'<'", "'<<'", "'2>'", "'>'", "'>>'"
};

std::vector<std::string> ShellGrammarParser::_symbolicNames = {
  "", "", "", "", "", "", "", "STRING", "WS"
};

dfa::Vocabulary ShellGrammarParser::_vocabulary(_literalNames, _symbolicNames);

std::vector<std::string> ShellGrammarParser::_tokenNames;

ShellGrammarParser::Initializer::Initializer() {
	for (size_t i = 0; i < _symbolicNames.size(); ++i) {
		std::string name = _vocabulary.getLiteralName(i);
		if (name.empty()) {
			name = _vocabulary.getSymbolicName(i);
		}

		if (name.empty()) {
			_tokenNames.push_back("<INVALID>");
		} else {
      _tokenNames.push_back(name);
    }
	}

  _serializedATN = {
    0x3, 0x430, 0xd6d1, 0x8206, 0xad2d, 0x4417, 0xaef1, 0x8d80, 0xaadd, 
    0x3, 0xa, 0x37, 0x4, 0x2, 0x9, 0x2, 0x4, 0x3, 0x9, 0x3, 0x4, 0x4, 0x9, 
    0x4, 0x4, 0x5, 0x9, 0x5, 0x4, 0x6, 0x9, 0x6, 0x3, 0x2, 0x3, 0x2, 0x3, 
    0x3, 0x3, 0x3, 0x5, 0x3, 0x11, 0xa, 0x3, 0x3, 0x4, 0x3, 0x4, 0x7, 0x4, 
    0x15, 0xa, 0x4, 0xc, 0x4, 0xe, 0x4, 0x18, 0xb, 0x4, 0x3, 0x4, 0x7, 0x4, 
    0x1b, 0xa, 0x4, 0xc, 0x4, 0xe, 0x4, 0x1e, 0xb, 0x4, 0x3, 0x5, 0x3, 0x5, 
    0x3, 0x5, 0x3, 0x5, 0x3, 0x5, 0x3, 0x5, 0x7, 0x5, 0x26, 0xa, 0x5, 0xc, 
    0x5, 0xe, 0x5, 0x29, 0xb, 0x5, 0x3, 0x6, 0x3, 0x6, 0x3, 0x6, 0x3, 0x6, 
    0x3, 0x6, 0x3, 0x6, 0x3, 0x6, 0x3, 0x6, 0x3, 0x6, 0x3, 0x6, 0x5, 0x6, 
    0x35, 0xa, 0x6, 0x3, 0x6, 0x2, 0x3, 0x8, 0x7, 0x2, 0x4, 0x6, 0x8, 0xa, 
    0x2, 0x2, 0x39, 0x2, 0xc, 0x3, 0x2, 0x2, 0x2, 0x4, 0x10, 0x3, 0x2, 0x2, 
    0x2, 0x6, 0x12, 0x3, 0x2, 0x2, 0x2, 0x8, 0x1f, 0x3, 0x2, 0x2, 0x2, 0xa, 
    0x34, 0x3, 0x2, 0x2, 0x2, 0xc, 0xd, 0x5, 0x4, 0x3, 0x2, 0xd, 0x3, 0x3, 
    0x2, 0x2, 0x2, 0xe, 0x11, 0x5, 0x6, 0x4, 0x2, 0xf, 0x11, 0x5, 0x8, 0x5, 
    0x2, 0x10, 0xe, 0x3, 0x2, 0x2, 0x2, 0x10, 0xf, 0x3, 0x2, 0x2, 0x2, 0x11, 
    0x5, 0x3, 0x2, 0x2, 0x2, 0x12, 0x16, 0x7, 0x9, 0x2, 0x2, 0x13, 0x15, 
    0x7, 0x9, 0x2, 0x2, 0x14, 0x13, 0x3, 0x2, 0x2, 0x2, 0x15, 0x18, 0x3, 
    0x2, 0x2, 0x2, 0x16, 0x14, 0x3, 0x2, 0x2, 0x2, 0x16, 0x17, 0x3, 0x2, 
    0x2, 0x2, 0x17, 0x1c, 0x3, 0x2, 0x2, 0x2, 0x18, 0x16, 0x3, 0x2, 0x2, 
    0x2, 0x19, 0x1b, 0x5, 0xa, 0x6, 0x2, 0x1a, 0x19, 0x3, 0x2, 0x2, 0x2, 
    0x1b, 0x1e, 0x3, 0x2, 0x2, 0x2, 0x1c, 0x1a, 0x3, 0x2, 0x2, 0x2, 0x1c, 
    0x1d, 0x3, 0x2, 0x2, 0x2, 0x1d, 0x7, 0x3, 0x2, 0x2, 0x2, 0x1e, 0x1c, 
    0x3, 0x2, 0x2, 0x2, 0x1f, 0x20, 0x8, 0x5, 0x1, 0x2, 0x20, 0x21, 0x5, 
    0x6, 0x4, 0x2, 0x21, 0x27, 0x3, 0x2, 0x2, 0x2, 0x22, 0x23, 0xc, 0x3, 
    0x2, 0x2, 0x23, 0x24, 0x7, 0x3, 0x2, 0x2, 0x24, 0x26, 0x5, 0x6, 0x4, 
    0x2, 0x25, 0x22, 0x3, 0x2, 0x2, 0x2, 0x26, 0x29, 0x3, 0x2, 0x2, 0x2, 
    0x27, 0x25, 0x3, 0x2, 0x2, 0x2, 0x27, 0x28, 0x3, 0x2, 0x2, 0x2, 0x28, 
    0x9, 0x3, 0x2, 0x2, 0x2, 0x29, 0x27, 0x3, 0x2, 0x2, 0x2, 0x2a, 0x2b, 
    0x7, 0x4, 0x2, 0x2, 0x2b, 0x35, 0x7, 0x9, 0x2, 0x2, 0x2c, 0x2d, 0x7, 
    0x5, 0x2, 0x2, 0x2d, 0x35, 0x7, 0x9, 0x2, 0x2, 0x2e, 0x2f, 0x7, 0x6, 
    0x2, 0x2, 0x2f, 0x35, 0x7, 0x9, 0x2, 0x2, 0x30, 0x31, 0x7, 0x7, 0x2, 
    0x2, 0x31, 0x35, 0x7, 0x9, 0x2, 0x2, 0x32, 0x33, 0x7, 0x8, 0x2, 0x2, 
    0x33, 0x35, 0x7, 0x9, 0x2, 0x2, 0x34, 0x2a, 0x3, 0x2, 0x2, 0x2, 0x34, 
    0x2c, 0x3, 0x2, 0x2, 0x2, 0x34, 0x2e, 0x3, 0x2, 0x2, 0x2, 0x34, 0x30, 
    0x3, 0x2, 0x2, 0x2, 0x34, 0x32, 0x3, 0x2, 0x2, 0x2, 0x35, 0xb, 0x3, 
    0x2, 0x2, 0x2, 0x7, 0x10, 0x16, 0x1c, 0x27, 0x34, 
  };

  atn::ATNDeserializer deserializer;
  _atn = deserializer.deserialize(_serializedATN);

  size_t count = _atn.getNumberOfDecisions();
  _decisionToDFA.reserve(count);
  for (size_t i = 0; i < count; i++) { 
    _decisionToDFA.emplace_back(_atn.getDecisionState(i), i);
  }
}

ShellGrammarParser::Initializer ShellGrammarParser::_init;
