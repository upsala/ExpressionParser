grammar Parser;

start_expression
		: expression EOF
		;

expression
		: NullLiteral																																							# NullLiteral
		| BooleanLiteral 																																					# BooleanLiteral
		| DecimalLiteral 																																					# DecimalLiteral
		| HexIntegerLiteral																																				# HexIntegerLiteral
		| OctalIntegerLiteral																																			# OctalIntegerLiteral
		| BinaryIntegerLiteral																																		# BinaryIntegerLiteral
		| DoubleQuoteString																																				# DoubleQuoteString
		| SingleQuoteString																																				# SingleQuoteString
		| name=Identifier																																					# Variable
		| QuotedVariable																																					# QuotedVariable
		| LBRACKET RBRACKET																																				# EmptyArray
		| LBRACKET expression ( COMMA  expression )*  RBRACKET																		# Array
		| expr=expression LBRACKET selector=arraySelectorEntries RBRACKET													# ArraySelector
		| LBRACE RBRACE																																						# EmptyObject
		| LBRACE objectEntry ( COMMA objectEntry )* RBRACE																				# Object
		| withLiteral																																							# With
		| name=Identifier LPARENT parameter=functionParameter? RPARENT														# Function
		| LPARENT inner=expression RPARENT                            														# Parentheses
		| operator=(SUB|ADD|BIT_NOT) right=expression																							# Negate
		| left=expression operator=POWER right=expression																					# Power
		| EXCLMATION_MARK right=expression																												# Not
		| left=expression operator=(MUL|DIV|MODULO) right=expression															# MultiplicationOrDivision
		| left=expression operator=(ADD|SUB) right=expression																			# AdditionOrSubtraction
		| left=expression operator=(SHIFT_LEFT|SHIFT_RIGHT) right=expression											# Shift
		| left=expression operator=(CMP_EQ|CMP_GE|CMP_GT|CMP_LE|CMP_LT|CMP_NE1|CMP_NE2) right=expression	# Comparison
		| left=expression operator=(BIT_AND|BIT_OR|BIT_XOR) right=expression											# BitOperations
		| condition=expression QMARK ( choice1=expression )? COLON choice2=expression							# Ternary
		| left=expression operator=(BOOL_AND|BOOL_OR|BOOL_XOR) right=expression										# Bool
		;

objectEntry
		: key=expression COLON value=expression
		;

arraySelectorEntries
		: arraySelectorEntry ( COMMA arraySelectorEntry )*
		;

arraySelectorEntry
		: from=expression ARRAY_RANGE to=expression
		| from=expression
		;

functionParameter
		: expr=expression ( COMMA expr=expression )*
		;

withLiteral
		: WITH LPARENT ( withParameter )+ parameter=functionParameter RPARENT
		| WITH LPARENT parameter=functionParameter RPARENT
		;

withParameter
		: expr=expression AS id=Identifier COMMA
		;

fragment ExponentPart
    : E [+-]? Digit+
    ;

fragment StringEsc
		: '\\' [btnfr"'\\]
		;

DoubleQuoteString
		: DOUBLE_QUOTE ( StringEsc | . )*? DOUBLE_QUOTE
		;

SingleQuoteString
		: SINGLE_QUOTE ( StringEsc | . )*? SINGLE_QUOTE
		;

QuotedVariable
		: VARIABLE_QUOTE .*? VARIABLE_QUOTE
		;

NullLiteral
		: NULL
		;

BooleanLiteral
		: TRUE
    | FALSE
    ;

HexIntegerLiteral
		: '0' X HexDigit+
		;

OctalIntegerLiteral
		: '0' O [0-7]+
		;

BinaryIntegerLiteral
		: '0' B [01]+
		;

DecimalLiteral
		: Digit+ DOT Digit+ ExponentPart?
    | DOT Digit+ ExponentPart?
    | Digit+ DOT ExponentPart?
    | Digit+ ExponentPart?
    ;

NULL: N U L L;
FALSE: F A L S E;
TRUE: T R U E;
AS: A S;
WITH: W I T H;
AND: A N D;
OR: O R;
XOR: X O R;
NOT: N O T;

Identifier
		: ( Letter | UNDERSCORE ) ( Letter | Digit | UNDERSCORE )*
		;

MUL: '*';
DIV: '/';
ADD: '+';
SUB: '-';
POWER: '**';
MODULO: '%';
UNDERSCORE: '_';
COMMA: ',';
LBRACKET: '[';
RBRACKET: ']';
LPARENT: '(';
RPARENT: ')';
LBRACE: '{';
RBRACE: '}';
DOT: '.';
COLON: ':';
DOUBLE_QUOTE: '"';
SINGLE_QUOTE: '\'';
VARIABLE_QUOTE: '`';

CMP_GT: '>';
CMP_LE: '<=';
CMP_GE: '>=';
CMP_LT: '<';
CMP_NE1: '<>';
CMP_NE2: '!=';
CMP_EQ: '==';
QMARK: '?';
BOOL_OR: '||';
BOOL_AND: '&&';
BOOL_XOR: '^^';
BIT_OR: '|';
BIT_AND: '&';
BIT_XOR: '^';
BIT_NOT: '~';
SHIFT_LEFT: '<<';
SHIFT_RIGHT: '>>';
EXCLMATION_MARK: '!';
ARRAY_RANGE: '..';

fragment Digit
		: [0-9]
		;

fragment Letter
		: [A-Za-z]
		;

fragment HexDigit
    : [0-9a-fA-F]
    ;

fragment A: [Aa];
fragment B: [Bb];
fragment C: [Cc];
fragment D: [Dd];
fragment E: [Ee];
fragment F: [Ff];
fragment G: [Gg];
fragment H: [Hh];
fragment I: [Ii];
fragment J: [Jj];
fragment K: [Kk];
fragment L: [Ll];
fragment M: [Mm];
fragment N: [Nn];
fragment O: [Oo];
fragment P: [Pp];
fragment Q: [Qq];
fragment R: [Rr];
fragment S: [Ss];
fragment T: [Tt];
fragment U: [Uu];
fragment V: [Vv];
fragment W: [Ww];
fragment X: [Xx];
fragment Y: [Yy];
fragment Z: [Zz];

WHITESPACE: [ \r\n\t]+ -> skip;

