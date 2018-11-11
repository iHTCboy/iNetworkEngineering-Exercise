class Overload{
  
  int m,n;
  Overload(){
     m=0;
     n=0;
           }

  Overload(int a,int b){
     m=a;    //初始化变量m
     n=b;    //初始化变量n
           }

  int add(){
     System.out.println("无参数加法"+m+"+"+n+"="+(m+n));
     return m+n;
         }

  int add(int a,int b){
     System.out.println("整型加法"+a+"+"+b+"="+(a+b));
     return a+b;
         } 

  double add(double a,double b){
     System.out.println("实型加法"+a+"+"+b+"="+(a+b));
     return a+b;
         } 

  double add(int a,int b,double c){
      double sum;
     System.out.println("混合加法"+a+"+"+b+"+"+c+"="+(a+b+c));
     sum=a+b+c;
     return sum;    //返回加法运算的结果
         } 

  public static void main(String args[]){
     int ix,iy;
     double dx,dy;
     Overload ov=new Overload();   //声明一个Overload对象ov并初始化

     ix=ov.add();
     iy=ov.add(3,6);

     dx=ov.add(2.1,5.3);   //调用实型加法函数参数为2.1,5.3
     dy=ov.add(3,6,2.2);
        }
   }
