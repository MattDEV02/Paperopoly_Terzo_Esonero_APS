package com.lambert.paperopoly.domain.casella;

import com.lambert.paperopoly.domain.Giocatore;
import org.jetbrains.annotations.NotNull;

public class CasellaDelVia extends Casella {
   private static final Float IMPORTO = 200.0F;

   public CasellaDelVia(String nome, Integer indice) {
      super(nome, indice);
   }

   @Override
   public String toString() {
      return "CasellaDeiDadi: {" +
              " indice = " + this.getIndice().toString() +
              ", nome = '" + this.getNome() + '\'' +
              ", IMPORTO = " + CasellaDelVia.IMPORTO +
              " }";
   }

   @Override
   public void atterratoSu(@NotNull Giocatore giocatore) {
      giocatore.aggiungiSoldi(CasellaDelVia.IMPORTO);
   }
}
