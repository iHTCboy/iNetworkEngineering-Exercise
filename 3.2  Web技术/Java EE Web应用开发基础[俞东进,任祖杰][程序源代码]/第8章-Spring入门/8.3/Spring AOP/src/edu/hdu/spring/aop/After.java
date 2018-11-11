package edu.hdu.spring.aop;
import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;
public class After implements AfterReturningAdvice{
public void afterReturning(Object returnValue, Method method, Object[] args, 
Object target) throws Throwable {
      System.out.println("结账了！");
}
}

/*DinningInterface.java 接口*/
