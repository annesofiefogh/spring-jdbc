package com.example.springjdbcbackend.repositories;

import com.example.springjdbcbackend.models.Employee;
import com.example.springjdbcbackend.utility.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IRepository<Employee> {

    @Override
    public List<Employee> getAllEntities() {
        Connection conn = DatabaseConnectionManager.getConnection();
        List<Employee> allEmployees = new ArrayList<>();
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employees");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Employee temp = new Employee(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDate(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8)
                );
                allEmployees.add(temp);
            }

        } catch(SQLException e){
            System.out.println("Something wrong in statement");
            e.printStackTrace();
        }
        return allEmployees;
    }

    @Override
    public Employee getSingleById(int id) {
        Connection conn = DatabaseConnectionManager.getConnection();
        try{
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employees WHERE id = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Employee oneEmployee = new Employee(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDate(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8)
                );
                return oneEmployee;
            }
            return null;
        } catch (SQLException e){
            System.out.println("Something wrong in statement");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean create(Employee entity) {
        Connection conn = DatabaseConnectionManager.getConnection();
        try{
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO employees(`employee_name`,`job`,`manager`,`hiredate`,`salary`,`commission`,`department_number`) VALUES (?,?,?,?,?,?,?)");
            pstmt.setString(1, entity.getEmployee_name());
            pstmt.setString(2, entity.getJob());
            pstmt.setInt(3, entity.getManager());
            pstmt.setDate(4, entity.getHiredate());
            pstmt.setInt(5, entity.getSalary());
            pstmt.setInt(6, entity.getCommission());
            pstmt.setInt(7, entity.getDepartment_number());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public List<Employee> getAllEntitiesByDepartment(String department_name){
        Connection conn = DatabaseConnectionManager.getConnection();
        List<Employee> employeesByDepartment = new ArrayList<>();
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM departments, employees WHERE departments.department_number = employees.department_number AND departments.department_name = ?");
            pstmt.setString(1, department_name);
            pstmt.execute();
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                Employee temp = new Employee(
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getDate(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getInt(11)
                );
                employeesByDepartment.add(temp);
            }
        } catch (SQLException e){
            System.out.println("Something wrong in statement");
            e.printStackTrace();
        }
        return employeesByDepartment;
    }
}

