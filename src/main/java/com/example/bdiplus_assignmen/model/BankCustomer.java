package com.example.bdiplus_assignmen.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankCustomer {

    @Id
    @SequenceGenerator(
            name = "customer_id_sequence" ,
            sequenceName = "customer_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_sequence"
    )
    private Integer customerId;
    private String customerName;
    private String customerEmail;
    private String customerPhoneNumber;
    private String customerPassword ;
    private String customerAddress;
    private String customerUserName;
    private Long customerCardNo;

}
