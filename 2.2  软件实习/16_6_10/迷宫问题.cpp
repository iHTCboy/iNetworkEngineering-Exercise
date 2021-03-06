#include<iostream>
#include <string>
#include<stdio.h>    //exit(0) 控制程序直接退出
using namespace std;

//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【定义迷宫数据结构】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡

class T             //定义描述迷宫中当前位置的结构类型
{
       public:
       int x;          //x代表当前位置的行坐标
       int y;          //y代表当前位置的列坐标
       int dir;        //0:无效,1:东,2:南,3:西,4:北
};


//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【定义链表结点】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡

class LinkNode        //链表结点
{
            friend class Stack;   //将外部class Stack声明为LinkNode类的友元函数
    public:
            T data;
            LinkNode *next;
};


//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【定义栈数据结构】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡

class Stack
{
      private:
               LinkNode *top;             //指向第一个结点的栈顶指针
      public:
              Stack();                    //构造函数，置空栈
              ~Stack();                   //析构函数
			  void Push(T e);             //把元素data压入栈中
			  T Pop();                    //使栈顶元素出栈
			  T GetPop();                 //取出栈顶元素
			  void Clear();               //把栈清空
			  bool empty();               //判断栈是否为空，如果为空则返回1，否则返回0
};


//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【初始化Stack()】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡

Stack::Stack()          //构造函数，置空栈
{
       top=NULL;
}


//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【初始化~Stack()】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡

Stack::~Stack()         //析构函数
{
}


//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【压栈函数】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡
void Stack::Push(T e)          //把元素e压入栈中
{
       LinkNode *P;
       P=new LinkNode;
       P->data=e;               //链栈【头插法】，把e插到链头
       P->next=top;
       top=P;
}


//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【出栈函数】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡

T Stack::Pop()                 //使栈顶元素出栈
{
       T Temp;
       LinkNode *P;
       P=top;
       top=top->next;         //链栈【头取法】，把top所指data赋给Temp
       Temp=P->data;
       delete P;
       return Temp;
}


//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【取栈顶元素函数】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡

T Stack::GetPop()               //取出栈顶元素
{
        return top->data;
}


//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【清空栈函数】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡

void Stack::Clear()                    //把栈清空
{
        top=NULL;
}


//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【判断栈空函数】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡

bool Stack::empty()        //判断栈是否为空，如果为空则返回1，否则返回0
{
      if(top==NULL)
		  return 1;
      else 
		  return 0;
}


//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【函数声名】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡

        int move[4][2]={{0,1},{1,0},{0,-1},{-1,0}};      //定义当前位置移动的4个方向.【分别先向东、南、西、北】
		bool Mazepath(string **maze,int m,int n);           //寻找迷宫maze中从（0，0）到（m,n）的路径，如果到则返回true,否则返回false
		void PrintPath(Stack p,int m,int n,string **maze);                        //输出迷宫的路径
		void Restore(string **maze,int m,int n);            //恢复迷宫
		string ** GetMaze(int &m,int &n);                    //获取迷宫，返回存取迷宫的二维指针
	    int a1,b1;
		int c1,d1;



//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【主函数】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡

