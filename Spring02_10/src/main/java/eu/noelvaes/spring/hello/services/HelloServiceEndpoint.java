package eu.noelvaes.spring.hello.services;

import javax.annotation.PostConstruct;
import javax.jws.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@WebService
public class HelloServiceEndpoint 
                          extends SpringBeanAutowiringSupport{
   private Hello helloService;
   
   public HelloServiceEndpoint() {
      System.out.println("Constructor");
   }
   
   @PostConstruct
   public void postConstruct() {
       System.out.println("postconstruct has run.");
   }
   
   @Autowired(required = true) 
   @WebMethod(exclude=true)
   public void setHelloService(Hello helloService) {
      System.out.println("setHelloService()");
      this.helloService = helloService;
   }
   
   @WebMethod
   public String sayHello() {
      System.out.println("sayHello");
      return helloService.sayHello();
   }
}