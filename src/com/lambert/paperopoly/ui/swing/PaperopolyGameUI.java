package com.lambert.paperopoly.ui.swing;

import com.lambert.paperopoly.domain.PartitaAPaperopoly;
import com.lambert.paperopoly.technicalservices.PropertiesReader;

import javax.swing.*;
import java.awt.*;

public class PaperopolyGameUI {

   private PartitaAPaperopoly partitaAPaperopoly;

   public PaperopolyGameUI() {
      JFrame frame = new JFrame("PaperopolyGame");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(300, 200);

      // Creiamo un colore di sfondo chiaro
      Color lightBackground = new Color(115, 207, 224); // RGB

      // Panel per contenere tutti i componenti con GridBagLayout per il centrare
      JPanel panel = new JPanel(new GridBagLayout());
      panel.setBackground(lightBackground); // Impostiamo il colore di sfondo chiaro

      // Etichetta titolo centrata in alto
      JLabel titleLabel = new JLabel("PaperopolyGame", JLabel.CENTER);
      titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.gridwidth = 2;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.anchor = GridBagConstraints.NORTH;
      gbc.insets = new Insets(25, 10, 10, 10); // Margine inferiore
      panel.add(titleLabel, gbc);

      // Pannello per contenere i campi input
      JPanel inputPanel = new JPanel(new GridBagLayout());
      inputPanel.setBackground(lightBackground); // Impostiamo il colore di sfondo chiaro
      gbc.gridy = 1;
      gbc.insets = new Insets(4, 10, 5, 10); // Margine inferiore per i campi input

      // Etichetta e campo input per "# giri"
      JLabel giriLabel = new JLabel("  # giri:");
      JTextField giriField = new JTextField(8);
      gbc.gridx = -1;
      gbc.gridy = 0;
      inputPanel.add(giriLabel, gbc);
      gbc.gridx = 1;
      inputPanel.add(giriField, gbc);

      // Etichetta e campo input per "# giocatori"
      JLabel giocatoriLabel = new JLabel("  # Giocatori:");
      JTextField giocatoriField = new JTextField(8);
      gbc.gridx = 0;
      gbc.gridy = 1; // Modifica la riga per il secondo campo
      inputPanel.add(giocatoriLabel, gbc);
      gbc.gridx = 1;
      inputPanel.add(giocatoriField, gbc);

      // Aggiungiamo il pannello dei campi input al pannello principale
      gbc.gridy = 2; // Modifica la riga per il pannello dei campi input
      panel.add(inputPanel, gbc);

      // Bottone "Inizia partita"
      JButton startButton = new JButton("Inizia partita");
      startButton.setForeground(Color.WHITE);
      startButton.setBackground(Color.BLUE);
      startButton.setFocusPainted(false); // Rimuove il bordo di focus attorno al bottone
      gbc.gridy = 3;
      gbc.gridx = 0;
      gbc.gridwidth = 2;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      gbc.insets = new Insets(10, 10, 20, 10); // Margine per il bottone
      panel.add(startButton, gbc);

      startButton.addActionListener(event -> {
         try {
            Integer numeroGiri = Integer.parseInt(giriField.getText());
            Integer numeroGiocatori = Integer.parseInt(giocatoriField.getText());
            this.partitaAPaperopoly = new PartitaAPaperopoly(numeroGiri, numeroGiocatori);
            this.partitaAPaperopoly.giocaPartita();
         } catch (NumberFormatException numberFormatException) {
            System.err.println(numberFormatException.getMessage());
         }
      });

      // Aggiungiamo il pannello principale al frame
      frame.add(panel);

      // Centriamo la finestra al centro dello schermo
      frame.setLocationRelativeTo(null);

      // Mostra la finestra
      frame.setVisible(true);
   }
}
