#include <stdio.h> 
#include <math.h> 
#include <stdlib.h> 
int sum=0;/*记录方案的个数*/ 
int Place(int k,int *x) 
/*判断新加入的皇后所在的位置 k 是否与其他皇后的位置冲突，此函数用来作为是否进行剪枝的判断条件*/ 
{ 
int j; 
for(j=1;j<k;j++) 
if( (abs(k-j) == abs(x[j]-x[k])) || (x[j]==x[k]) )/*x[i]表示皇后 i 放在棋盘的第 i 行的第x[i]列*/ 
return 0;/*能攻击到其他皇后，返回 0 */ 
return 1;/*不能攻击到其他皇后，返回 1 */ 
} 

void Backtrack(int t,int n,int *x) 
/*递归回溯求解*/ 
{ 
int i; 
if(t>n) 
{ 
sum++; 
/*输出一个方案*/ 
printf("方案%d：",sum); 
for(i=1;i<=n;i++) 
printf("(%d,%d) ",i,x[i]); 
printf("\n"); 
} 
else 
for(i=1;i<=n;i++) 
{ 
x[t]=i; 
if(Place(t,x)) Backtrack(t+1,n,x);/*如果新加入第t个皇后所在的位置 i 没有与其他皇后的位置冲突，则进入解空间子树，试探第t+1个皇后的位置；否则不进入子树，舍弃该段子树，即进行剪枝*/ 
} 
} 

main() 
{ 
int n,*x; 
int i; 
printf("请输入皇后的个数："); 
scanf("%d",&n); 
x=(int *)malloc((n+1)*sizeof(int));/*x[0]未使用*/ 
printf("以下每个方案都表示出了%d个皇后在棋盘上的坐标\n\n",n); 
Backtrack(1,n,x);/*求解*/ 
printf("总共有%d种方案\n",sum); 
}
