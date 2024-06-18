package com.lambert.paperopoly.domain.casella;

import com.lambert.paperopoly.domain.Giocatore;

public class CasellaSostaLibera extends Casella {
   public CasellaSostaLibera(String nome, Integer indice) {
      super(nome, indice);
   }

   @Override
   public String toString() {
      return "CasellaDeiDadi: {" +
              " indice = " + this.getIndice().toString() +
              ", nome = '" + this.getNome() + '\'' +
              " }";
   }

   @Override
   public void atterratoSu(Giocatore giocatore) {
      // NO-OP
   }
}
