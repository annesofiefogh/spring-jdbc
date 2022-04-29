package com.example.springjdbcbackend.repositories;

import com.example.springjdbcbackend.models.Department;
import com.example.springjdbcbackend.models.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DepartmentTestRepository implements IRepository<Department> {

    ArrayList<Department> allDempartmentsTest = new ArrayList<>(
            Arrays.asList(
                    new Department(10, "Dep1", "SAN FRAN"),
                    new Department(20, "Dep2", "SAN FRAN"),
                    new Department(30, "Dep3", "SAN FRAN"),
                    new Department(40, "Dep4", "SAN FRAN")
            )
    );

    @Override
    public List<Department> getAllEntities() {
        return allDempartmentsTest;
    }

    @Override
    public Department getSingleById(int id) {
        return null;
    }

    @Override
    public boolean create(Department entity) {
        return false;
    }

    @Override
    public List<Department> getAllEntitiesByDepartment(String name) {
        return null;
    }
}
