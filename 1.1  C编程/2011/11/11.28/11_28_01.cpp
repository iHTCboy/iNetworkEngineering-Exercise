# include <stdio.h>
int main ()
{
     int str_sum(int a[],int i,int j);
	 int x,a[]={1,2,3,4,5,6,7,8,9};
	 x=str_sum(a,3,7);
	 printf("%d\n",x);
	
  return 0;
}

int str_sum(int a[],int i,int j)
{
      int k,sum=0;
	  for(k=i;k<j;k+=2);
		  sum=sum+a[k];

	  return sum;

}