import java.net.*;  
public class LocalHostTest
{
    public static void main(String[] args)
    {
        try
        {
            InetAddress localAddress = InetAddress.getLocalHost();
            System.out.println("主机名/IP地址：" + localAddress);            
        }
        catch (UnknownHostException e)  
        {
            e.printStackTrace();  
        }
    }
}
