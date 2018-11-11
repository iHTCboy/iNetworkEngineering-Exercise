/*
——————————
说明：
引用的作用，引用与被引用的值一样。
——————————
*/
# include<iostream>
using namespace std;
void f(int & m,int n)
{
    int temp;
	temp=m;
	m=n;
	n=temp;
	cout<<n<<endl;
	
}

  int main()
{
   int a=5,b=10;
   f(a,b);
   cout<<a<<"  "<<b<<endl;
   return 0;
}
 
/*
——————————
结果：

 5
10  10

——————————
*/