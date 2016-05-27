package eu.noelvaes.spring.beers.services;

public class FaultBean {
   private String message;

   public FaultBean() {
   }
   
   public FaultBean(String message) {
      this.message = message;
   }

   public String getMessage() {
      return message;
   }

   public void setMessage(String message) {
      this.message = message;
   }
   
}
