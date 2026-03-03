package pi.skill.exchange.platform.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomEntreprise;

    @Column(length = 1500)
    private String description;

    private String adresse;

    private String email;

    private String telephone;

    private String siteWeb;

    // Une entreprise publie plusieurs offres
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<JobOffer> jobOffers;

}
