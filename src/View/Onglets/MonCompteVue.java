package View.Onglets;

import View.Onglets.MonCompteComposant.*;
import javax.swing.*;
import java.awt.*;

public class MonCompteVue extends JPanel {

    private JScrollPane information_utilisateurs_scroll_panel;
    private JScrollPane modification_information_utilisateur_scroll_panel;
    private Footer footer_panel;

    public MonCompteVue(int barre_navigation_panel_width, int frame_height) {
        setBackground(new Color(194, 156, 255));
        setLayout(new BorderLayout());

        // Création des panels
        InformationUtilisateurs information_utilisateurs_panel = new InformationUtilisateurs();
        ModificationInformationUtilisateur modification_information_utilisateur_panel = new ModificationInformationUtilisateur();

        // Création des JScrollPane pour chaque panel
        information_utilisateurs_scroll_panel = new JScrollPane(information_utilisateurs_panel);
        modification_information_utilisateur_scroll_panel = new JScrollPane(modification_information_utilisateur_panel);

        // Ajout du JScrollPane d'informations utilisateurs au centre de MonCompteVue par défaut
        add(information_utilisateurs_scroll_panel, BorderLayout.CENTER);

        // Création du footer
        footer_panel = new Footer();

        // Ajout du footer en bas de MonCompteVue
        add(footer_panel, BorderLayout.SOUTH);

        // Ajout des listeners du footer pour changer la vue
        footer_panel.addModifierListener(e -> {
            switchView("MODIFICATION_INFO_UTILISATEUR");
        });
        footer_panel.addValiderListener(e -> {
            switchView("INFO_UTILISATEURS");
        });
    }

    // Méthode pour changer la vue en fonction du nom du panel
    private void switchView(String viewName) {
        switch (viewName) {
            case "MODIFICATION_INFO_UTILISATEUR":
                remove(information_utilisateurs_scroll_panel);
                add(modification_information_utilisateur_scroll_panel, BorderLayout.CENTER);
                break;
            case "INFO_UTILISATEURS":
                remove(modification_information_utilisateur_scroll_panel);
                add(information_utilisateurs_scroll_panel, BorderLayout.CENTER);
                break;
            default:
                break;
        }
        revalidate();
        repaint();
    }
}
