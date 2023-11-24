package com.yuwei.customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository("list")
public class CustomerListDataAccessService implements CustomerDao{

    private static final List<Customer> customers;
    static {
        customers = new ArrayList<>();
        Customer alex = new Customer(
                1,
                "Alex",
                "a@gmail.com",
                30
        );
        customers.add(alex);

        Customer ana = new Customer(
                1,
                "Ana",
                "N@gmail.com",
                20
        );
        customers.add(ana);
    }
    @Override
    public List<Customer> selectAllCustomers() {
        return customers;
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        return customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    @Override
    public void insertCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public boolean existsPersonWithEmail(String email) {
        return customers.stream()
                .anyMatch(c -> c.getEmail().equals(email));
    }


    @Override
    public void deleteCustomerById(Integer customerId) {
        customers.stream()
                .filter(c -> c.getId().equals(customerId))
                        .findFirst().ifPresent(customers::remove);

    }

    @Override
    public boolean existsPersonWithId(Integer customerId) {
        return customers.stream()
                .anyMatch( c -> c.getId().equals(customerId));
    }

    @Override
    public void updateCustomer(Customer update) {
        customers.add(update);
    }


}
