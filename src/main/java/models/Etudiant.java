package models;

import java.util.ArrayList;

public class Etudiant extends Personne {

    private ArrayList<Note> listeNote = new ArrayList<>();

    public Etudiant(String nom, String prenom) {
        super(nom, prenom);
    }

    public Etudiant rendreAnonyme() {
        prenom = "anonymous";
        nom = "anonymous";
        return this;
    }

    public Etudiant rendreUppercase() {
        prenom = prenom.toUpperCase();
        nom = nom.toUpperCase();
        return this;
    }

    public ArrayList<Note> getListeNote() {
        return listeNote;
    }

    public void setListeNote(ArrayList<Note> listeNote) {
        this.listeNote = listeNote;
    }
}
