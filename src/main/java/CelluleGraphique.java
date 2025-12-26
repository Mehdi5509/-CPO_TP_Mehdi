import javax.swing.*;
import java.awt.*;

public class CelluleGraphique extends JButton {
    CelluleLumineuse celluleAssociee;

    public CelluleGraphique(CelluleLumineuse uneCellule) {
        this.celluleAssociee = uneCellule;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = this.getWidth();
        int h = this.getHeight();

        if (celluleAssociee.getEtat()) {
            g.setColor(Color.YELLOW);
        } else {
            g.setColor(Color.DARK_GRAY);
        }
        g.fillOval(4, 4, w - 8, h - 8);
    }
}