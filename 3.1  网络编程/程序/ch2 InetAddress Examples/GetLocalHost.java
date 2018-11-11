/**
 * 获取本机IP地址信息
 * 
 * @author (yhz) 
 * @version (2013-6-20)
 */
import java.net.*;   //大多数网络编程要用到该包，本例用到类InetAddress、UnknownHostException。

public class GetLocalHost
{
    public static void main(String[] args)
    {
        try
        {
            /*
             * getLocalHost是类InetAddress的静态方法，所以直接用类名调用该函数
             * getLocalHost用于返回本地主机地址信息；若因为安全策略不可访问，返回127.0.0.1。
             * 
             */
            InetAddress localAddress = InetAddress.getLocalHost();
            /*
             * 实际上调用的是localAddress.toString()，返回的字符串具有以下形式：主机名/字面值 IP 地址。
             * 可以用下面的两句代替。
             */
            System.out.println("主机名/IP地址：" + localAddress); 
            //System.out.println("主机名：" + localAddress.getHostName());
            //System.out.println("IP地址：" + localAddress.getHostAddress());
            
        }
        catch (UnknownHostException e)  //网络程序可能会遇到各种各样的异常情况，所以大多需要进行异常处理
        {
            e.printStackTrace();  //发生异常时，只是简单的输出异常信息
        }
    }
}
