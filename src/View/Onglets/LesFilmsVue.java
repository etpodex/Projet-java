package View.Onglets;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.net.URL;

public class LesFilmsVue extends JPanel {

    private int nombre_film = 3;
    private String[] titre_film = {"Lama", "Chien", "Fleur"};
    private String[] description_film = {"Lamasticot", "CHIEN OUAF OUAF le chien et paf le chien aussi", "je suis une fleur, je suis une tres jolie fleur, je suis plus belle qu'une rose et sens meilleur qu'un lila, qui suis je ? je suis toi ? tu es une fleur. Tu es une tres jolie fleur, ..."};
    private String[] image_URL_film = {"https://www.fredzone.org/wp-content/uploads/2022/08/wakfu-photo-1180110-1536x864.png", "url_image2", "url_image3"};
    private JPanel[] filmPanels = new JPanel[nombre_film];

    public LesFilmsVue(int barre_navigation_panel_width, int frame_height) {
        setBackground(new Color(0, 210, 120));
        setPreferredSize(new Dimension(barre_navigation_panel_width, frame_height));

        // Création du panneau principal
        setLayout(new GridLayout(nombre_film, 1)); // Utilisation d'un layout de grille pour empiler les films

        // Création dynamique des sous-panneaux pour chaque film
        for (int i = 0; i < nombre_film; i++) {
            filmPanels[i] = createFilmPanel(titre_film[i], description_film[i], image_URL_film[i]);
            add(filmPanels[i]); // Ajout du sous-panneau au panneau principal
        }
    }

    // Méthode pour créer un sous-panneau pour un film donné
    private JPanel createFilmPanel(String titre, String description, String imageURL) {
        // Création des composants pour le sous-panneau
        JLabel titleLabel = new JLabel(titre);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Réduction de la taille de la police

        JLabel descriptionLabel = new JLabel(description);
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 12)); // Réduction de la taille de la police

        JLabel imageLabel = new JLabel();
        try {
            URL url = new URL(imageURL);
            BufferedImage img = ImageIO.read(url);
            if (img != null) {
                int imageSize = Math.min(150, LesFilmsVue.this.getWidth() / 3); // Taille maximale de l'image basée sur la largeur de LesFilmsVue
                Image resizedImg = img.getScaledInstance(imageSize, imageSize, Image.SCALE_SMOOTH); // Réduction de la taille de l'image
                ImageIcon icon = new ImageIcon(resizedImg);
                imageLabel.setIcon(icon);
            } else {
                System.out.println("L'image à l'URL suivante est null : " + imageURL);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        JButton reserveButton = new JButton("Réserver");

        // Création du sous-panneau pour le film
        JPanel filmPanel = new JPanel();
        filmPanel.setBackground(new Color(224, 224, 255)); // Bleu pastel
        filmPanel.setLayout(new BorderLayout());

        // Calcul du padding en fonction de la taille du panel LesFilmsVue
        int padding = Math.max(5, LesFilmsVue.this.getWidth() / 20); // 5 pixels minimum, ajusté selon la largeur de LesFilmsVue
        filmPanel.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding)); // Padding dynamique

        // Ajout des composants au sous-panneau
        filmPanel.add(imageLabel, BorderLayout.WEST);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(2, 1));
        textPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 5)); // Marge supérieure ajustée
        textPanel.add(titleLabel);
        textPanel.add(descriptionLabel);
        filmPanel.add(textPanel, BorderLayout.CENTER);

        filmPanel.add(reserveButton, BorderLayout.SOUTH);

        return filmPanel;
    }




}
