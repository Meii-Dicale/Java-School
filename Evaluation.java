public class Evaluation {
    private double note; 
    private String commentaire;
    private Matieres matiere;


    public Evaluation(double note, String commentaire, Matieres matiere) {
        this.note = note;
        this.commentaire = commentaire;
        this.matiere = matiere;
    }

    public double getNote() {
        return this.note;
    }

    public Matieres getMatiere() {
        return this.matiere;
    }

    @Override
    public String toString() {
        return "Evaluation [note=" + note + ", commentaire=" + commentaire + ", matiere=" + matiere + "]";
    }


}