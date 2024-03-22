package View.PrincipaleVueComposant;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class LesFilmsVue extends JPanel {

    public LesFilmsVue(int barre_navigation_panel_width, int frame_height) {
        setBackground(new Color(0, 210, 120));
        setPreferredSize(new Dimension(barre_navigation_panel_width, frame_height));

        // Création du titre
        JLabel titleLabel = new JLabel("Le Lama c'est trop kwelos");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        // Création de la description
        JLabel descriptionLabel = new JLabel("Il était une fois un lama pas comme les autres... il était... très... MOCHE!");
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        // Chargement de l'image
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("lama.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Redimensionnement de l'image
        Image resizedImg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(resizedImg);
        JLabel imageLabel = new JLabel(icon);

        // Création du bouton "Réserver"
        JButton reserveButton = new JButton("Réserver");

        // Création du conteneur pour le titre, l'image et la description
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(3, 1));
        textPanel.add(titleLabel);
        textPanel.add(descriptionLabel);
        textPanel.add(reserveButton);

        // Ajout des éléments au panneau principal
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(imageLabel);
        add(textPanel);
    }
}
