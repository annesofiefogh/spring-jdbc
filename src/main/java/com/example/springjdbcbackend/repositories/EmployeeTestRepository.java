package com.example.springjdbcbackend.repositories;

import com.example.springjdbcbackend.models.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeTestRepository implements IRepository<Employee> {

    ArrayList<Employee> allEmployeesTest = new ArrayList<>(
            Arrays.asList(
                    new Employee("HANS", "SALES", 9876, null, 2450, 0, 30),
                    new Employee("JAN", "ACCOUNTING", 5637, null, 3000, 0, 10),
                    new Employee("DAN", "RESEARCH", 1234, null, 4200, 0, 20),
                    new Employee("KARL", "SALES", 9887, null, 2100, 0, 30)
            )
    );

    @Override
    public List<Employee> getAllEntities() {
        return allEmployeesTest;
    }

    @Override
    public Employee getSingleById(int id) {
        return null;
    }

    @Override
    public boolean create(Employee entity) {
        return false;
    }

    @Override
    public List<Employee> getAllEntitiesByDepartment(String name) {
        return null;
    }
}
