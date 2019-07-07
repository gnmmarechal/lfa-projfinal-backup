import cv2
import numpy
import sys
import os.path
import pathlib

class Image:
	def __init__(self,elem,path):
		self.elem = elem
		self.path = path
		self.name = self.searchName(path)
		self.extension = self.searchExtension(path)
	@staticmethod
	def searchName(path):
		p = path.split("/")
		n = p[len(p)-1].split(".")
		return n[0]
	@staticmethod		
	def searchExtension(path):
		p = path.split(".")
		return p[len(p)-1]

#Funções auxiliares				
def filter(img,r,g,b):
	new = numpy.zeros(img.shape, img.dtype)
	for h in range(img.shape[0]):
		for w in range(img.shape[1]):
			new[h,w] = [img[h,w][0] * b, img[h,w][1] * g, img[h,w][2] * r]
	return new
		
def copy(img):
	return Image(img.elem,img.path)
	
def colours(img, a, b):
	#alpha altera o contraste
	#beta altera o brilho
	return cv2.convertScaleAbs(img, alpha=a, beta=b)

#Funções da linguagem
def open(path):
	img = cv2.imread(path)
	return Image(img,path)
	
def save(image):
	dest = "copy_of_" + image.name + "." + image.extension
	target_file = pathlib.Path(dest)
	if target_file.is_file():
		i = 0
		while(target_file.is_file()):
			i = i + 1
			dest = "copy_of_" + image.name + " (" + str(i) + ") ." + image.extension
			target_file = pathlib.Path(dest)
	
	cv2.imwrite(dest, image.elem)

def show(image):
	if image.elem.shape[0] > 720 or image.elem.shape[0] > 1280:
		show(scale(image,70))
	else:
		cv2.imshow(image.name, image.elem)
		cv2.waitKey(0)
		cv2.destroyAllWindows()
	
#Aceita valores de 1-100, mas os valores pares são reduzidos em 1
#Utiliza Gaussian Blur simples
def blur(img,x):
	if x < 1 or x > 100:
		print("Invalid blur value. Values: 1 - 100")
		return img
	if x%2 == 0:
		x = x-1
	image = copy(img)
	image.elem = cv2.GaussianBlur(image.elem,(x,x),0)
	return image

#Aceita valores de 0-300. Predefinido: 100
def contrast(img, x):
	if x < 0 or x > 300:
		print("Invalid contrast value. Values: 0 - 300")
		return img
	image = copy(img)
	image.elem = colours(image.elem,x/100,1)
	return image

#Aceita valores de 0-100. Predefinido: 50
def brightness(img, x):
	if x < 0 or x > 100:
		print("Invalid brightness value. Values: 0 - 100")
		return img
	image = copy(img)
	image.elem = colours(image.elem,1,x-50)
	return image


def edges(img):
	image = copy(img)
	image.elem = cv2.Canny(image.elem,100,200)
	return image
	
#Aceita valores de 1-1000 100 = 100%
def scale(img,x):
	if x < 1 or x > 1000:
		print("Invalid scale value. Values: 1 - 1000")
		return img
	image = copy(img)
	image.elem = cv2.resize(image.elem, None, fx=x/100, fy=x/100)
	return image
	
def resize(img,w,h):
	if w < 1 or h < 1:
		print("Invalid resizing values.")
		return img
	image = copy(img)
	image.elem = cv2.resize(image.elem,(w,h))
	return image

#Função adaptada da documentação do OpenCV
#Guarda os ficheiros das caras
def extract(img):
	image = copy(img)
	gray = cv2.cvtColor(image.elem, cv2.COLOR_BGR2GRAY)
	faceCascade = cv2.CascadeClassifier(cv2.data.haarcascades + "haarcascade_frontalface_default.xml") 
	faces = faceCascade.detectMultiScale(
		gray,
		scaleFactor=1.3,
		minNeighbors=3,
		minSize=(30, 30)
	)
	print("Found {0} Faces.".format(len(faces)))
	for (x, y, w, h) in faces:
		roi_color = image.elem[y:y + h, x:x + w]
		print("Face found. Saving.")
		cv2.imwrite(image.name + "_" + str(w) + str(h) + '_faces.jpg', roi_color)
		
