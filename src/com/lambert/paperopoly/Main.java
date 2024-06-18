package com.lambert.paperopoly;

import com.lambert.paperopoly.ui.swing.PaperopolyGameUI;

import javax.swing.*;

public class Main {
   public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> new PaperopolyGameUI());
   }
}
