grammar Commands;

program  : statement* EOF; 

statement 	:	instruction ';'
				| block
				| forcycle
		 		;

instruction	:	assignment
				| writing
				;

block	:	'{' statement* '}';

assignment	:	ID '=' IMAGE
				| ID '=' ID
				| ID '=' writing
				;

writing		:	'(' writing ')'
				| operation
				;

operation :	'save' (writing|ID|IMAGE)						#SaveImage
		   	| 'show' (writing|ID|IMAGE)						#ShowImage
		   	| 'gray' (writing|ID|IMAGE)							#Gray
		   	| 'blur' (writing|ID|IMAGE)							#Blur
		   	| 'crop' NUM NUM (writing|ID|IMAGE)				#Crop
		   	| 'zoom' NUM (writing|ID|IMAGE)					#Zoom
		   	| 'saturation' NUM	(writing|ID|IMAGE)				#Saturation
		   	| 'brightness'	NUM	(writing|ID|IMAGE)				#Brightness
		   	| 'edges' (writing|ID|IMAGE)						#Edges
		   	| 'contrast' NUM (writing|ID|IMAGE)				#Contrast
		   	| 'rotate' NUM	(writing|ID|IMAGE)					#Rotate
		   	| 'scale' NUM	(writing|ID|IMAGE)					#Scale
		   	| 'resize' NUM NUM (writing|ID|IMAGE)		 		#Resize
		   	| 'extract' (writing|ID|IMAGE)						#Extract
		   	| 'contour' (writing|ID|IMAGE)						#Contour
		   	| 'difference' (writing|((ID|IMAGE) (ID|IMAGE)))	#Difference
		   	;	


forcycle: 	'for' '(' LETTER '=' NUM ';' LETTER op=('<'|'>'|'==') NUM ';' LETTER increment=('++'|'--') ')' block;

ID 	: [A-Za-z]+ [A-Za-z0-9_]*;
LETTER: [a-zA-Z]+;
NUM		: [0-9]+;
IMAGE   : '"' [A-Za-z0-9./]+ '"';
COMMENT : '//' .*? '\n' -> skip;
WS    	: [ \t\n\r]+ -> skip ;