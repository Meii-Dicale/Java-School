
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Eleve extends Personne {

    private Classe classe;
    private ArrayList<Cours> emploieDuTemps;
    private ArrayList<Evaluation> evaluations;

    public Eleve(String nom, String prenom, Classe classe) {
        super(nom, prenom);
        this.classe = classe;
        this.emploieDuTemps = new ArrayList<>();
        this.evaluations = new ArrayList<>();

    }
    public static Eleve creerEtudiant(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nom");
        String nom = scanner.nextLine();
        System.out.println("Prénom:");
        String prenom = scanner.nextLine();
        System.out.println("Classe :");
        for ( Classe elem : Classe.values()){
            System.out.println(elem);
        }
        String classUser = scanner.nextLine();
        Classe class1 = Classe.valueOf(classUser);

        return new Eleve(nom, prenom, class1);
    }

    public Classe getClasse() {
        System.out.println("L'élève " + this.getNom() + " " + this.getPrenom() + " est dans la classe " + this.classe);
        return this.classe;
    }

    public ArrayList<Cours> getEmploieDuTemps() {
        return this.emploieDuTemps;
    }

    public Classe setClasse(Classe classe) {
        this.classe = classe;
        return this.classe;
    }

    public ArrayList<Evaluation> getEvaluations() {
        return this.evaluations;
    }

    public Map<Matieres, Double> calculerMoyennesParMatiere() {
        return this.evaluations.stream()
                .collect(Collectors.groupingBy(
                        Evaluation::getMatiere,
                        Collectors.averagingDouble(Evaluation::getNote)));
    }

    public void afficherLaMoyenne(Eleve eleve) {
        System.out.println("Calcul des moyennes pour " + eleve.getPrenom() + " " + eleve.getNom() + ":");
        Map<Matieres, Double> moyennes = eleve.calculerMoyennesParMatiere();
        if (moyennes.isEmpty()) {
            System.out.println("Aucune note enregistrée pour cet élève.");
        } else {
            moyennes.forEach((matiere, moyenne)
                    -> System.out.printf("Moyenne en %s: %.2f\n", matiere, moyenne));
        }
    }
    public static void afficherEleves() {
        List<Eleve> eleves = SingletonData.getInstance().getEleves();

        System.out.println("Liste des élèves :");
        eleves.forEach(System.out::println);
    }
    public static void modifierEleve() {
        List<Eleve> eleves = SingletonData.getInstance().getEleves();

        afficherEleves();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nom de l'élève à modifier :");
        String nomEleve = scanner.nextLine();
        for ( Eleve eleve : eleves){
            if (eleve.getNom().equals(nomEleve)) {
                System.out.println(" Modification du nom de l'élève");
                String newNom = scanner.nextLine();
                eleve.setNom(newNom);
                System.out.println(" Modification du prénom de l'élève");
                String newPrenom = scanner.nextLine();
                eleve.setPrenom(newPrenom);
            }
        }
    }
    public static void supprimerEleve(){
        List<Eleve> eleves = SingletonData.getInstance().getEleves();
        afficherEleves();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nom de l'élève à supprimer :");
        String nomEleve = scanner.nextLine();
        for ( Eleve eleve : eleves){
            if (eleve.getNom().equals(nomEleve)) {
                eleves.remove(eleve);
            }
        }
    }

 @Override 
 public String toString() {
    return prenom +" " + nom + " en classe de " + classe;
 }

    public static void GererEtudiant() {
        Scanner scanner = new Scanner(System.in);
        List<Eleve> eleves = SingletonData.getInstance().getEleves();


        boolean isInt = false;
        while(!isInt){
            System.out.println("Que voulez faire ?");
            System.out.println("1 - Afficher les étudiants");
            System.out.println("2 - Creation d'un étudiant");
            System.out.println("3 - Modification d'un étudiant");
            System.out.println("4 - Supression d'un étudiant");
            System.out.println("5 - Retour au menu");
            try {
                int userChoise = Integer.parseInt(scanner.nextLine());
                switch (userChoise) {
                    case 1:
                       afficherEleves();
                        break;
                    case 2:
                        System.out.println("Création de l'étudiant");
                        Eleve eleve = creerEtudiant();
                        eleves.add(eleve);
                        break;
                    case 3:
                        System.out.println("Modification de l'étudiant");
                        modifierEleve();
                        break;
                    case 4:
                        System.out.println("Suppression de l'étudiant ");
                        supprimerEleve();
                        break;
                    case 5:
                        System.out.println("Retour au menu");
                        return;
                    default:
                    System.out.println("Que voulez faire ?");
                    System.out.println("1 - Afficher les étudiants");
                    System.out.println("2 - Creation d'un étudiant");
                    System.out.println("3 - Modification d'un étudiant");
                    System.out.println("4 - Supression d'un étudiant");
                    isInt = false;
                    break;

             }
    
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

}
