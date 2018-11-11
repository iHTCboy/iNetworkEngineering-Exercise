
/**
 * 一个简单的邮件发送器，需要身份认证，不支持发送附件。
 * 
 * @author (YHZ) 
 * @version (2013-7-11)
 */

import javax.mail.*; //类Session、Authenticator、Message、Address等需要用到
import javax.mail.internet.*;  //类MimeMessage、InternetAddress等需要用到
import java.util.*;  //类Properties、Date等需要用到

public class SimpleMailSender
{
    private Session session = null;  //用于收发邮件的Session
    private String sender;  //发送方邮箱，即身份认证时的用户名
    private String password; //邮箱的访问密码
    private String host; //支持发送邮件功能的服务器的域名;可以通过你所使用的邮件服务器提供的帮助信息查找到
    
    /**
     * 构造函数，参数依次为：用户名、密码及邮件发送服务器域名。
     * 一般都是需要进行身份认证的，本程序未考虑不需要身份认证的情况。
     */
    public SimpleMailSender(String username, String password, String smtpHostName)
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
     * 支持给一个人发送一封邮件
     * @param isText: isText为true表示以文本格式发送；isText为flase表示以HTML格式发送
     * @param recipient: 接收方邮箱地址
     * @param subject: 邮件主题
     * @param content: 要发送的内容
     */
    public void sendSingleMail(boolean isText, String recipient, String subject, Object content) throws MessagingException 
    {
        //Message类用于封装邮件消息，包括发送者、接收者、主题、发送时间、内容等。
        //Message是一个抽象类，常常使用javax.mail.internet.MimeMessage这个子类
        //建立MimeMessage对象时，需要将Session对象作为MimeMessage构造方法的参数传入
        Message mailMsg = new MimeMessage(session);
        
        //Address用于封装发送方或接收方的地址信息，提供邮箱名即可；还可以附加别名
        //Address是一个抽象类，常常使用javax.mail.internet.InternetAddress这个子类
        Address from = new InternetAddress(sender);  //创建发送方地址
        mailMsg.setFrom(from);   //设置发送方,也可以用mailMsg.setReplyTo(from)；
        
        Address to = new InternetAddress(recipient);  //创建接收地址
        mailMsg.setRecipient(Message.RecipientType.TO, to);  //设置接收方；RecipientType.TO表示接收方，RecipientType.CC表示抄送方
        
        mailMsg.setSubject(subject);  //设置主题        
        mailMsg.setSentDate(new Date());  //设置发送时间（系统时间）
        
        if (isText)  //以文本方式发送
        {
            mailMsg.setText(content.toString());  //设置邮件的内容
        }
        else  //以HTML格式发送
        {
            mailMsg.setContent(content.toString(), "text/html;charset=utf-8");  //设置邮件的内容
        }
        
        Transport.send(mailMsg);  //发送邮件。系统为自动在发送前建立连接，并在发送结束后释放连接
    }

     /**
     * 支持给多个人发送同一封邮件(邮件主题与内容相同)
     * @param isText: isText为true表示以文本格式发送；isText为flase表示以HTML格式发送
     * @param recipients: 接收方邮箱地址的列表
     * @param subject: 邮件主题
     * @param content: 要发送的内容
     */
    public void sendMultiMail(boolean isText, List<String> recipients, String subject, Object content) throws MessagingException 
    {
        Message mailMsg = new MimeMessage(session);   //     
        Address from = new InternetAddress(sender);  //创建发送方地址
        mailMsg.setFrom(from);   //设置发送方,也可以用mailMsg.setReplyTo(from)；
        
        int num = recipients.size();
        Address[] to = new Address[num]; //创建接收地址
        for (int i = 0; i < num; i ++)
        {
            to[i] = new InternetAddress(recipients.get(i));
        }
        mailMsg.setRecipients(Message.RecipientType.TO, to);  //设置接收方；接收方多一个列表，包含多个接收者
        
        mailMsg.setSubject(subject);  //设置主题        
        mailMsg.setSentDate(new Date());  //设置发送时间（系统时间）
        
        if (isText)  //以文本方式发送
        {
            mailMsg.setText(content.toString());  //设置邮件的内容
        }
        else  //以HTML格式发送
        {
            mailMsg.setContent(content.toString(), "text/html;charset=utf-8");  //设置邮件的内容
        }
        
        //message.saveChanges(); // implicit with send()

        Transport transport = session.getTransport("smtp");  //建立一个用于邮件传输的对象
        transport.connect(host, sender, password);  //建立连接，对于要连续发送多封邮件的情形，这样方式比较高效.
        transport.sendMessage(mailMsg, mailMsg.getAllRecipients());  //向所有发送者扭送邮件
        transport.close();  //断开连接

    }
    
    public static void main(String[] args) throws MessagingException
    {
        SimpleMailSender sender = new SimpleMailSender("canoe@glite.edu.cn", "canoe982", "smtp.glite.edu.cn");
        
        //sender.sendSingleMail(true, "2002018@glut.edu.cn", "test", "fdsafdasfasf"); 
        
        //向多个用户发送同一封邮件
        List<String> to = new ArrayList<String>();
        to.add("canoe@glite.edu.cn");
        to.add("18123408@qq.com");
        to.add("2002018@glut.edu.cn");
        sender.sendMultiMail(false, to, "test", "safdasfsafasf\ndsafddsafdsaf");
    }
}
