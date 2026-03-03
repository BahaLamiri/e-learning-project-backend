package pi.skill.exchange.platform.Entity;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateCandidature;

    private String cv;

    @Column(length = 1500)
    private String lettreMotivation;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus statut;

    // Candidat (User existant)
    //@ManyToOne
    //@JoinColumn(name = "candidat_id")
    //private User candidat;

    @ManyToOne
    @JoinColumn(name = "job_offer_id")
    private JobOffer jobOffer;
}

