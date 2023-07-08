package com.musyimi.repair;

public record RepairRegistrationRequest(
        String name,
        String title,
        String brand,

        String issue,
        Integer phone_number
) {

}
