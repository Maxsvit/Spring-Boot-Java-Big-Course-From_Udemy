package com.mycode.cruddemo;

import com.mycode.cruddemo.dao.StudentDAO;
import com.mycode.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);\
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		int numsRow = studentDAO.deleteAll();
		System.out.println("Delete row count: " + numsRow);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int id = 2;
		studentDAO.delete(id);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int id = 1;
		Student student = studentDAO.findById(id);
		student.setFirstName("Max");
		studentDAO.update(student);
		System.out.println("Hi, program is completed");
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Burdo");

		for (Student s : theStudents){
			System.out.println(s);
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();

		for (Student s : theStudents){
			System.out.println(s);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		Student student1 = new Student("Anastasia","Burdo","burdoa@gmail.com");
		studentDAO.save(student1);

		int id = student1.getId();
		System.out.println("Saved student. Generated id for this student: " + id);

		Student foundStudent = studentDAO.findById(id);
		System.out.println("Found the student: " + foundStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		System.out.println("Creating 3 students ...");
		Student student1 = new Student("John","Lay","john@gmail.com");
		Student student2 = new Student("Boris","Worston","borisw@gmail.com");
		Student student3 = new Student("Natalia","Kiddle","nataliak@gmail.com");

		System.out.println("Saving 3 students ...");

		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {

		System.out.println("Creating new student object...");
		Student student1 = new Student("Max","Doe","nasd@gmail.com");

		System.out.println("Saving new student object...");
		studentDAO.save(student1);

		System.out.println("Saved student. Genereated id: " + student1.getId());
	}

}
