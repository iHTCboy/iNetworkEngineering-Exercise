I = imread('lenna.bmp');
subplot(2,2,1);
imshow(I);
title('RGB Image'); 

J = rgb2gray(I);
J = im2double(J); 
subplot(2,2,2);
imshow(J);
title('Gray Image');

K = dct2(J);
subplot(2,2,3);
imshow(K);
title('DCT2 Image');

L = idct2(K);
subplot(2,2,4);
imshow(L);
title('IDCT2 Image');
