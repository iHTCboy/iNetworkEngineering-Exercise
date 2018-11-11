# include <stdio.h>
char  cchar(char  ch)
{
    if(ch>='A'&&ch<='Z')  
		ch=ch-'A'+'a';
    return  ch;
}
void main()
{    int  i=0;
     char   s[ ]="ABC+abc=defDEF";
     while( s[i] )
	 { s[i]=cchar(s[i]);
           i++;
	 }
     printf("%s\n",s);
}