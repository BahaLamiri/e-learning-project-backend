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
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    private LocalDateTime registeredAt;

    @Enumerated(EnumType.STRING)
    private RegistrationStatus status;   // PENDING, CONFIRMED, CANCELLED

    @PrePersist
    public void prePersist() {
        this.registeredAt = LocalDateTime.now();
        if (this.status == null) this.status = RegistrationStatus.PENDING;
    }
}