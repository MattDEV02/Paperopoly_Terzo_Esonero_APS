package com.lambert.paperopoly.domain;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitaAPaperopoly {
   private static final List<String> NOMI_GIOCATORI = new ArrayList<String>(Arrays.asList("Alice", "Bob", "Carl", "David", "Eva", "Frank", "Grace", "Igor"));
   private Integer numeroGiri;
   private List<Giocatore> giocatori;
   private Tabellone tabellone;
   private Bussolotto bussolotto;
   private static volatile PartitaAPaperopoly INSTANCE;

   public static PartitaAPaperopoly getInstance(Integer numeroGiri, Integer numeroGiocatori) {
      if (PartitaAPaperopoly.INSTANCE == null) {
         // Sincronizzazione per garantire la sicurezza del thread
         synchronized (PartitaAPaperopoly.class) {
            if (PartitaAPaperopoly.INSTANCE == null) {
               PartitaAPaperopoly.INSTANCE = new PartitaAPaperopoly(numeroGiri, numeroGiocatori);
            }
         }
      }
      return PartitaAPaperopoly.INSTANCE;
   }

   private PartitaAPaperopoly(Integer numeroGiri, Integer numeroGiocatori) {
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
   }


   public Integer getNumeroGiri() {
      return this.numeroGiri;
   }

   public void setNumeroGiri(Integer numeroGiri) {
      this.numeroGiri = numeroGiri;
   }

   public void giocaPartita() {
      System.out.println("Inizio della simulazione per " + this.numeroGiri.toString() + " giri e " + this.giocatori.size() + " numero Giocatori:");
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
              ", giocatori = " + this.giocatori.toString() +
              ", tabellone = " + this.tabellone.toString() +
              " }";
   }
}
