package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="merchants")
@NoArgsConstructor
@Data
public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;
    private BigDecimal transactionFee;
    private BigDecimal commissionRate;
    private Integer payoutDelayCount;


   // private Payment payment;  // one merchant many payment how can I define multiple payment objects
    // do not create the foreign key in the merchant table because of one to many
    // if we are doing this uni directional we don't need the following:  if we want to do it bi directional than I need this code
 //  @OneToMany(mappedBy="merchant") // in oneToMany relationship ownership belongs to many
   // "merchant" is the field name in payment class
  //  private List<Payment> payment;


    public Merchant(String name, String code, BigDecimal transactionFee, BigDecimal commissionRate, Integer payoutDelayCount) {
        this.name = name;
        this.code = code;
        this.transactionFee = transactionFee;
        this.commissionRate = commissionRate;
        this.payoutDelayCount = payoutDelayCount;
    }
}
