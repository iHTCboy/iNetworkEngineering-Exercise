# include <iostream>
using namespace std;
int main()
{
     char c[]="0123456789001112222";
     int i0=0,i1=0,i2=0,i3=0;
	 for (int i=0;i<19;i++)
	 switch(c[i]) 
	 { 
        case'0': i0++;break;
		case'1': i1++;break;
		case'2': i2++;break;
		default: i3++;break;
	 }
	 cout<<"i0="<<i0<<endl;
	 cout<<"i1="<<i1<<endl;
	 cout<<"i2="<<i2<<endl;
	 cout<<"i3="<<i3<<endl;

	 return 0;
}