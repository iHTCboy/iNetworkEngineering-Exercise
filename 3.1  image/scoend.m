function J=translate(I,x,y);
tfom = maketform('affine'[1 0 x;0 1 y;0 0 1]');
J = imtransfrom (I,tform,'XData',[1 size(I,2)+x],'YData',[1 size(I,1)+y],'FillValues',0);

