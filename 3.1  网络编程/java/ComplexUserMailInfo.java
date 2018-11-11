
/**
 * 用于存放收信方信息的类，包括收信人，信件的主题及内容
 * 
 * @author (YHZ) 
 * @version (2013-8-4)
 */
public class UserMailInfo
{
    private String account; //收信人邮箱
    private String subject; //邮件主题
    private String content; //邮件内容
    
    public UserMailInfo(String account, String subject, String content)
    {
        this.account = account;
        this.subject = subject;
        this.content = content;
    }

    public String getSubject()
    {
        return subject;
    }
    
    public String getAccount()
    {
        return account;
    }
    
    public String getContent()
    {
        return content;
    }
}
