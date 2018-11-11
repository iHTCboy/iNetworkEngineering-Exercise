I=imread('cameraman.tif');
subplot(2,1,1)
imshow(I);
subplot(2,1,2)
J= fft2(I);
imshow(J)
