package com.lambert.paperopoly.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bussolotto {
   private static final Integer NUMERO_DADI = 2;

   private List<Dado> dadi;

   public Bussolotto() {
      this.dadi = new ArrayList<Dado>(Bussolotto.NUMERO_DADI);
      for(Integer i = 0; i < Bussolotto.NUMERO_DADI; i++) {
         this.dadi.add(new Dado());
      }
   }

   public List<Dado> getDadi() {
      return this.dadi;
   }

   public void setDadi(List<Dado> dadi) {
      this.dadi = dadi;
   }

   public void mischia() {
      for(Dado dado : this.dadi) {
         dado.tira();
      }
   }

   public Integer getTotale() {
      Integer totale = 0;
      for(Dado dado : this.dadi) {
         totale += dado.getValoreFaccia();
      }
      return totale;
   }

   @Override
   public String toString() {
      return "Bussolotto: {" +
              " dadi = " + this.dadi.toString() +
              " }";
   }

   @Override
   public boolean equals(Object object) {
      if (this == object) {
         return true;
      }
      if (object == null || this.getClass() != object.getClass()) {
         return false;
      }
      Bussolotto that = (Bussolotto) object;
      return Objects.equals(this.dadi, that.getDadi());
   }

   @Override
   public int hashCode() {
      return Objects.hashCode(this.dadi);
   }
}
