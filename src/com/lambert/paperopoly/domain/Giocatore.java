package com.lambert.paperopoly.domain;

import com.lambert.paperopoly.domain.casella.Casella;

import java.util.Objects;

public class Giocatore {
   private String nome;
   private Tabellone tabellone;
   private Casella casella;
   private Bussolotto bussolotto;
   private Float soldi;
   private Boolean giroFermo = false;

   public Giocatore(String nome, Tabellone tabellone, Casella casella, Bussolotto bussolotto) {
      this.nome = nome;
      this.tabellone = tabellone;
      this.casella = casella;
      this.bussolotto = bussolotto;
      this.soldi = 100.0F;
   }

   public Bussolotto getBussolotto() {
      return this.bussolotto;
   }

   public Casella getCasella() {
      return this.casella;
   }

   public String getNome() {
      return this.nome;
   }

   public Float getSoldi() {
      return this.soldi;
   }

   public Tabellone getTabellone() {
      return this.tabellone;
   }

   public void setBussolotto(Bussolotto bussolotto) {
      this.bussolotto = bussolotto;
   }

   public void setCasella(Casella casella) {
      this.casella = casella;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public void setSoldi(Float soldi) {
      this.soldi = soldi;
   }

   public void setTabellone(Tabellone tabellone) {
      this.tabellone = tabellone;
   }

   public Boolean getGiroFermo() {
      return this.giroFermo;
   }

   public void setGiroFermo(Boolean giroFermo) {
      this.giroFermo = giroFermo;
   }

   @Override
   public String toString() {
      return "Giocatore: {" +
              " bussolotto = " + this.bussolotto.toString() +
              ", nome = '" + this.nome + '\'' +
              ", tabellone = " + this.tabellone.toString() +
              ", soldi = " + this.soldi.toString() +
              ", giroFermo = " + this.giroFermo.toString() +
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
      Giocatore that = (Giocatore) object;
      return Objects.equals(this.nome, that.getNome());
   }

   @Override
   public int hashCode() {
      return Objects.hashCode(this.nome);
   }

   public void effettuaTurno() {
      if(giroFermo) {
         this.giroFermo = false;
         return;
      }
      this.bussolotto.mischia();
      Integer valoreFacceTotale = this.bussolotto.getTotale();
      Casella vecchiaCasella = this.casella;
      Casella nuovaCasella = this.tabellone.getNuovaCasella(this.casella, valoreFacceTotale);
      this.casella = nuovaCasella;
      this.casella.atterratoSu(this);
      System.out.println("Turno Giocatore " + this.getNome() + ": ");
      System.out.println("Casella d'inizio: " + vecchiaCasella.toString() + ", totale Dadi: " + valoreFacceTotale.toString() + ", Casella di fine: " + nuovaCasella.toString()); // ...
   }

   public void aggiungiSoldi(Float importo) {
      this.soldi += importo;
   }

   public void riduciSoldi(Float importo) {
      this.soldi -= importo;
   }

   public void avanza(Integer distanza) {
      Casella vecchiaCasella = this.casella;
      Casella casellaAvanzamento = this.tabellone.getNuovaCasella(vecchiaCasella, distanza);
      this.casella = casellaAvanzamento;
   }

   public void indietreggia(Integer distanza) {
      Casella vecchiaCasella = this.casella;
      Casella casellaAvanzamento = this.tabellone.getNuovaCasella(vecchiaCasella, -1 * distanza );
      this.casella = casellaAvanzamento;
   }
}
