package pi.skill.exchange.platform.Entity;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    @Column(length = 2000)
    private String description;

    private String typeContrat;

    private Double salaire;

    private String localisation;

    private LocalDate datePublication;

    private LocalDate dateExpiration;

    @Enumerated(EnumType.STRING)
    private JobStatus statut;

    // Relation avec Company
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    // Une offre a plusieurs candidatures
    @OneToMany(mappedBy = "jobOffer", cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Application> applications;
}
