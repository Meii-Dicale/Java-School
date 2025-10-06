import java.util.ArrayList;

public class Agent extends Personne {

    public Agent(String nom, String prenom ) {
        super(nom, prenom);
    }


    /// prof ///
    public Enseignant creerEnseignant(String nom, String prenom, Matieres matiere, int salaire) {
        System.out.println("Nouvel enseignant créé : " + nom + " " + prenom + ", matière : " + matiere);
        return new Enseignant(nom, prenom, matiere, salaire);
    }

    public void donnerSalaire(Enseignant enseignant, int salaire){
        System.out.println("L'enseignant" + enseignant.getPrenom() + enseignant.getNom() + "a obtenue un nouveau salaire de " + salaire);
        enseignant.setSalaire(salaire);
    }

    public Enseignant virerEnseignant(Enseignant enseignant){
        
        System.out.println("L'enseignant " + enseignant.getPrenom() + " " + enseignant.getNom() + " a été supprimé");
        enseignant = null;
        return enseignant;
    }

    //eleve ///
    public Eleve creerEleve(String nom, String prenom, Classe classe) {
        System.out.println("Nouvel élève créé : " + nom + " " + prenom + ", classe : " + classe);
        return new Eleve(nom, prenom, classe);
    }

    public Eleve changerDeClasse(Eleve eleve, Classe nouvelleClasse){
        eleve.setClasse(nouvelleClasse);
        System.out.println("L'élève " + eleve.getPrenom() + " " + eleve.getNom() + " est passé en classe de " + nouvelleClasse);
        return eleve;
    }

    public Eleve ajouterEmploieDuTemps(Eleve eleve ,Cours cours){
        eleve.getEmploieDuTemps().add(cours);
        System.out.println("L'élève " + eleve.getPrenom() + " " + eleve.getNom() + " a obtenu la matière " + cours);
        return eleve;
    }

    public Eleve virerEleve(Eleve eleve){
        System.out.println("L'élève " + eleve.getPrenom() + " " + eleve.getNom() + " a été supprimé");
        eleve = null;
        return eleve;
    }

    // cours///

    public Cours creerUnCours(Matieres matiere , Enseignant enseignant,Classe classe){
        System.out.println("Le cours de " + matiere + " a été créé pour l'enseignant " + enseignant.getPrenom() + " " + enseignant.getNom() + " dans la classe " + classe + ".");
        return new Cours(matiere, enseignant, classe);
    }
    public Cours ajouterUneEleve(Cours cours, Eleve eleve){
        cours.ajouterEleve(eleve);
        return cours;
    }
    public Cours supprimerUneEleve(Cours cours, Eleve eleve){
        cours.supprimerEleve(eleve);
        return cours;
    }


    public Cours supprimerUnCours(Cours cours){
        if (!cours.getEleve().isEmpty() ) {
            System.out.println("Ce cours contient des élèves et ne peux pas être supprimé");
            return cours;
        }
        cours = null;
        System.out.println("Le cours a été supprimé");
        return cours;
    }


}
