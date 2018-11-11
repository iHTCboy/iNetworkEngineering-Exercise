
/**
 * 用于测试FileDownLoader的测试类
 * 
 * @author (YHZ) 
 * @version (2013-8-5)
 */
import java.io.*;
import java.net.*;

public class FileDownTester
{
    public static void main(String[] args) throws MalformedURLException, IOException
    {
        String url = "http://departs.glut.edu.cn/kjcyc/news/uploading/upload/2013729172814.pdf";
        String fileName = "temp.dat";
        
        FileDownLoader fdl = new FileDownLoader(url, fileName);
        fdl.download();
        System.out.println("下载完成");
    }
}
