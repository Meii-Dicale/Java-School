
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // Agent agent1 = new Agent("Wannyn", "Lorelei");
        // Enseignant prof1 = agent1.creerEnseignant("Thomas", "Smagghe", Matieres.Java, 3500);
        // Enseignant prof2 = agent1.creerEnseignant("Theo","Bialasik", Matieres.Karaté, 3500);
        // Enseignant prof3 = agent1.creerEnseignant("Pierre", "Stak", Matieres.BallonDanse, 3500);

        // System.out.println("----------");
        // Eleve eleve1= agent1.creerEleve("San", "Ezekiel", Classe.GS);
        // Eleve eleve2= agent1.creerEleve("Nicolle", "Julien", Classe.TROISIEME);
        // System.out.println("----------");
        // agent1.ajouterEmploieDuTemps(eleve1, Matieres.Java);
        // agent1.ajouterEmploieDuTemps(eleve1, Matieres.Karaté);
        // System.out.println("----------");
        // Cours cours1 = agent1.creerUnCours(Matieres.BallonDanse, prof3, Classe.CE1);
        // Cours cours2 = agent1.creerUnCours(Matieres.Karaté, prof2, Classe.CP);
        // System.out.println("----------");
        // agent1.ajouterUneEleve(cours1, eleve1);
        // agent1.ajouterUneEleve(cours1, eleve2);
        // agent1.ajouterUneEleve(cours2, eleve1);
        // System.out.println("----------");
        // agent1.supprimerUnCours(cours2);
        // agent1.supprimerUnCours(cours1);
        // System.out.println("----------");
        // agent1.supprimerUneEleve(cours2, eleve2);
        // System.out.println("----------");
        // agent1.changerDeClasse(eleve1, Classe.CP);
        // System.out.println("----------");
        // prof1.noterUnEleve(eleve1,15,"De bons résultats", Matieres.Java);
        // prof1.noterUnEleve(eleve1,10,"Ezekiel aurait du réviser.", Matieres.Java);
        // prof1.noterUnEleve(eleve1,18,"Très bien", Matieres.Java);
        // prof1.noterUnEleve(eleve1,14,"Quelques erreurs d'innatention !", Matieres.Java);
        // prof2.noterUnEleve(eleve1,18,"Très bien petit scarabée", Matieres.Karaté);
        // prof2.noterUnEleve(eleve1,14,"C'est encourageant", Matieres.Karaté);
        // System.out.println("----------");
        // eleve1.afficherLaMoyenne(eleve1);
        // System.out.println("----------");
        // prof1.noterUnEleve(eleve1,15,"Très bien", Matieres.BallonDanse);
        // prof1.noterUnEleve(eleve2,15,"Très bien", Matieres.Java);
        // System.out.println("----------");
        // agent1.donnerSalaire(prof1, 4000);
        // agent1.virerEnseignant(prof1);
        // agent1.virerEleve(eleve1);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Que voulez vous gérer ? ");
            System.out.println("1 - Gestion des étudiants");
            System.out.println("2 - Gestion des professeurs");
            System.out.println("3 - Gestion des cours");
            System.out.println("4 - Gestion des inscription");
            System.out.println("5 - Gestions des notes");
            System.out.println("6 - Fin du programme");
            try {
                int userChoice = Integer.parseInt(scanner.nextLine());

                switch (userChoice) {
                    case 1:
                        System.out.println("Gestion des étudiants");
                        Eleve.GererEtudiant();
                        break;
                    case 2:
                        System.out.println("Gestion des professeurs");
                        Enseignant.gererEnseignants();
                        break;
                    case 3:
                        System.out.println("Gestion des cours");
                        Cours.gererCours();
                        break;
                    case 4:
                        System.out.println("Gestions des inscriptions");
                        Cours.gererInscription();
                        break;
                    case 5:
                        System.out.println("Gestion des notes");
                        break;
                    case 6:
                        System.out.println("Fin du programme");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Que voulez vous gérer ? ");
                        System.out.println("1 - Gestion des étudiants");
                        System.out.println("2 - Gestion des professeurs");
                        System.out.println("3 - Gestion des cours");
                        System.out.println("4 - Gestion des inscription");
                        System.out.println("5 - Gestions des notes");
                        System.out.println("6 - Fin du programme");
                        break;
                        
                }
            } catch (Exception e) {
                System.out.println("Votre choix doit être un chiffre");
            }
        }

    }
}
