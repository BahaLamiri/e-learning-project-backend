package pi.skill.exchange.platform.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String invoiceNumber;

    private LocalDate issueDate;

    private Double totalAmount;

    @OneToOne
    private Payment payment;
}
