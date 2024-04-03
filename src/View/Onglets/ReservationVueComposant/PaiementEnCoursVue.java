package View.Onglets.ReservationVueComposant;

import Controller.Evenements.AffichageOnglet.AffAccueilEvenement;
import Controller.Evenements.FileEvenements;
import View.MasterVue;
import View.Onglets.AccueilVue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaiementEnCoursVue extends JPanel {
    ;
    private JButton accueilButton; // Déclaration du bouton en tant que variable membre pour y accéder ultérieurement

    private ImageIcon chargement_icon;
    private JLabel chargement_label;

    public PaiementEnCoursVue() {

        setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        JLabel message_label = new JLabel("Nous vérifions vos informations bancaires, merci de patienter !");
        message_label.setHorizontalAlignment(SwingConstants.CENTER);

        chargement_icon = new ImageIcon("gear.png");
        chargement_label = new JLabel(chargement_icon);

        chargement_label.setHorizontalAlignment(SwingConstants.CENTER);

        add(message_label, BorderLayout.NORTH);
        add(chargement_label, BorderLayout.CENTER);
    }

    public void startPaiementTimer() {
        Timer timer = new Timer(100, new ActionListener() {
            double angle = 0;
            int count = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                angle += Math.PI / 18;
                if (angle >= Math.PI * 2) {
                    angle -= Math.PI * 2;
                }
                chargement_label.setIcon(new RotatedIcon(chargement_icon, angle));
                count++;
                if (count >= 20) {
                    ((Timer) e.getSource()).stop();
                    clearAndDisplayMessage();
                }
            }
        });
        timer.start();
    }

    private void clearAndDisplayMessage() {
        removeAll(); // Supprime tous les composants actuels de cette page

        // Affiche le message de confirmation de paiement
        JLabel newMessageLabel = new JLabel("Le paiement a bien été effectué, retrouvez votre e-billet par e-mail.");
        newMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(newMessageLabel, BorderLayout.CENTER);

        // Crée le bouton de retour à l'accueil
        accueilButton = new JButton("Retour à l'accueil");
        accueilButton.addActionListener(e -> {
            FileEvenements.getInstance().publier(new AffAccueilEvenement());
        });


        add(accueilButton, BorderLayout.SOUTH);

        // Valide les changements et redessine la fenêtre
        revalidate();
        repaint();
    }

    // Classe interne pour gérer la rotation de l'icône de chargement
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
