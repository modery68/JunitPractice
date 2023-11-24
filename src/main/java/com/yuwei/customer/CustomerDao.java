package com.yuwei.customer;

import com.yuwei.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface CustomerDao {
    List<Customer> selectAllCustomers();
    Optional<Customer> selectCustomerById(Integer id);
    void insertCustomer(Customer customer);
    boolean existsPersonWithEmail(String email);
    void deleteCustomerById(Integer id);
    boolean existsPersonWithId(Integer customerId);
    void updateCustomer(Customer update);

}
