I = imread('lenna.bmp');
J = translate(I,200,200);
imshow(I);
title('Ô´Í¼Ïñ');
figure;
imshow(J);
title('translated');