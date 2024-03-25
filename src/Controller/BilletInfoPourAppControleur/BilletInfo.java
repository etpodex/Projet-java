package Controller.BilletInfoPourAppControleur;

public class BilletInfo {
    private final String titre_film_billet;
    private final String data_film_billet;
    private final String data_horaire_billet;
    private final int data_salle_billet;
    private final String data_siege_billet;
    private final int nbre_de_billet_acheter;
    private final int nbre_de_billet_adulte;
    private final int nbre_de_billet_enfant;
    private final int nbre_de_billet_senior;
    private final String qrcode_billet;

    public BilletInfo(String titreFilm, String dateFilm, String horaire, int salle, String siege, int nbBilletsAcheter, int nbBilletsAdulte, int nbBilletsEnfant, int nbBilletsSenior, String qrcode) {
        this.titre_film_billet = titreFilm;
        this.data_film_billet = dateFilm;
        this.data_horaire_billet = horaire;
        this.data_salle_billet = salle;
        this.data_siege_billet = siege;
        this.nbre_de_billet_acheter = nbBilletsAcheter;
        this.nbre_de_billet_adulte = nbBilletsAdulte;
        this.nbre_de_billet_enfant = nbBilletsEnfant;
        this.nbre_de_billet_senior = nbBilletsSenior;
        this.qrcode_billet = qrcode;
    }

    public String getTitreFilm() {
        return titre_film_billet;
    }

    public String getDateFilm() {
        return data_film_billet;
    }

    public String getHoraire() {
        return data_horaire_billet;
    }

    public int getSalle() {
        return data_salle_billet;
    }

    public String getSiege() {
        return data_siege_billet;
    }

    public int getNbBilletsAcheter() {
        return nbre_de_billet_acheter;
    }

    public int getNbBilletsAdulte() {
        return nbre_de_billet_adulte;
    }

    public int getNbBilletsEnfant() {
        return nbre_de_billet_enfant;
    }

    public int getNbBilletsSenior() {
        return nbre_de_billet_senior;
    }

    public String getQrcode() {
        return qrcode_billet;
    }
}

