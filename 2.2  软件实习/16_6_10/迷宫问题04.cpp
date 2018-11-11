#include <stdio.h>
#include <malloc.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>

#define TRUE        1
#define FALSE       0
#define OK          1
#define ERROR       0
#define INFEASIBLE -1
#define NULL       0 

#define WALL  0         
#define PATH  1         
#define RIGHT -1        
#define DOWN -2       
#define LEFT -3        
#define UP   -4        
#define BACK -5        
#define DESTINATION -6


typedef int Status;
typedef int MazeType[10][10];
typedef int ElemType;

typedef struct{
	int x;
	int y;
}PosType;//迷宫中的位置类型

typedef struct
{
	int ord;
	PosType seat;
	int di;
}SElemType;//栈元素类型

typedef struct
{
	SElemType *base;
	SElemType *top;
	int stacksize;
}Stack;//栈类型





#define STACK_INIT_SIZE  1000
#define STACKINCREMENT   100
 typedef struct
 {
     SElemType *base; //栈底指针
     SElemType *top;  //栈顶指针
     int   stacksize; //栈容量
 }SqStack;

Status InitStack(SqStack &S)
{
//构造空栈S  
 S.base=(SElemType*)malloc(STACK_INIT_SIZE*sizeof(SElemType));
  if(!S.base)exit(OVERFLOW);    //存储分配失败
  S.top=S.base;   //空栈
  S.stacksize=STACK_INIT_SIZE;
  return(OK);
}//InitStack  复杂度"O(1)"


Status Push(SqStack &S, SElemType e){
//插入e为栈顶元素
   if(S.top-S.base==S.stacksize){//栈满则应重新分配空间
     S.base=(SElemType *)
         realloc(S.base,(S.stacksize+STACKINCREMENT)*sizeof(SElemType));
     if(!S.base)exit(OVERFLOW);
     S.top=(S.base+S.stacksize);//使得S.top重新指向栈顶,因realloc
     S.stacksize+=STACKINCREMENT;
   }
   *S.top ++=e;    //top指向待插入位置    
   return(OK);
}//Push ,复杂度O(1)


Status Pop(SqStack &S,SElemType &e){
    //若栈不空则栈顶元素出栈并用e带回其值
    if(S.top==S.base)return ERROR;
    e=*(--S.top);     //栈顶元素为*(S.top-1)
     return OK;
} //复杂度O(1)

Status StackEmpty(SqStack S)
{                                                             //判断栈是否为空
	if(S.top==S.base)	return TRUE;
	else		return FALSE;
}

Status GetTop(SqStack &S,SElemType &e)
{                                                                    //读出栈顶元素
	e=*S.top;
	return OK;
}

Status StackTraverse(SqStack S,Status (*visit)(SElemType)){
	//从栈底元素到栈顶元素依次执行visit函数，通常用于输出栈中元素
	SElemType *p=S.base;	
	if(S.base==S.top)printf("空栈\n");
	else
		while(p<S.top){(*visit)(*p);++p;}
	return OK;
}

Status PrintSElem(SElemType e){
	printf("step:%d to (%d,%d)\n",e.ord,e.seat.x,e.seat.y);
	return OK;
}



Status InitMaze(MazeType &maze){//生成迷宫,"0"表示通PATH，"1"表示不通WALL
	PosType m;
	srand(time(NULL));
	for(m.y=0;m.y<=9;m.y++)	{maze[0][m.y]=WALL;maze[9][m.y]=WALL;}
    for(m.x=1;m.x<=8;m.x++)	{maze[m.x][0]=WALL;maze[m.x][9]=WALL;}
    for(m.x=1;m.x<=8;m.x++)
		for(m.y=1;m.y<=8;m.y++)
			maze[m.x][m.y]=rand()%2;
	return OK;
}//MakeMaze

Status  OutputMaze(MazeType maze)
{
    int i,j;
	for(i=0;i<=9;i++)
	{
		printf("\t");
		for(j=0;j<=9;j++)
		{

			switch(maze[i][j])
				{
					case RIGHT	    : printf("→");	break;
				    case DOWN   	: printf("↓");	break;
			     	case LEFT	    : printf("←");	break;
				    case UP		    : printf("↑");	break;
			        case PATH       : printf("  "); break;
				    case BACK	    : printf("@");	break;
					case WALL	    : printf("■");	break;
					case DESTINATION: printf("*"); break;
			}
		}
		printf("\n" );
	}
	return OK;
}
		
