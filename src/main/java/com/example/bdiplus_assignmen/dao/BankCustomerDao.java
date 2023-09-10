package com.example.bdiplus_assignmen.dao;

import com.example.bdiplus_assignmen.model.BankCustomer;

import java.util.List;
import java.util.Optional;



public interface BankCustomerDao {

    void addBankCustomer(BankCustomer customer);

    BankCustomer selectCustomerById(Integer customerId);

    List<BankCustomer> selectAllBankCustomer();

    BankCustomer updateBankUser(Integer userId, BankCustomer updatedUser);

    public void deleteBankCustomerById(Integer customerId);
}
