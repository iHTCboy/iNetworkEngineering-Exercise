# include <stdio.h>
int main ()
{
    int a=1,b=2,c=3,*pa=&a,*pb=&b,*pc=&c;
	a++;
	c+=b;
	{
	   int b=4,c,*pb=&b,*pc=&c;
	   c=2*b;
	   a+=c;
	   printf("%d,%d,%d\n",*pa,*pb,*pc);

	}
	  printf("%d,%d,%d\n",*pa,*pb,*pc);

   return 0;
}

/*
   ½á¹û£º
        10,4,8
        10,2,5
*/
