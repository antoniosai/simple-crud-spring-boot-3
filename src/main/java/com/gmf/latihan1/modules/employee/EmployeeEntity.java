package com.gmf.latihan1.modules.employee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    @Column(name = "employee_id", nullable = false, unique = true)
    private String employeeId;

    @Column(name = "employee_name", nullable = false)
    private String name;
}
