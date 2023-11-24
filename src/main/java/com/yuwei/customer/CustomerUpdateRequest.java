package com.yuwei.customer;

public record CustomerUpdateRequest(
        String name,
        String email,
        Integer age
) {

}
