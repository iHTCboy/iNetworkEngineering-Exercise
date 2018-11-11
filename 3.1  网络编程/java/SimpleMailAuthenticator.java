/**
 * 用于邮件发送前的认证的类。
 * JavaMail API通过使用授权者类（Authenticator）以用户名、密码的方式访问那些受到保护的资源，在这里“资源”就是指邮件服务器。
 * Authenticator是一个抽象类，我们必须派生自己的认证类，且重写getPasswordAuthentication()方法。
 * 在创建Session时要用到该类的对象。
 * 需要加载javax.mail包，方法是：（1）下载该包并放置到安装目录lib下；（2）在BlueJ中加载该包。
 * @author (YHZ) 
 * @version (2013-7-10)
 */

import javax.mail.*;  //需要用到其中的Authenticator及PasswordAuthentication

public class MailAuthenticator extends Authenticator 
{  
    private String username;    //认证时需提供的用户名
    private String password;    //认证时需要提供的密码

    //匿名构造函数，当不需要用户名与密码时使用
    public MailAuthenticator()
    {
        username = null;
        password = null;
    }
    
    public MailAuthenticator(String username, String password) 
    {  
        this.username = username;
        this.password = password; 
    }  
    
    //重载getPasswordAuthentication方法，返回一个由指定用户名与密码实现的认证，细节由Java本身实现
    protected PasswordAuthentication getPasswordAuthentication() 
    {  
        return new PasswordAuthentication(username, password);  
    }  

} 

