
/**
 * 根据IP地址获得地址信息，并判断该地址是否可达
 * 
 * @author (yhz) 
 * @version (2013-6-20)
 */
import java.net.*;
import java.io.*;  //与文件处理有关的类，这里涉及到类IOException

public class GetHostByAddress
{
    public static void main(String[] args)
    {
        try
        {
            /*
             * getByAddress只支持用byte数组表示的IP地址，而不支持字符串形式的IP地址。
             * 若想通过字符串形式的IP地址获取主机名，可以先调用getByName，再调用getHostName得到主机名
             * byte的取值范围为-128-127，所以当IP地址中的某位大于127时，要强制转换为byte类型
             */
            byte[] ip = new byte[] {(byte)192, (byte) 168, 10, (byte) 199};
            
            /*
             * getByAddress并不检测指定IP地址的主机是否存在，所以，当用户未指定主机名时，主机名为空
             */
            InetAddress localAddress = InetAddress.getByAddress(ip);
            System.out.println("主机名/IP地址：" + localAddress); 
            
            boolean flag = localAddress.isReachable(5000);   //判断该地址是否可达，超时时间设为5S，该时间不宜太短
            
            if (flag)
                System.out.println("可达 " +  localAddress); 
            else 
                System.out.println("不可达 " +  localAddress); 
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
}
