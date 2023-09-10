package com.example.bdiplus_assignmen.service;


import com.example.bdiplus_assignmen.dao.BankCustomerDao;
import com.example.bdiplus_assignmen.exception.ResourceNotFoundException;
import com.example.bdiplus_assignmen.model.BankCustomer;
import com.example.bdiplus_assignmen.repository.BankCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankCustomerService implements BankCustomerDao {

    @Autowired
    private BankCustomerRepository bankCustomerRepository;

    public void addBankCustomer(BankCustomer customer) {
        // Validate input data before saving
        validateCustomerData(customer);

        // Save the customer
        bankCustomerRepository.save(customer);
    }

    @Override
    public BankCustomer selectCustomerById(Integer customerId) {
        return bankCustomerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + customerId));
    }

    @Override
    public List<BankCustomer> selectAllBankCustomer() {
        return bankCustomerRepository.findAll();
    }

    @Override
    public BankCustomer updateBankUser(Integer userId, BankCustomer updatedUser) {
        // Check if the user exists
        BankCustomer existingUser = bankCustomerRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        // Validate and update the fields you want to change
        validateCustomerData(updatedUser);

        existingUser.setCustomerName(updatedUser.getCustomerName());
        existingUser.setCustomerEmail(updatedUser.getCustomerEmail());
        existingUser.setCustomerPhoneNumber(updatedUser.getCustomerPhoneNumber());
        existingUser.setCustomerPassword(updatedUser.getCustomerPassword());
        existingUser.setCustomerAddress(updatedUser.getCustomerAddress());
        existingUser.setCustomerUserName(updatedUser.getCustomerUserName());
        existingUser.setCustomerCardNo(updatedUser.getCustomerCardNo());

        // Save the updated user
        return bankCustomerRepository.save(existingUser);
    }

    @Override
    public void deleteBankCustomerById(Integer customerId) {
        // Check if the task exists
        if (!bankCustomerRepository.existsById(customerId)) {
            throw new ResourceNotFoundException("Customer not found with id: " + customerId);
        }

        // Delete the customer by ID
        bankCustomerRepository.deleteById(customerId);
    }

    private void validateCustomerData(BankCustomer customer) {
        // Implement your validation logic here
        // Example: Check if required fields are not empty, validate email format, etc.
        if (customer.getCustomerName() == null || customer.getCustomerName().isEmpty()) {
            throw new IllegalArgumentException("Customer name is required.");
        }

    }
}
