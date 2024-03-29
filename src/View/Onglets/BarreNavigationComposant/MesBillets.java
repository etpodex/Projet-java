package View.Onglets.BarreNavigationComposant;

/**BIBLIOTHEQUE**/

import Controller.Evenements.Affichage.AffMesBilletsEvenement;
import Controller.Evenements.FileEvenements;
import View.Onglets.BarreNavigation;

import javax.swing.*;
import java.awt.*;


public class MesBillets extends JButton{

    public MesBillets(BarreNavigation barre_navigation){
        setBackground(Color.WHITE);
        setForeground(Color.GRAY);
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        setFocusPainted(false);
        setText("Mes Billets");

        addActionListener(e -> {
            FileEvenements.getInstance().publier(new AffMesBilletsEvenement());
        });
    }

}
