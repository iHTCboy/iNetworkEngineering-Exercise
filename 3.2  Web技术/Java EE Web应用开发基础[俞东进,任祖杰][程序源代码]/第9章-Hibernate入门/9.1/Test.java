import net.sf.hibernate.*;
import net.sf.hibernate.cfg.*;
public class Test {
public static void main(String[] args) {
try {
//创建SessionFactory实例
                      SessionFactory sf = new Configuration().configure().buildSessionFactory();
                       //创建Session实例
                      Session session = sf.openSession();
                  Transaction tx = session.beginTransaction();
                    for (int i = 0; i < 200; i++) {
                          Customer customer = new Customer();
                          customer.setUsername("customer" + i);
                          customer.setPassword("customer");
                          //保存customer到数据库中
session.save(customer); 
                    }
                    tx.commit(); //提交事务
                    session.close(); //关闭Session
} catch (HibernateException e) {
                  e.printStackTrace();
}
}
 }
