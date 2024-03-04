package es.guepardito.gui.custom;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.util.Objects;

import static es.guepardito.logic.GameController.HANGED_NUM;

public class ImagePanel extends JPanel {

    public ImagePanel() {
        super();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/hanged_" + HANGED_NUM + ".png")));
        g.drawImage(img.getImage(), 0, 0, 300, 800, null);
    }
}
