package pi.skill.exchange.platform.Entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "cours")
public class Cours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMatier;

    private String title;

    private String description;

    private int chapterNum;

    private String classeLevel;

    private String teacherName;

    private String subject;

    private String language;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


    @OneToMany(mappedBy = "cours", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Quiz> quizzes;


    public Cours() {}

    public Cours(String title, String description, int chapterNum, String classeLevel,
                 String teacherName, String subject, String language) {
        this.title = title;
        this.description = description;
        this.chapterNum = chapterNum;
        this.classeLevel = classeLevel;
        this.teacherName = teacherName;
        this.subject = subject;
        this.language = language;
    }


    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }



    public Long getIdMatier() { return idMatier; }
    public void setIdMatier(Long idMatier) { this.idMatier = idMatier; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getChapterNum() { return chapterNum; }
    public void setChapterNum(int chapterNum) { this.chapterNum = chapterNum; }

    public String getClasseLevel() { return classeLevel; }
    public void setClasseLevel(String classeLevel) { this.classeLevel = classeLevel; }

    public String getTeacherName() { return teacherName; }
    public void setTeacherName(String teacherName) { this.teacherName = teacherName; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }


    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public List<Quiz> getQuizzes() { return quizzes; }
    public void setQuizzes(List<Quiz> quizzes) { this.quizzes = quizzes; }

    // ─── toString ──────────────────────────────────────────

    @Override
    public String toString() {
        return "Cours{" +
                "idMatier=" + idMatier +
                ", title='" + title + '\'' +
                ", classeLevel='" + classeLevel + '\'' +
                ", chapterNum=" + chapterNum +
                ", subject='" + subject + '\'' +
                '}';
    }
}

