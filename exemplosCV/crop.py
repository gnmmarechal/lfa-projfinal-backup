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
    k = cv2.waitKey(0)
    while True:
        if k == ord("y"):
            cv2.imwrite(newfilename, image)
            break
        elif k == ord("n"):
            break
    cv2.destroyAllWindows()


def show(image):
    cv2.imshow("Result", image)
    cv2.waitKey(0)
    cv2.destroyAllWindows()


def gray(image):
    return cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)


def movieframework(bg, img, x, y):
    (x1, x2) = x
    (y1, y2) = y
    final = bg.copy()
    final[x1:x2, y1:y2] = img
    return final

def movie(background, img):
    img = cv2.resize(img, (100, 100))
    print(background.shape)
    background = cv2.resize(background, (400, 400))
    print(background.shape)
    print(img.shape)
    imgwidth, imgheight, _ = img.shape
    bgwidth, bgheight, _ = background.shape
    finalimg = movieframework(background, img, (300, 400), (0, 100))
    # Variavel de estado da imagem (posicao dela numa grid do background, por agora apenas horizontal) e limite
    horizontalindex = 0
    limit = 4
    while True:
        cv2.imshow("Movie", finalimg)
        k = cv2.waitKeyEx()
        if k == 65363:
            print("right")
            horizontalindex += 1
            if horizontalindex >= limit:
                horizontalindex -= 1
            else:
                finalimg = movieframework(background, img, (300, 400), (horizontalindex*100, horizontalindex*100 + 100))
        elif k == 65361:
            print("left")
            horizontalindex -= 1
            if horizontalindex >= 0:
                finalimg = movieframework(background, img, (300, 400), (horizontalindex*100, horizontalindex*100 + 100))
            else:
                horizontalindex += 1
        else:
            print("Only horizontal moves alowed! Use the right and left arrow keys")
            break


def main():
    filename = "sunfield.jpg"
    img = cv2.imread(filename)
    background = np.zeros([400, 400, 3], np.uint8)
    """print(img.shape)
	img = rotation(img, 180)
	img = crop(img)
	img = gray(img)
	save(filename, img)"""
    movie(background, img)


main()