int main()
{
        int m=0,n=0;              //定义迷宫的长和宽
        string **maze;               //定义二维指针存取迷宫
		   printf(" ◢■■◣◢■■◣  ◢■ 　 ◢■■◣    ◢■■◣    ◢■■◣  ◢■         \n");
		   printf(" 　　　■■　　■  　■　  　 　 ■    ■          　　　■  　■         \n");
		   printf(" ◢■■◤■　　■　  ■　  ■■■■ 年 ■■■■ 月 ◢■■◤  　■  号     \n");
		   printf(" ■　　　■　　■　　■　   　   ■    ■    ■    ■　　　 　 ■         \n");
		   printf(" ◥■■■◥■■◤◥■■■◤◥■■◤    ◥■■◤    ◥■■■◥■■■◤     \n");
		   printf("\n");
		   printf("       ━━━━━━━━━【作者】━━━━━━━━━━━━━━             \n");
		   printf("      ┃                                                    ┃            \n");
		   printf("      ┃                ● 何天从                           ┃            \n");
		   printf("      ┃                ● 网络工程专业 11-1班              ┃            \n");
		   printf("      ┃                ● 学号：3110757101                 ┃            \n");
		   printf("      ┃                ● 信息科学与工程学院               ┃            \n");
		   printf("      ┃                ● 桂林理工大学                     ┃            \n");
		   printf("      ┃                                                    ┃            \n");
		   printf("       ━━━━━━━━━━━━━━━━━━━━━━━━━━━             \n");
		   printf("\n");
		
            printf("┣━━━━━━━━━【迷宫路径探索】━━━━━━━━━┫   \n");
            printf("┃                                                    ┃   \n");
			printf("┃              ⑴〖输入迷宫路径〗                    ┃   \n");
			printf("┃              ⑵〖清空屏幕〗                        ┃   \n");
			printf("┃              ⑶〖结束探索〗                        ┃   \n");
 			printf("┃                                                    ┃   \n");
			printf("┣━━━━━━━━━━━━━━━━━━━━━━━━━━┫   \n");
		    printf("\n");
			while(1)
			{   
				int j;
				printf("\n       【请选择】操作：");
				scanf("%d",&j);
				switch(j)
				{
				   case 1:
					   {
						   maze=GetMaze(m,n);        //调用GetMaze(int &m,int &n)函数，得到迷宫
						   if(Mazepath(maze,m,n))    //调用Mazepath(int **maze,int m,int n)函数获取路径
						   {
							  
						   } 
						   else 
						   {
							   cout<<"\n《抱歉》！此路径不通!\n\n";
							   printf("┣━━━━━━━━━【迷宫路径探索】━━━━━━━━━┫   \n");
							   printf("┃                                                    ┃   \n");
							   printf("┃              ⑴〖输入迷宫路径〗                    ┃   \n");
							   printf("┃              ⑵〖清空屏幕〗                        ┃   \n");
							   printf("┃              ⑶〖结束探索〗                        ┃   \n");
							   printf("┃                                                    ┃   \n");
							   printf("┣━━━━━━━━━━━━━━━━━━━━━━━━━━┫   \n");
						       printf("\n");
						   }
						   printf("\n");
						   break;
					   }
				  case 2:
					  {
		               system("cls");  //清屏函数
					   		   printf("┣━━━━━━━━━【迷宫路径探索】━━━━━━━━━┫   \n");
							   printf("┃                                                    ┃   \n");
							   printf("┃              ⑴〖输入迷宫路径〗                    ┃   \n");
							   printf("┃              ⑵〖清空屏幕〗                        ┃   \n");
							   printf("┃              ⑶〖结束探索〗                        ┃   \n");
							   printf("┃                                                    ┃   \n");
							   printf("┣━━━━━━━━━━━━━━━━━━━━━━━━━━┫   \n");
						       printf("\n");
					   break;
					  }
				  case 3:
					   return 0;
				   default:
					   printf("\n               【输入有误】，请重新输入！\n");
				}
			}
			return 0;
}


//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【存储迷宫函数】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡

