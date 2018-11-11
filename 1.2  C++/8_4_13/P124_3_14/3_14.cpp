# include <iostream>
using namespace std;
class B
{
   public:
	B(){}
	B(int i,int j)
	{
	   x=i;
	   y=j;	
	}
	void printb()
	{
	   cout<<x<<","<<y<<endl;
	   	}
   private:
	   int x,y;
};

class A
{
    public:
		A(){}
		A(int I,int J);
		void printa();
	private:
		B c;
};

A::A(int i,int j):c(i,j)
{

}

void A::printa()
{
   c.printb();
}

int main()
{
   A a(7,8);
   a.printa();
   return 0;
}