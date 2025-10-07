import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SingletonData {
    private static SingletonData instance;
    private List<Eleve> eleves;
    private List<Enseignant> enseignants;
    private List<Cours> cours;
    private List<Matieres> matieres;
    private List<Classe> classes;
    private List<Evaluation> evaluations;
    



    private SingletonData(){
        eleves = new ArrayList<>();
        enseignants = new ArrayList<>();
        cours = new ArrayList<>();
        matieres = new ArrayList<>();
        classes = new ArrayList<>();
        evaluations = new ArrayList<>();
    }
    public  static SingletonData getInstance(){
        if(instance == null){
            instance = new SingletonData();
        }
        return instance;
    }
    public void ajouterEleve(Eleve eleve){
        eleves.add(eleve);
    }
    public List<Eleve> getEleves(){
        return eleves;
    }
    public void ajouterEnseignant(Enseignant enseignant){
        enseignants.add(enseignant);
    }
    public List<Enseignant> getEnseignants(){
        return enseignants;
    }
    public void ajouterCours(Cours cours){
        this.cours.add(cours);
    }
    public List<Cours> getCours(){
        return cours;
    }
    public void ajouterMatiere(Matieres matiere){
        matieres.add(matiere);
    }
    public List<Matieres> getMatieres(){
        return matieres;
    }
    public void ajouterClasse(Classe classe){
        classes.add(classe);
    }
    public List<Classe> getClasses(){
        return classes;
    }
    public void ajouterEvaluation(Evaluation evaluation){
        evaluations.add(evaluation);
    }
    public List<Evaluation> getEvaluations(){
        return evaluations;
    }

    // ========== MÉTHODES DE SAUVEGARDE ==========
    
    public void sauvegarderTout() {
        sauvegarderEleves();
        sauvegarderEnseignants();
        sauvegarderCours();
        sauvegarderEvaluations();
        System.out.println("Toutes les données ont été sauvegardées !");
    }
    
    public void sauvegarderEleves() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("eleves.txt"))) {
            for (Eleve eleve : eleves) {
                writer.println(eleve.getNom() + "|" + eleve.getPrenom() + "|" + eleve.getClasse());
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde des élèves : " + e.getMessage());
        }
    }
    
    public void sauvegarderEnseignants() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("enseignants.txt"))) {
            for (Enseignant enseignant : enseignants) {
                writer.println(enseignant.getNom() + "|" + enseignant.getPrenom() + "|" + 
                             enseignant.getMatiere() + "|" + enseignant.getSalaire());
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde des enseignants : " + e.getMessage());
        }
    }
    
    public void sauvegarderCours() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("cours.txt"))) {
            for (Cours cours : cours) {
                writer.println(cours.getMatiere() + "|" + cours.getClasse() + "|" + 
                             cours.getEnseignant().getNom() + "|" + cours.getEnseignant().getPrenom());
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde des cours : " + e.getMessage());
        }
    }
    
    public void sauvegarderEvaluations() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("evaluations.txt"))) {
            for (Eleve eleve : eleves) {
                for (Evaluation eval : eleve.getEvaluations()) {
                    writer.println(eleve.getNom() + "|" + eleve.getPrenom() + "|" + 
                                 eval.getNote() + "|" + eval.getCommentaire() + "|" + 
                                 eval.getMatiere() + "|" + eval.getTypeEvaluation() + "|" + 
                                 eval.getDate());
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde des évaluations : " + e.getMessage());
        }
    }
    
    // ========== MÉTHODES DE CHARGEMENT ==========
    
    public void chargerTout() {
        chargerEleves();
        chargerEnseignants();
        chargerCours();
        chargerEvaluations();
        System.out.println("Toutes les données ont été chargées !");
    }
    
    public void chargerEleves() {
        if (!Files.exists(Paths.get("eleves.txt"))) {
            return;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader("eleves.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    String nom = parts[0];
                    String prenom = parts[1];
                    Classe classe = Classe.valueOf(parts[2]);
                    Eleve eleve = new Eleve(nom, prenom, classe);
                    eleves.add(eleve);
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur lors du chargement des élèves : " + e.getMessage());
        }
    }
    
    public void chargerEnseignants() {
        if (!Files.exists(Paths.get("enseignants.txt"))) {
            return;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader("enseignants.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 4) {
                    String nom = parts[0];
                    String prenom = parts[1];
                    Matieres matiere = Matieres.valueOf(parts[2]);
                    int salaire = Integer.parseInt(parts[3]);
                    Enseignant enseignant = new Enseignant(nom, prenom, matiere, salaire);
                    enseignants.add(enseignant);
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur lors du chargement des enseignants : " + e.getMessage());
        }
    }
    
    public void chargerCours() {
        if (!Files.exists(Paths.get("cours.txt"))) {
            return;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader("cours.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 4) {
                    Matieres matiere = Matieres.valueOf(parts[0]);
                    Classe classe = Classe.valueOf(parts[1]);
                    String nomEnseignant = parts[2];
                    String prenomEnseignant = parts[3];
                    
                    // Trouver l'enseignant correspondant
                    Enseignant enseignant = null;
                    for (Enseignant ens : enseignants) {
                        if (ens.getNom().equals(nomEnseignant) && ens.getPrenom().equals(prenomEnseignant)) {
                            enseignant = ens;
                            break;
                        }
                    }
                    
                    if (enseignant != null) {
                        Cours cours = new Cours(matiere, enseignant, classe);
                        this.cours.add(cours);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur lors du chargement des cours : " + e.getMessage());
        }
    }
    
    public void chargerEvaluations() {
        if (!Files.exists(Paths.get("evaluations.txt"))) {
            return;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader("evaluations.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 7) {
                    String nomEleve = parts[0];
                    String prenomEleve = parts[1];
                    double note = Double.parseDouble(parts[2]);
                    String commentaire = parts[3];
                    Matieres matiere = Matieres.valueOf(parts[4]);
                    String typeEvaluation = parts[5];
                    // Note: on ignore la date pour simplifier
                    
                    // Trouver l'élève correspondant
                    for (Eleve eleve : eleves) {
                        if (eleve.getNom().equals(nomEleve) && eleve.getPrenom().equals(prenomEleve)) {
                            Evaluation eval = new Evaluation(note, commentaire, matiere, typeEvaluation);
                            eleve.getEvaluations().add(eval);
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur lors du chargement des évaluations : " + e.getMessage());
        }
    }

}
