package com.example.bdiplus_assignmen.service;

import com.example.bdiplus_assignmen.exception.ResourceNotFoundException;
import com.example.bdiplus_assignmen.model.BankCustomer;
import com.example.bdiplus_assignmen.repository.BankCustomerRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

public class BankCustomerServiceTest {

    @Mock
    private BankCustomerRepository bankCustomerRepository;

    @InjectMocks
    private BankCustomerService bankCustomerService =new BankCustomerServiceImpl();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addBankCustomer() {

        BankCustomer bankCustomer=new BankCustomer(1,"Dhanush","dhanush@gmail.com",
                "12345678","Dhanush",
                "Chennai","Dhnaush",1234567889L);
        when(bankCustomerRepository.save(bankCustomer)).thenReturn(bankCustomer);

        BankCustomer result=bankCustomerService.addBankCustomer(bankCustomer);
        Assertions.assertEquals(bankCustomer,result);

    }
    @Test
    void NegativeAddBankCustomer() {

        BankCustomer bankCustomer=new BankCustomer(1,null,"dhanush@gmail.com",
                "12345678","Dhanush",
                "Chennai","Dhnaush",1234567889L);

        Assertions.assertThrows(ResourceNotFoundException.class, () ->bankCustomerService.addBankCustomer(bankCustomer),"Customer name is required");

    }

    @Test
    void selectCustomerById() {
        BankCustomer bankCustomer=new BankCustomer(1,"Dhanush","dhanush@gmail.com",
                "12345678","Dhanush",
                "Chennai","Dhnaush",1234567889L);
        when( bankCustomerRepository.findById(bankCustomer.getCustomerId())).thenReturn(Optional.of(bankCustomer));

        BankCustomer result=bankCustomerService.selectCustomerById(bankCustomer.getCustomerId());
        Assertions.assertEquals(bankCustomer,result);
    }

    @Test
    void selectAllBankCustomer() {

        BankCustomer bankCustomer1=new BankCustomer(1,"Dhanush","dhanush@gmail.com",
                "12345678","Dhanush",
                "Chennai","Dhnaush",1234567889L);
        BankCustomer bankCustomer2=new BankCustomer(2,"Dhanush","dhanush@gmail.com",
                "12345678","Dhanush",
                "Chennai","Dhnaush",1234567889L);
        BankCustomer bankCustomer3=new BankCustomer(3,"Dhanush","dhanush@gmail.com",
                "12345678","Dhanush",
                "Chennai","Dhnaush",1234567889L);
        when( bankCustomerRepository.findAll()).thenReturn(Arrays.asList(bankCustomer1,bankCustomer2,bankCustomer3));

        List<BankCustomer> result=bankCustomerService.selectAllBankCustomer();
        Assertions.assertEquals(Arrays.asList(bankCustomer1,bankCustomer2,bankCustomer3),result);
    }

    @Test
    void updateBankUser() {
        BankCustomer bankCustomer=new BankCustomer(1,"Dhanush","dhanush@gmail.com",
                "12345678","Dhanush",
                "Chennai","Dhnaush",1234567889L);
        BankCustomer updatedBankCustomer=new BankCustomer(1,"Dhanush S","dhanush@gmail.com",
                "12345678","Dhanush",
                "Chennai","Dhnaush",1234567889L);
        when(bankCustomerRepository.findById(bankCustomer.getCustomerId())).thenReturn(Optional.of(bankCustomer));
        when(bankCustomerRepository.save(bankCustomer)).thenReturn(updatedBankCustomer);

        BankCustomer result=bankCustomerService.updateBankUser(bankCustomer.getCustomerId(), updatedBankCustomer);
        Assertions.assertEquals(updatedBankCustomer,result);
        Assertions.assertEquals(updatedBankCustomer.getCustomerName(),result.getCustomerName());
    }

    @Test
    void NegativeUpdatBankCustomer() {

        BankCustomer bankCustomer=new BankCustomer(1,"Dhanush","dhanush@gmail.com",
                "12345678","Dhanush",
                "Chennai","Dhnaush",1234567889L);

        Assertions.assertThrows(ResourceNotFoundException.class, () ->bankCustomerService.updateBankUser(bankCustomer.getCustomerId(),bankCustomer));

    }
    @Test
    void NegativeUpdatBankCustomerName() {

        BankCustomer bankCustomer=new BankCustomer(1,null,"dhanush@gmail.com",
                "12345678","Dhanush",
                "Chennai","Dhnaush",1234567889L);
        when(bankCustomerRepository.findById(bankCustomer.getCustomerId())).thenReturn(Optional.of(bankCustomer));

        Assertions.assertThrows(ResourceNotFoundException.class, () ->bankCustomerService.updateBankUser(bankCustomer.getCustomerId(),bankCustomer));

    }

    @Test
    void deleteBankCustomerById() {
        BankCustomer bankCustomer=new BankCustomer(1,"Dhanush","dhanush@gmail.com",
                "12345678","Dhanush",
                "Chennai","Dhnaush",1234567889L);
        when(bankCustomerRepository.existsById(bankCustomer.getCustomerId())).thenReturn(true);

        String result=bankCustomerService.deleteBankCustomerById(bankCustomer.getCustomerId());
        Assertions.assertEquals("Customer with ID" + bankCustomer.getCustomerId() + " deleted successfully.",result);
    }

    @Test
    void NegativeDeleteBankCustomer() {

        BankCustomer bankCustomer=new BankCustomer(1,"Dhanush","dhanush@gmail.com",
                "12345678","Dhanush",
                "Chennai","Dhnaush",1234567889L);

        Assertions.assertThrows(ResourceNotFoundException.class, () ->bankCustomerService.deleteBankCustomerById(bankCustomer.getCustomerId()),
                "Customer not found with id: " + bankCustomer.getCustomerId());

    }
}
