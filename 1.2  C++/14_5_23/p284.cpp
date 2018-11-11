# include <iostream>
using namespace std;
template <typename T>//模板声明，其中T为类型参数
class compare//类模板名为compare
{
    public:
	  compare(T a,T b)
	  {
	     x=a;  y=b;
	  }
       T min();
	 private:
	   T x,y;
};
template<typename T>// 模板声明
T compare<T>::min()//在类模板体外定义成员函数min，返回类型为T
{
	return(x<y)?x:y;
}
int main()
{
   compare <int> com1(3,7);//用类模板定义对象com1，此时T被int替代
   cout<<"其中的最小值是："<<com1.min()<<endl;
   return 0;

}