string ** GetMaze(int &m,int &n)             //返回存取迷宫的二维指针
{
        string **maze;                      //定义二维指针存取迷宫
        int i=0,j=0;
		cout<<"\n       【请输入】迷宫的长和宽:";
		int a,b;
		cin>>a>>b;                       //输入迷宫的宽a和高b
		cout<<"\n       【请输入】迷宫内容:\n";	     //m，n分别代表迷宫的行数m和列数n
		n=a;
		m=b; 
		maze=new string *[m+2];             //申请长度等于行数加2的二级指针【这句就是给一个指向指针的指针动态分配m+2个存放int类型指针的数组，用于动态申请二维数组。】
		for(i= 0;i<m+2;i++)              //申请每个二维指针的空间
			
		{
			maze[i]=new  string[n+2];
		}
		for(i=1;i<=m;i++)                //输入迷宫的内容，0代表可通，1代表不通
		{
           for(j=1;j<=n;j++)
		   {
               cin>>maze[i][j];
		   } 
		}
        for(i=0;i<m+2;i++)
		{
              maze[i][0]=maze[i][n+1]="■";    //使纵向围墙为1，就是0列和6列纵向
		}
        for(i=0;i<n+2;i++) 
		{
             maze[0][i]=maze[m+1][i]="■";;     //使横向围墙为1，就是0行和6行横向
		}
        return maze;                        //返回存贮迷宫的二维指针maze
}; 


//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【寻找迷宫路径函数】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡

bool Mazepath(string **maze,int m,int n)           //寻找迷宫maze中从（1，1）到（m,n）的路径，如果到则返回true,否则返回false
{
      Stack q,p;                                //定义栈p、q,分别存探索迷宫的过程和存储路径
      T Temp1,Temp2;       
      int x,y,loop;
	  printf("\n       【请输入】入口行坐标，列坐标：");
	  cin>>a1>>b1;
	  while(a1>m||b1>n)
	  {
		  printf("\n       【输入坐标有误】");
	      printf("\n       【请重新输入】入口行坐标，列坐标：");
	      cin>>a1>>b1;
	  }
	  printf("\n");
	  printf("\n       【请输入】出口行坐标，列坐标：");
	  cin>>c1>>d1;
	  while(c1>m||d1>n)
	  {
		  printf("\n       【输入坐标有误】");
	      printf("\n       【请重新输入】出口行坐标，列坐标：");
	      cin>>c1>>d1;
	  }
	  printf("\n");
      Temp1.x=a1;
      Temp1.y=b1;
      q.Push(Temp1);                             //将入口位置入栈
      p.Push(Temp1);
      maze[a1][b1]="12";                             //标志入口位置已到达过
      while(!q.empty())                          //栈q非空，则反复探索
      {
         Temp2=q.GetPop();                       //获取栈顶元素
           if(!(p.GetPop().x==q.GetPop().x&&p.GetPop().y==q.GetPop().y)) 
		   {
                 p.Push(Temp2);                   //如果有新位置入栈，则把上一个探索的位置存入栈p  
		   } 
          for(loop=0;loop<4;loop++)               //探索当前位置的4个相邻位置
		  { 
              x=Temp2.x+move[loop][0];            //计算出新位置行x位置值（move分别=0、1、0、-1）
              y=Temp2.y+move[loop][1];            //计算出新位置列y位置值（move分别=1、0、-1、0）
              if(maze[x][y]=="0")                       //判断新位置是否可达
			  {
                    Temp1.x=x;                    //把可行路径的行x、列y坐标赋给Temp
                    Temp1.y=y;
                    maze[x][y]="12";               //标志新位置已到达过
                    q.Push(Temp1);                //新位置入栈【临时栈q】
			  }  
              if((x==c1)&&(y==d1))                  //成功到达出口
			  {
                    Temp1.x=c1;                    //把出口的行x、列y坐标赋给Temp
					Temp1.y=d1;
					Temp1.dir=0;
					p.Push(Temp1); 					  //把最后一个位置入栈p
					PrintPath(p,m,n,maze);                     //输出路径
					Restore(maze,m,n);                //恢复路径
					return 1;                         //表示成功找到路径
			  } 
		  }
          if(p.GetPop().x==q.GetPop().x&&p.GetPop().y==q.GetPop().y)   //如果没有新位置入栈，则返回到上一个位置
		  {
                   p.Pop();
                   q.Pop();
		  }
	  }
           return 0;                       //表示查找失败，即迷宫无路经
}


//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【输出路径函数】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡

