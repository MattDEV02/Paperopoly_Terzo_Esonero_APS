package com.lambert.paperopoly.domain;

import com.lambert.paperopoly.domain.casella.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class Tabellone {
   private static final Integer SIZE = 32;
   private List<Casella> caselle;

   public Tabellone(Bussolotto bussolotto) {
      this.caselle = new ArrayList<Casella>(Tabellone.SIZE);
      this.costruisciCaselle(bussolotto);
   }

   public List<Casella> getCaselle() {
      return this.caselle;
   }

   public void setCaselle(List<Casella> caselle) {
      this.caselle = caselle;
   }

   public void costruisciCaselle(Bussolotto bussolotto) {
      /*
      for(Integer i = 0; i < Tabellone.SIZE; i++) {
         Casella casella = null;
         this.caselle.add(casella);
      }*/
      this.caselle.add(new CasellaDelVia("Casella del Via", 0));
      this.caselle.add(new CasellaSostaLibera("Casella Sosta Libera", 1));
      this.caselle.add(new CasellaConIPersonaggi("Casella con i Personaggi", 2));
      this.caselle.add(new CasellaSostaLibera("Casella Sosta Libera", 3));
      this.caselle.add(new CasellaConIPersonaggi("Casella con i Personaggi", 4));
      this.caselle.add(new CasellaSostaLibera("Casella Sosta Libera", 5));
      this.caselle.add(new CasellaDeiDadi("Casella dei Dadi", 6));
      this.caselle.add(new CasellaSostaLibera("Casella Sosta Libera", 7));
      this.caselle.add(new CasellaDeiDollari("Casella dei Dollari", 8, 50.0F, bussolotto));
      this.caselle.add(new CasellaConIPersonaggi("Casella con i Personaggi", 9));
      this.caselle.add(new CasellaDelGranchio("Casella del Granchio", 10, this.getPrimaCasella()));
      this.caselle.add(new CasellaSostaLibera("Casella Sosta Libera", 11));
      this.caselle.add(new CasellaConIBassotti("Casella dei Bassotti", 12));
      this.caselle.add(new CasellaConIPersonaggi("Casella con i Personaggi", 13));
      this.caselle.add(new CasellaDeiDadi("Casella Sosta Libera", 14));
      this.caselle.add(new CasellaSostaLibera("Casella Sosta Libera", 15));
      this.caselle.add(new CasellaDeiDollari("Casella dei Dollari", 16, 100.0F, bussolotto));
      this.caselle.add(new CasellaSostaLibera("Casella Sosta Libera", 17));
      this.caselle.add(new CasellaDeiDadi("Casella dei Dadi", 18));
      this.caselle.add(new CasellaConIPersonaggi("Casella con i Personaggi", 19));
      this.caselle.add(new CasellaSostaLibera("Casella Sosta Libera", 20));
      this.caselle.add(new CasellaConIPersonaggi("Casella con i Personaggi", 21));
      this.caselle.add(new CasellaSostaLibera("Casella Sosta Libera", 22));
      this.caselle.add(new CasellaConIPersonaggi("Casella con i Personaggi", 23));
      this.caselle.add(new CasellaDeiDollari("Casella dei Dollari", 24, 150.0F, bussolotto));
      this.caselle.add(new CasellaSostaLibera("Casella Sosta Libera", 25));
      this.caselle.add(new CasellaConIPersonaggi("Casella con i Personaggi", 26));
      this.caselle.add(new CasellaSostaLibera("Casella Sosta Libera", 27));
      this.caselle.add(new CasellaConIPersonaggi("Casella con i Personaggi", 28));
      this.caselle.add(new CasellaDeiDadi("Casella dei Dadi", 29));
      this.caselle.add(new CasellaSostaLibera("Casella Sosta Libera", 30));
      this.caselle.add(new CasellaConIPersonaggi("Casella con i Personaggi", 31));
   }

   public Casella getPrimaCasella() {
      return this.caselle.get(0);
   }

   public Casella getNuovaCasella(@NotNull Casella casella, Integer distanza) {
      Integer indiceCasella = casella.getIndice();
      Integer indiceNuovaCasella = (Math.abs(indiceCasella + distanza)) % Tabellone.SIZE;
      return this.caselle.get(indiceNuovaCasella);
   }

   @Override
   public String toString() {
      return "Tabellone: {" +
              " caselle = " + this.caselle.toString() +
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
      Tabellone that = (Tabellone) object;
      return Objects.equals(this.caselle, that.getCaselle());
   }

   @Override
   public int hashCode() {
      return Objects.hashCode(caselle);
   }
}
