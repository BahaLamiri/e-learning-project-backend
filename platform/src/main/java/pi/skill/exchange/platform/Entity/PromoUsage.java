package pi.skill.exchange.platform.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class PromoUsage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private PromoCode promoCode;

    @ManyToOne
    private User user;

    @ManyToOne
    private Subscription subscription;

    private LocalDateTime usedAt;
}
