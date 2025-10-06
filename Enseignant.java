
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Enseignant extends Personne{
    private Matieres matiere;
    private int salaire;
    private List<Cours> cours;



    public Enseignant(String nom, String prenom, Matieres matiere, int salaire) {
        super(nom, prenom);
        this.matiere = matiere;
        this.salaire = salaire;
        this.cours = new ArrayList<>();
    }

    public List<Cours> getCours() {
        return this.cours;
    }
    public void ajouterCours(Cours cours){
        this.cours.add(cours);
    }


    public Matieres getMatiere() {
        return this.matiere;
    }

    public void setSalaire(int salaire){
        this.salaire = salaire;
    }

    public int getSalaire(){
        return this.salaire;
    }

    public void noterUnEleve(Eleve eleve, double note, String commentaire, Matieres matiere){
        if (this.matiere != matiere) {
            System.out.println("L'élève " + eleve.getNom() + " " + eleve.getPrenom() + " ne peut pas être noté dans cette matière car l'enseignant ne l'enseigne pas.");
        }else if (!eleve.getEmploieDuTemps().contains(matiere)){
            System.out.println("L'élève " + eleve.getNom() + " " + eleve.getPrenom() + " ne peut pas être noté dans cette matière car il n'y est pas inscrit dans son emploi du temps.");
        }else{
        System.out.println("L'élève " + eleve.getNom() + " " + eleve.getPrenom() + " a été noté " + note + "/20 dans la matière " + matiere + " : " + commentaire );
        Evaluation evaluation = new Evaluation(note, commentaire, matiere);
        eleve.getEvaluations().add(evaluation);
        }

    }

    public static Enseignant creerEnseignant(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nom");
        String nom = scanner.nextLine();
        System.out.println("Prénom:");
        String prenom = scanner.nextLine();
        System.out.println("Matière :");
        for ( Matieres elem : Matieres.values()){
            System.out.println(elem);
        }
        String matiereUser = scanner.nextLine();
        Matieres matiere1 = Matieres.valueOf(matiereUser);
        System.out.println("Salaire :");
        int salaire = scanner.nextInt();
        return new Enseignant(nom, prenom, matiere1, salaire);
    }

    public static void modifierEnseignant(){
        List<Enseignant> enseignants = SingletonData.getInstance().getEnseignants();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nom de l'enseignant à modifier :");
        String nomEnseignant = scanner.nextLine();
        for ( Enseignant enseignant : enseignants){
            if (enseignant.getNom().equals(nomEnseignant)) {
                System.out.println(" Modification du nom de l'enseignant");
                String newNom = scanner.nextLine();
                enseignant.setNom(newNom);
                System.out.println(" Modification du prénom de l'enseignant");
                String newPrenom = scanner.nextLine();
                enseignant.setPrenom(newPrenom);
            }
        }
    }
    public static void supprimerEnseignant(){
        List<Enseignant> enseignants = SingletonData.getInstance().getEnseignants();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nom de l'enseignant à supprimer :");
        String nomEnseignant = scanner.nextLine();
        for ( Enseignant enseignant : enseignants){
            if (enseignant.getNom().equals(nomEnseignant)) {
                enseignants.remove(enseignant);
            }
        }
    }



    public static void gererEnseignants(){
        List<Enseignant> enseignants = SingletonData.getInstance().getEnseignants();
        Scanner scanner = new Scanner(System.in);
        boolean isInt = false;
        while(!isInt){
            System.out.println("Que voulez faire ?");
            System.out.println("1 - Afficher les enseignants");
            System.out.println("2 - Creation d'un enseignant");
            System.out.println("3 - Modification d'un enseignant");
            System.out.println("4 - Supression d'un enseignant");
            System.out.println("5 - Retour au menu");
            try {
                int userChoise = Integer.parseInt(scanner.nextLine());
                switch (userChoise) {
                    case 1:
                        System.out.println("Liste des enseignants :");
                        enseignants.forEach(System.out::println);
                        break;
                    case 2:
                        System.out.println("Création de l'enseignant");
                        Enseignant enseignant = creerEnseignant();
                        enseignants.add(enseignant);
                        break;
                    case 3:
                        System.out.println("Modification de l'enseignant");
                        modifierEnseignant();
                        break;
                    case 4:
                        System.out.println("Suppression de l'enseignant ");
                        supprimerEnseignant();
                        break;
                    case 5:
                        System.out.println("Retour au menu");
                        return;
                    default:    
                    System.out.println("Que voulez faire ?");
                    System.out.println("1 - Afficher les enseignants");
                    System.out.println("2 - Creation d'un enseignant");
                    System.out.println("3 - Modification d'un enseignant");
                    System.out.println("4 - Supression d'un enseignant");
                    System.out.println("5 - Retour au menu");
        }
    } catch (Exception e) {
        System.out.println(e);

    }
}
}

@Override
public String toString() {
    return "Enseignant " + nom +" " + prenom +" enseignant de "+ matiere;
}
}
