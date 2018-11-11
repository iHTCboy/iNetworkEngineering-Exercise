//栈的顺序存储结构，顺序表类
#include<iostream.h>
//------------------------------栈的顺序存储结构---------------------------------------------
typedef int  ElemType;     // 数据元素的类型
const int MAXSIZE=100;     // 数组的容量
class SqStack
  { private:
      ElemType  elem[MAXSIZE];
      int top;
    public:
      SqStack( void);
      ~SqStack(){};
      int  SqStack::SetEmpty();
      void  SqStack::push(  ElemType e);
      ElemType SqStack::pop();
      void SqStack::PrintOut();
     int SqStack::IsEmpty(void)const ;
};
//-------------------------------------------------------------
SqStack::SqStack( void):top(0){ }
int  SqStack::SetEmpty()
   { return top==0;
   }

void  SqStack::push(  ElemType e)
{ 




}
ElemType SqStack::pop()
 {
    


}
void SqStack::PrintOut()
  {int k;
   cout<<"\n PrintOut Data:\n" ;
   for(k=top; k>=1;k--) cout<<elem[k];
   cout<<endl;
 }
int SqStack::IsEmpty(void)const
{ if(top==0) return 1;
     else return 0;
 }
//---------------------------------------------------------------------------
int main(int argc, char* argv[])
{ int k;
  ElemType e,x;
  SqStack  as;
   cout<<"\n                           顺序表存储结构演示";
  do{
    cout<<"\n\n";
    cout<<"\n\n    1.插入一个数据元素e（入栈）";
    cout<<"\n\n    2.删除一个元素，返回其值（出栈）";
    cout<<"\n\n    3..结束程序";
    cout<<"\n******************************** ";
    cout<<"\n    请输入你的选择(1,2,3,4,5,6)";    cin>>k;
    switch(k){
       case 1:{cout<<"\n 入栈，数据 e=?";
               cin>>e;
               as.push(e);
               as.PrintOut();
              }break;
       case 2:{  cout<<"\n 出栈";
                 x=as.pop();
                 cout<<"\n  出栈元素数值= "<<x;
                  as.PrintOut();
             }break;
       default:break;
         } //switch
     cout<<"\n--------------------------------- ";
    }while(k>=1&&k<3);
  cout<<"\n          再见!";
  cout<<"\n     按任意键，返回。";
  //_getch(); 
  return 0;
}

