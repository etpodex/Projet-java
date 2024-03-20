import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controleur {
    /**ATTRIBUTS**/
    private Vue vue;
    private Modele modele;

    /**CONSTRUCTEUR**/
    public Controleur(Vue vue, Modele modele) {
        //initialisation de vue et modele
        this.vue = vue;
        this.modele = modele;

        //On donne les images et titre du modele à la vue
        // Ajout des données du modèle à la vue
        vue.afficherFilms(modele.getTitresFilms(), modele.getAffichesFilms());


        //Listener --> evenement bouton inscription dans onglet connexion
        vue.inscriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // ---> attribut pour recuperer les infos d'inscription de la vue pour plus tard les envoyer au modèle
                String email = vue.getEmail();
                String password = vue.getPassword();

                // ---> Suite du code (par ex methode pour gerer inscription avec info recup)

                // affichage de la nouvelle fenetre
                vue.afficherNouvelleFenetre();
            }
        });

        //Listener --> evenement bouton connexion dans onglet connexion
        vue.connexionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ---> attribut pour recuperer les infos d'inscription de la vue pour plus tard les envoyer au modèle
                String email = vue.getEmail();
                String password = vue.getPassword();

                // ---> Suite du code (par ex verif que l'email et le mdp existe)
                // ---> Suite du code (par ex methode du modele pour gerener connexion + recup info de la database)

                // affichage de la nouvelle fenetre
                vue.afficherNouvelleFenetre();
            }
        });
    }


    /**MAIN**/

    // Méthode pour démarrer l'application
    public void demarrer() {
        // Vous pouvez mettre ici des initialisations ou d'autres actions nécessaires pour démarrer l'application
    }

    // Méthode main pour démarrer l'application
    public static void main(String[] args) {
        Vue vue = new Vue();
        Modele modele = new Modele();
        Controleur controleur = new Controleur(vue, modele);
        controleur.demarrer();
    }
}
