I=imread('cameraman.tif');
%subplot(2,2,1)
%imshow(I);
J=fft2(I);
%subplot(2,1,2)
imshow(J);