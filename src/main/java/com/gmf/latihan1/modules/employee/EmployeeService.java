package com.gmf.latihan1.modules.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeEntity> showAllEmployees() {
        return employeeRepository.findAll();
    }

    public EmployeeEntity getSingleEmployee(String employeeId) {
        return employeeRepository.findById(employeeId).get();
    }

    @Transactional
    public EmployeeEntity createNewEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    public EmployeeEntity updateExistingEmployee(String employeeId, EmployeeEntity employeeEntity) throws Exception {

        EmployeeEntity employee = getSingleEmployee(employeeId);

        if(employee == null) throw new Exception("Employee Doesn't Exist");

        System.out.println("Saving Employee");

        return employeeRepository.save(employeeEntity);
    }

    public void deleteEmployee(String employeeId) {
        employeeRepository.deleteById(employeeId);
    }

}
