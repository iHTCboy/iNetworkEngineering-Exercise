/*
————————————
说明：
引用变量与引用函数的关系。
————————————
*/
# include <iostream>
using namespace std;
int &f(int &i)
{
   i+=10;//i=i+10;
   return i;
   
}
int main()
{
	int k=0;
	int &m=f(k);//用F调用K，并I引用K；执行I+=10；
	            //返回I（K）；引用F函数返回值，
	            //并赋给引用M。（K-I-F-M）
	cout<<k<<endl;
	m=20;       //（K-I-F-M）
	cout<<k<<endl;
	return 0;	
	
}

/*
———————————
结果：
10
20
———————————
*/