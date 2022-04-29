package com.example.springjdbcbackend.controllers;

import com.example.springjdbcbackend.models.Employee;
import com.example.springjdbcbackend.repositories.EmployeeRepository;
import com.example.springjdbcbackend.repositories.IRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Objects;

@Controller
public class EmployeeController {

    private final IRepository<Employee> employeeIRepository = new EmployeeRepository();

    @GetMapping("/employees")
    public String allEmployees(Model model){
        model.addAttribute("employees",employeeIRepository.getAllEntities());
        return "employees";
    }

    @GetMapping("/employee")
    public String getEmployee(Model model, @RequestParam int id){
        model.addAttribute("employee", employeeIRepository.getSingleById(id));
        return "employee";
    }

    @GetMapping("/create")
    public String getCreateEmployee(){
        return "createEmployee";
    }

    @PostMapping("/create")
    public String createEmployee(WebRequest request){
        String employee_name = request.getParameter("employee_name");
        String job = request.getParameter("job");
        int manager = Integer.parseInt(request.getParameter("manager"));
        Date hiredate = Date.valueOf(request.getParameter("hiredate"));
        int salary = Integer.parseInt(request.getParameter("salary"));
        int commission = Integer.parseInt(request.getParameter("commission"));
        int department_number = Integer.parseInt(Objects.requireNonNull(request.getParameter("department_number")));
        Employee employee = new Employee(employee_name, job, manager, hiredate, salary, commission, department_number);
        employeeIRepository.create(employee);
        return "redirect:/create";
    }

    @GetMapping("/employeesByDepartment")
    public String getAllEmployeesByDepartment(){
        return "employeesByDepartment";
    }

    //Doesn't work...yet
    @PostMapping("/employeesByDepartment")
    public String seeAllEmployeesByDepartment(Model model, WebRequest request){
        String department_name = request.getParameter("department_name");
        model.addAttribute("employees", employeeIRepository.getAllEntitiesByDepartment(department_name));
        return "redirect:/employeesByDepartment";
    }
}
