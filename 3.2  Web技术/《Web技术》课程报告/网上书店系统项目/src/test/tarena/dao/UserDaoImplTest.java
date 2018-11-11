package test.tarena.dao;

import org.junit.Before;
import org.junit.Test;

import com.tarena.dao.impl.UserDaoImpl;
import com.tarena.entity.User;
import static org.junit.Assert.assertEquals;

public class UserDaoImplTest {
	private UserDaoImpl userDaoImpl;
	@Before
	public void setUp() throws Exception {
		userDaoImpl = new UserDaoImpl();
	}

	@Test
	public void testSavaUser() throws Exception{
		User user = new User();
		user.setEmail("king@163.com");
		user.setNickname("king");
		user.setPassword("1234");
		user.setEmailVerify(false);
		user.setEmailVerifyCode("123456789");
		int id = userDaoImpl.saveUser(user);
		assertEquals(1,id);
	}

}
