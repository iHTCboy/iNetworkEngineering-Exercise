# include <iostream>
using namespace std;
int  main()
{
    int a,b,c,d,t;
	cout<<"输入四个数字:"<<endl;
	cin>>a>>b>>c>>d;
	cout<<"这四个数从小到大的结果为："<<endl;
	if(a>b)
	{
		t=a;
		a=b;
		b=t;	
	}
    if(a>c)
	{
	    t=a;
		a=b;
		b=t;
	}
    if (a>d) 
	{t=a;a=d;d=t;} 
	if (b>c) 
	{t=b;b=c;c=t;}
	if (b>d) 
	{t=b;b=d;d=t;}
	if (c>d) 
	{t=c;c=d;d=t;}
	
	cout<<a<<"<"<<b<<"<"<<c<<"<"<<d<<endl;

    return 0;
}