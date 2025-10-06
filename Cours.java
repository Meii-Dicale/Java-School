import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cours {

    private Matieres matiere;
    private Enseignant enseignant;
    private Classe classe;
    private ArrayList<Eleve> eleves;

    public Cours(Matieres matiere, Enseignant enseignant, Classe classe) {
        this.matiere = matiere;
        this.enseignant = enseignant;
        this.classe = classe;
        this.eleves = new ArrayList<>();
    }

    public Matieres getMatiere() {
        return matiere;
    }

    public void setMatiere(Matieres matiere) {
        System.out.println("La matière " + matiere + " a été définie pour ce cours");
        this.matiere = matiere;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        System.out.println("L'enseignant " + enseignant + " a été définie pour ce cours");
        this.enseignant = enseignant;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        System.out.println("La classe " + classe + " a été définie pour ce cours");
        this.classe = classe;
    }

    public ArrayList<Eleve> getEleve() {
        return this.eleves;
    }

    public void ajouterEleve(Eleve eleve) {
        if (this.eleves.contains(eleve)) {
            System.out.println("L'élève " + eleve.getPrenom() + " " + eleve.getNom() + " est déjà inscrit pour ce cours");
        } else {
            System.out.println("L'élève " + eleve.getPrenom() + " " + eleve.getNom() + " a été ajouté pour ce cours");
            this.eleves.add(eleve);
        }
    }

    public void supprimerEleve(Eleve eleve) {
        if (!this.eleves.contains(eleve)) {
            System.out.println("L'élève " + eleve.getNom() + " " + eleve.getPrenom() + " n'est pas inscrit pour ce cours");
        } else {
            System.out.println("L'élève " + eleve.getNom() + " " + eleve.getPrenom() + " a été supprimé pour ce cours");
            eleves.remove(eleve);
        }
    }

    public static Cours creerCours() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Matière :");
        for (Matieres elem : Matieres.values()) {
            System.out.println(elem);
        }
        String matiereUser = scanner.nextLine();
        Matieres matiere1 = Matieres.valueOf(matiereUser);

        System.out.println("Enseignant :");
        List<Enseignant> enseignants = SingletonData.getInstance().getEnseignants();
        for (Enseignant elem : enseignants) {
            System.out.println(elem.getNom() + " " + elem.getPrenom());
        }
        String enseignantUser = scanner.nextLine();
        Enseignant enseignant1 = null;
        for (Enseignant enseignant : enseignants) {
            if (enseignant.getNom().equals(enseignantUser) && matiere1 == enseignant.getMatiere()) {
                enseignant1 = enseignant;
                break;
            }
        }
        System.out.println("Classe :");
        for (Classe elem : Classe.values()) {
            System.out.println(elem);
        }
        String classeUser = scanner.nextLine();
        Classe classe1 = Classe.valueOf(classeUser);
        Cours cours1 = new Cours(matiere1, enseignant1, classe1);
        if (enseignant1 != null) {
            enseignant1.ajouterCours(cours1);
        }
        return cours1;
    }

    public static void modifierCours() {
        List<Cours> cours = SingletonData.getInstance().getCours();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nom du cours à modifier :");
        String nomCours = scanner.nextLine();
        for (Cours cours1 : cours) {
            if (cours1.getMatiere().toString().equalsIgnoreCase(nomCours)) {
                System.out.println(" Modification de la matière du cours");
                String newMatiere = scanner.nextLine();
                cours1.setMatiere(Matieres.valueOf(newMatiere));
                System.out.println(" Modification de l'enseignant du cours");
                String newEnseignant = scanner.nextLine();
                cours1.setEnseignant(SingletonData.getInstance().getEnseignants().get(Integer.parseInt(newEnseignant)));
                System.out.println(" Modification de la classe du cours");
                String newClasse = scanner.nextLine();
                cours1.setClasse(Classe.valueOf(newClasse));
            }
        }
    }

    public static void supprimerCours() {
        List<Cours> cours = SingletonData.getInstance().getCours();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nom du cours à supprimer :");
        String nomCours = scanner.nextLine();
        
        // Utilisation de removeIf pour éviter ConcurrentModificationException
        boolean removed = cours.removeIf(c -> c.getMatiere().toString().equalsIgnoreCase(nomCours));
        
        if (removed) {
            System.out.println("Le cours de " + nomCours + " a été supprimé.");
        } else {
            System.out.println("Cours non trouvé.");
        }
    }

    public static void gererCours() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("--- Gestion des Cours ---");
            System.out.println("1 - Afficher les cours");
            System.out.println("2 - Création d'un cours");
            System.out.println("3 - Modification d'un cours");
            System.out.println("4 - Suppression d'un cours");
            System.out.println("5 - Retour au menu");
            try {
                int userChoice = Integer.parseInt(scanner.nextLine());
                switch (userChoice) {
                    case 1:
                        System.out.println("Liste des cours :");
                        SingletonData.getInstance().getCours().forEach(System.out::println);
                        break;
                    case 2:
                        System.out.println("Création du cours");
                        Cours coursUnitaire = creerCours();
                        SingletonData.getInstance().ajouterCours(coursUnitaire);
                        break;
                    case 3:
                        System.out.println("Modification du cours");
                        modifierCours();
                        break;
                    case 4:
                        System.out.println("Suppression du cours ");
                        supprimerCours();
                        break;
                    case 5:
                        System.out.println("Retour au menu");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Choix invalide, veuillez réessayer.");
                }
            } catch (Exception e) {
                System.out.println("Erreur de saisie : " + e.getMessage());
            }
        }
    }

    public static void ajouterEleveAuCours() {
        Scanner scanner = new Scanner(System.in);
        List<Eleve> eleves = SingletonData.getInstance().getEleves();
        List<Cours> cours = SingletonData.getInstance().getCours();
        System.out.println("Liste des cours :");
        cours.forEach(c -> System.out.println(c.getMatiere()));
        System.out.println("Nom du cours :");
        String nomCours = scanner.nextLine();

        System.out.println("Liste des élèves :");
        eleves.forEach(e -> System.out.println(e.getNom() + " " + e.getPrenom()));
        System.out.println("Nom de l'élève :");
        String nomEleve = scanner.nextLine();

        Eleve eleveTrouve = null;
        for (Eleve eleve : eleves) {
            if (eleve.getNom().equalsIgnoreCase(nomEleve)) {
                eleveTrouve = eleve;
                break;
            }
        }

        Cours coursTrouve = null;
        for (Cours c : cours) {
            if (c.getMatiere().toString().equalsIgnoreCase(nomCours)) {
                coursTrouve = c;
                break;
            }
        }

        if (eleveTrouve != null && coursTrouve != null) {
            coursTrouve.ajouterEleve(eleveTrouve);
        } else {
            System.out.println("Élève ou cours non trouvé.");
        }
    }
    
    // --- MÉTHODE COMPLÉTÉE ---
    public static void supprimerEleveDuCours() {
        Scanner scanner = new Scanner(System.in);
        List<Cours> cours = SingletonData.getInstance().getCours();

        // 1. Sélectionner le cours
        System.out.println("Liste des cours :");
        cours.forEach(c -> System.out.println(c.getMatiere()));
        System.out.println("De quel cours voulez-vous supprimer un élève ?");
        String nomCours = scanner.nextLine();

        Cours coursSelectionne = null;
        for (Cours c : cours) {
            if (c.getMatiere().toString().equalsIgnoreCase(nomCours)) {
                coursSelectionne = c;
                break;
            }
        }

        // 2. Si le cours est trouvé, sélectionner l'élève
        if (coursSelectionne != null) {
            ArrayList<Eleve> elevesInscrits = coursSelectionne.getEleve();
            if (elevesInscrits.isEmpty()) {
                System.out.println("Il n'y a aucun élève dans ce cours.");
                return;
            }

            System.out.println("Liste des élèves dans ce cours :");
            elevesInscrits.forEach(e -> System.out.println(e.getNom() + " " + e.getPrenom()));
            System.out.println("Quel élève voulez-vous supprimer (entrez le nom) ?");
            String nomEleve = scanner.nextLine();

            Eleve eleveASupprimer = null;
            for (Eleve e : elevesInscrits) {
                if (e.getNom().equalsIgnoreCase(nomEleve)) {
                    eleveASupprimer = e;
                    break;
                }
            }

            // 3. Si l'élève est trouvé, le supprimer
            if (eleveASupprimer != null) {
                coursSelectionne.supprimerEleve(eleveASupprimer);
            } else {
                System.out.println("Cet élève n'a pas été trouvé dans la liste des inscrits.");
            }
        } else {
            System.out.println("Cours non trouvé.");
        }
    }

    public static void gererInscription() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("--- Gestion des Inscriptions ---");
            System.out.println("1 - Afficher les cours et leurs inscrits");
            System.out.println("2 - Inscrire un élève dans un cours");
            System.out.println("3 - Supprimer un élève d'un cours");
            System.out.println("4 - Retour au menu");
            try {
                int userChoice = Integer.parseInt(scanner.nextLine());
                switch (userChoice) {
                    case 1:
                        System.out.println("Liste des cours :");
                        SingletonData.getInstance().getCours().forEach(c -> {
                            System.out.println("- Cours de " + c.getMatiere() + " :");
                            if (c.getEleve().isEmpty()) {
                                System.out.println("  Aucun élève inscrit.");
                            } else {
                                c.getEleve().forEach(e -> System.out.println("  -> " + e.getPrenom() + " " + e.getNom()));
                            }
                        });
                        break;
                    case 2:
                        System.out.println("Ajout d'un élève dans un cours");
                        ajouterEleveAuCours();
                        break;
                    case 3:
                        System.out.println("Suppression d'un élève d'un cours");
                        supprimerEleveDuCours();
                        break;
                    case 4:
                        System.out.println("Retour au menu");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Choix invalide, veuillez réessayer.");
                }
            } catch (Exception e) {
                System.out.println("Erreur de saisie : " + e.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        return "Cours de " + matiere + " avec l'enseignant " + enseignant.getPrenom() + " " + enseignant.getNom() + " dans la classe " + classe;
    }
} 