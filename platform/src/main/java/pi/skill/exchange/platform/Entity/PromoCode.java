package pi.skill.exchange.platform.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class PromoCode {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String code;

    @Enumerated(EnumType.STRING)
    private DiscountType discountType;

    private Double value;

    private Integer maxUses;

    private Integer usedCount = 0;

    private LocalDate validFrom;
    private LocalDate validUntil;

    @ElementCollection(targetClass = PlanType.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "promo_applicable_plans")
    @Column(name = "plan_type")
    private List<PlanType> applicablePlans;

    private Boolean isFirstTimeOnly;

    private Boolean active = true;
}
