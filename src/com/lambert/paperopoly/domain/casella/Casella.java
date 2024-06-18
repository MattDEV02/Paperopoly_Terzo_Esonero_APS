package com.lambert.paperopoly.domain.casella;

import com.lambert.paperopoly.domain.Giocatore;

import java.util.Objects;

public abstract class Casella {
   private String nome;
   private Integer indice;

   public Casella(String nome, Integer indice) {
      this.nome = nome;
      this.indice = indice;
   }

   public Integer getIndice() {
      return this.indice;
   }

   public void setIndice(Integer indice) {
      this.indice = indice;
   }

   public String getNome() {
      return this.nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   @Override
   public String toString() {
      return "Casella: {" +
              " indice = " + this.indice.toString() +
              ", nome = '" + this.nome + '\'' +
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
      Casella that = (Casella) object;
      return Objects.equals(this.indice, that.getIndice());
   }

   @Override
   public int hashCode() {
      return Objects.hash(this.indice);
   }

   public abstract void atterratoSu(Giocatore giocatore);
}
