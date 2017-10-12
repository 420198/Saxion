grammar ShellGrammar;

shell: command;
command: simplecommand #simpleC
        | pipecommand #pipeC;

simplecommand: programName=STRING test+=STRING* ior=ioredirect*;

pipecommand: leftc=simplecommand | pipec=pipecommand '|' rightc=simplecommand;

ioredirect : op='<' path=STRING
            | op='<<' path=STRING
            | op='2>' path=STRING
            | op='>' path=STRING
            | op='>>' path=STRING ;

STRING:(~[ \t\r\n])+;

WS: [ \t\r\n]+ -> skip;