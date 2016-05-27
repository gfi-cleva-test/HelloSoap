package eu.noelvaes.spring.hello.services;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service("hello")
public class HelloImpl implements Hello {
   private String target;
   
   @Value("World")
   public void setTarget(String target) {
      this.target = target;
   }
   
   public String sayHello() {
      return "Hello " + target;
   }

}
