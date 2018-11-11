I=imread('lenna.bmp');  %读入原图像；
I = rgb2gray(I);
I=im2double(I);  %将原图像转为双精度数据类型；
T=dctmtx(8);  %产生二维DCT变换矩阵
B=blkproc(I,[8 8],'P1*x*P2',T,T');  %计算二维DCT，矩阵T及其转置T’是DCT函数P1*x*P2的参数
mask=[ 1 1 1 1 0 0 0 0
       1 1 1 0 0 0 0 0
       1 1 0 0 0 0 0 0
       1 0 0 0 0 0 0 0
       0 0 0 0 0 0 0 0
       0 0 0 0 0 0 0 0
       0 0 0 0 0 0 0 0
       0 0 0 0 0 0 0 0];      %二值掩膜，用来压缩DCT系数，只留下DCT系数中左上角的10个
B2=blkproc(B,[8 8],'P1.*x',mask);   %只保留DCT变换的10个系数
I2= blkproc(B2,[8,8],'P1*x*P2',T',T); %逆DCT，重构图像
subplot(1,2,1);
imshow(I);title('原图像'); %显示原图像
subplot(1,2,2);
imshow(I2);title('压缩图像');%显示压缩后的图像。对比原始图像和压缩后的图像，虽然舍弃了85%的DCT系数，但图像仍然清晰（当然有一些质量损失）
