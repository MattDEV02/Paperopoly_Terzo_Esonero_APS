package com.lambert.paperopoly.domain;

import java.util.Objects;
import java.util.Random;

public class Dado {
   public static final Integer MAX = 6;
   private static final Random RANDOM = new Random();
   private Integer valoreFaccia;

   public Dado() {
      this.tira();
   }

   public void tira() {
      this.valoreFaccia = Dado.RANDOM.nextInt(Dado.MAX) + 1;
   }

   public Integer getValoreFaccia() {
      return this.valoreFaccia;
   }

   public void setValoreFaccia(Integer valoreFaccia) {
      this.valoreFaccia = valoreFaccia;
   }

   @Override
   public boolean equals(Object object) {
      if (this == object) {
         return true;
      }
      if (object == null || this.getClass() != object.getClass()) {
         return false;
      }
      Dado that = (Dado) object;
      return Objects.equals(this.valoreFaccia, that.getValoreFaccia());
   }

   @Override
   public int hashCode() {
      return Objects.hashCode(this.valoreFaccia);
   }

   @Override
   public String toString() {
      return "Dado: {" +
              " valoreFaccia = " + this.valoreFaccia.toString() +
              " }";
   }
}
