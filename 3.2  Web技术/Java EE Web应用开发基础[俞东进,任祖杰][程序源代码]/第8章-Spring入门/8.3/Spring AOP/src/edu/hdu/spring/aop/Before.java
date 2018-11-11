/*Before.java 提前通知*/
package edu.hdu.spring.aop;
import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;
public class Before implements MethodBeforeAdvice {
public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
System.out.println("点好菜！");
}
}

/*After.java 之后通知*/
