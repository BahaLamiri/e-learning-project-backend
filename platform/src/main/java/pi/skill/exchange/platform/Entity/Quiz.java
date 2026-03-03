package pi.skill.exchange.platform.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQuiz;

    private String question;

    @ManyToOne
    @JoinColumn(name = "cours_id")
    private Cours cours;

    public Quiz() {}

    public Long getIdQuiz() { return idQuiz; }
    public void setIdQuiz(Long idQuiz) { this.idQuiz = idQuiz; }

    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }

    public Cours getCours() { return cours; }
    public void setCours(Cours cours) { this.cours = cours; }
}