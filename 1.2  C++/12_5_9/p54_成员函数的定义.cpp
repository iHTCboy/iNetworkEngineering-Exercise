# include <iostream>
using namespace std;
class point
{
   public:
	  point(int a,int b)
	  {
	    x=a;y=b;
	  }
	  int wo(int,int);
      int getx();
	  int gety();
   private:
	  int x,y;	
};
int point::wo(int a,int b)
{
    x=a;y=b;
	cout<<x<<";"<<b<<endl;
	return	x;
}
int point::getx()
{
   return x;
}
int point::gety()
{
   return y;
}
void main ()
{   
    point A(1314,520);
	A.wo(3,4);
	cout<<A.wo()<<endl;
    cout<<A.getx()<<endl;
    cout<<A.gety()<<endl;
}