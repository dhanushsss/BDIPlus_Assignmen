package com.example.bdiplus_assignmen.model;


import jakarta.persistence.*;

@Entity
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


    public BankCustomer() {
    }

    public BankCustomer( String customerName, String customerEmail, String customerPhoneNumber, String customerPassword, String customerAddress, String customerUserName, Long customerCardNo) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerPassword = customerPassword;
        this.customerAddress = customerAddress;
        this.customerUserName = customerUserName;
        this.customerCardNo = customerCardNo;
    }


    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerUserName() {
        return customerUserName;
    }

    public void setCustomerUserName(String customerUserName) {
        this.customerUserName = customerUserName;
    }

    public Long getCustomerCardNo() {
        return customerCardNo;
    }

    public void setCustomerCardNo(Long customerCardNo) {
        this.customerCardNo = customerCardNo;
    }

    @Override
    public String toString() {
        return "BankCustomer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerPhoneNumber='" + customerPhoneNumber + '\'' +
                ", customerPassword='" + customerPassword + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerUserName='" + customerUserName + '\'' +
                ", customerCardNo=" + customerCardNo +
                '}';
    }
}