#As imagens necessitam de ter o mesmo tamanho ou então as imagens levam resize para a menor resolução possível
def difference(img1,img2):
	image1 = img1.elem
	image2 = img2.elem
	
	if image1.shape[0] != image2.shape[0] or image1.shape[1] != image2.shape[1]:
		if image1.shape[0] >= image2.shape[0]:
			h = image2.shape[0]
		else:
			h = image1.shape[0]
		if image1.shape[1] >= image2.shape[1]:
			w = image2.shape[1]
		else:
			w = image1.shape[1]
		new_img1 = resize(image1,w,h)
		new_img2 = resize(image2,w,h)
		elem = cv2.absdiff(new_img1,new_img2)
	else:
		elem = cv2.absdiff(image1,image2)
		
	return(Image(elem,"differenceOf_" + img1.name + "_and_" + img2.name + "." + img1.extension))	

#Ponto dado corresponde ao canto inferior esquerdo do resultado
#Uso: Crop Imagem (x,y) width heigth
def crop(img,x,y,w,h):
	if x < 0 or y < 0:
		print("Invalid coordinates.")
		return img
	if w < 0 or h < 0:
		print("Invalid rectangle size.")
		return img
	image = copy(img)
	image.elem = image.elem[y:y+h, x:x+w]
	return image

def rotation(img, d):
	image = copy(img)
	(h, w) = image.elem.shape[:2]
	center = (w / 2, h / 2)
	M = cv2.getRotationMatrix2D(center, d, 1.0)
	image.elem = cv2.warpAffine(image.elem, M, (w, h))
	return image

def gray(img):
	image = copy(img)
	image.elem = cv2.cvtColor(image.elem, cv2.COLOR_BGR2GRAY)
	return image

def convert(img,type):
	image = copy(img)
	if type == 1:
		image.elem =  filter(image.elem,1,0,0)
	elif type == 2:
		image.elem =  filter(image.elem,0,1,0)
	elif type == 3:
		image.elem =  filter(image.elem,0,0,1)
	elif type == 4:
		image.elem =  cv2.cvtColor(image.elem, cv2.COLOR_BGR2GRAY)
	elif type == 5:
		image.elem =  cv2.cvtColor(image.elem, cv2.COLOR_BGR2HLS)
	elif type == 6:
		image.elem =  cv2.cvtColor(image.elem, cv2.COLOR_BGR2LUV)
	elif type == 7:
		image.elem =  cv2.cvtColor(image.elem, cv2.COLOR_BGR2XYZ)	
	elif type == 8:
		image.elem =  cv2.cvtColor(image.elem, cv2.COLOR_BGR2RGB)	
	elif type == 9:
		image.elem =  cv2.cvtColor(image.elem, cv2.COLOR_BGR2YUV)
	elif type == 12:
		image.elem =  filter(image.elem,1,1,0)
	elif type == 13:
		image.elem =  filter(image.elem,1,0,1)
	elif type == 23:
		image.elem =  filter(image.elem,0,1,1)	
	else:
		print("Type not recognized")	
	return image

def main():
	img = open("harold1.jpg")
	img2 = open("harold2.jpg")
	img3 = open("harold1_hello.jpg")	
	#show(convert(img,12))
	#show(convert(img,5))
	#show(gray(img))
	#show(rotation(img,90))
	#show(crop(img,50,100,200,200))
	#show(difference(img,img3))
	#extract(img)
	#show(resize(img,500,500))
	#show(scale(img,50))
	#show(edges(img))
	#show(contrast(img,40))
	#show(brightness(img,10))
	#show(blur(img,40))
	#img = blur(img,30)
	#save(img)
	show(img2)
	
	


main()
