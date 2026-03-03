package pi.skill.exchange.platform.Entity;

import jakarta.persistence.*;

@Entity
public class SubscriptionPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private PlanType type;

    private String description;

    private Double monthlyPrice;
    private Double yearlyPrice;

    private Integer maxRequestsPerMonth;

    private Boolean priorityMatching;

    private Boolean accessPremiumCourses;
    private Boolean accessJobOffers;
    private Boolean accessCoworking;

    private Boolean active = true;
}
