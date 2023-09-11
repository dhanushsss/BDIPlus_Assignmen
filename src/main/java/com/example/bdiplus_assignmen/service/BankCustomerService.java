package com.example.bdiplus_assignmen.service;

import com.example.bdiplus_assignmen.model.BankCustomer;


import java.util.List;


public interface BankCustomerService  {

    BankCustomer addBankCustomer(BankCustomer customer);

    BankCustomer selectCustomerById(Integer customerId);

    List<BankCustomer> selectAllBankCustomer();

    BankCustomer updateBankUser(Integer userId, BankCustomer updatedUser);

    public String deleteBankCustomerById(Integer customerId);


}
