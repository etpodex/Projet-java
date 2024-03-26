package View.Onglets.ReservationVueComposant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaiementEnCoursVue extends JPanel {

    public PaiementEnCoursVue() {
        setBackground(Color.WHITE); // Fond blanc
        setLayout(new BorderLayout()); // Utilisation d'un BorderLayout

        // Message de paiement en cours
        JLabel messageLabel = new JLabel("Nous vérifions vos informations bancaires, merci de patienter !");
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Icône de chargement tournante
        ImageIcon loadingIcon = new ImageIcon("gear.png"); // Assurez-vous d'avoir l'icône "gear.png" dans votre répertoire de travail
        JLabel loadingLabel = new JLabel(loadingIcon);
        loadingLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Animation de rotation de l'icône
        Timer timer = new Timer(100, new ActionListener() {
            double angle = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                angle += Math.PI / 18;
                if (angle >= Math.PI * 2) {
                    angle -= Math.PI * 2;
                }
                loadingLabel.setIcon(new RotatedIcon(loadingIcon, angle));
            }
        });
        timer.start();

        // Ajout des composants à la page de paiement en cours
        add(messageLabel, BorderLayout.NORTH);
        add(loadingLabel, BorderLayout.CENTER);
    }

    // Classe interne pour la rotation de l'icône
    private static class RotatedIcon implements Icon {
        private final Icon icon;
        private final double angle;

        public RotatedIcon(Icon icon, double angle) {
            this.icon = icon;
            this.angle = angle;
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            Graphics2D g2 = (Graphics2D) g.create();
            int width = icon.getIconWidth();
            int height = icon.getIconHeight();
            g2.translate(x + width / 2, y + height / 2);
            g2.rotate(angle);
            icon.paintIcon(c, g2, -width / 2, -height / 2);
            g2.dispose();
        }

        @Override
        public int getIconWidth() {
            return icon.getIconWidth();
        }

        @Override
        public int getIconHeight() {
            return icon.getIconHeight();
        }
    }
}
