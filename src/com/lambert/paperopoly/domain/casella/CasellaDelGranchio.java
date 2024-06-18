package com.lambert.paperopoly.domain.casella;

import com.lambert.paperopoly.domain.Giocatore;
import org.jetbrains.annotations.NotNull;

public class CasellaDelGranchio extends Casella {

   private Casella casellaSalto;

   public CasellaDelGranchio(String nome, Integer indice, Casella casellaSalto) {
      super(nome, indice);
      this.casellaSalto = casellaSalto;
   }

   public Casella getCasellaSalto() {
      return this.casellaSalto;
   }

   public void setCasellaSalto(Casella casellaSalto) {
      this.casellaSalto = casellaSalto;
   }

   @Override
   public String toString() {
      return "CasellaDeiDadi: {" +
              " indice = " + this.getIndice().toString() +
              ", nome = '" + this.getNome() + '\'' +
              ", casellaSalto = " + this.casellaSalto +
              " }";
   }

   @Override
   public void atterratoSu(@NotNull Giocatore giocatore) {
      giocatore.setCasella(this.casellaSalto);
   }
}
