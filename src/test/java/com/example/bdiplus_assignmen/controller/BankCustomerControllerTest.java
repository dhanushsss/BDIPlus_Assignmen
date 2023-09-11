package com.example.bdiplus_assignmen.controller;

import com.example.bdiplus_assignmen.model.BankCustomer;
import com.example.bdiplus_assignmen.service.BankCustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import static org.mockito.Mockito.when;

class BankCustomerControllerTest {

    @Mock
    private BankCustomerService bankCustomerService;

    @InjectMocks
    private BankCustomerController bankCustomerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addCustomer() {


        BankCustomer bankCustomer=new BankCustomer(1,"Dhanush","dhanush@gmail.com",
                "12345678","Dhanush",
                "Chennai","Dhnaush",1234567889L);
        when(bankCustomerService.addBankCustomer(bankCustomer)).thenReturn(bankCustomer);

        ResponseEntity<BankCustomer> result=bankCustomerController.addBankCustomer(bankCustomer);
        Assertions.assertEquals(bankCustomer,result.getBody());
        Assertions.assertEquals( HttpStatus.OK,result.getStatusCode());



    }
    @Test
    void getBankCustomerById() {
        BankCustomer bankCustomer=new BankCustomer(1,"Dhanush","dhanush@gmail.com",
                "12345678","Dhanush",
                "Chennai","Dhnaush",1234567889L);
        when(bankCustomerService.selectCustomerById(bankCustomer.getCustomerId())).thenReturn(bankCustomer);

        ResponseEntity<BankCustomer> result=bankCustomerController.getBankCustomerById(bankCustomer.getCustomerId());
        Assertions.assertEquals(bankCustomer,result.getBody());
        Assertions.assertEquals( HttpStatus.OK,result.getStatusCode());


    }

    @Test
    void updateCustomer() {
        BankCustomer bankCustomer=new BankCustomer(1,"Dhanush","dhanush@gmail.com",
                "12345678","Dhanush",
                "Chennai","Dhnaush",1234567889L);
        when(bankCustomerService.updateBankUser(bankCustomer.getCustomerId(),bankCustomer)).thenReturn(bankCustomer);

        ResponseEntity<String> result=bankCustomerController.updateCustomer(bankCustomer.getCustomerId(),bankCustomer);
        Assertions.assertEquals("Customer with ID " + bankCustomer.getCustomerId() + " updated successfully.",result.getBody());
        Assertions.assertEquals( HttpStatus.OK,result.getStatusCode());
    }

    @Test
    void deleteCustomer() {
        BankCustomer bankCustomer=new BankCustomer(1,"Dhanush","dhanush@gmail.com",
                "12345678","Dhanush",
                "Chennai","Dhnaush",1234567889L);
        when(bankCustomerService.deleteBankCustomerById(bankCustomer.getCustomerId())).thenReturn("Customer with ID " + bankCustomer.getCustomerId() + " deleted successfully.");

        ResponseEntity<String> result=bankCustomerController.deleteCustomer(bankCustomer.getCustomerId());
        Assertions.assertEquals("Customer with ID " + bankCustomer.getCustomerId() + " deleted successfully.",result.getBody());
        Assertions.assertEquals( HttpStatus.OK,result.getStatusCode());
    }

    @Test
    void getAllBankCustomer() {

        BankCustomer bankCustomer=new BankCustomer(1,"Dhanush","dhanush@gmail.com",
                "12345678","Dhanush",
                "Chennai","Dhnaush",1234567889L);
        when(bankCustomerService.selectAllBankCustomer()).thenReturn(List.of(bankCustomer));

        ResponseEntity<List<BankCustomer>> result=bankCustomerController.getAllBankCustomer();
        Assertions.assertEquals(List.of(bankCustomer),result.getBody());
        Assertions.assertEquals( HttpStatus.OK,result.getStatusCode());
    }
}