import cv2
import numpy as np
import sys

def crop(image):
	r = cv2.selectROI(image)
    # Crop image
	imCrop = image[int(r[1]):int(r[1]+r[3]), int(r[0]):int(r[0]+r[2])]
	return imCrop
	

def rotation(image, graus):
	(h, w) = image.shape[:2]
	center = (w / 2, h / 2)
	# rotate the image by 180 degrees
	if isinstance(graus, str):
		try:
			graus = int(graus)
		except ValueError:
			print("graus is not a number")
	M = cv2.getRotationMatrix2D(center, graus, 1.0)
	rotated = cv2.warpAffine(image, M, (w, h))
	return rotated

def save(filename, image):
	cv2.imshow("Crop result", image)
	k = cv2.waitKey(0)
	while True:
		if k == ord("y"):
			cv2.imwrite("cropped" + filename, image)
			break
		elif k == ord("n"):
			break
	cv2.destroyAllWindows()

def main():
	filename = "sunfield.jpg"
	img = cv2.imread(filename)
	img = rotation(img, 180)
	img = crop(img)
	save(filename, img)
	cv2
	
	
	
		
		

main()