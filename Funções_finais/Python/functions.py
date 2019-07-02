import cv2
import numpy as np
import sys

#OpenImage



#Blur



#Zoom



#Saturation
#import cv2

img = cv2.imread("D:\\testing\\test.png",1)

hsv = cv2.cvtColor(img, cv2.COLOR_BGR2HSV)
greenMask = cv2.inRange(hsv, (26, 10, 30), (97, 100, 255))


#Brightness



#Edges



#Contrast



#Scale



#Resize



#Extract



#Contour



#Difference
