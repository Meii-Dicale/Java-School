
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // Charger les données sauvegardées au démarrage
        System.out.println("Chargement des données...");
        SingletonData.getInstance().chargerTout();
        
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
            System.out.println("6 - Sauvegarde des données");
            System.out.println("7 - Fin du programme");
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
                        gererNotes(scanner);
                        break;
                    case 6:
                        System.out.println("Sauvegarde des données");
                        sauvegarderDonnees();
                        break;
                    case 7:
                        System.out.println("Fin du programme");
                        // Sauvegarder automatiquement avant de fermer
                        System.out.println("Sauvegarde automatique...");
                        SingletonData.getInstance().sauvegarderTout();
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

    public static void gererNotes(Scanner scanner) {
        boolean continuer = true;
        
        while (continuer) {
            System.out.println("\n=== GESTION DES NOTES ===");
            System.out.println("1 - Ajouter une note (via enseignant)");
            System.out.println("2 - Afficher les notes d'un élève");
            System.out.println("3 - Afficher toutes les notes");
            System.out.println("4 - Calculer les moyennes");
            System.out.println("5 - Retour au menu principal");
            
            try {
                int choix = Integer.parseInt(scanner.nextLine());
                
                switch (choix) {
                    case 1:
                        ajouterNoteViaEnseignant(scanner);
                        break;
                    case 2:
                        afficherNotesEleve(scanner);
                        break;
                    case 3:
                        afficherToutesLesNotes();
                        break;
                    case 4:
                        calculerMoyennes(scanner);
                        break;
                    case 5:
                        continuer = false;
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez réessayer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
            }
        }
    }

    public static void ajouterNoteViaEnseignant(Scanner scanner) {
        
        // Afficher les enseignants
        List<Enseignant> enseignants = SingletonData.getInstance().getEnseignants();
        if (enseignants.isEmpty()) {
            System.out.println("Aucun enseignant trouvé. Créez d'abord des enseignants.");
            return;
        }
        
        System.out.println("Liste des enseignants :");
        for (int i = 0; i < enseignants.size(); i++) {
            System.out.println((i + 1) + " - " + enseignants.get(i));
        }
        
        System.out.print("Choisissez un enseignant (numéro) : ");
        try {
            int indexEnseignant = Integer.parseInt(scanner.nextLine()) - 1;
            if (indexEnseignant < 0 || indexEnseignant >= enseignants.size()) {
                System.out.println("Index invalide.");
                return;
            }
            
            Enseignant enseignant = enseignants.get(indexEnseignant);
            
            // Afficher les élèves
            List<Eleve> eleves = SingletonData.getInstance().getEleves();
            if (eleves.isEmpty()) {
                System.out.println("Aucun élève trouvé.");
                return;
            }
            
            System.out.println("Liste des élèves :");
            for (int i = 0; i < eleves.size(); i++) {
                System.out.println((i + 1) + " - " + eleves.get(i));
            }
            
            System.out.print("Choisissez un élève (numéro) : ");
            int indexEleve = Integer.parseInt(scanner.nextLine()) - 1;
            if (indexEleve < 0 || indexEleve >= eleves.size()) {
                System.out.println("Index invalide.");
                return;
            }
            
            Eleve eleve = eleves.get(indexEleve);
            
            // Saisir la note
            System.out.print("Entrez la note (0-20) : ");
            double note = Double.parseDouble(scanner.nextLine());
            if (note < 0 || note > 20) {
                System.out.println("La note doit être entre 0 et 20.");
                return;
            }
            
            // Saisir le commentaire
            System.out.print("Entrez un commentaire : ");
            String commentaire = scanner.nextLine();
            
            // Utiliser la méthode existante de l'enseignant
            enseignant.noterUnEleve(eleve, note, commentaire, enseignant.getMatiere());
            
        } catch (NumberFormatException e) {
            System.out.println("Veuillez entrer un nombre valide.");
        }
    }

    public static void afficherNotesEleve(Scanner scanner) {
        List<Eleve> eleves = SingletonData.getInstance().getEleves();
        
        if (eleves.isEmpty()) {
            System.out.println("Aucun élève trouvé.");
            return;
        }
        
        System.out.println("Liste des élèves :");
        for (int i = 0; i < eleves.size(); i++) {
            System.out.println((i + 1) + " - " + eleves.get(i));
        }
        
        System.out.print("Choisissez un élève (numéro) : ");
        try {
            int indexEleve = Integer.parseInt(scanner.nextLine()) - 1;
            if (indexEleve < 0 || indexEleve >= eleves.size()) {
                System.out.println("Index invalide.");
                return;
            }
            
            Eleve eleve = eleves.get(indexEleve);
            List<Evaluation> evaluations = eleve.getEvaluations();
            
            if (evaluations.isEmpty()) {
                System.out.println("Aucune note trouvée pour cet élève.");
                return;
            }
            
            System.out.println("\nNotes de " + eleve.getPrenom() + " " + eleve.getNom() + " :");
            System.out.println("========================================");
            
            for (Evaluation eval : evaluations) {
                System.out.println(eval.toString());
            }
            
            // Afficher les moyennes
            eleve.afficherLaMoyenne(eleve);
            
        } catch (NumberFormatException e) {
            System.out.println("Veuillez entrer un nombre valide.");
        }
    }

    public static void afficherToutesLesNotes() {
        System.out.println("\n=== TOUTES LES NOTES ===");
        
        List<Eleve> eleves = SingletonData.getInstance().getEleves();
        if (eleves.isEmpty()) {
            System.out.println("Aucun élève trouvé.");
            return;
        }
        
        boolean hasAnyNotes = false;
        for (Eleve eleve : eleves) {
            List<Evaluation> evaluations = eleve.getEvaluations();
            if (!evaluations.isEmpty()) {
                hasAnyNotes = true;
                System.out.println("\n" + eleve.getPrenom() + " " + eleve.getNom() + " :");
                System.out.println("----------------------------------------");
                
                for (Evaluation eval : evaluations) {
                    System.out.println("  " + eval.toString());
                }
            }
        }
        
        if (!hasAnyNotes) {
            System.out.println("Aucune note trouvée dans le système.");
        }
    }

    public static void calculerMoyennes(Scanner scanner) {
        List<Eleve> eleves = SingletonData.getInstance().getEleves();
        
        if (eleves.isEmpty()) {
            System.out.println("Aucun élève trouvé.");
            return;
        }
        
        System.out.println("1 - Moyenne d'un élève spécifique");
        System.out.println("2 - Moyennes de tous les élèves");
        System.out.print("Choisissez une option (1-2) : ");
        
        try {
            int choix = Integer.parseInt(scanner.nextLine());
            
            switch (choix) {
                case 1:
                    System.out.println("Liste des élèves :");
                    for (int i = 0; i < eleves.size(); i++) {
                        System.out.println((i + 1) + " - " + eleves.get(i));
                    }
                    
                    System.out.print("Choisissez un élève (numéro) : ");
                    int indexEleve = Integer.parseInt(scanner.nextLine()) - 1;
                    if (indexEleve >= 0 && indexEleve < eleves.size()) {
                        eleves.get(indexEleve).afficherLaMoyenne(eleves.get(indexEleve));
                    } else {
                        System.out.println("Index invalide.");
                    }
                    break;
                    
                case 2:
                    System.out.println("\nMoyennes de tous les élèves :");
                    System.out.println("========================================");
                    for (Eleve eleve : eleves) {
                        if (!eleve.getEvaluations().isEmpty()) {
                            eleve.afficherLaMoyenne(eleve);
                            System.out.println("----------------------------------------");
                        }
                    }
                    break;
                    
                default:
                    System.out.println("Choix invalide.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Veuillez entrer un nombre valide.");
        }
    }

    public static void sauvegarderDonnees() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== SAUVEGARDE DES DONNÉES ===");
        System.out.println("1 - Sauvegarder tout");
        System.out.println("2 - Sauvegarder les élèves uniquement");
        System.out.println("3 - Sauvegarder les enseignants uniquement");
        System.out.println("4 - Sauvegarder les cours uniquement");
        System.out.println("5 - Sauvegarder les notes uniquement");
        System.out.println("6 - Retour au menu principal");
        
        try {
            int choix = Integer.parseInt(scanner.nextLine());
            
            switch (choix) {
                case 1:
                    SingletonData.getInstance().sauvegarderTout();
                    break;
                case 2:
                    SingletonData.getInstance().sauvegarderEleves();
                    System.out.println("Élèves sauvegardés !");
                    break;
                case 3:
                    SingletonData.getInstance().sauvegarderEnseignants();
                    System.out.println("Enseignants sauvegardés !");
                    break;
                case 4:
                    SingletonData.getInstance().sauvegarderCours();
                    System.out.println("Cours sauvegardés !");
                    break;
                case 5:
                    SingletonData.getInstance().sauvegarderEvaluations();
                    System.out.println("Notes sauvegardées !");
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Choix invalide.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Veuillez entrer un nombre valide.");
        }
    }
}
