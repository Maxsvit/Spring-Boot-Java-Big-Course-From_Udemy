package com.myproject.springboot.cruddemo.dao;

import com.myproject.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager thentityManager){
        entityManager = thentityManager;
    }


    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
        List<Employee> employees = theQuery.getResultList();

        return employees;

    }

    @Override
    public Employee findById(int theId) {
        Employee employee = entityManager.find(Employee.class,theId);

        return employee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee employee = entityManager.merge(theEmployee);

        return employee;
    }

    @Override
    public void deleteById(int theId) {

        Employee employee = entityManager.find(Employee.class,theId);
        entityManager.remove(employee);

    }
}
