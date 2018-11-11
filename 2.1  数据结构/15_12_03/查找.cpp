#include <iostream>
using namespace std;
typedef int KeyType;       // 关键字的类型
const int MAXSIZE=100;     // 数组的容量
struct ElemType            //学生的记录信息
{
KeyType  key ;        //学号
char name[10];         //姓名
int english;            //成绩
int math;             //成绩
} ;
class List
{ 
public:
ElemType *ht;     //表数组
int length;       //表大小（长度）
//KeyType   p;      // 除留余数法的大质数
public:
	List( int n1,int p1);
	~List(){delete []ht;  length=0;};
	//int  find( KeyType k );
	int  search( KeyType k );
	//void  creat_hash();
	void PrintOut();
};
//-------------------------------------------------------------
List::List(int n1,int p1)
{ 
int num=0; 
length=n1;  p=p1;
ht=new ElemType[length];
for(int i=0;i<length;i++)ht[i].key=-1;
}
void  List::creat_hash()
{ 
int i,j,K,en,ma;char na[10];
cout<<"\n  请逐一输入各个学号（关键字值）（-1结束）："; cin>>K;
while(K!=-1&&num<length)
{ 
cout<<"\n  请输入学生的姓名，英语成绩和高数成绩：";
cin>>na>>en>>ma;
	ht[i].key=K;
	strcpy(ht[i].name,na);     //用串拷贝赋值
	ht[i].english=en;
	ht[i].math=ma;              //　插入学生记录K
	cout<<"\n   插入成功！" ; num++;
	cout<<"\n  请逐一输入各个学号（关键字值）（-1结束）：";
cin>>K;
}
}

//查询某关键字的记录
int  List::search( KeyType k )
{ 


}

void  List::PrintOut()
{ int i,j;
for (i=0;i<length; i++)
{
	if(ht[i].key!=-1)
		cout<<"\n  i="<<i<<"   学号："<<ht[i].key<<"  姓名："<<ht[i].name
		<<"   英语成绩："<<ht[i].english<<"   高数成绩："<<ht[i].math;
}
}
int main()
{  
int p0,n0;
cout<<"\n  请输入n值（n值应是记录总数的.3-1.5倍)";
cin>>n0;
cout<<"\n  请输入P值（应是不大于n 的大质数）："; 
cin>>p0;
List  ha(n0,p0);  
ElemType a;
int k; char ch;
do { cout<<"\n\n\n";
cout<<"\n       1. 建立哈希表 ";
cout<<"\n       2. 在哈希表中查找某位学生";
cout<<"\n       3. 输出哈希表";
cout<<"\n       4. 结束";
cout<<"\n==============================";
cout<<"\n       输入您的选择(1,2,3,4):"; cin>>k;
switch(k)
{ 
case 1:{  ha.creat_hash();
}  break;
case 2:{  
cout<<"\n  请输入待查找的学生学号：";  cin>>a.key;
	int i=ha.search(a.key);
	if(i==-1) 
		       cout<<"\n  此学生"<<a.key<<"  不存在！" ;
else
		   cout<<"\n  i="<<i<<"   学号："<<ha.ht[i].key<<"  姓名："<<ha.ht[i].name
		<<"   英语成绩："<<ha.ht[i].english<<"   高数成绩："<<ha.ht[i].math;
	   }   break;
case 3:{ ha.PrintOut(); }  break;
}
}while(k>=1&&k<=3);
getchar();        
return 0;
}