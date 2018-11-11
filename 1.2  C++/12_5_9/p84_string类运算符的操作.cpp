# include <iostream>
# include <string>
using namespace std;
int main()
{
   string s1="I LVOE YOU";
   string s2=" and you love me?";
   string s3="me,too";
   string s4,s5;
   s4=s1;
   cout<<"s4 is  "<<s4<<endl;
   s5=s1+s2;
   cout<<"s1+s2 is  "<<s5<<endl;
   s5=s1+"+1314";
   cout<<"s1+\"+1314\"is  "<<s5<<endl;
	   if(s3>s1)
         cout<<"s3>s1"<<endl;
	   else 
	   cout<<"s3<s2"<<endl;
	   if(s4==s1)
		   cout<<"s4==s1"<<endl;
	   else	   
		   cout<<"s4<>s1"<<endl;
	   cout<<"请输入一个字符串给s5:";
	   cin>>s5;
	   cout<<"s5 is  "<<s5<<endl;
	return 0;
		
}