package com.example.springjdbcbackend.services;

import com.example.springjdbcbackend.models.Employee;
import com.example.springjdbcbackend.repositories.EmployeeTestRepository;
import com.example.springjdbcbackend.repositories.IRepository;

import java.util.List;

public class EmployeeService {

    private final IRepository<Employee> repo;

    public EmployeeService(IRepository<Employee> repo) {
        this.repo = repo;
    }

    public int averageSalaryFromTestData (){
        List<Employee> allEmployees = repo.getAllEntities();

        //Find average salary of all employees
        int averageSalary = 0;
        for (Employee e : allEmployees) {
            averageSalary += e.getSalary()/allEmployees.size();
        }
        return averageSalary;
    }

    public boolean hasSalaryAboveAverage(Employee employee){
        if (employee.getSalary() > averageSalaryFromTestData()){
            return true;
        }
        return false;
    }
}
