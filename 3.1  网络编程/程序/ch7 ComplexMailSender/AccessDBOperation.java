
/**
 * 一个简单的对Access数据库进行操作的类。
 * 数据库名：UserMailInfo；表名：MailInfo；表中包含三个字段：
 * 用户邮箱(Account)：文本内容，最多50个字符，主键。
 * 邮件主题(Subject)：文本内容，最多50个字符。
 * 邮件内容(Content)：文本内容，最多255个字符。
 * 
 * @author (YHZ) 
 * @version (2013-8-4)
 */

import java.sql.*;  //JDBC使用
import java.util.*;

public class AccessDBOperation
{ 
    private Connection conn;  //用于与数据库连接的Connection对象
    private Statement stmt;  //用于执行SQL语句的Statement对象
   
    public AccessDBOperation()
    {
        init();

    }

    //初始化操作Access数据库的相关工作：加载驱动，创建连接，创建Statement对象
    public void init()
    {
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  //加载JDBC－ODBC驱动
            String url = "jdbc:odbc:Driver={MicroSoft Access Driver (*.mdb)};DBQ=.//database//UserMailInfo.mdb";  //连接Access数据库的URL，数据库文件存放于当前文件夹下的database中
            Connection conn =  DriverManager.getConnection(url);  //不需要用户名与密码
            stmt = conn.createStatement();  //创建Statement对象，用于执行SQL语句.            
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("无法加载JDBC－ODBC驱动程序");
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }
    
    //通过访问Access数据库UserMailInfo,获取其中表MailInfo中的记录
    public List<UserMailInfo> getUserInfo()
    {
        if (stmt == null)
            return null;
            
        List<UserMailInfo> userInfo = new ArrayList<UserMailInfo>();
        String sql = "Select * from MailInfo";
        try
        {
            ResultSet rst = stmt.executeQuery(sql);  //执行查询表的操作，返回结果存放于rst中
            
            while(rst.next())  //遍历rst中的记录
            {
                String account = rst.getString("Account");  //取出每行记录中的信息
                String subject = rst.getString("Subject");
                String content = rst.getString("Content");
                
                UserMailInfo user = new UserMailInfo(account, subject, content);
                userInfo.add(user);
            }
            
            rst.close();  //关闭记录集
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        
        return userInfo;        
    }
    
    //关闭数据库。操作之前，请确认与之相关联的ResultSet对象已经被关闭
    public void close()
    {
        try
        {
            if (stmt != null)  //先关闭Statement对象，再关闭Connection对象
                stmt.close();
            if (conn != null)
                conn.close();                
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }        
    }
    
}
