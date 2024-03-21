package View.PrincipaleVueComposant.BarreNavigationComposant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LesFilms extends JButton{

    public LesFilms (){
        setBackground(Color.WHITE);
        setForeground(Color.GRAY);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        setFocusPainted(false);
        setText("Les Films");
    }
}
