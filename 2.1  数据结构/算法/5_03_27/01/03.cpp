#include   <iostream> 
using   namespace   std; 

const   int   MAX=31; 
const   int   b[MAX]={1,13,17,14}; 
int   x[MAX]={0}; 
int   sum; 

int   Sum(); 
int   SumOfSub(int   ,int   ,int   ); 
void   Display(int   *); 

int   main() 
{ 
        cout << "enter   the   sum: " << endl; 
cin >> sum; 
int   s=0,k=0,r; 
r=Sum(); 
//	cout < <r < <endl; 
SumOfSub(s,k,r); 
return   0; 
} 

int   Sum() 
{ 
int   s=0; 
for(int   i=0;i <MAX;i++) 
{ 
                s+=b[i]; 
} 
return   s; 
} 

int   SumOfSub(int   s,int   k,int   r) 
{ 
if(r <0)     return   0; 
x[k]=1; 
if(s+b[k]==sum) 
{ 
Display(x); 
} 

if(s+b[k]+b[k+1] <=sum) 
SumOfSub(s+b[k],k+1,r-b[k]); 

//         if(s+r-b[k]> =sum&&s+b[k+1] <=sum) 
//	 { 
x[k]=0; 
SumOfSub(s,k+1,r-b[k]); 
//	 } 
return   0; 
} 

void   Display(int   *x) 
{ 
for(int   i=0;i <MAX;i++) 
{ 
if(x[i]==1) 
cout << b[i] << "\t "; 
} 
cout << endl; 
}
