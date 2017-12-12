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


	//initialize some data in mongodb
	@Override
	public void run(String... args) {
		Map<String, String> data = new HashMap<>();
		data.put("login1", "mysecretpassword1");
		data.put("login2", "mysecretpassword2");
		data.put("login3", "mysecretpassword3");

		repository.deleteAll();

		// save a couple of users
		repository.save(new UserSet("14e3e222d", data));
		repository.save(new UserSet("14e3e657d", data));
		repository.save(new UserSet("14e3e657d", data));
	}
}
