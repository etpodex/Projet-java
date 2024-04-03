package View.Onglets.BarreNavigationComposant;

import Controller.Evenements.AffichageOnglet.AffGererOffreEvenement;
import Controller.Evenements.FileEvenements;
import View.Onglets.BarreNavigation;

import javax.swing.*;
import java.awt.*;

public class GererOffre extends JButton {

    public GererOffre (){
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
