/*
2.	穷举三位数的水仙花数。
水仙花数是指一个 n 位数 ( n≥3 )，
它的每个位上的数字的 n 次幂之和等于它本身。
（例如：13 + 53 + 33 = 153）*/

#include <stdio.h>
void main()
{
int a,b,c,d;
for(a=100;a<=999;a++)
{
	b=a/100;
	c=a/10-b*10;
	d=a-b*100-c*10;

	if(b*b*b+c*c*c+d*d*d==a) 
		printf("%d = %d^3 + %d^3 + %d^3\n",a,b,c,d);
}
}
