class Demo2_6 {
public static void main(String args[]) {
boolean leap;
int year=2005;
if ((year%4==0 && year%100!=0) || (year%400==0)) // 方法1
System.out.println(year+" 年是闰年");
else
System.out.println(year+" 年不是闰年");
year=2008; // 方法2
if (year%4!=0)
leap=false;
else if (year%100!=0)
leap=true;
else if (year%400!=0)
leap=false;
else
leap=true;
if (leap==true)
System.out.println(year+" 年是闰年");
else
System.out.println(year+" 年不是闰年");
year=2050; // 方法3
if (year%4==0) {
if (year%100==0) {
if (year%400==0)
leap=true;
else
leap=false;
}
else
leap=false;
}
else
leap=false;
if (leap==true)
System.out.println(year+" 年是闰年");
else
System.out.println(year+" 年不是闰年");
}
}
