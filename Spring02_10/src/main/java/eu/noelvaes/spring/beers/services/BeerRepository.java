package eu.noelvaes.spring.beers.services;

import java.util.*;

import eu.noelvaes.spring.beers.domain.*;

public interface BeerRepository {
   public Beer getBeerById(int id);
   public List<Beer> getBeerByAlcohol(float alcohol);
   public void updateBeer(Beer b);
}