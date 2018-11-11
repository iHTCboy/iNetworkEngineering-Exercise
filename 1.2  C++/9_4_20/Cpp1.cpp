#include <iostream.h> 
class score { 
public: 
 score(int x,int y)  { 
  sc1=x; 
  sc2=y; 
  cout<<"constructing score : "<<x<<"   "<<y<<endl; 
 } 
 ~score()  { 
  cout<<"destructing score: "<<sc1<<"   "<<sc2<<endl; 
 }  
protected: 
 int sc1; 
 int sc2;  
}; 
class student :public score{  
public:  
	student(int i,int k,int id):score (i,k)  
	{     
		noid=id;
		cout<<"constructing  a student,id :   "<<noid; 
	} 
  ~student()  { 
    cout<<"destructing  a student:   "<<noid<<endl; 
   }   
private: 
     int   noid;      
}; 
void  main() {    
 student s1(33,88,99); 
  cout<<"back in main"<<endl; 
  }  
