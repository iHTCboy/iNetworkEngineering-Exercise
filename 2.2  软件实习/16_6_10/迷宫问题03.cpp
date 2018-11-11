#include<iostream.h>
class T       //定义描述迷宫中当前位置的结构类型
{
public:
	int x;          //x代表当前位置的行坐标
    int y;          //y代表当前位置的列坐标
    int dir;        //0:无效,1:东,2:南,3:西,4:北
};

class LinkNode      //链表结点
{
	friend class Stack;
public:
	T data;
    LinkNode *next;
};

class Stack
{
private:
	LinkNode *top;           //指向第一个结点的栈顶指针
public:
	Stack();              //构造函数，置空栈
    ~Stack();             //析构函数
    void Push(T e);           //把元素data压入栈中
    T Pop();                  //使栈顶元素出栈
    T GetPop();               //取出栈顶元素
    void Clear();                   //把栈清空
    bool empty();        //判断栈是否为空，如果为空则返回1，否则返回0
};

Stack::Stack()          //构造函数，置空栈
{
	top=NULL;
}

Stack::~Stack()         //析构函数
{
}

void Stack::Push(T e)          //把元素x压入栈中
{
	LinkNode *P;
    P=new LinkNode;
    P->data=e;
    P->next=top;
    top=P;
}

T Stack::Pop()                 //使栈顶元素出栈
{
	T Temp;
    LinkNode *P;
    P=top;
    top=top->next;
    Temp=P->data;
    delete P;
    return Temp;
}

T Stack::GetPop()               //取出栈顶元素
{
	return top->data;
}

void Stack::Clear()                    //把栈清空
{
	top=NULL;
}

bool Stack::empty()        //判断栈是否为空，如果为空则返回1，否则返回0
{
	if(top==NULL)
		return 1;
    else 
		return 0;
}

int move[4][2]={{0,1},{1,0},{0,-1},{-1,0}};   //定义当前位置移动的4个方向
bool Mazepath(int **maze,int m,int n);      
//寻找迷宫maze中从（0，0）到（m,n）的路径
//到则返回true,否则返回false
void PrintPath(Stack p,int m,int n);        //输出迷宫的路径
void Restore(int **maze,int m,int n);        //恢复迷宫
int** GetMaze(int &m,int &n);       //获取迷宫
//返回存取迷宫的二维指针

int main()
{
	int m=0,n=0;       //定义迷宫的长和宽
    int **maze;        //定义二维指针存取迷宫
    maze=GetMaze(m,n);  //调用GetMaze(int &m,int &n)函数，得到迷宫
    if(Mazepath(maze,m,n)) //调用Mazepath(int **maze,int m,int n)函数获取路径
	{
		cout<<"迷宫路径探索成功!\n";
	}
    else 
	{
		cout<<"路径不存在!\n";
	}
	return 0;
}

int** GetMaze(int &m,int &n)//返回存取迷宫的二维指针
{
	int **maze;              //定义二维指针存取迷宫
    int i=0,j=0,count=0;
    cout<<"请输入迷宫的长和宽:";
    int a,b;cin>>a>>b;             //输入迷宫的长和宽
    cout<<"请输入迷宫内容:\n";
    m=a;
    n=b;          //m,n分别代表迷宫的行数和列数
    maze=new int *[m+2];  //申请长度等于行数加2的二级指针
    for(i= 0;i<m+2;i++)  //申请每个二维指针的空间
	{
		maze[i]=new int[n+2];
	}
    for(i=1;i<=m;i++)          //输入迷宫的内容，0代表可通，1代表不通
	{
		for(j=1;j<=n;j++)
		{
			cin>>maze[i][j];
		}
	}
    for(i=0;i<m+2;i++)
	{
        maze[i][0]=maze[i][n+1]=1;
	}
    for(i=0;i<n+2;i++)
	{
        maze[0][i]=maze[m+1][i]=1;
	}

    return maze;              //返回存贮迷宫的二维指针maze
};

bool Mazepath(int **maze,int m,int n)//寻找迷宫maze中从（0，0）到（m,n）的路径
//到则返回true,否则返回false
{
	Stack q,p;       //定义栈p、q,分别存探索迷宫的过程和存储路径
    T Temp1,Temp2;      
    int x,y,loop;
    Temp1.x=1;
    Temp1.y=1;
    q.Push(Temp1);           //将入口位置入栈
    p.Push(Temp1);
    maze[1][1]=-1;          //标志入口位置已到达过
    while(!q.empty())      //栈q非空，则反复探索
	{
		Temp2=q.GetPop();      //获取栈顶元素
        if(!(p.GetPop().x==q.GetPop().x&&p.GetPop().y==q.GetPop().y)) 
		{
			p.Push(Temp2);     
		}
        //如果有新位置入栈，则把上一个探索的位置存入栈p
		for(loop=0;loop<4;loop++)   //探索当前位置的4个相邻位置
		{
			x=Temp2.x+move[loop][0];     //计算出新位置x位置值
            y=Temp2.y+move[loop][1];      //计算出新位置y位置值
			if(maze[x][y]==0)         //判断新位置是否可达
			{
				Temp1.x=x;
                Temp1.y=y;
                maze[x][y]=-1;          //标志新位置已到达过
                q.Push(Temp1);         //新位置入栈
			}
			if((x==(m))&&(y==(n)))    //成功到达出口
			{
				Temp1.x=m;
                Temp1.y=n;
                Temp1.dir=0;
                p.Push(Temp1);       //把最后一个位置入栈
                PrintPath(p,m,n);        //输出路径
                Restore(maze,m,n);        //恢复路径
				return 1;            //表示成功找到路径
			}
		}
		if(p.GetPop().x==q.GetPop().x&&p.GetPop().y==q.GetPop().y)
           //如果没有新位置入栈，则返回到上一个位置
		{
			p.Pop();
            q.Pop();
		}
	}
	return 0;           //表示查找失败，即迷宫无路经
}

