I=imread('lenna.bmp');  %����ԭͼ��
I = rgb2gray(I);
I=im2double(I);  %��ԭͼ��תΪ˫�����������ͣ�
T=dctmtx(8);  %������άDCT�任����
B=blkproc(I,[8 8],'P1*x*P2',T,T');  %�����άDCT������T����ת��T����DCT����P1*x*P2�Ĳ���
mask=[ 1 1 1 1 0 0 0 0
       1 1 1 0 0 0 0 0
       1 1 0 0 0 0 0 0
       1 0 0 0 0 0 0 0
       0 0 0 0 0 0 0 0
       0 0 0 0 0 0 0 0
       0 0 0 0 0 0 0 0
       0 0 0 0 0 0 0 0];      %��ֵ��Ĥ������ѹ��DCTϵ����ֻ����DCTϵ�������Ͻǵ�10��
B2=blkproc(B,[8 8],'P1.*x',mask);   %ֻ����DCT�任��10��ϵ��
I2= blkproc(B2,[8,8],'P1*x*P2',T',T); %��DCT���ع�ͼ��
subplot(1,2,1);
imshow(I);title('ԭͼ��'); %��ʾԭͼ��
subplot(1,2,2);
imshow(I2);title('ѹ��ͼ��');%��ʾѹ�����ͼ�񡣶Ա�ԭʼͼ���ѹ�����ͼ����Ȼ������85%��DCTϵ������ͼ����Ȼ��������Ȼ��һЩ������ʧ��