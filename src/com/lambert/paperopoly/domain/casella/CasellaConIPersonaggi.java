package com.lambert.paperopoly.domain.casella;

import com.lambert.paperopoly.domain.Giocatore;
import org.jetbrains.annotations.NotNull;

public class CasellaConIPersonaggi extends Casella {

   private static final Integer DISTANZA = 3;

   public CasellaConIPersonaggi(String nome, Integer indice) {
      super(nome, indice);
   }

   @Override
   public String toString() {
      return "CasellaConIBassotti: {" +
              " indice = " + this.getIndice().toString() +
              ", nome = '" + this.getNome() + '\'' +
              ", DISTANZA = " + CasellaConIPersonaggi.DISTANZA +
              " }";
   }

   @Override
   public void atterratoSu(@NotNull Giocatore giocatore) {
      giocatore.indietreggia(CasellaConIPersonaggi.DISTANZA);
   }
}
