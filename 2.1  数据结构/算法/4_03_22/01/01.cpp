#include<stdio.h>
void main()
{
 int n,count=0;
 for(n=1000;n<=5000;n++)
  if(n%4==2&&n%7==3&&n%9==5)
  {
   printf("%d   ",n);
   count=count+1;
   if(count%5==0)
	   printf("\n");
  }
  printf("\ncount = %d\n",count);
}
