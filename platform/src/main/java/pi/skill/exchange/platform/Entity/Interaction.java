package pi.skill.exchange.platform.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Interaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private InteractionType type;
    // LIKE, LOVE, UPVOTE, DOWNVOTE, BOOKMARK

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "message_id")
    private Message message;
}