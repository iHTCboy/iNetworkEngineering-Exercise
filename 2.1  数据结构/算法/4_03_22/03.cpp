#include <stdio.h>
void main()
{
	int a,b,k,n,i,j,h,t,u,c[3000],d[3000];
	printf("input the number a,b,k:\n");
	scanf("%d %d %d",&a,&b,&k);
	n=0;
	for(j=a;j<=b;j++)
	{
		for(i=1;i<=j-1;i++)
		{
			for(t=0,u=2;u<=i;u++)
				if(j%u==0&&i%u==0)
				{
					t=1;
					break;
				}
				if(t==0)
				{
					n++;
					c[n]=i;
					d[n]=j;
				}
		}
	}

	for(i=1;i<=n-1;i++)
		for(j=1;j<=n-i;j++)
			if(c[j]*d[j+1]>c[j+1]*d[j])
			{
				h=c[j];
				c[j]=c[j+1];
			    c[j+1]=h;
				h=d[j];
				d[j]=d[j+1];
				d[j+1]=h;
			}
	printf("The total number is:n=%d\n",n);
	printf("the %d is:%d/%d\n",k,c[k],d[k]);
}