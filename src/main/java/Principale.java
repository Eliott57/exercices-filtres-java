import models.Etudiant;
import models.Note;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.toUpperCase;
import static java.util.stream.Collectors.toCollection;

public class Principale {
    public static void main(String[] args) {

        Etudiant etudiant1 = new Etudiant("bansept", "franck");
        etudiant1.getListeNote().add(new Note("JAVA", 15));
        etudiant1.getListeNote().add(new Note("PHP", 10));
        etudiant1.getListeNote().add(new Note("UML", 5));

        Etudiant etudiant2 = new Etudiant("doe", "simon");
        etudiant2.getListeNote().add(new Note("JAVA", 5));
        etudiant2.getListeNote().add(new Note("PHP", 19));

        Etudiant etudiant3 = new Etudiant("stark", "sansa");
        etudiant3.getListeNote().add(new Note("C#", 5));
        etudiant3.getListeNote().add(new Note("AVA", 19));


        List<Etudiant> listeEtudiant = new ArrayList<>();
        listeEtudiant.add(etudiant1);
        listeEtudiant.add(etudiant2);
        listeEtudiant.add(etudiant3);

        //Exercice 1
        String emails = listeEtudiant.stream()
                .map(etudiant -> etudiant.getNom() + "." + etudiant.getPrenom() + "@cesi.com")
                .collect(Collectors.joining(" - "));

        System.out.println(emails);

        //Exercice 2
        Etudiant majorDePromoAvecUnS = listeEtudiant.stream()
                .filter(etudiant -> etudiant.getNom().toCharArray()[0] == 's' || etudiant.getPrenom().toCharArray()[0] == 's')
                .max(Comparator.comparingInt(etudiant ->
                        etudiant.getListeNote().stream().mapToInt(note -> note.getNote()).max().getAsInt()))
                        .get();

        System.out.println(majorDePromoAvecUnS.getNom() + " " + majorDePromoAvecUnS.getPrenom());

        //Exercice 3
        ArrayList<Note> notes = listeEtudiant.stream()
                .map(etudiant -> etudiant.getListeNote())
                .flatMap(ArrayList::stream)
                .collect(toCollection(ArrayList::new));

        System.out.println(notes);

        //Exercice 4
        String triEtudiant = listeEtudiant.stream()
                .sorted(Comparator.comparingDouble((Etudiant etudiant) -> etudiant.getListeNote().stream().mapToInt(note -> note.getNote()).average().getAsDouble()).reversed())
                .map(etudiant -> toUpperCase(etudiant.getPrenom().toCharArray()[0]) + "." + toUpperCase(etudiant.getNom().toCharArray()[0]) + " (" + etudiant.getListeNote().stream().mapToInt(note -> note.getNote()).max().getAsInt() + ")")
                .collect(Collectors.joining(" > "));

        System.out.println(triEtudiant);
    }
}
