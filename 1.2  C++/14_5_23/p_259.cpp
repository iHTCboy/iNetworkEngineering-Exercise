#include<iostream.h> //258
class sz
{
public:
sz()   {}
sz(int b[3][3])
  {for(int j=0;j<3;j++)
     for(int i=0;i<3;i++)  
          a[j][i]=b[j][i];
  }
friend sz operator+(sz &c1,sz &c2);
void display()
   { for(int j=0;j<3;j++)
        for(int i=0;i<3;i++) 
         cout<<a[j][i]<<endl;
  }
int a[3][3];
};
sz operator+(sz &c1,sz &c2)
{  sz tem;
  for(int j=0;j<3;j++)
     for(int i=0;i<3;i++) 
         tem.a[j][i]=c1.a[j][i]+c2.a[j][i];
return tem;
}

void main()
{
  int b[3][3]={{1,2,3},{2,3,4},{3,4,5}};
    
  sz obj1,obj2(b),tem;

for(int j=0;j<3;j++)
     for(int i=0;i<3;i++)  
		 cin>>obj1.a[j][i];
tem=obj1+obj2;
tem.display();

}
