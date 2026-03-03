package pi.skill.exchange.platform.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Cessation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String motifCessation;
    private Date dateCessation;
    @ManyToOne
    @JoinColumn(name = "userrr_id")
    private User userrr;
}
