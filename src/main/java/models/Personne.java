package models;

public class Personne {
    protected String nom;
    protected String prenom;

    static public String bonjour = "bonjour";

    public Personne(String nom, String prenom) {
        this.setNom(nom);
        this.setPrenom(prenom);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
