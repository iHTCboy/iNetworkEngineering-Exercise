#include <iostream.h>
#include <stdio.h>
#include <stdlib.h>
#include <malloc.h> 

typedef struct BiTNode
{
	char data;
    struct BiTNode *lchild,*rchild; 
    int LTag, RTag,flag;
 }BiTNode,*BiTree;

 void CreatBiTree(BiTree &T)           //建立一棵二叉树
{
    char ch;
    cin>>ch;
    if(ch=='#')
        T=NULL;
    else
    {
        T=(BiTree)malloc(sizeof(BiTNode));
        if(!T)
            exit(0);
        T->data=ch;
        CreatBiTree(T->lchild);
        CreatBiTree(T->rchild);
    }
}

void PreOrderTraverse(BiTree &T)
{                                    //前序遍历递归
	if(T)
	{  
		cout << T->data<<" ";
		PreOrderTraverse(T->lchild);
		PreOrderTraverse(T->rchild);
	}
}

void InorderTraverse(BiTree &T)
{                                   //中序遍历递归
	if(T)
	{  
	    InorderTraverse(T->lchild);
		cout << T->data<<" ";
		InorderTraverse(T->rchild);
	}
}

void PostTravel(BiTree &T)
{                                 //后序遍历递归
	if(T)
	{  
		PostTravel(T->lchild);
		PostTravel(T->rchild);
        cout << T->data<<" ";
	}
}

void preOrderTraverse(BiTree T)
{                                 //前序遍历非递归
	  BiTree S[20];
	  int top=-1;        
	  do
	  {
	         while(T!= NULL) 
	            {
	              cout << T->data<<" ";
	              top++;
				  S[top]=T; 
	              T=T->lchild;
	             }
	         if( top >-1 )
	          {
	             T=S[top]; 
				 top--; 
	             T = T->rchild; 
	           }
	  }while (( T != NULL ) ||(top>-1));
}

int inorderTraverse(BiTree T)
{                                //中序遍历非递归
	BiTree s[20];
	int i=-1;
	while(T||i>-1)
	{
		if(T)
		{
			i++;
			s[i]=T;	
			T=T->lchild;
		}
		else
		{
			T=s[i];
			cout<<T->data<<" ";
			i--;
			T=T->rchild;
		}
	}
	return 0;
}

