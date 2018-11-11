
/**
 * 一个简单的文件下载类
 * 
 * @author (YHZ) 
 * @version (2013-8-5)
 */

import java.io.*;
import java.net.*;

public class FileDownLoader
{
    private String urlSpec;  //需要下载的资源的URL描述
    private String fileName;  //用于存放下载的资源的文件名

    /**
     * Constructor for objects of class FileDownLoader
     */
    public FileDownLoader(String urlSpec, String fileName)
    {
        this.urlSpec = urlSpec;
        this.fileName = fileName;
    }

    /**
     * 下载文件
     */
    public void download() throws MalformedURLException, IOException
    {
        URL url = new URL(urlSpec);
        URLConnection conn = url.openConnection();  //建立双向连接
        
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));  //创建输入流     
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));  //创建输出流
        
        int ch;
        while ((ch = br.read()) != -1)  //复制文件
        {
            bw.write(ch);
        }
        
        br.close();
        bw.close();

    }
}
