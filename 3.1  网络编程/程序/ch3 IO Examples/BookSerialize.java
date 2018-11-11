
/**
 * 一个简单的测试程序，用于对Book类的对象进行序列化操作
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.io.*;

public class BookSerialize
{
	public static void main(String args[]) throws IOException,ClassNotFoundException
	{
	    Book book = new Book(123, "Test"); //Book实现了Serializable 接口的类
	    
	    ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("book.dat"));
	    oos.writeObject(book);  //写入book对象
	    oos.close(); 
	    book=null;
	    ObjectInputStream ois=new ObjectInputStream(new FileInputStream("book.dat"));    
	    book=(Book)ois.readObject(); //读取之前存储的book对象
	    ois.close(); 
 	    
	    System.out.print(book);
	    //思考1：book.dat是文件文件还是二进制文件？
	    //思考2：如果要读取多个book对象怎么办？
	}
}

