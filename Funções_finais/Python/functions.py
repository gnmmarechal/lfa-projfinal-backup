import cv2
import numpy as np
import sys

def open(path):
	return cv2.imread(path)

#Aceita valores de 1-100, mas os valores pares são reduzidos em 1
def blur(image,x):
	if x < 1 or x > 100:
		return image
	if x%2 == 0:
		x = x-1
	return cv2.GaussianBlur(image,(x,x),0)
	
#Aceita valores de 1-1000 100 = 100%
def zoom(image,x):
	if x < 1 or x > 1000:
		return image
	ratio = float(x)/100
	return  cv2.resize(image,None,fx=ratio,fy=ratio)
	

#Saturation



#Brightness



#Edges
def edges(image):
	return cv2.Canny(image,100,200)


#Contrast



#Scale



#Resize



#Extract



#Difference



def crop(image):
	r = cv2.selectROI(image, False)
	cv2.destroyAllWindows()
	cropped = image[int(r[1]):int(r[1]+r[3]), int(r[0]):int(r[0]+r[2])]
	if cropped.shape[0] <= 0 or cropped.shape[1] <= 0:
		return image;
	return cropped

def rotation(image, graus):
	(h, w) = image.shape[:2]
	center = (w / 2, h / 2)
	if isinstance(graus, str):
		try:
			graus = int(graus)
		except ValueError:
			print("graus is not a number")
			return image
	M = cv2.getRotationMatrix2D(center, graus, 1.0)
	rotated = cv2.warpAffine(image, M, (w, h))
	return rotated

def save(newfilename, image):
	cv2.imwrite(newfilename, image)

def show(image):
	cv2.imshow("", image)
	cv2.waitKey(0)
	cv2.destroyAllWindows()

def gray(image):
	return cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)

def main():
	img = open("harold1.jpg")
	img2 = open("harold2.jpg")
	show(img)
	show(rotation(img,90))
	show(gray(img))
	show(crop(img))
	show(blur(img,7))
	show(zoom(img, 50))
	show(edges(img))
	#save("harold_copy.jpg",img)

main()
