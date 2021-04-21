lexer grammar LanguageLexerRules;

/** Definition of the tokens used **/
ID : [a-z][a-zA-Z0-9_]* ; //Identifiers
NUM : '0' | '-'?[1-9][0-9]* ; //Integers
INT_TYPE : 'INT' ; // Keyword
COMMENT : '--' ~[\r\n] -> skip; // Skip anything that's not \r or \n after comment
WS : [ \t\n]+ -> skip; // Ignore whitespaces


