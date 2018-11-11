package edu.hdu.javaee.hibernate;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class Test {
	private static final SessionFactory sessionFactory;
	static {
		try {
			// 创建SessionFactory，自动在src路径下寻找hibernate.cfg.xml						sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void main(String[] args) {
		Blog blog = new Blog();
		blog.setTitle("这里是日志标题");
		blog.setContent("这里是日志内容");
		blog.setDate(new Date());
		Test t = new Test();
		Session session =Test.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		t.save(session, blog);
		t.select(session);
		t.update(session, blog.getId());
		t.select(session);
		t.delete(session,blog.getId());
		t.select(session):
		session.getTransaction().commit();
	}

 	public void save(Session session, Blog blog) {
		try {
			session.save(blog);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
 
	public void select(Session session) {
		try {
			String sql = "from Blog";
			List l = session.createQuery(sql).list();
			for (Blog b : l) {
				System.out.println(b.getId());
				System.out.println(b.getTitle());
				System.out.println(b.getContent());
				System.out.println(b.getDate());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	public void update(Session session，Integer id) {
		try {
			Blog b = (Blog) session.load(Blog.class, id);
			b.setTitle("更新后标题");
			session.update(b);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	public void delete(Session session, Integer id) {
		try {
			Blog b = (Blog) session.load(Blog.class, id);
			session.delete(b);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
} 