void PrintPath(Stack p,int m,int n)        //输出路径
{
	cout<<"迷宫的路径为\n";
    cout<<"括号内的内容分别表示为(行坐标,列坐标,数字化方向,方向)\n";
    Stack t;            //定义一个栈，按从入口到出口存取路径
    int a,b;
    T data;
    LinkNode *temp;
    temp=new LinkNode;         //申请空间
    temp->data=p.Pop();        //取栈p的顶点元素，即第一个位置
	t.Push(temp->data);  //第一个位置入栈t
    delete temp;         //释放空间
	while(!p.empty())    //栈p非空，则反复转移
	{
		temp=new LinkNode;
		temp->data=p.Pop();         //获取下一个位置
        //得到行走方向
		a=t.GetPop().x-temp->data.x;   //行坐标方向
        b=t.GetPop().y-temp->data.y;   //列坐标方向
		if(a==1) 
		{
			temp->data.dir=1;     //方向向下，用1表示
		}
		else 
			if(b==1) 
			{
				temp->data.dir=2; //方向向右，用2表示
			}
			else
				if(a==-1) 
				{
					temp->data.dir=3;  //方向向上，用3表示
				}
				else
					if(b==-1) 
					{
						temp->data.dir=4;  //方向向左，用4表示
					}
					t.Push(temp->data);            //把新位置入栈
					delete temp;
	}

/*
    Stack x,y;
	LinkNode *j,k;
    j=new LinkNode;         //申请空间
    k=new LinkNode;         //申请空间
    j->data=p.Pop();        //取栈p的顶点元素，即第一个位置
	k->data=j->data;    
    x.Push(j->data);  //第一个位置入栈t
	y.Push(k->data);
    delete j;
	delete k;




	cout<<"迷宫为: "<<endl;
	cout<<"  ";
	for(int c=0;c<n+2;c++)
	{
		cout<<c<<' ';
	}
	cout<<endl;
	int r=0;
	cout<<r<<' ';
		for(i=0;i<m+2;i++)
		{
			for(j=0;j<n+2;j++)
			{
				if(
				
				cout<<maze[i][j]<<' ';
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


*/


    Stack x;
	LinkNode *k;
    k=new LinkNode;         //申请空间

    //输出路径，包括行坐标，列坐标，下一个位置方向
	while(!t.empty())         //栈非空，继续输出
	{
		k->data=t.Pop();
		data=k->data;
		x.Push(k->data);
		delete k;
        cout<<'('<<data.x<<','<<data.y<<','<<data.dir<<",";  //输出行坐标，列坐标
		switch(data.dir)   //输出相应的方向 
		{
		case 1:cout<<"↓)\n";break;
        case 2:cout<<"→)\n";break;
        case 3:cout<<"↑)\n";break;
        case 4:cout<<"←)\n";break;
        case 0:cout<<")\n";break;
				}
	}
   int i=0,j=0,count=0;
	cout<<"迷宫为: "<<endl;
	cout<<"  ";
	for(int c=0;c<n+2;c++)
	{
		cout<<c<<' ';
	}
	cout<<endl;
	int r=0;
	cout<<r<<' ';
		for(i=0;i<m+2;i++)
		{
			for(j=0;j<n+2;j++)
			{   LinkNode *te;
			    te=new LinkNode;
				if(i>0&&i<m+1&&j>0,j<n+1)
				{

						te->data=x.Pop();
				}
				if(te->data.dir==1)
					cout<<'↓'<<' ';
			   else if(te->data.dir==2)
				   	cout<<'→'<<' ';
			   else if(te->data.dir==3)
				   	cout<<'↑'<<' ';
			   else if(te->data.dir==4)
				   	cout<<'←'<<' ';
				  delete te;  

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


}

void Restore(int **maze,int m,int n)       //恢复迷宫
{
	int i,j;
    for(i=0;i<m+2;i++)            //遍历指针
		for(j=0;j<n+2;j++)       
		{
			if(maze[i][j]==-1)         //恢复探索过位置，即把-1恢复为0
				maze[i][j]=0;
		}
}
