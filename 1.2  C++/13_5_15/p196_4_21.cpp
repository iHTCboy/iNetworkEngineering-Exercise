# include <iostream>
using namespace std;
class Time
{
  public:
	  Time(int h,int m,int s):hour(h),minutes(m),seconds(s){}
	{
	  hours=h;
	  minutes=m;
	  seconds=s;	
	}

	voed display()
   {
      cout<<"出生时间:"<<hours<<"时"<<minutes<<"分";
	  cout<<seconds<<"秒"<<endl;
   }
  protected:
	  int hours,minutes,seconds;
};

class Date
｛
    public:
		Date(int m,int d,int y):month(mo),day(d),year(y){}
		{
		  month=mo;
		  day=d;
		  year=y;
		}
		void display()
	 {
		 cout<<"出生年月:"<<year<<"年"<<month<<"月";
		 cout<<day<<"日"<<endl;	 
	 }
   protected:
	   int month,day,year;
｝;

class Birthtime :public Time,public Date
{
	Birthtime(int mo,int d,int y,int h,int m,int s):Date(m,d,y),Time(h,m,s){}

	void display2()
	{
	  //cout<<"姓名"<<Childname<<endl;
	  Date.display();
	  Time.display();
	}
  // private:
    //	char Childname;
};
void main()
{
  Birthtime t(4,14,1991,13,14,520);
  t.display2();

}
