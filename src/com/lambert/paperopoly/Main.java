package com.lambert.paperopoly;

import com.lambert.paperopoly.ui.swing.PaperopolyGameUI;

import javax.swing.*;
/*
un tabellone con 9 caselle, disposte su una griglia 3x3, con una scala dalla casella 2 alla 5 ed un serpente
dalla casella 8 alla 4;
o un giocatore Alice che gioca con un segnalino rosso e si trova nella casella 3;
o un giocatore Bob che gioca con un segnalino verde e si trova nella casella 5;
o un giocatore Carlo che gioca con un segnalino blu e non ha ancora mai tirato i dadi.
*  */
public class Main {
   public static void main(String[] args) {
      SwingUtilities.invokeLater(PaperopolyGameUI::new);
   }
}
