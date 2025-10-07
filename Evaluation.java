import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evaluation {
    private static int nextId = 1;
    private int id;
    private double note; 
    private String commentaire;
    private Matieres matiere;
    private LocalDate date;
    private String typeEvaluation; // "Contrôle", "Devoir", "Examen", etc.

    public Evaluation(double note, String commentaire, Matieres matiere) {
        this.id = nextId++;
        this.note = note;
        this.commentaire = commentaire;
        this.matiere = matiere;
        this.date = LocalDate.now();
        this.typeEvaluation = "Contrôle";
    }

    public Evaluation(double note, String commentaire, Matieres matiere, String typeEvaluation) {
        this.id = nextId++;
        this.note = note;
        this.commentaire = commentaire;
        this.matiere = matiere;
        this.date = LocalDate.now();
        this.typeEvaluation = typeEvaluation;
    }

    public int getId() {
        return this.id;
    }

    public double getNote() {
        return this.note;
    }

    public Matieres getMatiere() {
        return this.matiere;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public String getTypeEvaluation() {
        return this.typeEvaluation;
    }

    public String getCommentaire() {
        return this.commentaire;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void setTypeEvaluation(String typeEvaluation) {
        this.typeEvaluation = typeEvaluation;
    }

    public boolean estValide() {
        return this.note >= 0 && this.note <= 20;
    }

    public String getAppreciation() {
        if (this.note >= 18) return "Excellent";
        if (this.note >= 16) return "Très bien";
        if (this.note >= 14) return "Bien";
        if (this.note >= 12) return "Assez bien";
        if (this.note >= 10) return "Passable";
        return "Insuffisant";
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("Evaluation #%d [%s] %s - %.2f/20 (%s) - %s - %s", 
            id, date.format(formatter), matiere, note, typeEvaluation, getAppreciation(), commentaire);
    }


}