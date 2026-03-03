package pi.skill.exchange.platform.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Lob
    private String description;

    private String location;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private int capacity;

    @Lob
    private byte[] image;

    @Enumerated(EnumType.STRING)
    private EventStatus status;

    @Enumerated(EnumType.STRING)
    private EventCategory category;

    private LocalDateTime createdAt;


    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private User organizer;

    // Liste des inscriptions liées
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Registration> registrations;

    // Liste des rappels liés
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reminder> reminders;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        if (this.status == null) this.status = EventStatus.DRAFT;
    }

}