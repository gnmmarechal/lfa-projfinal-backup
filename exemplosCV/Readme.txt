Funções disponiveis:

Cor
	gray -      gray(image)

Formato
	crop -      crop(image)

	rotation -  rotation(image, graus)

MISC
	save -      save(newfilename, image)

	show -      show(image)
Movie
	movieframework(bg, img, x, y)  #x = (x1,x2) & y = (y1,y2)
		Poe a imagem (img) no background (bg) nas coordendas dadas pelos dois tuplos x e y
	movie(background, img)
		Cria uma janela com o background definido (neste momento o background esta a ser resized para 400x400 e a img para 100x100 mas dá para alterar facilmente com o valor da variavel limite e as dimensoes do resize)
