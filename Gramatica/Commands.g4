grammar Commands;

stat : movie* EOF; 

movie : function (PIPE function)*;

load : 'load' IMAGE;

save : 'save' '->' function*;

show : 'show' function*;

function :   load					#LoadImage
		   | save					#SaveImage
		   | show					#ShowImage
		   | 'gray' function		#Gray
		   | 'blur' function		#Blur
		   | 'crop' function		#Crop
		   | 'zoom' function		#Zoom
		   | 'saturation' function	#Saturation
		   | 'brightness' function	#Brightness
		   | 'edges' function		#Edges
		   | 'rotate' function		#Rotate
		   | 'scale' function		#Scale
		   | 'resize' function		#Resize
		   | 'place' function		#Place
		   | IMAGE 					#Imagem
		   | ARG 					#Argument
		   ;	

PIPE  : '|';
IMAGE : [A-Za-z0-9.]+;
ARG   : [A-Za-z0-9.]+;
WS    : [ \t\r\n]+ -> skip ;