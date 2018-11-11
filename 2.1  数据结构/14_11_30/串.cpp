#include<string.h>
#include <iostream>
using namespace std;
//-------串--------
class String1
{public:
     String1(){};
     ~String1(){};
     void Insert(string t,int pos);     //插入数据
     void Delete(int pos,int num);   //删除数据
     void Creat();                  //生成新字符串函数
     void Display();                //输出结果
  private:
     char *str;                     //数据内容
     int size;                      //长度
 };
//------生成新字符串函数--------
void String1:: Creat()
 {
	//char *s=new char[20];  
char *s="follow me sunshine";	
//cin>>s;
    size=strlen(s);                    //测算长度
    str=new char[size];               //新建临时str
if(str==0)  
cout<<"没有申请到空间！";
    strcpy(str,s);                      //把s数据内容复制给str
 }
//--------输出----------
void String1::Display()
{ int i;
  for(i=0;i<size;i++)  
cout<<str[i];
  cout<<endl;
}
//---插入运算:在串对象s的pos位置后插入一个串t---
//
void String1::Insert(string t,int pos)    
{




}
//------删除:删除串中的一个子串-------
 void  String1:: Delete(int pos,int num)
{ 





}
//--------主函数---------
 int main(int argc, char* argv[])
{  int pos,num,k;
   string s,s1,t;
   do{  cout<<"\n\n    1.生成字符串"  ;
        cout<<"\n\n    2.插入子串s1";
        cout<<"\n\n    3.删除子串";
        cout<<"\n\n    4.结束程序";
        cout<<"\n******************************** ";
        cout<<"\n    请输入你的选择(1,2,3,4)";  cin>>k;
  switch(k){
       case 1:{cout<<"请输入一个字符串：";
               s.Creat();
               cout<<"字符串为：      ";     s.Display();
              }break;
      case 2:{ cout<<"请输入子串插入位置pos"<<endl;
                cin>>pos;
                cout<<"请输入要插入的子串:  ";   cin>>s1;
                s.Insert(s1,pos);
                cout<<"插入后的字符串为：  ";  s.Display();
              }break;
       case 3:{ cout<<"请输入要删除子串的开始位置pos及子串长度num"<<endl;
               cin>>pos>>num;
               s.Delete(pos,num);
               cout<<"删除后的字符串为：  ";
               s.Display();
             }break;
     default:break;
  }
 //switch
     cout<<"\n--------------------------------- ";
}while(k>=1&&k<5);
  cout<<"\n          再见!";
  cout<<"\n     按任意键，返回。";
  return 0;
}
