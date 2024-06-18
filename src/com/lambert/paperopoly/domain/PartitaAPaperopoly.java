package com.lambert.paperopoly.domain;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitaAPaperopoly {

   private static final List<String> NOMI_GIOCATORI = new ArrayList<String>(Arrays.asList("Alice", "Bob", "Carl", "David", "Eva", "Frank", "Grace", "Igor"));
   private Integer numeroGiri;
   private Integer numeroGiocatori;
   private List<Giocatore> giocatori;
   private Tabellone tabellone;
   private Bussolotto bussolotto;

   public Integer getNumeroGiri() {
      return this.numeroGiri;
   }

   public void setNumeroGiri(Integer numeroGiri) {
      this.numeroGiri = numeroGiri;
   }

   public Integer getNumeroGiocatori() {
      return this.numeroGiocatori;
   }

   public void setNumeroGiocatori(Integer numeroGiocatori) {
      this.numeroGiocatori = numeroGiocatori;
   }

   public PartitaAPaperopoly(Integer numeroGiri, Integer numeroGiocatori) {
      this.bussolotto = new Bussolotto();
      this.tabellone = new Tabellone(this.bussolotto);
      if(numeroGiocatori > PartitaAPaperopoly.NOMI_GIOCATORI.size()) {
         numeroGiocatori = PartitaAPaperopoly.NOMI_GIOCATORI.size();
      }
      this.giocatori = new ArrayList<Giocatore>(numeroGiocatori);
      for(Integer i = 0; i < numeroGiocatori; i++) {
         giocatori.add(new Giocatore(PartitaAPaperopoly.NOMI_GIOCATORI.get(i), this.tabellone, this.tabellone.getPrimaCasella(), this.bussolotto));
      }
      this.numeroGiri = numeroGiri;
      this.numeroGiocatori = numeroGiocatori;
   }

   public void giocaPartita() {
      System.out.println("Inizio della simulazione per " + this.numeroGiri.toString() + " giri e " + this.numeroGiocatori + " numero Giocatori:");
      for(Integer giro = 0; giro < this.numeroGiri; giro++) {
         this.giocaTurno(giro);
      }
      System.out.println("Fine della simulazione.");
   }

   public void giocaTurno(@NotNull Integer giro) {
      System.out.println("Giro " + String.valueOf(giro + 1) + ": ");
      for(Giocatore giocatore : this.giocatori) {
         giocatore.effettuaTurno();
      }
   }

   @Override
   public String toString() {
      return "PartitaAPaperopoly: {" +
              " bussolotto = " + this.bussolotto.toString() +
              ", numeroGiri = " + this.numeroGiri.toString() +
              ", numeroGiocatori = " + this.numeroGiocatori.toString() +
              ", giocatori = " + this.giocatori.toString() +
              ", tabellone = " + this.tabellone.toString() +
              " }";
   }
}
