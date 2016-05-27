package eu.noelvaes.spring.beers.services;

import javax.jms.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service("beerJmsReceiver")
public class BeerJmsReceiver implements MessageListener {
   private BeerService beerService;

   @Autowired
   public void setBeerService(BeerService beerService) {
      this.beerService = beerService;
   }

   public void onMessage(Message msg) {
      try {
         if (msg instanceof ObjectMessage) {
            ObjectMessage message = (ObjectMessage) msg;
            int[][] beers = (int[][]) message.getObject();
            beerService.orderBeers(beers);
            System.out.println("Beers ordered");
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

}
