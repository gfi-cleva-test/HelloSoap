package eu.noelvaes.spring.beers.services;

import javax.xml.ws.*;

@WebFault
public class BeerWSException extends Exception {
   private FaultBean faultBean;

   public BeerWSException(String message, FaultBean faultBean,
         Throwable cause) {
      super(message, cause);
      this.faultBean = faultBean;
   }

   public BeerWSException(String message, FaultBean faultBean) {
      super(message);
      this.faultBean = faultBean;
   }

   public FaultBean getFaultInfo() {
      return faultBean;
   }
}
