
/**
 * 一个简单的Book类，实现了Serializable接口
 * 
 * @author (yhz) 
 * @version (2013-6-24)
 */

import java.io.*; //Serializable在该包内定义

public class Book implements Serializable 
{
    private int code;  //编号
    private String name;  //书名
    
    public Book(int code, String name)
    {
        this.code = code;
        this.name = name;
    }
    
    public String toString()
    {
        return "Code: " + code + "; name: " + name;
    }
}
