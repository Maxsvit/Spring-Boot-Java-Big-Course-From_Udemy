package com.exampleaop.aopdemo;

import com.exampleaop.aopdemo.dao.AccountDAO;
import com.exampleaop.aopdemo.dao.MembershipDAO;
import com.exampleaop.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO,
											   MembershipDAO membershipDAO,
											   TrafficFortuneService trafficFortuneService){

		return runner ->{

			//demoTheBeforeAdvice(accountDAO,membershipDAO);
			//demoTheAfterReturningAdvice(accountDAO);
			//demoTheAfterThrowingAdvice(accountDAO);
			//demoTheAfterAdvice(accountDAO);
			//demoTheAroundAdvice(trafficFortuneService);
			//demoTheAroundAdviceHandleException(trafficFortuneService);
			demoTheAroundAdviceRethrowException(trafficFortuneService);
		};
	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n Main Program: demoTheAroundAdviceRethrowException");

		System.out.println("Calling getFortune()");

		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire);

		System.out.println("\n My fortune is: " +data);
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n Main Program: demoTheAroundAdviceHandleException");

		System.out.println("Calling getFortune()");

		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire);

		System.out.println("\n My fortune is: " +data);
	}

	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n Main Program: demoTheAroundAdvice");
		System.out.println("Calling getFortune()");

		String data = trafficFortuneService.getFortune();
		System.out.println("\n My fortune is: " +data);
	}

	private void demoTheAfterAdvice(AccountDAO accountDAO) {
		List<Account> theAccounts =null;

		try {
			boolean tripWire = false;
			theAccounts = accountDAO.findAccounts(tripWire);
		}catch (Exception exc){
			System.out.println("\n MainProgram: demoTheAfterThrowingAdvice: " + exc);

		}

		System.out.println("MainProgram: demoTheAfterThrowingAdvice: ");
		System.out.println("-----------");
		System.out.println(theAccounts);
	}

	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
		List<Account> theAccounts =null;

		try {
			boolean tripWire = true;
			theAccounts = accountDAO.findAccounts(tripWire);
		}catch (Exception exc){
			System.out.println("\n MainProgram: demoTheAfterThrowingAdvice: " + exc);

		}

		System.out.println("MainProgram: demoTheAfterThrowingAdvice: ");
		System.out.println("-----------");
		System.out.println(theAccounts);
	}

	private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {
		List<Account> theAccounts = accountDAO.findAccounts();

		System.out.println("MainProgram: demotheafterReturningAdvice: ");
		System.out.println("-----------");
		System.out.println(theAccounts);
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO,MembershipDAO membershipDAO) {

		Account account = new Account();
		account.setName("Madhu");
		account.setLevel("Platinum");
		boolean flag = true;
		accountDAO.addAccount(account,flag);
		accountDAO.doWork();

		accountDAO.setName("foobar");
		accountDAO.setServiceCode("silver");

		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();

		membershipDAO.addSillyMember();
		membershipDAO.goToSleep();
	}

}
