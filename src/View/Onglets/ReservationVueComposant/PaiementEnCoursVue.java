package View.Onglets.ReservationVueComposant;

import Controller.Evenements.AffichageOnglet.AffAccueilEvenement;
import Controller.Evenements.FileEvenements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Panneau affichant l'état en cours du paiement avec une animation de chargement.
 * Une fois le paiement terminé, affiche un message de confirmation avec un bouton pour retourner à l'accueil.
 */
public class PaiementEnCoursVue extends JPanel {
    private JButton accueilButton; // Bouton pour retourner à l'accueil
    private ImageIcon chargement_icon; // Icône de chargement
    private JLabel chargement_label; // Label pour afficher l'icône de chargement
    private Timer timer; // Timer pour l'animation de chargement

    /**
     * Constructeur de la classe PaiementEnCoursVue.
     */
    public PaiementEnCoursVue() {
        setBackground(new Color(238, 238, 238));
        setLayout(new BorderLayout());
        initUI(); // Initialise l'interface utilisateur
    }

    /**
     * Initialise les composants de l'interface utilisateur.
     */
    private void initUI() {
        // Initialise ou réinitialise les éléments de l'interface utilisateur
        removeEverything(); // Supprime tous les composants existants

        chargement_icon = new ImageIcon("gear.png"); // Assurez-vous que le chemin de l'icône est correct
        chargement_label = new JLabel(chargement_icon); // Crée un label avec l'icône de chargement
        chargement_label.setHorizontalAlignment(SwingConstants.CENTER); // Centre l'icône horizontalement

        JLabel message_label = new JLabel("Nous vérifions vos informations bancaires, merci de patienter !");
        message_label.setHorizontalAlignment(SwingConstants.CENTER); // Centre le message horizontalement

        add(message_label, BorderLayout.NORTH); // Ajoute le message en haut
        add(chargement_label, BorderLayout.CENTER); // Ajoute l'icône de chargement au centre
    }

    /**
     * Supprime tous les composants du panneau.
     */
    private void removeEverything() {
        removeAll(); // Supprime tous les composants
        if (timer != null) {
            timer.stop(); // Arrête le timer existant
        }
    }

    /**
     * Démarre l'animation de chargement du paiement.
     */
    public void startPaiementTimer() {
        removeEverything(); // Supprime tous les composants existants
        initUI(); // Réinitialise les composants de l'interface utilisateur

        timer = new Timer(100, new ActionListener() {
            double angle = 0;
            int count = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                angle += Math.PI / 18; // Incrémente l'angle pour la rotation
                if (angle >= Math.PI * 2) {
                    angle -= Math.PI * 2; // Réinitialise l'angle après une rotation complète
                }
                chargement_label.setIcon(new RotatedIcon(chargement_icon, angle)); // Applique la rotation à l'icône
                count++;
                if (count >= 20) {
                    timer.stop(); // Arrête le timer lorsque le compteur atteint 20
                    clearAndDisplayMessage(); // Affiche le message final
                }
            }
        });
        timer.start(); // Démarre le timer
    }

    /**
     * Affiche un message de confirmation une fois le paiement terminé.
     */
    private void clearAndDisplayMessage() {
        removeAll(); // Efface le panneau avant d'ajouter le message de confirmation

        JLabel newMessageLabel = new JLabel("Le paiement a bien été effectué, retrouvez votre e-billet par e-mail.");
        newMessageLabel.setHorizontalAlignment(SwingConstants.CENTER); // Centre le message horizontalement
        add(newMessageLabel, BorderLayout.CENTER); // Ajoute le message au centre

        // Crée le bouton pour retourner à l'accueil
        accueilButton = new JButton("Retour à l'accueil");
        accueilButton.addActionListener(e -> {
            FileEvenements.getInstance().publier(new AffAccueilEvenement());
        });
        add(accueilButton, BorderLayout.SOUTH); // Ajoute le bouton en bas

        revalidate(); // Revalide le panneau pour mettre à jour l'affichage
        repaint(); // Redessine le panneau
    }

    /**
     * Classe interne pour l'icône rotative.
     */
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
            g2.translate(x + width / 2, y + height / 2); // Translate pour placer le centre de l'icône au bon endroit
            g2.rotate(angle); // Rotation de l'icône
            icon.paintIcon(c, g2, -width / 2, -height / 2); // Peint l'icône après rotation
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
