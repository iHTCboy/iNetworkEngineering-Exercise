class Demo2_2 {
public static void main(String args[]) {
int a=25, b=20, e=3, f=0;
boolean d=a<b;
System.out.println("a=25,b=20,e=3,f=0");
System.out.println("因为关系表达式 a<b 为假，所以其逻辑值为 ： "+d);
if (e!=0 && a/e>5)
System.out.println("因为e 非0 且a/e 为8 大于5，所以输出 a/e＝ "+a/e);
if (f!=0 && a/f>5)
System.out.println("a/f = "+a/f);
else
System.out.println("因为f值为0，所以输出 f = "+f);
}
}
