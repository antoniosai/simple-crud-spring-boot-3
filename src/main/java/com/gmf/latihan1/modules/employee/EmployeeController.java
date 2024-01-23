package com.gmf.latihan1.modules.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping()
    public List<EmployeeEntity> showAllEmployees() {
        return employeeService.showAllEmployees();
    }

    @GetMapping("/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable String employeeId) {
        return employeeService.getSingleEmployee(employeeId);
    }

    @PutMapping("/{employeeId}")
    public EmployeeEntity updateEmployee(@PathVariable String employeeId, @RequestBody EmployeeEntity employeeData) throws Exception {
        return employeeService.updateExistingEmployee(employeeId, employeeData);
    }

    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity newEmployee) {
        return employeeService.createNewEmployee(newEmployee);
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable String employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

}
