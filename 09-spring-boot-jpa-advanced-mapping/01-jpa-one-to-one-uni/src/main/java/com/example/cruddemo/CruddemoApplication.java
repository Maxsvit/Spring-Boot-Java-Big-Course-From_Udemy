package com.example.cruddemo;

import com.example.cruddemo.dao.AppDao;
import com.example.cruddemo.entity.Instructor;
import com.example.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);

	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){

		return  runner -> {
//			createConstructor(appDao);
//			findByIdConstructor(appDao);
			deleteInstructor(appDao);
		};
	}

	private void deleteInstructor(AppDao appDao) {

		int theId = 3;
		appDao.deleteInstructorById(theId);
	}

	private void findByIdConstructor(AppDao appDao) {
		int theId = 1;

		Instructor tempInst = appDao.findById(theId);
		System.out.println(tempInst);
		System.out.println("the associated instructorDetail only: " + tempInst.getInstructorDetail());
	}

	private void createConstructor(AppDao appDao) {
		Instructor tempInstr = new Instructor("Chad","Darby","darby@example.com");
		InstructorDetail instructorDetail = new InstructorDetail("https://www.mychannel.com/youtube","Luv to play football");

		tempInstr.setInstructorDetail(instructorDetail);
		appDao.save(tempInstr);

	}

}
