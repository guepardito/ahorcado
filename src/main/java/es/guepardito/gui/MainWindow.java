package es.guepardito.gui;

import es.guepardito.gui.custom.GamePanel;
import es.guepardito.gui.custom.ImagePanel;
import es.guepardito.logic.GameController;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static es.guepardito.logic.GameController.*;

public class MainWindow extends JFrame {

    // Constructor de la ventana, solo componentes necesarios
    public MainWindow() {
        // inicializar variables
        iniciarJuego();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, GameController.WIDTH,GameController.HEIGHT);
        setTitle("Ahorcado");

        // inicializar paneles
        ImagePanel leftPanel = new ImagePanel();
        GamePanel rightPanel = new GamePanel();

        // establecer el layout de la ventana como BorderLayout
        setLayout(new GridLayout(1, 2));

        // agregar los paneles a la ventana
        add(leftPanel);
        add(rightPanel);

        // dar color a los paneles
        leftPanel.setBackground(Color.DARK_GRAY);
        rightPanel.setBackground(Color.DARK_GRAY);

        // añadir evento que reconoce el teclado
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!GameController.gameOver) {
                    char letter = Character.toUpperCase(e.getKeyChar());
                    if (Character.isLetter(letter)) {
                        characterList.add(letter);
                        if (GameController.tryChar(letter)) {
                            if (letters == 0) {
                                repaint();
                                JOptionPane.showMessageDialog(MainWindow.this, "¡Ganaste!");
                                restartGame();
                            }
                        } else {
                            HANGED_NUM++;
                            if (HANGED_NUM >= 6) {
                                repaint();
                                JOptionPane.showMessageDialog(MainWindow.this, "¡Perdiste! La palabra era: " + secretWord);
                                restartGame();
                            }
                        }
                        repaint();
                    }
                }
            }
        });

        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void restartGame() {
        iniciarJuego();
        repaint();
    }

    private void iniciarJuego() {
        String userInput = JOptionPane.showInputDialog(MainWindow.this, "Inserte la palabra a adivinar:");
        if (userInput != null && !userInput.isEmpty()) {
            secretWord = userInput.toUpperCase();
            actualWord = new StringBuilder();
            actualWord.append("_".repeat(secretWord.length()));
            characterList.clear();
            HANGED_NUM = 0;
            letters = secretWord.length();
            gameOver = false;
        } else {
            // si el usuario cancela o no ingresa una palabra, salir del juego
            System.exit(0);
        }
    }

}
