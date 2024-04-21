package View.Onglets.BarreNavigationComposant;

import javax.swing.*;

/**
 * Le panneau Compte représente l'onglet de gestion du compte dans la barre de navigation.
 */
public class Compte extends JPanel {

    /**
     * Constructeur de la classe Compte.
     */
    public Compte(){
        setBackground(new java.awt.Color(0, 0, 255)); // Définit la couleur de fond en bleu

        // Revalide la mise en page + Redessine le panneau
        revalidate();
        repaint();
    }
}
