grammar Commands;

program  		: 	statement* EOF; 

statement 		:	instruction ';'
				| 	block
				| 	repeat
		 		;

instruction		:	assignment
				|	show
				|	save
				;

block			:	'{' statement* '}';

assignment		:	ID '=' IMAGE
				| 	ID '=' ID
				| 	ID '=' operation
				;

writing			: 	operation 
				;

writing2		:  	operation ',' operation 
				;

operation 		: 	'gray'  		'(' (writing | ID | IMAGE ) ')'										#Gray
				| 	'blur'  		'(' NUM ',' (writing | ID | IMAGE ) ')'								#Blur
				| 	'crop'  		'(' NUM ',' NUM ',' NUM ',' NUM ',' (writing| ID | IMAGE ) ')'		#Crop
				| 	'zoom'  		'(' NUM ',' (writing| ID | IMAGE ) ')'   							#Zoom
				| 	'brightness'	'(' NUM ','	(writing|ID|IMAGE) ')'									#Brightness
				| 	'edges'  		'(' (writing|ID|IMAGE) ')'											#Edges
				| 	'contrast' 		'(' NUM ',' (writing|ID|IMAGE) ')'									#Contrast
				| 	'rotate' 		'(' NUM ','	(writing|ID|IMAGE) ')'									#Rotate
				| 	'scale'  		'(' NUM ',' (writing|ID|IMAGE) ')'									#Scale
				| 	'resize' 		'(' NUM ',' NUM ',' (writing|ID|IMAGE) ')'		 					#Resize
				| 	'extract' 		'(' (writing|ID|IMAGE) ')'											#Extract
				| 	'contour' 		'(' (writing|ID|IMAGE) ')'											#Contour
				| 	'difference'  	'(' (writing2 | ( ID ',' ID ) | ( IMAGE ',' ID ) | (ID ',' IMAGE) | (IMAGE ',' IMAGE) | ( writing ',' ID) | (ID ',' writing) 
							   		| (IMAGE ',' writing) | (writing ',' IMAGE)) ')'  					#Difference
				| 	'convert' 		'(' NUM ',' (writing|(ID|IMAGE)) ')'								#Convert
				;

save			: 	'save' '(' ID ')'																	#SaveFile
				;

repeat			:  	'repeat' '(' NUM ')' block	
				;

show			:	'show' '(' (ID | IMAGE)  ')'														#ShowImage
				;

ID 	: [A-Za-z]+ [A-Za-z0-9_]*;
LETTER: [a-zA-Z]+;
NUM		: [0-9]+;
IMAGE   : '"' [A-Za-z0-9./]+ '"';
COMMENT : '//' .*? '\n' -> skip;
WS    	: [ \t\n\r]+ -> skip ;