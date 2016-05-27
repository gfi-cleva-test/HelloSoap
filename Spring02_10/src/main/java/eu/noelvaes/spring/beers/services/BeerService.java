package eu.noelvaes.spring.beers.services;

public interface BeerService {
   public void orderBeer(int beerId, int number) throws InvalidBeerException,
         InvalidNumberException;

   public void orderBeers(int[][] beers) throws InvalidBeerException,
         InvalidNumberException;
}