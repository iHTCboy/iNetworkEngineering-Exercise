package edu.hdu.spring.aop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
public class MainTest {
public static void main(String[] args) {
         ApplicationContext ac = new 
FileSystemXmlApplicationContext("src/spring-aop.xml");
DinningInterface din = (DinningInterface)ac.getBean("proxybean");
         din.eat();
}
}
