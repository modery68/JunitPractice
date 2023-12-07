package com.yuwei.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;


class CustomerJPADataAccessServiceTest {

    private CustomerJPADataAccessService underTest;
    private AutoCloseable autoCloseable;
    @Mock
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new CustomerJPADataAccessService(customerRepository);
    }

    @AfterEach
    void tearDown() throws Exception{
        //close resource
        autoCloseable.close();
    }

    @Test
    void selectAllCustomers() {
        // Given

        underTest.selectAllCustomers();

        // Then
        verify(customerRepository)
                .findAll();
    }

    @Test
    void selectCustomerById() {
        // Given
        int id = 1;

        // When
        underTest.selectCustomerById(id);

        // Then
        verify(customerRepository).findById(id);
    }

    @Test
    void insertCustomer() {
        // Given
        Customer customer = new Customer(
                1,"abc", "cd@gmail.com", 2);
        // When
        underTest.insertCustomer(customer);
        // Then
        verify(customerRepository).save(customer);
    }

    @Test
    void existsPersonWithEmail() {
        // Given
        String email = "a@gmail.com";
        // When
        underTest.existsPersonWithEmail(email);
        // Then
        verify(customerRepository).existsCustomerByEmail(email);
    }

    @Test
    void deleteCustomerById() {
        // Given
        int id = 1;
        // When
        underTest.deleteCustomerById(id);

        // Then
        verify(customerRepository).deleteById(id);
    }

    @Test
    void existsPersonWithId() {
        // Given
        int id = 1;
        // When
        underTest.existsPersonWithId(id);
        // Then
        verify(customerRepository).existsCustomerById(id);
    }

    @Test
    void updateCustomer() {
        Customer customer = new Customer(
                1,"abec", "ced@gmail.com", 2);
        // When
        underTest.updateCustomer(customer);
        // Then
        verify(customerRepository).save(customer);
    }
}