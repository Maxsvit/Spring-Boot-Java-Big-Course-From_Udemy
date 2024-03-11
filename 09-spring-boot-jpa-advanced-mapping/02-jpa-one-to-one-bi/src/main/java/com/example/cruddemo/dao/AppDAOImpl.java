package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Instructor;
import com.example.cruddemo.entity.InstructorDetail;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppDAOImpl  implements AppDao{

    private EntityManager entityManager;

    public AppDAOImpl(EntityManager theentityManager){
        this.entityManager = theentityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);

    }

    @Override
    public Instructor findById(int theId) {

        return entityManager.find(Instructor.class,theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
            Instructor tempInstructor = entityManager.find(Instructor.class,theId);

            entityManager.remove(tempInstructor);

    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class,theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        InstructorDetail tmpInstructorDetail = entityManager.find(InstructorDetail.class,theId);

        tmpInstructorDetail.getInstructor().setInstructorDetail(null);

        entityManager.remove(tmpInstructorDetail);

    }
}
