package Controller.Evenements;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class FileEvenements {

    private static FileEvenements instance;
    private final List<Consumer<Object>> abonnes = new ArrayList<>();

    private FileEvenements() {}

    public static FileEvenements getInstance() {
        if (instance == null) {
            instance = new FileEvenements();
        }
        return instance;
    }

    public void abonner(Consumer<Object> abonne) {
        abonnes.add(abonne);
    }

    public void publier(Object objet) {
        abonnes.forEach(abonne -> abonne.accept(objet));
    }
}
