import javax.swing.*;
import Controller.VueControleur;

public class
Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VueControleur();
            }
        });
    }
}
