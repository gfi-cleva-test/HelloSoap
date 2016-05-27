package eu.noelvaes.spring.hello.services;

import javax.jms.*;

import org.springframework.stereotype.*;

@Service("helloJmsReceiver")
public class HelloJmsReceiver implements MessageListener {

   public void onMessage(Message msg) {      
      try {
         if(msg instanceof TextMessage) {
            String text = ((TextMessage)msg).getText();
            System.out.println("Hello " + text);
         }
      }
      catch (JMSException e) {
         e.printStackTrace();
      }
   }
}
