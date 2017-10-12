grammar DutchJava;

parse: methodeUITVOERING* blok EOF;

blok: statement*;

statement:
 read_statement
 | declarering
 | print_statement
 | als_statement
 | voor_statement
 | zolang_statement
 | methodeAANROEP
 | toekenning
 | toekenningWithMethod
 | verandering
 | veranderingWithMethod
 | value_expressie SEMICOL;

read_statement:ID '< ('DATATYPE')' SEMICOL;

print_statement:'schrijf ' ID SEMICOL #schrijfId
| 'schrijf 'STRING SEMICOL #schrijfString
 |'schrijf 'value_expressie SEMICOL #schrijfValExpr
 |'schrijf 'expressie SEMICOL #schrijfExpr;

als_statement: 'als' cond_block=conditie_block ('alsanders' conditie_block)* ('anders' stat_blok)?;

zolang_statement: 'zolang' expressie stat_blok;

voor_statement: 'voor' (HAAKOPEN (toek=toekenning | verand=verandering) expressie SEMICOL value_expressie HAAKSLUIT) stat_blok;

declarering: DATATYPE ID SEMICOL;
toekenning: DATATYPE ID KENTOE expr=value_expressie SEMICOL;
toekenningWithMethod: DATATYPE ID KENTOE expr=methodeAANROEP;

verandering: id=ID KENTOE expr=value_expressie SEMICOL;
veranderingWithMethod: id=ID KENTOE expr=methodeAANROEP;

conditie_block: expr=expressie sBlock=stat_blok;

stat_blok: '{' blok '}' #statementBlok;

func_stat_blok: '{' blok GEEFTERUG? ID? SEMICOL? '}';

methodeAANROEP: ID HAAKOPEN argument? HAAKSLUIT SEMICOL;
methodeUITVOERING: DATATYPE 'functie' ID HAAKOPEN argument_uitvoering? HAAKSLUIT func_stat_blok;

argument: (argument_type ',')* argument_type;
argument_uitvoering: (DATATYPE argument_type ',')* DATATYPE argument_type;

argument_type: STRING | INT | FLOAT | BOOLEAN | ID;

expressie: leftExpr=expressie op=(KLEINERGELIJK | GROTERGELIJK | KLEINERDAN | GROTERDAN) rightExpr=expressie #vergelijkingExpr
 | leftExpr=expressie op=(GELIJKAAN | NIETGELIJKAAN) rightExpr=expressie #gelijkheidExpr
 | atom #atomCondExpr;

value_expressie:  leftExpr=value_expressie op=(KEER | GEDEELDDOOR | MODULO )rightExpr=value_expressie #keerGddModExpr
 | leftExpr=value_expressie op=(PLUS | MINUS) rightExpr=value_expressie #plusMinExpr
 | leftExpr=value_expressie op=(KEERIS | GEDEELDDOORIS | MINIS | PLUSIS) rightExpr=value_expressie #isRekenExpr
 | leftExpr=value_expressie op=('--' | '++') #minminPlusPlusExpr
 | atom #atomValueExpr;

atom: HAAKOPEN (expressie | value_expressie) HAAKSLUIT #atomexpressie
 | INT     #atomInt
 | FLOAT   #atomFloat
 | BOOLEAN #atomBoolean
 | ID      #atomId
 | STRING  #atomString;

GELIJKAAN : '==';
NIETGELIJKAAN : '!=';
GROTERDAN : '>';
KLEINERDAN : '<';
GROTERGELIJK : '>=';
KLEINERGELIJK : '<=';

MINUS : '-';
PLUS : '+';
KEER : '*';
GEDEELDDOOR : '/';
MODULO : '%';
PLUSIS: '+=' | '=+';
MINIS: '-=' | '=-';
KEERIS: '*=' | '=*';
GEDEELDDOORIS: '/=' | '=/';

SEMICOL : ';';
KENTOE : '=' | 'is';
HAAKOPEN : '(';
HAAKSLUIT : ')';
GEEFTERUG: 'geefterug';

DATATYPE: ('draad' | 'nummer' | 'vliegend' | 'booleaans' | 'leegte');

INT: [0-9]+;

FLOAT: [0-9]+ '.' [0-9]* | '.' [0-9]+;

BOOLEAN: 'waar' | 'onwaar';

STRING: '"' (~["\r\n] | '""')* '"';

ID: [a-zA-Z] [a-zA-Z_0-9]*;

COMMENT: '@@' ~[\r\n]* -> skip;

SPACE: [ \t\r\n] -> skip;