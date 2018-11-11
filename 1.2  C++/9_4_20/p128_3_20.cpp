/*
   1。关于静态成员的运用
   2。调用构造函数的次数
   3。指针对象的应用

*/
# include <iostream>
using namespace std;
class aClass
{
public:
	aClass()
	{
	   total++;
	}
   ~aClass()
   {
  total--;
   }
   int gettotal()
   {
   return total;
   }
private:
	static int total;
};
int aClass::total=0;
int main()
{
   aClass o1,o2,o3;
   cout<<o1.gettotal()<<"objects in existence\n";
	   aClass*p ;
   p=new aClass;
   if(!p)
   {
      cout<<"Allocation error \n";
	  return 1;
   }
	  cout<<o1.gettotal();
	  cout<<"objects in existence after allocation\n";
	  delete p;
	  cout<<o1.gettotal();
	  cout<<"objects in existence after deletion\n";
	  return 0;
   
}