void PrintPath(Stack p,int m,int n,string **maze)                         //输出路径
{

 	Stack t;                                      //定义一个栈，按从入口到出口存取路径
 	int a,b;
 	T data;
 	LinkNode *temp;
 	temp=new LinkNode;                           //申请空间
	temp->data=p.Pop();                          //取栈p的顶点元素，即第一个位置
	t.Push(temp->data);                          //第一个位置入栈t
	delete temp;                                 //释放空间
    while(!p.empty())                           //栈p非空，则反复回首转移
 	{
 		temp=new LinkNode;
 		temp->data=p.Pop();                      //获取下一个位置，得到行走方向
  		a=t.GetPop().x-temp->data.x;             //行坐标方向
  		b=t.GetPop().y-temp->data.y;             //列坐标方向
 		if(a==1) 
 		{
  			temp->data.dir=1;                    //方向向下，用1表示
		}
  		else if(b==1) 
  		{
  			temp->data.dir=2;                    //方向向右，用2表示
  		}
 		else if(a==-1) 
  		{
  			temp->data.dir=3;                    //方向向上，用3表示
  		}
  		else if(b==-1) 
  		{
  	    	temp->data.dir=4;                    //方向向左，用4表示
  		}
  		t.Push(temp->data);                      //把新位置入栈
  		delete temp;
	}
 

    Stack x,y;              //把t赋给x和y
	LinkNode *w,*k;
	w=new LinkNode;         //申请空间
    k=new LinkNode;         //申请空间
	while(!t.empty()) 
	{
    w->data=t.Pop();        //取栈p的顶点元素，即第一个位置
	k->data=w->data;    
    x.Push(w->data);       //第一个位置入栈t
	y.Push(k->data);
    delete w;
	delete k;
	w=new LinkNode;         //申请空间
    k=new LinkNode;         //申请空间

	}


							while(!y.empty())                           //把路径赋值方向
							{
								data=y.Pop();
							if(data.dir==1)                                  
									maze[data.x][data.y]="↓";
							else if(data.dir==2)
									maze[data.x][data.y]="→";	
							else if(data.dir==3)
									maze[data.x][data.y]="↑";
							else if(data.dir==4)
									maze[data.x][data.y]="←";
														
							} 






    Stack z;           //把x反向赋给z。（从z的栈顶是入口坐标）
	LinkNode *u;
	u=new LinkNode;         //申请空间
  	while(!x.empty()) 
	{
             u->data=x.Pop();        //取栈p的顶点元素，即第一个位置
           	 z.Push(u->data);       //第一个位置入栈t
	         delete u;
           	 u=new LinkNode;         //申请空间
	}

		    cout<<"\n《恭喜》！迷宫路径探索成功!\n\n";

            printf("┣━━━━━━━━━【迷宫路径输出】━━━━━━━━━┫   \n");
            printf("┃                                                    ┃   \n");
			printf("┃              ⑴〖输出迷宫的二维图〗                ┃   \n");
			printf("┃              ⑵〖输出迷宫的路径〗                  ┃   \n");			
			printf("┃              ⑶〖重新输入迷宫路径〗                ┃   \n");			
			printf("┃              ⑷〖退空屏幕〗                        ┃   \n");			
			printf("┃              ⑸〖结束探索〗                        ┃   \n");
 			printf("┃                                                    ┃   \n");
			printf("┣━━━━━━━━━━━━━━━━━━━━━━━━━━┫   \n");
		    printf("\n");
			while(1)
			{   
				int j;
				printf("\n       【请选择】操作：");
				scanf("%d",&j);
				printf("\n");
				switch(j)
				{
				   case 1:
					   {
						       int i=0,j=0,count=0;
							   cout<<"\n【输出】迷宫的方阵为： \n"<<endl;
							   cout<<"  ";
							   for(int c=0;c<n+2;c++)
							   {
								   cout<<c<<"  ";
							   }
							   cout<<endl;
							   int r=0;
							   cout<<r<<" ";
							   for(i=0;i<m+2;i++)
							   {
								   for(j=0;j<n+2;j++)
								   {
									   if(maze[i][j]=="12")
										   maze[i][j]=48;
									   maze[a1][b1]="入";	
									   maze[c1][d1]="出";
									   if(maze[i][j]=="0"||maze[i][j]=="1")
										   cout<<" ";
									   cout<<maze[i][j]<<" ";
									   count++;
									   if(count%(n+2)==0)
									   {
										   r++;
										   cout<<endl;
										   if(r<m+2)
											   cout<<r<<' ';
									   }
								   }
							   }
							   cout<<endl;
							   cout<<"【■：围墙，入：入口，→:向右走，↓：向下走，←：向左走，↑：向上走 】\n\n";
							   break;
					   }
				   case 2:
					   {
						   	cout<<"\n【输出】迷宫的路径为：\n\n";
							while(!z.empty())                           //栈非空，循环输出路径，包括行坐标、列坐标、下一个位置方向
							{
								data=z.Pop();
								cout<<"           "<<"("<<data.x<<","<<data.y<<",";  //输出行x坐标，列y坐标
								switch(data.dir)                                     //输出相应的方向 
								{    	
								case 1:
									cout<<"↓)\n";
									break;
								case 2:
									cout<<"→)\n";
									break;
								case 3:
									cout<<"↑)\n";
									break;
								case 4:
									cout<<"←)\n";
									break;
								case 0:
									cout<<")\n";
									break;
								}
							} 
							cout<<"\n【括号内容:(行坐标,列坐标,方向)】\n";
							break;
					   }	
				   case 3:
					   {
						   int m=0,n=0;              //定义迷宫的长和宽
					       string **maze;               //定义二维指针存取迷宫
						   maze=GetMaze(m,n);        //调用GetMaze(int &m,int &n)函数，得到迷宫
						   if(Mazepath(maze,m,n))    //调用Mazepath(int **maze,int m,int n)函数获取路径
						   {
							   printf("┣━━━━━━━━━【迷宫路径探索】━━━━━━━━━┫   \n");
							   printf("┃                                                    ┃   \n");
							   printf("┃              ⑴〖输入迷宫路径〗                    ┃   \n");
							   printf("┃              ⑵〖结束探索〗                        ┃   \n");
							   printf("┃              ⑶〖清空屏幕〗                        ┃   \n");
							   printf("┃                                                    ┃   \n");
							   printf("┣━━━━━━━━━━━━━━━━━━━━━━━━━━┫   \n");
							   printf("\n");
						  }  					  	   					 				   
					   }
				   case 4:
					  {
		               system("cls");  //清屏函数
					   
            printf("┣━━━━━━━━━【迷宫路径输出】━━━━━━━━━┫   \n");
            printf("┃                                                    ┃   \n");
			printf("┃              ⑴〖输出迷宫的二维图〗                ┃   \n");
			printf("┃              ⑵〖输出迷宫的路径〗                  ┃   \n");			
			printf("┃              ⑶〖重新输入迷宫路径〗                ┃   \n");			
			printf("┃              ⑷〖退空屏幕〗                        ┃   \n");			
			printf("┃              ⑸〖结束探索〗                        ┃   \n");
 			printf("┃                                                    ┃   \n");
			printf("┣━━━━━━━━━━━━━━━━━━━━━━━━━━┫   \n");
		    printf("\n");
					   break;
					  }
				   case 5:
					   exit(0);
				   default:
					   printf("\n               【输入有误】，请重新输入！\n");
				}
			}
}



//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【恢复函数】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡
void Restore(string **maze,int m,int n)       //恢复迷宫
{
 int i,j;
 for(i=0;i<m+2;i++)            //遍历指针
  for(j=0;j<n+2;j++)       
  {
   if(maze[i][j]=="-1")         //恢复探索过位置，即把-1恢复为0
    maze[i][j]="0";
  }
}
