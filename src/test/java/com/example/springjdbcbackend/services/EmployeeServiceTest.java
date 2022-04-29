package com.example.springjdbcbackend.services;

import com.example.springjdbcbackend.models.Employee;
import com.example.springjdbcbackend.repositories.EmployeeTestRepository;
import com.example.springjdbcbackend.repositories.IRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    @Test
    void hasSalaryAboveAverage() {
        //Arrange
        IRepository<Employee> testRepo = new EmployeeTestRepository();
        EmployeeService employeeService = new EmployeeService(testRepo);
        Employee employee = new Employee("GERT", "RESEARCH", 9845, null, 3000, 0, 10);

        //Act
        boolean expectedResult = employeeService.hasSalaryAboveAverage(employee);
        boolean actualResult = false;

        //Assert
        //assertEquals(expectedResult, actualResult);
        //assertFalse(expectedResult);
        assertTrue(expectedResult);

    }
}