package View.PrincipaleVueComposant;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LesFilmsVue extends JPanel {
    private Image image;

    public LesFilmsVue(int barre_navigation_panel_width, int frame_height){
        setBackground(new Color(0, 210, 120));
        setPreferredSize(new Dimension(barre_navigation_panel_width,frame_height));

        // Charger l'image
        try {
            // Chemin vers l'image "lama.jpg"
            String imagePath = "lama.jpg";
            // Charger l'image depuis le fichier
            image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dessiner l'image
        if (image != null) {
            // Dessiner l'image au centre du panneau
            int x = (getWidth() - image.getWidth(this)) / 2;
            int y = (getHeight() - image.getHeight(this)) / 2;
            g.drawImage(image, x, y, this);
        }
        // Dessiner le titre
        String title = "le lama c'est trop kwelos";
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        FontMetrics metrics = g.getFontMetrics();
        int titleWidth = metrics.stringWidth(title);
        int titleX = (getWidth() - titleWidth) / 2;
        int titleY = 30; // Position en Y arbitraire
        g.drawString(title, titleX, titleY);
    }
}
