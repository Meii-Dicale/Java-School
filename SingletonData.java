import java.util.ArrayList;
import java.util.List;

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

}
