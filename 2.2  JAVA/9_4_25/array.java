class Demo2_3 {
public static void main(String args[]) {
int a[]=new int[5];
int arr1[][]=new int[3][4];
a[0]=10;
a[1]=10+a[0];
a[2]=30;
a[3]=40;
a[4]= a[1]+ a[2];
arr1[0][0]=0; arr1[0][1]=1; arr1[0][2]=2;
arr1[1][0]=3; arr1[1][1]=4; arr1[1][2]=5;
arr1[2][0]=6; arr1[2][1]=7; arr1[2][2]=8;
System.out.println("a["+0+"] = "+a[0]);
System.out.println("a["+1+"] = "+a[1]);
System.out.println("a["+2+"] = "+a[2]);
System.out.println("a["+3+"] = "+a[3]);
System.out.println("a["+4+"] = "+a[4]);
System.out.println("arr1("+0+","+0+") = "+arr1[0][0]);
System.out.println("arr1("+0+","+1+") = "+arr1[0][1]);
System.out.println("arr1("+0+","+2+") = "+arr1[0][2]);
System.out.println("arr1("+1+","+0+") = "+arr1[1][0]);
System.out.println("arr1("+1+","+1+") = "+arr1[1][1]);
System.out.println("arr1("+1+","+2+") = "+arr1[1][2]);
}
}
