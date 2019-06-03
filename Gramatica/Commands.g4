grammar Commands;

stat : movie* EOF; 

movie : function+ (PIPE function)*;

function : OP ARG;

PIPE : '|';
ARG  : [a-z0-9.]+;
OP   : [A-Z]+;				// maiúscula para distinção entre operação e argumento
WS   : [ \t\r\n]+ -> skip ;