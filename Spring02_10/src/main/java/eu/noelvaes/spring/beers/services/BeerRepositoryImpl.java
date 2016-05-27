package eu.noelvaes.spring.beers.services;

import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.*;

import eu.noelvaes.spring.beers.domain.Beer;

@Repository("beerRepository")
public class BeerRepositoryImpl implements BeerRepository {   
   private EntityManager em;

   @PersistenceContext
   public void setEntityManager(EntityManager em) {
      this.em = em;
   }
   
   @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
   public Beer getBeerById(int id) {
      return em.find(Beer.class, id);
   }

   @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
   public List<Beer> getBeerByAlcohol(float alcohol) {
      TypedQuery<Beer> query = em.createQuery("select b from Beer b where b.alcohol = ?1",Beer.class);
      query.setParameter(1, alcohol);
      return query.getResultList();
   }

   @Transactional(propagation =Propagation.REQUIRED)
   public void updateBeer(Beer b) {
      em.merge(b);
   }
}
