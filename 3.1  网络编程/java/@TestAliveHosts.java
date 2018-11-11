
/**
 * 指出指定局域网络类的活跃主机
 * 
 * @author (yhz) 
 * @version (2013-6-20)
 */
import java.net.*;
import java.util.Scanner;  
import java.io.*;  //与文件处理有关的类，这里涉及到类IOException

public class TestAliveHosts
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("输入要的搜索的网络地址段信息(如要搜索192.168.10.*，就输入192.168.10.1)："); 
        String ipStr = scan.next();
        byte[] ip = stringToBytes(ipStr);
        ip[3] = 1;
        
        try
        {
            System.out.println("本网络内下列主机可达");
            for (int i = 1; i < 255; i ++)
            {                
                InetAddress localAddress = InetAddress.getByAddress(ip);
                System.out.println("正在检查地址：" + ip[3]);
                boolean flag = localAddress.isReachable(3000);   //判断该地址是否可达，超时时间设为5S，该时间不宜太短
                if (flag)
                {
                    System.out.println(localAddress.getHostName() + "/" + localAddress.getHostAddress()); 
                }
                
                //计算下一个IP地址对应的字符串
                //ip[3] = (byte) (ip[3] + 1);
                ip[3] ++;
            }
            
        }
        catch (UnknownHostException e)  //IP地址不合法时发生异常
        {
            e.printStackTrace(); 
        }
        catch (IOException e)  //函数isReachable可能抛出该异常
        {
            e.printStackTrace(); 
        }
    }
    
    /*
     * 将字符串形式的IP地址转换成byte数组。如参数为"192.168.10.199"时，形成的byte数组为｛-64; -88; 10; -57｝
     */
    private static byte[] stringToBytes(String ipStr)
    {
        byte[] ip = new byte[4];   //创建一个byte数组，用来存放结果
        
        ipStr = ipStr.replace('.', ':');  //将ipStr中的所有"."分隔符转换成":"，这是因为"."不能作为旁通的正规表达式
        String[] data = ipStr.split(":");  //将ip地址分成4个字符串
        for (int i = 0; i < data.length; i ++)
        {
            int value = stringToInt(data[i]);
            if (value <= 127)
                ip[i] = (byte) value;
            else
                ip[i] = (byte) (value - 256);
        }
        
        return ip;
    }
    
    /*
     * 将一个字符串形式的整数转换成整数。如参数为“192”，返回192。
     */
    private static int stringToInt(String str)
    {
        int value = 0;
        for (int i = 0; i < str.length(); i ++)
        {
            value = value * 10 + str.charAt(i) - '0';
        }
        return value;
    }
}
