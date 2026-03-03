package pi.skill.exchange.platform.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter @Setter
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Enumerated(EnumType.STRING)
    private MessageType type;
    // QUESTION, DISCUSSION, ANNOUNCEMENT

    @Enumerated(EnumType.STRING)
    private MessageStatus status;

    private boolean edited;
    private int editCount;

    private String attachmentUrl; // simple gestion de fichier

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private ForumTopic topic;

    // 🔥 Pour les réponses (commentaires)
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Message parentMessage;

    @OneToMany(mappedBy = "parentMessage", cascade = CascadeType.ALL)
    private List<Message> replies;

    @OneToMany(mappedBy = "message", cascade = CascadeType.ALL)
    private List<Interaction> interactions;
}