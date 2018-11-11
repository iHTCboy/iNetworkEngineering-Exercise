# include <stdio.h>
int main ()
{
   void sort(int array[],int n);
   int i, a[10]={1,3,5,7,9,2,4,6,8,10};
   sort(a,10);
   printf("The sorted array:\n");
   //printf("%d\n",a[0]);
   for(i=0;i<10;i++)
	   printf("%  d",a[i]);
   printf("\n");
   return 0;
}

void sort(int array[],int n)
{
    int i,j,k,t;
	for(i=0;i<n-1;i++)
	{
		k=i;
		for(j=i+1;j<n;j++)
			if(array[j]<array[k])
			    k=j;
		if(k!=i)
		{
	    t=array[k];
		array[k]=array[i];
		array[i]=t;
		}
	}
}







