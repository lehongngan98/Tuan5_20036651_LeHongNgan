package com.se.employeeservice.model;

import java.io.Serializable;

public record Employee(
        Long id,
        Long departmentId,
        String name,
        int age,
        String position
) implements Serializable {
}
