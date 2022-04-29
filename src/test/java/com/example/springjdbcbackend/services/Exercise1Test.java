package com.example.springjdbcbackend.services;

import com.example.springjdbcbackend.models.Employee;
import com.example.springjdbcbackend.repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise1Test {

    @Test
    void timeOfDay() {
        //Arrange
        Exercise1 ex1 = new Exercise1();
        String expectedDayOfTime = "night";
        int dayOfTime = 1;

        //Act
        String resultTimeOfDay = ex1.timeOfDay(dayOfTime);

        //Assert
        assertEquals(expectedDayOfTime, resultTimeOfDay);
    }

    @Test
    void validDepartmentNumber() {
        //Arrange
        Exercise1 ex2 = new Exercise1();
        int depNum = 880;
        boolean expectedResult = false;

        //Act
        boolean actualResult = ex2.validDepartmentNumber(depNum);

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void isValidSalary() {
        //Arrange
        Exercise1 ex3 = new Exercise1();
        EmployeeRepository er = new EmployeeRepository();
        int id = 7499;
        Employee employee = er.getSingleById(id);

        //Act
        boolean expectedResult = false;
        boolean actualResult = ex3.isValidSalary(employee);

        //Assert
        assertEquals(expectedResult, actualResult);
    }
}