package View;

import View.CIComposant.*;
import javax.swing.*;
import java.awt.*;

public class CIVue {
    /**ATTRIBUT**/

    //Bouton

    public static void creationCIPanel(JFrame frame, int frame_width, int frame_height, int choix){
        JPanel CIPanel = new JPanel();

        //structure
        int header_panel_height = (int) (frame_height * 0.1);
        int mid_panel_height = (int) (frame_height * 0.8);
        int footer_panel_height = (int) (frame_height * 0.1);

        //création des panels
        Header header_panel = new Header(frame_width, header_panel_height);
        Connexion connexion_panel = new Connexion(frame_width, mid_panel_height);
        //Inscription inscription_panel = new Inscription(frame_width, mid_panel_height);
        Footer footer_panel = new Footer(frame_width, footer_panel_height);

        if(choix == 1){
            CIPanel.setLayout(new BorderLayout());
            CIPanel.add(header_panel, BorderLayout.NORTH);
            CIPanel.add(connexion_panel, BorderLayout.CENTER);
            CIPanel.add(footer_panel, BorderLayout. SOUTH);

            frame.getContentPane().add(CIPanel);
        }
        else if(choix == 2){
            CIPanel.setLayout(new BoxLayout(CIPanel, BoxLayout.Y_AXIS));
            CIPanel.add(header_panel);
            //CIPanel.add(inscription_panel);
            CIPanel.add(footer_panel);

            frame.getContentPane().add(CIPanel);
        }
    }
}


