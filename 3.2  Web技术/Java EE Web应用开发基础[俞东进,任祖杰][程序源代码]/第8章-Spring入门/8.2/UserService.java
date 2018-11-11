public class UserService {
private UserDAO userDao;
public void queryList() { 
Ojbect obj =Class.forName(Config.UserDAOImpl).newInstance();
userDao = (UserDAO)obj; 
userDao.queryList() ;
} 
бнбн 
}
