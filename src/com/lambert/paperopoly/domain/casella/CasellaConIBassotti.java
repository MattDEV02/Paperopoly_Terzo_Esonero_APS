package com.lambert.paperopoly.domain.casella;

import com.lambert.paperopoly.domain.Giocatore;
import org.jetbrains.annotations.NotNull;

public class CasellaConIBassotti extends Casella {
   private static final Float IMPORTO = 100.0F;

   public CasellaConIBassotti(String nome, Integer indice) {
      super(nome, indice);
   }

   @Override
   public String toString() {
      return "CasellaConIBassotti: {" +
              " indice = " + this.getIndice().toString() +
              ", nome = '" + this.getNome() + '\'' +
              ", IMPORTO = " + CasellaConIBassotti.IMPORTO +
              " }";
   }

   @Override
   public void atterratoSu(@NotNull Giocatore giocatore) {
      giocatore.riduciSoldi(CasellaConIBassotti.IMPORTO);
      giocatore.setGiroFermo(true);
   }
}
