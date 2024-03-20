/**BIBLIOTHEQUE**/
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.List;

public class Modele {

    /**ATTRIBUTS**/

    //pour onglets les films
    private List<String> titresFilms;
    private List<ImageIcon> affichesFilms;

    /**CONSTRUCTEUR**/

    public Modele() {
        // ---> Faire avec la database
        // Initialisation des données temporaire en attendant la database
        titresFilms = new ArrayList<>();
        titresFilms.add("Dans la vie d'un lama");
        titresFilms.add("Dune 2");

        affichesFilms = new ArrayList<>();
        affichesFilms.add(new ImageIcon("lama.jpg"));
        affichesFilms.add(new ImageIcon("Dune2_affiche.jpg"));
    }

    /**METHODES**/

    //methode pour envoyer la liste des titres
    public List<String> getTitresFilms() {
        return titresFilms;
    }
    //methode pour envoyer la liste des affiches
    public List<ImageIcon> getAffichesFilms() {
        return affichesFilms;
    }
}
