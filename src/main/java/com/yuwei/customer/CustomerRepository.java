package com.yuwei.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    // existsCustomerByEmail is autocompleted by JPA query
    boolean existsCustomerByEmail(String email);

    boolean existsCustomerById(Integer customerId);
}
