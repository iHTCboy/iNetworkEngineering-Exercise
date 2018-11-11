% 读取图像
I =imread('考核实验图像.gif');           
subplot(2,4,1);                   
imshow(I);                                  
title('源图像');                  

%直方图均衡化处理
subplot(2,4,2);
imhist(I);
title('均衡化前直方图');
J =histeq(I);
subplot(2,4,3),
imshow(J);
title('均衡化后图像');
subplot(2,4,4),
imhist(J);
title('均衡化后直方图');



%灰度调整
K = imadjust(J,[0.7 0.9],[]);
subplot(2,4,5),
imshow(K);
title('原图所变换的灰度范围为(0.7 0.9)');




%平滑与锐化处理
K =double(K);
P =wiener2(K); %二维维纳滤波wiener2 
subplot(2,4,6),
imshow(P,[]);
title('自适应滤波平滑处理后的图像');




%边缘检测处理
M =edge(I, 'canny', [0.1 0.35]);   %用canny算子找出边缘
subplot(2,4,7)       
imshow(M);                                  
title('用canny算子处理的图像')           




%图像叠加
M1 = 800*M;  %边缘加强
N =imlincomb(0.3,M1,0.7,P); %0.3、0.7参数为两幅图叠加权值
subplot(2,4,8) ;
imshow(N ,[]);
title('最终的图像');
