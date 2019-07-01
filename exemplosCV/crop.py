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


def save(newfilename, image):
    cv2.imshow("Result", image)
    cv2.imwrite(newfilename, image)
    cv2.destroyAllWindows()

""" Para esta função poderá haver diversas maneiras de a concretizar
Mas o pedido de confirmação deveria ficar antes da função
def save(newfilename, image):
    cv2.imshow("Result", image)
    k = cv2.waitKey(0)
    while True:
        if k == ord("y"):
            cv2.imwrite(newfilename, image)
            break
        elif k == ord("n"):
            break
    cv2.destroyAllWindows()
"""

def show(image):
    cv2.imshow("Result", image)
    cv2.waitKey(0)
    cv2.destroyAllWindows()


def gray(image):
    return cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)



def imagePlacer(image1, image2, corner):
    if(corner == "BL"):
        image1[0:image2.shape[0], 0:image2.shape[1]] = image2
    elif(corner == "BR"):
        image1[image1.shape[0] - image2.shape[0]:image1.shape[0], image1.shape[1] - image2.shape[1]:image1.shape[0]] = image2
    elif(corner == "UL"):
        image1[image1.shape[0] - image2.shape[0]:image1.shape[0], 0:image2.shape[1]] = image2
    elif(corner == "UR"):
        image1[0:image2.shape[0], image1.shape[1] - image2.shape[1]:image1.shape[0]] = image2
    else:
		print("invalid parameter")
    return image1


def main():
    filename = "sunfield.jpg"
    img = cv2.imread(filename)
    img = cv2.resize(img, (100, 100))
    background = np.zeros([400, 400, 3], np.uint8)
    """print(img.shape)
	img = rotation(img, 180)
	img = crop(img)
	img = gray(img)
	save(filename, img)"""
    background = imagePlacer(background, img, "UR")
    cv2.imshow("corner", background)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

main()
