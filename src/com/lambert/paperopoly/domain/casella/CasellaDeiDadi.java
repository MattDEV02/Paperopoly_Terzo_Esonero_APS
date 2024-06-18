package com.lambert.paperopoly.domain.casella;

import com.lambert.paperopoly.domain.Giocatore;
import org.jetbrains.annotations.NotNull;

public class CasellaDeiDadi extends Casella {

   private static final Integer DISTANZA = 3;

   public CasellaDeiDadi(String nome, Integer indice) {
      super(nome, indice);
   }

   @Override
   public String toString() {
      return "CasellaDeiDadi: {" +
              " indice = " + this.getIndice().toString() +
              ", nome = '" + this.getNome() + '\'' +
              ", DISTANZA = " + CasellaDeiDadi.DISTANZA +
              " }";
   }

   @Override
   public void atterratoSu(@NotNull Giocatore giocatore) {
      giocatore.avanza(CasellaDeiDadi.DISTANZA);
   }
}
