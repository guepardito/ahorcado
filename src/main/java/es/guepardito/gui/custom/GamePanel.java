package es.guepardito.gui.custom;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.RenderingHints;

import static es.guepardito.logic.GameController.*;

public class GamePanel extends JPanel {

    public GamePanel() {
        super();
        setLayout(new GridLayout(2, 3));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.PLAIN, 24));
        g2d.drawString("Intentos: " + HANGED_NUM, 10, 290);
        g2d.drawString("Palabra: " + actualWord.toString(), 10, 320);
        g2d.drawString(characterList.toString(), 10, 350);
    }
}