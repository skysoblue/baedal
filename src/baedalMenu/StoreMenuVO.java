package baedalMenu;

import java.io.Serializable;

public class StoreMenuVO implements Serializable {
   private static final long serialVersionUID = 1L;
   private int price;
   
   public int getPrice() {
      return price;
   }
   public void setPrice(int price) {
      this.price = price;
   }
   
   
}