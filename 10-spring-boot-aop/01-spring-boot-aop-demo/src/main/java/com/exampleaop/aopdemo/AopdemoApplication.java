package com.exampleaop.aopdemo;

import com.exampleaop.aopdemo.dao.AccountDAO;
import com.exampleaop.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO){

		return runner ->{

			demoTheBeforeAdvice(accountDAO,membershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO,MembershipDAO membershipDAO) {

		Account account = new Account();
		boolean flag = true;
		accountDAO.addAccount(account,flag);
		accountDAO.doWork();

		membershipDAO.addSillyMember();
		membershipDAO.goToSleep();
	}

}
