package circledraw;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;

/**
 * Exercice : faire en sorte de dessiner un cercle à la position de la souris a chaque clic souris
 *
 * @author bastide
 */
public class CircleDrawPanel extends JPanel {

    final private List<Point> points = new LinkedList<>();

    public CircleDrawPanel() {
        super();
        this.setPreferredSize(new Dimension(250, 100));
        // Ajoute le listenerau composant
        this.addMouseListener(
                new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Ajouter un point à la liste
                points.add(e.getPoint());
                // Demander un refresh
                repaint();
            }
        }
        );
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Hello", 20, 20);
        // Redessiner tous les points
        points.forEach(p -> {
            drawCircleAt(g, p);
        });
    }

    /**
     * Cette méthode dessine un cercle de 10px au point spécifie
     *
     * @param g le contexte graphique
     * @param p le coin superieur gauche du cercle
     */
    public void drawCircleAt(Graphics g, Point p) {
        g.drawOval(p.x, p.y, 10, 10);
    }
}
