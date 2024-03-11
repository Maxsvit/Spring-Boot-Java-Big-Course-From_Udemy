package com.example.cruddemo;

import com.example.cruddemo.dao.AppDao;
import com.example.cruddemo.entity.Course;
import com.example.cruddemo.entity.Instructor;
import com.example.cruddemo.entity.InstructorDetail;
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
//			createInstructor(appDao);
//			findByIdConstructor(appDao);
//			deleteInstructor(appDao);
//			findByIdInstructorDetail(appDao);
//			deleteInstructorDetail(appDao);
//			createInstructorWithCourses(appDao);
//			findInstructorWithCourses(appDao);
//			findCoursesForInstructor(appDao);
//			findInstructorWithCoursesJoinFetch(appDao);
//			updateInstructor(appDao);
//			updateCourse(appDao);
			deleteCourseById(appDao);

		};
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
