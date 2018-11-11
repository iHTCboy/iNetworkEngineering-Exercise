//栈的顺序存储结构，顺序表类
#include<iostream.h>
//------------------------------栈的顺序存储结构---------------------------------------------
typedef int  ElemType;     // 数据元素的类型
const int MAXSIZE=100;     // 数组的容量


struct Node
{
//————数据成员————

      int entry;
      Node *next;  
   
//————成员函数————（重载）

   Node();  //Node的构造函数
   Node(int item,Node *add_on=0);   //多重构造函数，初始化数据成员
};


Node::Node()
 {
	 next=0;  //将next设为NULL，作为错误检查的安全措施
}


Node::Node(int item,Node *add_on) 
{
	  entry=item;
      Next=add_on; //指定一个NULL的默认值，使用两个参数或仅用第一个参数就能调用些构造函数
}


class  Stack  //定义链栈
  { 
        protected:
            Node *top_node; //定义栈顶结点指针
        public:
            Stack( void);                    //构造函数
          //~Stack(){};
            Bool  empty() ;                 //判断链栈是否为空
            void  push(  ElemType &item);  //链栈的入栈
            ElemType  pop();               //链栈的出栈
            ElemType  top(ElemType &item );
    };

//———————————————————————————————————————

Stack:: Stack( void): top_node (0){ }

//———————————————————————————————————————

bool  Stack:: Empty()
   { 
	    if (top_node==0)
             return 1;
        else return 0;

   }

//———————————————————————————————————————

void  Stack::push(  ElemType &e)
{ 




}

//———————————————————————————————————————

int Stack::pop()
 {




}

//———————————————————————————————————————

int  Stack:: top ()
  {
	  if (top_node==0) 
		  return 0;
      else  
		  return top_node->entry;
 }

//———————————————————————————————————————

int main(int argc, char* argv[])
{ 
	int i,k;
	ElemType e,x;
	Stack  as;
	cout<<"\n                           顺序表存储结构演示";
	do{
        cout<<"\n\n";
        cout<<"\n\n    1.插入一个数据元素e（入栈）";
        cout<<"\n\n    2.删除一个元素，返回其值（出栈）";
        cout<<"\n\n    3..结束程序";
        cout<<"\n******************************** ";
        cout<<"\n    请输入你的选择(1,2,3,4,5,6)";    cin>>k;
    switch(k)
	{
          case 1:{
			        cout<<"\n 入栈，数据 e=?";
                    cin>>e;
                    as.push(e);
                    as.top()
              }break;
          case 2:{ 
			        cout<<"\n 出栈";
                    x=as.pop();
                    cout<<"\n  出栈元素数值= "<<x;
                  
             }break;
         default:break;
	} //switch
         cout<<"\n--------------------------------- ";
	}while(k>=1&&k<3);

  cout<<"\n          再见!";
  cout<<"\n     按任意键，返回。";
  return 0;
}

