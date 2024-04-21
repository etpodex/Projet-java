package Model;

public class Billet {

    // Attributs
    private String titreFilm;
    private String dateSeance;
    private String heureSeance;
    private String salleBillet;
    private String siegeBillet;
    private int nombreBilletAdulte;
    private int nombreBilletEnfant;
    private int nombreBilletSenior;
    private String mailClient;
    private String urlImageFilm;

    // Constructeur par défaut
    public Billet() {
    }

    // Constructeur avec tous les paramètres
    public Billet(String titreFilm, String dateSeance, String heureSeance, String salleBillet,String siegeBillet,
                  int nombreBilletAdulte, int nombreBilletEnfant, int nombreBilletSenior,
                  String mailClient, String urlImageFilm) {
        this.titreFilm = titreFilm;
        this.dateSeance = dateSeance;
        this.heureSeance = heureSeance;
        this.salleBillet = salleBillet;
        this.siegeBillet = siegeBillet;
        this.nombreBilletAdulte = nombreBilletAdulte;
        this.nombreBilletEnfant = nombreBilletEnfant;
        this.nombreBilletSenior = nombreBilletSenior;
        this.mailClient = mailClient;
        this.urlImageFilm = urlImageFilm;
    }

    // Getters
    public String getTitreFilm() {
        return titreFilm;
    }

    public String getDateSeance() {
        return dateSeance;
    }

    public String getHeureSeance() {
        return heureSeance;
    }

    public String getSalleBillet() {
        return salleBillet;
    }

    public String getSiegeBillet(){
        return siegeBillet;
    }


    public int getNombreBilletAdulte() {
        return nombreBilletAdulte;
    }

    public int getNombreBilletEnfant() {
        return nombreBilletEnfant;
    }

    public int getNombreBilletSenior() {
        return nombreBilletSenior;
    }

    public String getMailClient() {return mailClient;}

    public String getUrlImageFilm() {
        return urlImageFilm;
    }

    // Setters
    public void setTitreFilm(String titreFilm) {
        this.titreFilm = titreFilm;
    }

    public void setDateSeance(String dateSeance) {
        this.dateSeance = dateSeance;
    }

    public void setHeureSeance(String heureSeance) {
        this.heureSeance = heureSeance;
    }

    public void setSalleBillet(String salleBillet) {
        this.salleBillet = salleBillet;
    }

    public void setNombreBilletAdulte(int nombreBilletAdulte) {
        this.nombreBilletAdulte = nombreBilletAdulte;
    }

    public void setNombreBilletEnfant(int nombreBilletEnfant) {
        this.nombreBilletEnfant = nombreBilletEnfant;
    }

    public void setNombreBilletSenior(int nombreBilletSenior) {
        this.nombreBilletSenior = nombreBilletSenior;
    }

    public void setMailClient(String mailClient) {
        this.mailClient = mailClient;
    }

    public void setsiegeBillet(String siegeBillet) {
        this.siegeBillet = siegeBillet;
    }

    public void setUrlImageFilm(String urlImageFilm) {
        this.urlImageFilm = urlImageFilm;
    }

    // Méthode toString
    @Override
    public String toString() {
        return "Billet{" +
                "titreFilm='" + titreFilm + '\'' +
                ", dateSeance=" + dateSeance +
                ", heureSeance='" + heureSeance + '\'' +
                ", salleBillet='" + salleBillet + '\'' +
                ", siegeBillet='" + siegeBillet + '\'' +
                ", nombreBilletAdulte=" + nombreBilletAdulte +
                ", nombreBilletEnfant=" + nombreBilletEnfant +
                ", nombreBilletSenior=" + nombreBilletSenior +
                ", mailClient='" + mailClient + '\'' +
                ", urlImageFilm='" + urlImageFilm + '\'' +
                '}';
    }
}