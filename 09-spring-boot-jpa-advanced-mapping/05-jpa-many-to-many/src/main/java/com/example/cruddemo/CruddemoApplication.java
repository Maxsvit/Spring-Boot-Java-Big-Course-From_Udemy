package com.example.cruddemo;

import com.example.cruddemo.dao.AppDao;
import com.example.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);

	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){

		return  runner -> {

			//createCourseAndStudent(appDao);
			//findCourseAndStudents(appDao);
			//findStudentAndCourses(appDao);
			//addMoreCoursesForStudent(appDao);
			//deleteCourseById(appDao);
			deleteStudentById(appDao);

		};
	}

	private void deleteStudentById(AppDao appDao) {
		int theId = 10;
		appDao.deleteStudentById(theId);
	}


	private void addMoreCoursesForStudent(AppDao appDao) {
		int theId = 2;

		Student tempStudent = appDao.findStudentAndCoursesByStudentId(theId);

		Course tempCourse1 = new Course("My love course!");
		Course tempCourse2 = new Course("My love and warm course!");

		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);

		appDao.update(tempStudent);
	}

	private void findStudentAndCourses(AppDao appDao) {
		int theId = 10;
		Student student = appDao.findStudentAndCoursesByStudentId(theId);
		System.out.println(student);
		System.out.println(student.getCourses());

	}

	private void findCourseAndStudents(AppDao appDao) {

		int theId = 10;
		Course tmpCourse = appDao.findCourseAndStudentsByCourseId(theId);
		System.out.println(tmpCourse);
		System.out.println(tmpCourse.getStudents());
	}

	private void createCourseAndStudent(AppDao appDao) {

		Course tempCourse = new Course("FC24 - How to earn 100 000 coin?");

		Student student = new Student("Max","Ratulin","maxrat@gmail.com");
		Student student2 = new Student("Liza","Kalor","lizakalor@gmail.com");

		tempCourse.addStudent(student);
		tempCourse.addStudent(student2);

		appDao.save(tempCourse);
	}

	private void deleteCourseAndReviews(AppDao appDao) {
		int theId = 10;
		appDao.deleteCourseById(theId);
	}

	private void retrieveCourseAndReviews(AppDao appDao) {
		int theId = 10;
		Course tempCourse = appDao.findCourseAndReviewsByCourseId(theId);

		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
	}

	private void createCourseAndReviews(AppDao appDao) {
		Course tmpCourse = new Course("FC24 - How to win every game?");

		tmpCourse.addReview(new Review("This course very useful !!"));
		tmpCourse.addReview(new Review("This course very useful, thanks !!"));
		tmpCourse.addReview(new Review("This course very useful, thanks you are great !!"));

		appDao.save(tmpCourse);
	}

	private void deleteCourseById(AppDao appDao) {
		int theId = 1;
		appDao.deleteCourseById(theId);
	}

	private void updateCourse(AppDao appDao) {

		int theId = 1;

		Course tmpCourse = appDao.findCourseById(theId);
		tmpCourse.setTitle("Lariko");
		appDao.update(tmpCourse);
	}

	private void updateInstructor(AppDao appDao) {

		int theId = 1;

		Instructor tmpInstr = appDao.findById(theId);
		tmpInstr.setLastname("Borkowski");

		appDao.update(tmpInstr);

	}

	private void findInstructorWithCoursesJoinFetch(AppDao appDao) {

		int theid = 1;
		Instructor tempInstr = appDao.findInstructorByIdJoinFetch(theid);
		System.out.println(tempInstr);
		System.out.println(tempInstr.getCourses());
	}

	private void findCoursesForInstructor(AppDao appDao) {

		int theId = 1;
		Instructor tempInstr = appDao.findById(theId);
		System.out.println(tempInstr);
		List<Course> courses = appDao.findCoursesByInstructorId(theId);
		tempInstr.setCourses(courses);
		System.out.println(tempInstr.getCourses());

	}

	private void findInstructorWithCourses(AppDao appDao) {
		int theId = 1;

		Instructor tempInstr = appDao.findById(theId);

		System.out.println(tempInstr);
		System.out.println(tempInstr.getCourses());
	}

	private void createInstructorWithCourses(AppDao appDao) {
		Instructor tempInstr = new Instructor("Max","Vandam","maxvandam@example.com");
		InstructorDetail instructorDetail = new InstructorDetail("https://www.mychannel231.com/youtube","Luv to play football");

		tempInstr.setInstructorDetail(instructorDetail);
	}

	private void deleteInstructorDetail(AppDao appDao) {
		int theId = 7;

		appDao.deleteInstructorDetailById(theId);
	}

	private void findByIdInstructorDetail(AppDao appDao) {

		int theId = 6;
		InstructorDetail tmpInstructorDetail = appDao.findInstructorDetailById(theId);

		System.out.println(tmpInstructorDetail);
	}

	private void deleteInstructor(AppDao appDao) {

		int theId = 4;
		appDao.deleteInstructorById(theId);
	}

	private void findByIdConstructor(AppDao appDao) {
		int theId = 1;

		Instructor tempInst = appDao.findById(theId);
		System.out.println(tempInst);
		System.out.println("the associated instructorDetail only: " + tempInst.getInstructorDetail());
	}

	private void createInstructor(AppDao appDao) {
		Instructor tempInstr = new Instructor("Chad","Darby","darby@example.com");
		InstructorDetail instructorDetail = new InstructorDetail("https://www.mychannel.com/youtube","Luv to play football");

		tempInstr.setInstructorDetail(instructorDetail);
		appDao.save(tempInstr);

	}

}
