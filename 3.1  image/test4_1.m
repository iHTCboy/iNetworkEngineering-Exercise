I = imread('G:\D—HTC\image\cameraman.tif');
subplot(2,2,1);
imshow(I);
title('Original Image'); 

subplot(2,2,2);
axis([0 255 0 1]);
imhist(I);
title('Original 直方图'); 

K = histeq(I,10);
subplot(2,2,3);
imshow(K);
title('直方图均衡化'); 

subplot(2,2,4);
axis([0 255 0 1]);
imhist(K);
title('均衡化 直方图'); 



