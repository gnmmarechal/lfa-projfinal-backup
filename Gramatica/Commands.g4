grammar Commands;

stat : movie* EOF; 

movie : function+ (PIPE function)*;

function : OP ARG;

PIPE : '|';
OP   : 'gray' | 'blur' | 'crop' | 'rotate' | 'scale' | 'resize' | 'place' | 'save' | 'show' | 'load';
ARG  : [A-Za-z0-9.]+;
WS   : [ \t\r\n]+ -> skip ;