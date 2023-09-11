package com.example.bdiplus_assignmen.controller;

import com.example.bdiplus_assignmen.model.BankCustomer;
import com.example.bdiplus_assignmen.service.BankCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<BankCustomer> addBankCustomer(@RequestBody BankCustomer customer) {
        BankCustomer bankCustomerDao=customerService.addBankCustomer(customer);
        return ResponseEntity.ok(bankCustomerDao);

    }

    @GetMapping("{customerId}")
    public ResponseEntity<BankCustomer> getBankCustomerById(@PathVariable("customerId") Integer customerId) {
        BankCustomer customer = customerService.selectCustomerById(customerId);
        return ResponseEntity.ok(customer);
    }



    @PutMapping("/update/{customerId}")
    public ResponseEntity<String> updateCustomer(@PathVariable("customerId") Integer customerId, @RequestBody BankCustomer updatedCustomer) {
        BankCustomer updated = customerService.updateBankUser(customerId, updatedCustomer);
        return ResponseEntity.ok("Customer with ID " + customerId + " updated successfully.");

    }


    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("customerId") Integer customerId) {
        String message=customerService.deleteBankCustomerById(customerId);
        return ResponseEntity.ok(message);

    }


    @GetMapping("/AllBankCustomer")
    public ResponseEntity<List<BankCustomer>> getAllBankCustomer() {
        List<BankCustomer> customers = customerService.selectAllBankCustomer();
        return ResponseEntity.ok(customers);
    }
}
