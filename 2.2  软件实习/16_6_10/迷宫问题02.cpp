#include<iostream>
#include<windows.h>
#include<conio.h>
#define MAXSIZE 100
using namespace std;
int sign[MAXSIZE][MAXSIZE];//标记矩阵，当相应块走过后，值变为1
typedef struct
{
	int x;
	int y;
}PosType;

typedef struct
{
	int ord;
    PosType seat;
	int di;
}SElemType;

typedef struct
{
	int m;
	int n;
	int map[MAXSIZE][MAXSIZE];
}MazeType;

class Stack
{
public:
	SElemType data[MAXSIZE];
	int top;
	Stack(void)
	{
		top=-1;
	}
	void push(SElemType e)
	{
		top++;
		data[top].ord=e.ord;
		data[top].di=e.di;
		data[top].seat=e.seat;
	}
	void pop(SElemType &e)
	{
		e.di=data[top].di;
		e.ord=data[top].ord;
		e.seat=data[top].seat;
		top--;
	}
	int empty()
	{
		if(top==-1)
			return 1;
		else
			return 0;
	}

};

void FootPrint(PosType ps)
{
	sign[ps.x][ps.y]=1;
}

int Pass(MazeType mazemap,PosType ps)
{
	if(mazemap.map[ps.x][ps.y]==0&&sign[ps.x][ps.y]==0)
		return 1;
	else 
		return 0;
}

PosType NextPos(PosType ps,int di)
{
	PosType temp;
	switch(di)
	{
	case 1:
		temp.x=ps.x+1;
		temp.y=ps.y;
		break;
	case 2:
		temp.x=ps.x;
		temp.y=ps.y-1;
		break;
	case 3:
		temp.x=ps.x-1;
		temp.y=ps.y;
		break;
	case 4:
		temp.x=ps.x;
		temp.y=ps.y+1;
		break;
	}
	return temp;
}
int MazePath(MazeType  &mazemap,PosType start,PosType end)
{
	Stack st;
	SElemType e;
	PosType curpos=start;
	int curstep=1;
	for(int i=0;i<mazemap.m;i++)
		for(int j=0;j<mazemap.n;j++)
			sign[i][j]=0;
	do
	{
		if(Pass(mazemap,curpos))
		{
			FootPrint(curpos);
			e.ord=curstep;
			e.seat=curpos;
			e.di=1;
			st.push(e);
			if(curpos.x==end.x&&curpos.y==end.y)
			{
				for(int i=0;i<=st.top;i++)
				{
					mazemap.map[st.data[i].seat.x][st.data[i].seat.y]=3;
				//	cout<<"("<<st.data[i].seat.x<<","<<st.data[i].seat.y<<")"<<"\t";
				}
				return 1;
			}
			curpos=NextPos(curpos,1);
			curstep++;
		}
		else
		{
			if(!st.empty())
			{
				st.pop(e);
				while(e.di==4&&!st.empty())
				{
					FootPrint(e.seat);
					st.pop(e);
				}
				if(e.di<4)
				{
					e.di++;
					st.push(e);
	//				cout<<"("<<(e.seat).x<<","<<(e.seat).y<<")"<<endl; //输出路径
					curpos=NextPos(e.seat,e.di);
				}
			}
		}

	}while(!st.empty());
	return 0;
}

void printmaze(MazeType mazemap,PosType start,PosType end)
{
	for(int i=0;i<mazemap.m;i++)
	{
		cout<<"\t\t";
		for(int j=0;j<mazemap.n;j++)
		{			
			if(1==mazemap.map[i][j])
				cout<<"墙";
			else if(i==start.x&&j==start.y)
				cout<<"口";
			else if(i==end.x&&j==end.y)
				cout<<"口";
			else if(3==mazemap.map[i][j])
				cout<<"口";
			else 
				cout<<"  ";
		}
		cout<<endl;
	}
}

void usermaze()
{
	MazeType usermap;
	PosType m_start,m_end;
	cout<<"输入迷宫宽度:"<<endl;
	cin>>usermap.n;
	cout<<"输入迷宫高度:"<<endl;
	cin>>usermap.m;	
	for(int i=0;i<usermap.m;i++)
	{
		cout<<"输入第"<<i+1<<"行迷宫图"<<endl;
		for(int j=0;j<usermap.n;j++)
		{
			cin>>usermap.map[i][j];
		}
	}
	cout<<"输入迷宫入口横坐标:"<<endl;
	cin>>m_start.x;
	cout<<"输入迷宫入口纵坐标:"<<endl;
	cin>>m_start.y;
	cout<<"输入迷宫出口横坐标:"<<endl;
	cin>>m_end.x;
	cout<<"输入迷宫出口纵坐标:"<<endl;
	cin>>m_end.y;
	cout<<"下面是您输入的迷宫地图:"<<endl<<endl;
	printmaze(usermap,m_start,m_end);
	if(MazePath(usermap,m_start,m_end))
	{
		cout<<"按任意键显示路径··· ···"<<endl;
		getch();
		printmaze(usermap,m_start,m_end);
		cout<<endl<<endl;
		cout<<"\t\t"<<"迷宫路径如上"<<endl<<endl;
	}
	else
		cout<<"没有路径!"<<endl;
	
}

