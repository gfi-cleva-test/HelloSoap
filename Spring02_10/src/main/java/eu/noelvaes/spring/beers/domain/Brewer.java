package eu.noelvaes.spring.beers.domain;

import java.io.*;
import java.util.*;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@Table(name="Brewers")
public class Brewer implements Serializable {
   @Id
   @Column(name="Id")
   private int id;
   
   @Column(name="Name")
   private String name;
   
   @Column(name="Address")
   private String address;
   
   @Column(name="ZipCode")
   private String zipCode;
   
   @Column(name="City")
   private String city;
   
   @Column(name="Turnover")
   private int turnover;
   
   @OneToMany(mappedBy="brewer")
   private Set<Beer> beers = new HashSet<Beer>();
   
   @XmlTransient
   public Set<Beer> getBeers() {
      return beers;
   }

   public void setBeers(Set<Beer> beers) {
      this.beers = beers;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
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

   public int getTurnover() {
      return turnover;
   }

   public void setTurnover(int turnover) {
      this.turnover = turnover;
   }

   public String getZipCode() {
      return zipCode;
   }

   public void setZipCode(String zipCode) {
      this.zipCode = zipCode;
   } 
   
   public String toString() {
      return name;
   }
}
