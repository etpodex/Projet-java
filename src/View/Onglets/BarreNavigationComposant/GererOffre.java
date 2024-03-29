package View.Onglets.BarreNavigationComposant;

import Controller.Evenements.Affichage.AffGererOffreEvenement;
import Controller.Evenements.FileEvenements;
import View.Onglets.BarreNavigation;

import javax.swing.*;
import java.awt.*;

public class GererOffre extends JButton {

    public GererOffre (BarreNavigation barre_navigation){
        setBackground(Color.WHITE);
        setForeground(Color.GRAY);
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        setFocusPainted(false);
        setText("Gerer Offre");

        addActionListener(e -> {
            FileEvenements.getInstance().publier(new AffGererOffreEvenement());
        });
    }
}
