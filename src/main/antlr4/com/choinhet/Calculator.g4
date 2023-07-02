grammar Calculator;
// parser rules
question
    : expression
    | EOF
    ;

expression
    : expression mult expression
    | expression div expression
    | expression sum expression
    | expression sub expression
    | parenthesisExpression
    | NUMBER
    ;

mult: MULTIPLICATION ;
div: DIVISION ;
sum: SUM ;
sub: SUBTRACTION ;

parenthesisExpression
    : LPAREN expression RPAREN
    ;

// lexer rules
NUMBER: [0-9]+ ;
WHITESPACE: [ \t\n\r]+ -> skip ;
DIVISION: '/' | '÷' | 'divided by' | 'over' ;
MULTIPLICATION: '*' | 'x' | 'X' | 'multiplied by' | 'times' | 'multiplied';
SUM: '+' | 'plus' | 'added to' | 'add' | 'sum';
SUBTRACTION: '-' | 'minus' | 'subtracted from' | 'subtract' | 'sub';
LPAREN : '(' | '[' | '{';
RPAREN : ')' | ']' | '}';

ERROR: . -> skip; // Skips any unrecognized characters causing token recognition errors
