package com.example.springjdbcbackend.services;

import com.example.springjdbcbackend.models.Employee;

public class Exercise1 {

    //1
    public String timeOfDay(int time){
        if (time >= 5 && time < 12){
            return "morning";
        } else if (time >= 12 && time < 16){
            return "afternoon";
        } else if (time >= 16 && time < 22){
            return "evening";
        }
        return "night";
    }

    //2
    public boolean validDepartmentNumber(int number){
        if (number >= 10 && number <= 990 && number % 10 == 0){
            return true;
        }
        return false;
    }

    //3
    public boolean isValidSalary(Employee employee){

        if(employee.getSalary() <= employee.getCommission()){
            return false;
        }
        return true;
    }

    //4


}
