package com.lambert.paperopoly.domain.casella;

import com.lambert.paperopoly.domain.Bussolotto;
import com.lambert.paperopoly.domain.Giocatore;
import org.jetbrains.annotations.NotNull;

public class CasellaDeiDollari extends Casella {
   private Float importo;
   private Bussolotto bussolotto;

   public CasellaDeiDollari(String nome, Integer indice, Float importo, Bussolotto bussolotto) {
      super(nome, indice);
      this.importo = importo;
      this.bussolotto = bussolotto;
   }

   public Float getImporto() {
      return this.importo;
   }

   public void setImporto(Float importo) {
      this.importo = importo;
   }

   @Override
   public String toString() {
      return "CasellaDeiDadi: {" +
              " indice = " + this.getIndice().toString() +
              ", nome = '" + this.getNome() + '\'' +
              ", importo = " + this.importo +
              " }";
   }

   public Bussolotto getBussolotto() {
      return this.bussolotto;
   }

   public void setBussolotto(Bussolotto bussolotto) {
      this.bussolotto = bussolotto;
   }

   @Override
   public void atterratoSu(@NotNull Giocatore giocatore) {
      giocatore.aggiungiSoldi(this.importo);
      Integer distanza = this.bussolotto.getTotale();
      giocatore.avanza(distanza);
   }
}
