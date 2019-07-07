grammar Commands;

stat  : movie* EOF; 

movie : function (PIPE function)* NEWLINE*;

open  : 'open' IMAGE;

save  : 'save' '->' function*;

show  : 'show' function*;

function :	ARG '=' function				#Variable
			| open							#OpenImage
		   	| save							#SaveImage
		   	| show							#ShowImage
		   	| function 'gray'				#Gray
		   	| function 'blur'				#Blur
		   	| function 'crop' NUM NUM		#Crop
		   	| function 'zoom' NUM? 			#Zoom
		   	| function 'saturation' NUM		#Saturation
		   	| function 'brightness'	NUM		#Brightness
		   	| function 'edges' 				#Edges
		   	| function 'contrast' NUM 		#Contrast
		   	| function 'rotate' NUM			#Rotate
		   	| function 'scale' NUM			#Scale
		   	| function 'resize' NUM NUM 	#Resize
		   	| function 'extract' 			#Extract
		   	| function 'contour' 			#Contour
		   	| (ARG ARG) 'difference'	        #Difference
		   	| ARG 							#Argument
		   	| IMAGE 						#Imagem
		   	;	

PIPE	: '|';
NUM		: [0-9]+;
ARG 	: [A-Za-z0-9]+;
IMAGE   : '"' [A-Za-z0-9./]+ '"';
NEWLINE : '\r' | '\n';
COMMENT : '//' .*? '\n' -> skip;
WS    	: [ \t]+ -> skip ;
