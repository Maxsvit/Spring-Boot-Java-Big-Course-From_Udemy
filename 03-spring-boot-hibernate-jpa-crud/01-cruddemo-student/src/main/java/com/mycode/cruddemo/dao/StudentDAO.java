package com.mycode.cruddemo.dao;

import com.mycode.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);
    void update(Student student);
    void delete(Integer id);
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String LastName);
    int deleteAll();

}
