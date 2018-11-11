
/**
 * 获取由URL指定的网页资源的源代码，并将其写入指定的文件。
 * 
 * @author (yhz) 
 * @version (2013-8-5)
 */
import java.net.*;
import java.io.*;

public class Source
{
    public static void main(String args[])
    {
        URL url;
        try
        {
            url = new URL("http://202.193.80.32/Git/Index.asp");
        }
        catch(MalformedURLException e)
        {
            System.out.println(e);
            return;
        }
        
        try
        {
            InputStream in = url.openStream();  //通过url建立一个输入流
            FileOutputStream out = new FileOutputStream(new File("test.txt"));   //创建一个输出流
            int c;
            while((c = in.read()) != -1)  //读取一个字节的数据
            {
                out.write(c);  //写入一个字节的数据
            }
            in.close();
            out.close();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}
