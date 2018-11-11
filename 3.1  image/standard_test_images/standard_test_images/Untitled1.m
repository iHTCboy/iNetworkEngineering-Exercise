I=imread('cameraman.tif');
imshow(I);
J= fft2(I);
imshow(J)