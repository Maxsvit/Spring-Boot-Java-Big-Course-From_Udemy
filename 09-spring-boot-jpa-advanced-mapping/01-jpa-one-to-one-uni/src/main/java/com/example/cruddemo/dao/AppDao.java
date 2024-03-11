package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Instructor;

public interface AppDao {

    void save(Instructor instructor);
    Instructor findById(int theId);
    void deleteInstructorById(int theId);
}
