package View.Onglets.MonCompteComposant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Footer extends JPanel {
    private JButton boutonModifier;
    private JButton boutonValider;

    public Footer() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        boutonModifier = new JButton("Modifier");
        boutonModifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remplacer le bouton "Modifier" par le bouton "Valider"
                remove(boutonModifier);
                add(boutonValider, BorderLayout.EAST);
                revalidate();
                repaint();
            }
        });

        boutonValider = new JButton("Valider");
        boutonValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remplacer le bouton "Valider" par le bouton "Modifier"
                remove(boutonValider);
                add(boutonModifier, BorderLayout.EAST);
                revalidate();
                repaint();
            }
        });

        // Par défaut, afficher le bouton "Modifier"
        add(boutonModifier, BorderLayout.EAST);
    }

    public void addModifierListener(ActionListener listener) {
        boutonModifier.addActionListener(listener);
    }

    public void addValiderListener(ActionListener listener) {
        boutonValider.addActionListener(listener);
    }
}
