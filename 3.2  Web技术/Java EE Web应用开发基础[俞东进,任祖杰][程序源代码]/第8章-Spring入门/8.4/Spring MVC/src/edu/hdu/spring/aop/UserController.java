package edu.hdu.spring.aop;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;

import org.springframework.validation.BindException;
public class UserController extends AbstractCommandController {
    protected ModelAndView handle(HttpServletRequest request,
            HttpServletResponse response, Object command, BindException be)
            throws Exception {
        User user = (User)command;//自动封装的User对象
        System.out.println(user);
        //根据springMVC-servlet.xml配置，视图跳转将转义成success.jsp
        return new ModelAndView("success");
    }
}
