
/**
 * 通过主机名或域名获取主机信息
 * 
 * @author (yhz) 
 * @version (2013-6-20)
 */
import java.net.*;
import java.util.Scanner;  //一个比较好用的输入类

public class GetHostByName
{
    public static void main(String[] args)
    {
        try
        {
            Scanner scan = new Scanner(System.in);  //创建一个处理键盘输入的对象，System.in代表标准输入设备，即键盘
            
            System.out.print("请输入你想查寻的主机：");
            String name = scan.next();  //从键盘接收一个字符串（换行结束）赋给name
            
            /*
             * 可用主机名获取局域网内的地址信息；也可以获得远程主机的地址信息，但需要网络及DNS支持。
             * 也可以用IP地址的字符串形式作为参数，如"192.168.10.199"，但此时不会自动查找该IP对应的主机名。
             * 一个主机名或域名可能对应多个IP地址，这时仅返回第一个IP地址。
             * 若想返回域名对应的所有IP地址，可以使用getAllByName
             * 当名字为null或localhost时，返回值为127.0.0.
             */
            InetAddress localAddress = InetAddress.getByName(name);
            System.out.println("主机名/IP地址：" + localAddress); 
            
        }
        catch (UnknownHostException e)  //当给定的域名不存在时，会产生该异常
        {
            e.printStackTrace(); 
        }
    }
}