Status FootPrint(MazeType &maze,PosType curpos,int di)
{
	
	switch(di)
	{
		
	    case RIGHT	    : maze[curpos.x][curpos.y]=RIGHT;	    break;
        case UP         : maze[curpos.x][curpos.y]=UP;          break;
		case DOWN	    : maze[curpos.x][curpos.y]=DOWN;	    break;
		case LEFT   	: maze[curpos.x][curpos.y]=LEFT;	    break;
		case BACK       : maze[curpos.x][curpos.y]=BACK;        break;

	}
	return OK;
}
		

PosType Nextpos(PosType pos,int di)
{
	switch(di){
	      case 1  :pos.x=pos.x,pos.y++;     break;
		  case 2  :pos.x++,pos.y=pos.y;     break;
		  case 3  :pos.x=pos.x,pos.y--;     break;
		  case 4  :pos.x--,pos.y=pos.y;     break;
	}
	return pos;
}


Status PassMaze(MazeType &maze,PosType start,PosType end,SqStack &S){//找出迷宫的一条通路
    PosType curpos;
	SElemType e;
	int curstep=1;
	curpos=start;
    if(maze[curpos.x][curpos.y]!=PATH) { printf("当前迷宫没有入口\n"); return FALSE;}
	do{   
	    if(maze[curpos.x][curpos.y]==PATH){//当前位置可通
			e.ord=curstep;
			e.seat=curpos;
			e.di=1;
			Push(S,e);
			if(curpos.x==end.x&&curpos.y==end.y){maze[curpos.x][curpos.y]=DESTINATION;return OK;}
			else{				   
				maze[curpos.x][curpos.y]=RIGHT;//从其向右走
				curpos=Nextpos(curpos,1);
				curstep++;
			}
		}
		else{//当前位置不通
			GetTop(S,e);			
			while(!StackEmpty(S)&&e.di==4){
				maze[e.seat.x][e.seat.y]=BACK;
				Pop(S,e);
				curstep--;
				if(StackEmpty(S))break;
				GetTop(S,e);
			}
			if(e.di<4){  //栈顶位置有其他方向可以选择
			    Pop(S,e); e.di++; Push(S,e);
				maze[e.seat.x][e.seat.y]=-e.di;   //注意前进方向踪迹与e.di互为相反数
                curpos=Nextpos(e.seat,e.di);
			}
		}
	}while(!StackEmpty(S));
    return FALSE;
}




Status OutPutWay(SqStack &S,SqStack &Q)
{
	
	SElemType e;
	InitStack(Q);
	if(StackEmpty(S)) return FALSE;
	else 
		while(!StackEmpty(S))
		{
			Pop(S,e);
			Push (Q,e);		
		}
		printf("具体路径是:\n");
        while (!StackEmpty(Q))
		{
			Pop(Q,e);
			printf("第%2d步到(%2d,%2d)\n",e.ord,e.seat.x,e.seat.y);
		}
		return OK;
}


void main(){
    MazeType maze;
	PosType start,end;
	SqStack S,Q;
	InitStack(S);
	InitMaze(maze);
	printf("初始迷宫为：\n");
	OutputMaze(maze);
	printf("输入迷宫的入口位置坐标从(0,0)到(9,9): ");
    scanf("%d,%d",&start.x,&start.y);
	printf("输入迷宫的出口位置坐标从(0,0)到(9,9): ");
	scanf("%d,%d",&end.x,&end.y);
	if(PassMaze(maze,start,end,S)){
		printf("迷宫可通,路径踪迹如下:\n");
	    OutputMaze(maze);
		printf("具体路径为：\n");
		StackTraverse(S,PrintSElem);
	}
	else{
		printf("迷宫不可通,路径踪迹如下:\n");
	    OutputMaze(maze);
	}

	printf("---------------输入任意数字键结束------------------");
	int pause;
	scanf("%d",&pause);
}
