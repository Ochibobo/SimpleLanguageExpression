grammar LanguageExpr;
import LanguageLexerRules; // Import the lexer

// Package name
@header{
    package grammar;
}

// Program starting point
// A program can either be an expression or a declaration
prog: (decl | expr)+ EOF  # Program
    ;

// Variable Declaration
decl: ID ':' INT_TYPE '=' NUM  # Declaration
    | ID ':' INT_TYPE '=' expr # Assignment
    ;

/** Expressions **/
expr: expr '/' expr  # Division
    | expr '*' expr  # Multiplication
    | expr '+' expr  # Addition
    | expr '-' expr  # Subtraction
    | ID             # Variable
    | NUM            # Number
    ;

