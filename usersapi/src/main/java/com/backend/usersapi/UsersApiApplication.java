package com.backend.usersapi;

import com.backend.usersapi.models.UserSet;
import com.backend.usersapi.repositories.UserSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class UsersApiApplication implements CommandLineRunner {

	@Autowired
	UserSetRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(UsersApiApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Map<String, String> pass = new HashMap<>();
		pass.put("login1", "pass1");
		pass.put("login2", "pass2");
		pass.put("login3", "pass3");

		repository.deleteAll();

		// save a couple of users
		repository.save(new UserSet("14e3e222d", pass));
		repository.save(new UserSet("14e3e657d", pass));
		repository.save(new UserSet("14e3e657d", pass));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (UserSet userSet : repository.findAll()) {
			System.out.println(userSet);
		}
		System.out.println();

		// fetch an individual user
		System.out.println("User found with identifier('14e3e222d'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByUserIdentifier("14e3e222d"));

		System.out.println("all users identifiers");
		System.out.println("--------------------------------");
		List<UserSet> list = repository.findAll();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getUserIdentifier());
		}


	}
}
