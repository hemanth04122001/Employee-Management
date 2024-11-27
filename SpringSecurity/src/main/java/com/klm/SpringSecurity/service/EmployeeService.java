package com.klm.SpringSecurity.service;


import com.klm.SpringSecurity.model.Employee;
import com.klm.SpringSecurity.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee employee;

    public List<Employee> getEmployee(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeByID(int id){
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee getEmployeeByName(String name){
        return employeeRepository.findByName(name);
    }

    @Transactional(rollbackFor =  Exception.class)
    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    @Transactional(rollbackFor =  Exception.class)
    public List<Employee> saveEmployees(List<Employee> employees){
        return  employeeRepository.saveAll(employees);
    }

    @Transactional(rollbackFor = Exception.class)
    public Employee updateEmployee(Employee employee) {

            Employee existingEmployee = employeeRepository.findById(employee.getId()).orElse(null);
            existingEmployee.setName(employee.getName());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setPhone(employee.getPhone());
            existingEmployee.setCreated_by(employee.getCreated_by());
            existingEmployee.setCreated_on(employee.getCreated_on());

            return employeeRepository.save(existingEmployee);
    }


    @Transactional(rollbackFor = Exception.class)
    public String deleteById(int id){
        employeeRepository.deleteById(id);
        return "Employee Deleted .... "+id;
    }
}
