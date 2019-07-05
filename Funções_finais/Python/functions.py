import cv2
import numpy as np
import sys

def open(path):
	return cv2.imread(path)
	
def save(newfilename, image):
	cv2.imwrite(newfilename, image)

def show(image):
	cv2.imshow("Result", image)
	cv2.waitKey(0)
	cv2.destroyAllWindows()
	
#Aceita valores de 1-100, mas os valores pares são reduzidos em 1
#Utiliza Gaussian Blur simples
def blur(image,x):
	if x < 1 or x > 100:
		print("Invalid blur value. Values: 1 - 100")
		return image
	if x%2 == 0:
		x = x-1
	return cv2.GaussianBlur(image,(x,x),0)
	
#Aceita valores de 1-1000 100 = 100%
"""
Função removida
def zoom(image,x):
"""	
	

#Aceita valores de 0-300. Predefinido: 100
def contrast(image, x):
	if x < 0 or x > 300:
		print("Invalid contrast value. Values: 0 - 300")
		return image
	return colours(image,x/100,1)

#Aceita valores de 0-100. Predefinido: 50
def brightness(image, x):
	if x < 0 or x > 100:
		print("Invalid brightness value. Values: 0 - 100")
		return image
	return colours(image,1,x-50)

#Função auxiliar
def colours(image, a, b):
	#alpha altera o contraste
	#beta altera o brilho
	return cv2.convertScaleAbs(image, alpha=a, beta=b)

def edges(image):
	return cv2.Canny(image,100,200)

#Aceita valores de 1-1000 100 = 100%
def scale(image,x):
	if x < 1 or x > 1000:
		print("Invalid scale value. Values: 1 - 1000")
		return image
	return cv2.resize(image, None, fx=x/100, fy=x/100)
	
def resize(image,w,h):
	if w < 1 or h < 1:
		print("Invalid resizing values.")
		return image
	return cv2.resize(image,(w,h))

#Função adaptada da documentação do OpenCV
#Guarda os ficheiros das caras
def extract(image):
	gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
	faceCascade = cv2.CascadeClassifier(cv2.data.haarcascades + "haarcascade_frontalface_default.xml") 
	faces = faceCascade.detectMultiScale(
		gray,
		scaleFactor=1.3,
		minNeighbors=3,
		minSize=(30, 30)
	)
	print("Found {0} Faces.".format(len(faces)))
	for (x, y, w, h) in faces:
		cv2.rectangle(image, (x, y), (x + w, y + h), (0, 0, 0), 2)
		roi_color = image[y:y + h, x:x + w]
		print("Face found. Saving.")
		cv2.imwrite(str(w) + str(h) + '_faces.jpg', roi_color)
		
#As imagens necessitam de ter o mesmo tamanho ou então as imagens levam resize para a menor resolução possível
def difference(image1,image2):
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
		return cv2.absdiff(new_img1,new_img2)
	return cv2.absdiff(image1,image2)

#Ponto dado corresponde ao canto inferior esquerdo do resultado
#Uso Crop Imagem (x,y) width heigth
def crop(image,x,y,w,h):
	if x < 0 or y < 0:
		print("Invalid coordinates.")
		return image
	if w < 0 or h < 0:
		print("Invalid rectangle size.")
		return image
	return image[y:y+h, x:x+w]


#Função interativa
def cropInt(image):
	r = cv2.selectROI(image, False)
	cv2.destroyAllWindows()
	cropped = image[int(r[1]):int(r[1]+r[3]), int(r[0]):int(r[0]+r[2])]
	if cropped.shape[0] <= 0 or cropped.shape[1] <= 0:
		return image
	return cropped

def rotation(image, graus):
	(h, w) = image.shape[:2]
	center = (w / 2, h / 2)
	if isinstance(graus, str):
		try:
			graus = int(graus)
		except ValueError:
			print("Given value is not a number")
			return image
	M = cv2.getRotationMatrix2D(center, graus, 1.0)
	rotated = cv2.warpAffine(image, M, (w, h))
	return rotated

def gray(image):
	return cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
""" Função removida
def hue(image,x):
	if x < 0 or x > 255:
		print("Invalid hue value. Values: 0 - 255")
		return image
	w = 0
	h = 0
	hsv = convert(image,5)
	while(not h > image.shape[0]):
		while(not w > image.shape[1]):
			p = hsv[w,h]
			t = p[0] + x
			if t < 0:
				t = 0
			if t > 255:
				t = 255
			p[0] = t 
			w = w + 1
		h = h + 1
	return cv2.cvtColor(hsv, cv2.COLOR_HSV2BGR)
"""
def filter(image,r,g,b):	
	new = np.zeros(image.shape, image.dtype)
	for h in range(image.shape[0]):
		for w in range(image.shape[1]):
			new[h,w] = [image[h,w][0] * b, image[h,w][1] * g, image[h,w][2] * r]
	return new
	
def convert(image,type):
	if type == 1:
		return filter(image,1,0,0)
	if type == 2:
		return filter(image,0,1,0)
	if type == 3:
		return filter(image,0,0,1)
	if type == 4:
		return cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
	if type == 5:
		return cv2.cvtColor(image, cv2.COLOR_BGR2HLS)
	if type == 6:
		return cv2.cvtColor(image, cv2.COLOR_BGR2LUV)
	if type == 7:
		return cv2.cvtColor(image, cv2.COLOR_BGR2XYZ)	
	if type == 8:
		return cv2.cvtColor(image, cv2.COLOR_BGR2RGB)	
	if type == 9:
		return cv2.cvtColor(image, cv2.COLOR_BGR2YUV)
	if type == 12:
		return filter(image,1,1,0)
	if type == 13:
		return filter(image,1,0,1)
	if type == 23:
		return filter(image,0,1,1)
	print("Type not recognized")	
	return image


def main():
	img = open("harold1.jpg")
	img2 = open("harold2.jpg")
	img3 = open("harold1_hello.jpg")
	#show(img)
	show(convert(img,12))
	#show(crop(img2,450,200,8000,400))
	#show(scale(img,1000))
	#show(brightness(img,0))
	#show(contrast(img,70))
	#show(img)
	#show(difference(img,img2))
	#show(img2)
	#extract(img2)
	#show(resize(img,1000,10))
	#show(rotation(img,40))
	#show(gray(img))
	#show(cropInt(img))
	#show(blur(img,7))
	#show(edges(img))
	#save("harold_copy.jpg",img)

main()
