
/**
 * 一个略微复杂的邮件发送器：可以同时给多人发送邮件，且每封邮件的主题及内容可以不一样；
 * 用一个Access数据库中的表来存放每个的邮箱、拟发送的邮件的主题及内容
 * 需要身份认证，不支持发送附件。
 * 
 * @author (YHZ) 
 * @version (2013-8-4)
 */

import javax.mail.*; //类Session、Authenticator、Message、Address等需要用到
import javax.mail.internet.*;  //类MimeMessage、InternetAddress等需要用到
import java.util.*;  //类Properties、Date等需要用到

public class ComplexMailSender
{
    private Session session = null;  //用于收发邮件的Session
    private String sender;  //发送方邮箱，即身份认证时的用户名
    private String password; //邮箱的访问密码
    private String host; //支持发送邮件功能的服务器的域名;可以通过你所使用的邮件服务器提供的帮助信息查找到
    
    /**
     * 构造函数，参数依次为：用户名、密码及邮件发送服务器域名。
     * 一般都是需要进行身份认证的，本程序未考虑不需要身份认证的情况。
     */
    public ComplexMailSender(String username, String password, String smtpHostName)
    {
        sender = username;
        this.password = password;
        host = smtpHostName;
        
        init(username, password, smtpHostName);
    }

    //构造一个用于发送邮件的Sesseion,Session类定义了基本的邮件会话。
    private void init(String username, String password, String smtpHostName) 
    {
        //Session对象利用了java.util.Properties对象获得了邮件服务器、用户名、密码信息和整个应用程序都要使用到的共享信息。
        Properties props = System.getProperties();  //也可以直接创建：props = new Properties();
        // 初始化props，所有属性值都用字符串表示
        props.put("mail.smtp.auth", "true");     //需要认证
        props.put("mail.smtp.port", "25");  //设置邮件发送端口，缺省为25
        props.put("mail.smtp.host", smtpHostName);  //设置用于发送邮件的邮件服务器，如smtp.glite.edu.cn
       
        Authenticator authenticator = new MailAuthenticator(username, password);   //身份验证，若不需要认证，设置为null  
        session = Session.getInstance(props, authenticator);   //创建Session
    }  

    
     /**
     * 支持给多个人发送同一封邮件(邮件主题与内容相同)
     * @param isText: isText为true表示以文本格式发送；isText为flase表示以HTML格式发送
     * @param userInfo：一个记录集，记录集中的每一行包含信息用户邮箱、邮件主题、邮件内容
     */
    public void sendMultiMail(boolean isText, List<UserMailInfo> userInfo) throws MessagingException 
    {
        Message mailMsg = new MimeMessage(session);   //     
        Address from = new InternetAddress(sender);  //创建发送方地址
        mailMsg.setFrom(from);   //设置发送方,也可以用mailMsg.setReplyTo(from)；
        
        Transport transport = session.getTransport("smtp");  //建立一个用于邮件传输的对象
        transport.connect(host, sender, password);  //建立连接，对于要连续发送多封邮件的情形，这样方式比较高效.
        
        for (UserMailInfo user : userInfo)
        {
            String account = user.getAccount();
            Address to = new InternetAddress(account); //创建接收地址
            mailMsg.setRecipient(Message.RecipientType.TO, to);  //设置接收方
        
            String subject = user.getSubject();
            mailMsg.setSubject(subject);  //设置主题        
            mailMsg.setSentDate(new Date());  //设置发送时间（系统时间）
        
            String content = user.getContent();
            if (isText)  //以文本方式发送
            {
                mailMsg.setText(content.toString());  //设置邮件的内容
            }
            else  //以HTML格式发送
            {
                mailMsg.setContent(content.toString(), "text/html;charset=utf-8");  //设置邮件的内容
            }
            transport.sendMessage(mailMsg, mailMsg.getAllRecipients());  //向所有发送者扭送邮件
        }


        transport.close();  //断开连接

    }
    
    public static void main(String[] args) throws MessagingException
    {
        ComplexMailSender sender = new ComplexMailSender("canoe@glite.edu.cn", "canoe982", "smtp.glite.edu.cn");       
        
        //向多个用户发送不同邮件
        AccessDBOperation db = new AccessDBOperation();
        List<UserMailInfo> user = db.getUserInfo();
        db.close();
        sender.sendMultiMail(false, user);
    }
}
