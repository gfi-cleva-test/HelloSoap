package eu.noelvaes.spring.beers.services;

import java.util.List;

import javax.jws.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import eu.noelvaes.spring.beers.domain.Beer;

@WebService
public class BeerServiceEndpoint extends SpringBeanAutowiringSupport {
   @Autowired
   private BeerService beerService;

   @Autowired
   private BeerRepository beerRepository;
   
   @WebMethod()
   public Beer getBeerById(int id) {
      System.out.println("GetBeerById");
      return beerRepository.getBeerById(id);
   }

   @WebMethod
   public List<Beer> getBeerByAlcohol(float alcohol) {
      return beerRepository.getBeerByAlcohol(alcohol);
   }

   @WebMethod
   public void orderBeer(int beerId, int number) throws BeerWSException {      
      try {
         beerService.orderBeer(beerId, number);
      } catch (Exception e) {
         throw new BeerWSException("Error", new FaultBean(e.getMessage()));
      }
   }

   @WebMethod
   public void orderBeers(int[][] beers) throws BeerWSException{
      try {
         beerService.orderBeers(beers);
      } catch (Exception e) {
         throw new BeerWSException("Error", new FaultBean(e.getMessage()));
      }
   }

}
