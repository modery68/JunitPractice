package com.yuwei.customer;

public record CustomerRegistrationRequest(
        String name,
        String email,
        Integer age
) {

}
