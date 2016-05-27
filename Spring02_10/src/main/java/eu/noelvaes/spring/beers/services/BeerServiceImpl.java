package eu.noelvaes.spring.beers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;
import eu.noelvaes.spring.beers.domain.Beer;

@Service("beerService")
public class BeerServiceImpl implements BeerService {
   private BeerRepository repository;
   
   @Autowired
   public void setBeerRepository(BeerRepository repository) {
      this.repository = repository;
   }

   @Secured({"ROLE_ADULT"})
   @Transactional(propagation = Propagation.REQUIRED,  rollbackFor = {
         InvalidBeerException.class, InvalidNumberException.class })
   public void orderBeer(int beerId, int number) throws InvalidBeerException,
         InvalidNumberException {
      Beer beer = repository.getBeerById(beerId);
      if (beer == null) {
         throw new InvalidBeerException("Beer " + beerId + " does not exist");
      }
      if (number < 0)
         throw new InvalidNumberException("Number " + number + " is invalid");
      beer.setStock(beer.getStock() - number);
   }

   @Secured({"ROLE_ADULT"})
   @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {
         InvalidBeerException.class, InvalidNumberException.class })
   public void orderBeers(int[][] beers) throws InvalidBeerException,
         InvalidNumberException {
      for (int[] beer : beers) {
         orderBeer(beer[0], beer[1]);
      }
   }
}
