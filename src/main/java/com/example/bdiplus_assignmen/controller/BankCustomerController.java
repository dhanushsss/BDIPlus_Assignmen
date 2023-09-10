package com.example.bdiplus_assignmen.controller;

import com.example.bdiplus_assignmen.exception.ResourceNotFoundException;
import com.example.bdiplus_assignmen.model.BankCustomer;
import com.example.bdiplus_assignmen.service.BankCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/customers")
public class BankCustomerController {

    @Autowired
    private BankCustomerService customerService;

    @PostMapping("/addBankCustomer")
    private ResponseEntity<String> addBankCustomer(@RequestBody BankCustomer customer) {
        try {
            customerService.addBankCustomer(customer);
            return ResponseEntity.ok("Customer added successfully!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid customer data: " + e.getMessage());
        }
    }

    @GetMapping("{customerId}")
    public ResponseEntity<Object> getBankCustomerById(@PathVariable("customerId") Integer customerId) {
        try {
            BankCustomer customer = customerService.selectCustomerById(customerId);
            return ResponseEntity.ok(customer);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer with ID " + customerId + " not found");
        }
    }


    @PutMapping("/update/{customerId}")
    public ResponseEntity<String> updateCustomer(@PathVariable("customerId") Integer customerId, @RequestBody BankCustomer updatedCustomer) {
        try {
            BankCustomer updated = customerService.updateBankUser(customerId, updatedCustomer);
            return ResponseEntity.ok("Customer with ID " + customerId + " updated successfully.");
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid customer data: " + e.getMessage());
        }
    }


    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("customerId") Integer customerId) {
        try {
            customerService.deleteBankCustomerById(customerId);
            return ResponseEntity.ok("Customer with ID " + customerId + " deleted successfully.");
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer with ID " + customerId + " not found");
        }
    }


    @GetMapping("/AllBankCustomer")
    public ResponseEntity<List<BankCustomer>> getAllBankCustomer() {
        List<BankCustomer> customers = customerService.selectAllBankCustomer();
        return ResponseEntity.ok(customers);
    }
}
