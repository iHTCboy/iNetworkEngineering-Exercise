I=imread('lenna.bmp');
figure(1);
imshow(I);%显示图像I

figure(2);

fid=fopen('cell_128.img','r');    %打开无格式文件
data1=(fread(fid,[128,128],'uint8')); %将打开的文件读入到data1
subplot(2,2,1)                         %将figure(1)分成2*2的4个子窗口,
imshow(data1,[0 255]);                %显示时需将double型转换为整型
title('CELL 1','Color','b');            %加标题

fid=fopen('fing_128.img','r'); %打开无格式文件
data3=(fread(fid,[128,128],'uint8'))';%将打开的文件读入到data3
data3=uint8(data3);%将灰度图象转换成uint8格式
subplot(2,2,2);    %取第二个子窗口
imshow(data3);%显示灰度图象
title('finger 2','Color','b');

fid=fopen('Lena_256.img','r');
data4=(fread(fid,[256,256],'uint8'))';
subplot(2,2,3)
imagesc(data4);
colormap(gray);
title('LENA 3','Color','r');

figure(3);
I1=zeros(128,128);%生成一个128×128的全黑图像
for i=38:1:90
    for j=58:1:70
        I1(i,j)=255;%或I1(i,j)=1；
    end
end
imshow(I1);%I1即为所求图形。
imwrite(I1,'output.bmp');


