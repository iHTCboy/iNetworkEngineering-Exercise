I=imread('cameraman.tif');
J = fft2(I);
figure,imshow(J);