package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Course;
import com.example.cruddemo.entity.Instructor;
import com.example.cruddemo.entity.InstructorDetail;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

            List<Course> tmpCourse = tempInstructor.getCourses();

            for(Course course: tmpCourse){
                course.setInstructor(null);
            }

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

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {

        TypedQuery<Course> query = entityManager.createQuery(
                "from Course  where instructor.id = :data", Course.class
        );
        query.setParameter("data",theId);

        List<Course> courses = query.getResultList();

        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i " +
                        " join fetch i.courses " +
                        "join fetch i.instructorDetail " +
                        "where  i.id = :data", Instructor.class
        );
        query.setParameter("data",theId);

        Instructor tempInstructor = query.getSingleResult();

        return tempInstructor;
    }

    @Override
    @Transactional
    public void update(Instructor instructorTmp) {
        entityManager.merge(instructorTmp);
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(int theId) {
       return entityManager.find(Course.class,theId);

    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {
        Course tmpCourse = entityManager.find(Course.class,theId);

        entityManager.remove(tmpCourse);
    }

    @Override
    @Transactional
    public void save(Course theCourse) {
        entityManager.persist(theCourse);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int theId) {
        TypedQuery<Course> courseTypedQuery = entityManager.createQuery(
                "select c from Course c " + "join fetch c.reviews " + "where c.id = :data", Course.class
        );
        courseTypedQuery.setParameter("data",theId);

        Course course = courseTypedQuery.getSingleResult();

        return course;
    }
}