void postorder (BiTree T)
{                               //后序遍历非递归
     BiTree s1[20];
	 int s2[20],top=0;
     do{
		 while (T!=NULL)
		 {
			 s1[top]=T; 
		     s2[top++]=0;  
             T=T->lchild;
		 }
		 while(top && s2[top-1]==1)
		 {
			 top--;
		     T=s1[top]; 
		     cout<<T->data<<" "; 
		 }  
         if(top>0)
		 {
			 s2[top-1]=1;
             T=s1[top-1]->rchild; 
		 }
	 }while (top>0); 
}


			
void main()  //主函数
{


   printf(" ◢■■◣◢■■◣  ◢■ 　 ◢■■◣    ◢■■◣    ◢■■◣  ◢■         \n");
   printf(" 　　　■■　　■  　■　  　 　 ■    ■          　　　■  　■         \n");
   printf(" ◢■■◤■　　■　  ■　  ■■■■ 年 ■■■■ 月 ◢■■◤  　■   号    \n");
   printf(" ■　　　■　　■　　■　   　   ■    ■    ■    ■　　　 　 ■         \n");
   printf(" ◥■■■◥■■◤◥■■■◤◥■■◤    ◥■■◤    ◥■■■◥■■■◤     \n");
   printf("\n");
   printf("       ━━━━━━━━━【作者】━━━━━━━━━━━━━━\n");
   printf("      ┃                                                    ┃                 \n");
   printf("      ┃                ● 何天从                           ┃               \n");
   printf("      ┃                ● 网络工程专业 11-1班              ┃    \n");
   printf("      ┃                ● 学号：3110757101                 ┃   \n");
   printf("      ┃                ● 信息科学与工程学院               ┃ \n");
   printf("      ┃                ● 桂林理工大学                     ┃ \n");
   printf("      ┃                                                    ┃         \n");
   printf("       ━━━━━━━━━━━━━━━━━━━━━━━━━━━  \n");
   printf("\n");
   
            printf("\n");
            printf("┣━━━━━━━━━【二叉树遍历】━━━━━━━━━━┫   \n");
            printf("┃                                                    ┃   \n");
			printf("┃              ⑴〖输入一棵二叉树（用#表示空）：〗   ┃   \n");		
			printf("┃              ⑵〖输出先序递归遍历结果〗            ┃   \n");
			printf("┃              ⑶〖输出中序递归遍历结果〗            ┃   \n");
			printf("┃              ⑷〖输出后序递归遍历结果〗            ┃   \n");
			printf("┃              ⑸〖输出先序非递归遍历结果〗          ┃   \n");
            printf("┃              ⑹〖输出中序非递归遍历结果〗          ┃   \n");
			printf("┃              ⑺〖输出后序非递归遍历结果〗          ┃   \n");	
			printf("┃              ⑻〖清空屏幕〗                        ┃   \n");	
			printf("┃             (O)〖结束遍历〗                        ┃   \n");
 			printf("┃                                                    ┃   \n");
			printf("┣━━━━━━━━━━━━━━━━━━━━━━━━━━┫   \n");
			printf("\n");


		   BiTree T;
   int e;
   while(e!=0)
   {
	   cout<<endl<<"       【请选择】操作：";
	   cin>>e;
	   cout<<endl;
	   if(e==1)
	   {
		   cout <<"【请输入】输入一棵二叉树（用#表示空）：";
		   CreatBiTree(T);
           cout<<endl;
	   }
	   if(e==2)
	   {
		   cout << "   【输出】先序递归遍历结果：";
	       PreOrderTraverse(T);
           cout<<endl;
	   }
	   if(e==3)     
	   { 
		   cout<< "   【输出】中序递归遍历结果：";
		   InorderTraverse(T);
           cout<<endl;
		
	   }
	   if(e==4)
	   {
		   cout<<"   【输出】后序递归遍历结果：";
		   PostTravel (T);
           cout<<endl;
	   }
	   if(e==5)
	   {
		   cout << "   【输出】先序非递归遍历结果：";
	             preOrderTraverse(T);
           cout<<endl;
	   }
	   if(e==6)     
	   { 
		   cout<< "   【输出】中序非递归遍历结果："	;
		   inorderTraverse(T);	
	   }
	   if(e==7)
	   {
		   cout<<"   【输出】后序非递归遍历结果：";
		   postorder (T);
           cout<<endl;
	   }	   
	   if(e==8)
	   {
		    system("cls");  //清屏函数
		    printf("┣━━━━━━━━━【二叉树遍历】━━━━━━━━━━┫   \n");
            printf("┃                                                    ┃   \n");
			printf("┃              ⑴〖输入一棵二叉树（用#表示空）：〗   ┃   \n");		
			printf("┃              ⑵〖输出先序递归遍历结果〗            ┃   \n");
			printf("┃              ⑶〖输出中序递归遍历结果〗            ┃   \n");
			printf("┃              ⑷〖输出后序递归遍历结果〗            ┃   \n");
			printf("┃              ⑸〖输出先序非递归遍历结果〗          ┃   \n");
            printf("┃              ⑹〖输出中序非递归遍历结果〗          ┃   \n");
			printf("┃              ⑺〖输出后序非递归遍历结果〗          ┃   \n");	
			printf("┃              ⑻〖清空屏幕〗                        ┃   \n");	
			printf("┃             (O)〖结束遍历〗                        ┃   \n");
 			printf("┃                                                    ┃   \n");
			printf("┣━━━━━━━━━━━━━━━━━━━━━━━━━━┫   \n");
			printf("\n");
		    cout <<"【请输入】输入一棵二叉树（用#表示空）：";
	   }
	   if(e>8||e<0)
	   {
		   cout<<"   【输入有误】请从新输入！！";
           cout<<endl;
	   }
   }
  
}
