package com.example.springjdbcbackend.services;

import com.example.springjdbcbackend.models.Department;
import com.example.springjdbcbackend.repositories.DepartmentTestRepository;
import com.example.springjdbcbackend.repositories.IRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentServiceTest {


    @Test
    void highestDepNo() {
        //Arrange
        IRepository<Department> testRepository = new DepartmentTestRepository();
        DepartmentService departmentService = new DepartmentService(testRepository);
        int expectedResult = 30;

        //Act
        int acutalResult = departmentService.highestDepNo();

        //Assert
        assertEquals(expectedResult, acutalResult);
    }
}