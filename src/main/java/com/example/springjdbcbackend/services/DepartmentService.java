package com.example.springjdbcbackend.services;

import com.example.springjdbcbackend.models.Department;
import com.example.springjdbcbackend.repositories.IRepository;

public class DepartmentService {

    private final IRepository<Department> repo;

    public DepartmentService(IRepository<Department> repo) {
        this.repo = repo;
    }

    public int highestDepNo(){
        int maxDepNo = 0;
        for (Department d : repo.getAllEntities()) {
            if (d.getDeptno() > maxDepNo){
                maxDepNo = d.getDeptno();
            }
        }
        return maxDepNo;
    }
}
