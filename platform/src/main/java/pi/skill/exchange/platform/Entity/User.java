package pi.skill.exchange.platform.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private byte[] image;
    private String email;
    private String nom, prenom, motDePasse, adresse, description;
    private Date dateNaissance, dateInscrit;
    private int num_Tel;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @Enumerated(EnumType.STRING)
    private Compte etatCompte;
    @ManyToOne
    @JoinColumn(name = "cessation_id")
    private Cessation cessation;

    @OneToMany(mappedBy = "organizer", cascade = CascadeType.ALL)
    private List<Event> organizedEvents;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Registration> registrations;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Reminder> reminders;
}