#include <stdio.h>
int a[10],s=0;
void main()
{ int put(int k);
put(1); // 调用递归函数put(1) 
printf(" 共有以上%d个解。\n",s);
}
// 桥本分数式递归函数 
#include <stdio.h>
int put(int k)
{ int i,j,u,m1,m2,m3;
if(k<=9)
{ for(i=1;i<=9;i++) // 探索第k个数字取值i 
{ a[k]=i;
for(u=0,j=1;j<=k-1;j++)
if(a[k]==a[j]) 
u=1; // 出现重复数字,则置u=1 
if(u==0) // 若第k个数字可为i 
{ if(k==9 && a[1]<a[4]) // 若已９个数字，则检查等式 
{m1=a[2]*10+a[3];m2=a[5]*10+a[6];
m3=a[8]*10+a[9];
if(a[1]*m2*m3+a[4]*m1*m3==a[7]*m1*m2)
{ s++; printf(" <->: ",s);  // 输出一个解 
printf("%d/%d+%d/%d",a[1],m1,a[4],m2);
printf("=%d/%d ",a[7],m3);
if(s%2==0) printf("\n");
}
}
else put(k+1); // 若不到９个数字，则调用 put(k+1) 
}
}
}
return s;
} 
