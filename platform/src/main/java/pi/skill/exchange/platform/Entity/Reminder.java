package pi.skill.exchange.platform.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    private LocalDateTime reminderDate;   // quand envoyer le rappel
    private String message;
    private boolean sent;                 // true = déjà envoyé

    @PrePersist
    public void prePersist() {
        this.sent = false;
    }
}