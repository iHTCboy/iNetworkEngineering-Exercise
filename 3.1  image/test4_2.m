I = imread('G:\D—HTC\image\cameraman.tif');
subplot(3,3,1)
imshow(I);
title('Original Image'); 

J = imnoise(I,'gaussian',0,0.005);
subplot(3,3,2)
imshow(J);
title('高斯噪声'); 

K = imnoise(I,'salt & pepper',0.02);
subplot(3,3,3)
imshow(K);
title('椒盐噪声'); 


H = fspecial('average',[3 3]);
filter2(H);
subplot(3,3,4);
title('高斯-均值滤波1');


M2 = imfilter(K,H);
U2 = filter2([3 5;3 5],M2);
subplot(3,3,5);
imshow(U2);
title('椒盐-均值滤波2');

A = medfilt2(J);
subplot(3,3,6);
imshow(A);
title('高斯-中值滤波1');

B = medfilt2(K);
subplot(3,3,7);
imshow(B);
title('椒盐-中值滤波2');


