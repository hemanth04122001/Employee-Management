package com.klm.SpringSecurity.controller;

import com.klm.SpringSecurity.model.Employee;
import com.klm.SpringSecurity.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/admin/getAllEmps")
    public List<Employee> findEmployees() {
        return employeeService.getEmployee();
    }

    @GetMapping("/user/getEmpByID/{id}")
    public Employee findEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeByID(id);
    }

    @GetMapping("/user/getEmpByName/{name}")
    public Employee findEmployeeByName(@PathVariable String name) {
        return employeeService.getEmployeeByName(name);
    }

    @PostMapping("/admin/addEmp")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PostMapping("/admin/addEmployees")
    public List<Employee> saveEmployees(@RequestBody List<Employee> employees) {
        return employeeService.saveEmployees(employees);
    }

    @PutMapping("/admin/update")
    public String updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
        return "Employee Updated ";
    }

    @DeleteMapping("/admin/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.deleteById(id);
        return "Employee Deleted With ID : " + id;
    }
}
