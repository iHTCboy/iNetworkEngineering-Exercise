# include <iostream>
using namespace std;
class base
{
    public:
		base()   //声明基类base
		{
		   a=5;
		   cout<<66<<"base a="<<a<<endl;		
		}
	protected:
		int a;
};
class base1:virtual public base  //声明类base是base1的虚基类
{
     public:
		int b1;
		base1()
		{
		   a=a+10;
		   cout<<"base1 a="<<a<<endl;		
		}
};
class base2:virtual public base  //声明类base是base2虚基类
{
     public:
		 int b2;
		 base2()
		 {
		   a=a+20;
		   cout<<"base2 a="<<a<<endl;		 
		 }
};
class derived:public base1,public base2
//derived是base1和base2的共同派生类，是base的间接派生类
{
    public:
		int d;
		derived()
		{
		   cout<<"derived a="<<a<<endl;		
		}
};
int main()
{
   derived obj;
   return 0;
}