void demomaze()
{
	MazeType  mazemap;
	PosType start,end;
	start.x=1,start.y=1;
	end.x=8,end.y=8;
	mazemap.m=10,mazemap.n=10;
	for(int i=0;i<10;i++)
		for(int j=0;j<10;j++)
			mazemap.map[i][j]=1;
	mazemap.map[1][1]=mazemap.map[1][2]=mazemap.map[1][4]=mazemap.map[1][5]=mazemap.map[1][6]=mazemap.map[1][8]=0;
	mazemap.map[2][1]=mazemap.map[2][2]=mazemap.map[2][4]=mazemap.map[2][5]=mazemap.map[2][6]=mazemap.map[2][8]=0;
	mazemap.map[3][1]=mazemap.map[3][2]=mazemap.map[3][3]=mazemap.map[3][4]=mazemap.map[3][7]=mazemap.map[3][8]=0;
	mazemap.map[4][1]=mazemap.map[4][5]=mazemap.map[4][6]=mazemap.map[4][7]=mazemap.map[5][8]=0;
	mazemap.map[5][1]=mazemap.map[5][2]=mazemap.map[5][3]=mazemap.map[5][5]=mazemap.map[5][6]=mazemap.map[5][7]=mazemap.map[5][8]=0;
	mazemap.map[6][1]=mazemap.map[6][3]=mazemap.map[6][4]=mazemap.map[6][5]=mazemap.map[6][7]=mazemap.map[6][8]=0;
	mazemap.map[7][1]=mazemap.map[7][5]=mazemap.map[7][8]=0;
	mazemap.map[8][2]=mazemap.map[8][3]=mazemap.map[8][4]=mazemap.map[8][5]=mazemap.map[8][6]=mazemap.map[8][7]=mazemap.map[8][8]=0;
///////////////////////////////////////
/*	
	{1,1,1,1,1,1,1,1,1,1},
	{1,0,0,1,0,0,0,1,0,1},
	{1,0,0,1,0,0,0,1,0,1},
	{1,0,0,0,0,1,1,0,0,1},
	{1,0,1,1,1,0,0,0,0,1},
	{1,0,0,0,1,0,0,0,0,1},
	{1,0,1,0,0,0,1,0,0,1},
	{1,0,1,1,1,0,1,1,0,1},
	{1,1,0,0,0,0,0,0,0,1},
	{1,1,1,1,1,1,1,1,1,1},
*/
/////////////////////////////////////
	printmaze(mazemap,start,end);
	cout<<"\n\n按任意键显示路径··· ···"<<endl;
	getch();
	system("cls");
	if(MazePath(mazemap,start,end))
	{
		printmaze(mazemap,start,end);
		cout<<endl;
		cout<<"\t\t"<<"迷宫路径如上"<<endl<<endl;
	}
	else
		cout<<"没有路径!"<<endl;
}
void main()
{
	cout<<"**************************     迷宫路径求解!     **************************"<<endl<<endl;
	cout<<"^^^^^^^^^^^^^^^^^^^^^^^^^^  计算机041040619崔久圣制作  ^^^^^^^^^^^^^^^^^^^^^^^^^^"<<endl<<endl;
	cout<<"***************************************************************************"<<endl<<endl;
	cout<<"\t\t下面是示例迷宫( 口 表示起点和终点):"<<endl<<endl;
	demomaze();
	while(1)
	{
		char a;
		cout<<"下面由用户自己输入迷宫地图(用1表示障碍，0表示通道,迷宫周边用1表示)"<<endl<<endl;
		cout<<"请按任意键继续··· ···"<<endl;
		getch();
		system("cls");
		usermaze();
		cout<<"按Q退出程序,其他键继续··· ···"<<endl;
		cin>>a;
		if('q'==a)
		{
			cout<<"\n\n\n\t********************欢迎下次使用!*******************"<<endl;
			break;
		}
		system("cls");
	}
}
