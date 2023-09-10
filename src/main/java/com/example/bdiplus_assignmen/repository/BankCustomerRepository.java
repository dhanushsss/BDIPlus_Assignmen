package com.example.bdiplus_assignmen.repository;

import com.example.bdiplus_assignmen.model.BankCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BankCustomerRepository extends JpaRepository<BankCustomer , Integer  > {

}
