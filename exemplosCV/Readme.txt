Funções disponiveis:

Cor
	gray -      gray(image)

	blur -      blur(image, level)

Formato
	crop -      crop(image)

	rotation -  rotation(image, graus)
				image rotation 90 

	scale - 	scale(image, scale)	

	resize -    resize(image, x, y)
				x: (num| +num | -num)
				y: (num| +num | -num)

MISC
	place -  	place(image1, image2, canto)
				canto: ("BL"|"BR"|"UL"|"UR")

	save -      save(newfilename, image)

	show -      show(image)

load "qq.jpg" | rotate 10 | crop ???  =>  (save | show | ) "jpg" "qqqq.jpg"
