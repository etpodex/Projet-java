package View.Onglets.BarreNavigationComposant;

import Controller.Evenements.AffichageOnglet.AffAccueilEvenement;
import Controller.Evenements.DeconnexionEvenement;
import Controller.Evenements.FileEvenements;

import javax.swing.*;
import java.awt.*;

public class Deconnexion extends JButton {

    public Deconnexion(){
        setBackground(Color.WHITE);
        setForeground(Color.GRAY);
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        setFocusPainted(false);
        setText("Se Déconnecter");

        addActionListener(e -> {
            FileEvenements.getInstance().publier(new DeconnexionEvenement());
        });
    }
}