package eu.noelvaes.spring.beers.domain;

import java.io.*;
import java.util.*;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@Table(name="Categories")
public class Category implements Serializable{
   @Id
   @Column(name="Id")
   private int id;
   
   @Column(name="Category")
   private String name;

   @OneToMany(mappedBy="category")
   private Set<Beer> beers = new HashSet<Beer>();

   @XmlTransient
   public Set<Beer> getBeers() {
      return beers;
   }

   public void setBeers(Set<Beer> beers) {
      this.beers = beers;
   }

   public int getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
   
   public String toString() {
      return name;
   }
}
