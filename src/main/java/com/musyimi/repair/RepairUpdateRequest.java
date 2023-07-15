package com.musyimi.repair;

public record RepairUpdateRequest(
        String name,
        String title,
        String brand,
        Integer phoneNumber,
        String issue
) {
}
