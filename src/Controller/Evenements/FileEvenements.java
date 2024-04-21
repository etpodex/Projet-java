package Controller.Evenements;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Cette classe représente un système de file d'attente pour les événements.
 * Les abonnés peuvent s'inscrire pour recevoir des événements et être notifiés lorsqu'un événement est publié.
 */
public class FileEvenements {

    private static FileEvenements instance;
    private final List<Consumer<Object>> abonnes = new ArrayList<>();

    // Constructeur privé pour empêcher l'instanciation directe depuis l'extérieur de la classe.
    private FileEvenements() {}

    /**
     * Obtient l'instance unique de la classe FileEvenements (singleton).
     *
     * @return L'instance unique de FileEvenements.
     */
    public static FileEvenements getInstance() {
        if (instance == null) {
            instance = new FileEvenements();
        }
        return instance;
    }

    /**
     * Permet à un abonné de s'inscrire pour recevoir des événements.
     *
     * @param abonne Le consommateur (abonné) qui recevra les événements.
     */
    public void abonner(Consumer<Object> abonne) {
        abonnes.add(abonne);
    }

    /**
     * Publie un événement à tous les abonnés enregistrés.
     *
     * @param objet L'objet représentant l'événement à publier.
     */
    public void publier(Object objet) {
        abonnes.forEach(abonne -> abonne.accept(objet));
    }
}
