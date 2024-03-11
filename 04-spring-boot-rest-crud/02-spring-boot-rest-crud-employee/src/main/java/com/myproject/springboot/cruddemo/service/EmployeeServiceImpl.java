package com.myproject.springboot.cruddemo.service;

import com.myproject.springboot.cruddemo.dao.EmployeeDAO;
import com.myproject.springboot.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO theEmployeeDao){
        employeeDAO = theEmployeeDao;
    }
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }


    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }
    @Transactional
    @Override
    public void deleteById(int theId) {
            employeeDAO.deleteById(theId);
    }
}
