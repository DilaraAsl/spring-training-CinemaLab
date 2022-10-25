package com.cydeo.entity;


import com.cydeo.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
@Table(name="payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "DATE")
    private LocalDate createdDate;

    private BigDecimal amount;


    @Enumerated(EnumType.STRING)
    private Status paymentStatus;


  //  @OneToOne(cascade=CascadeType.ALL) // one payment can only have one payment detail
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
   // @JoinColumn(name="payment_detail_id") we don't need to put this one unless we want to change the name
    private PaymentDetail paymentDetail; // every payment has a payment detail obj spring boot does not know what kind of relationship these two tables have

    @ManyToOne
    private Merchant merchant;

    @ManyToOne // payment many customer one
    private Customer customer;
    public Payment(LocalDate createdDate, BigDecimal amount, Status paymentStatus) {
        this.createdDate = createdDate;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }
}
