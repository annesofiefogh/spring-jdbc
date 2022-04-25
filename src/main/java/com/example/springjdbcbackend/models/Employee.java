package com.example.springjdbcbackend.models;

import java.sql.Date;

public class Employee {
    private int id;
    private String employee_name;
    private String job;
    private int manager;
    private Date hiredate;
    private int salary;
    private int commission;
    private int department_number;

    public Employee(int id, String employee_name, String job, int manager, Date hiredate, int salary, int commission, int department_number) {
        this.id = id;
        this.employee_name = employee_name;
        this.job = job;
        this.manager = manager;
        this.hiredate = hiredate;
        this.salary = salary;
        this.commission = commission;
        this.department_number = department_number;
    }

    public Employee(String employee_name, String job, int manager, Date hiredate, int salary, int commission, int department_number) {
        this.employee_name = employee_name;
        this.job = job;
        this.manager = manager;
        this.hiredate = hiredate;
        this.salary = salary;
        this.commission = commission;
        this.department_number = department_number;
    }

    public int getId() {
        return id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public String getJob() {
        return job;
    }

    public int getManager() {
        return manager;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public int getSalary() {
        return salary;
    }

    public int getCommission() {
        return commission;
    }

    public int getDepartment_number() {
        return department_number;
    }

    @Override
    public String toString() {
        return "Employee{" +
               "ID=" + id +
               ", employee_name='" + employee_name + '\'' +
               ", job='" + job + '\'' +
               ", manager=" + manager +
               ", hiredate=" + hiredate +
               ", salary=" + salary +
               ", commission=" + commission +
               ", department_number=" + department_number +
               '}';
    }
}


