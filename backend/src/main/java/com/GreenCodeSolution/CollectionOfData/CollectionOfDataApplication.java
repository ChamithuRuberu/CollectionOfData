package com.GreenCodeSolution.CollectionOfData;

import com.GreenCodeSolution.CollectionOfData.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CollectionOfDataApplication implements CommandLineRunner {
	@Autowired
	private UserRoleService userRoleService;

	public static void main(String[] args) {
		SpringApplication.run(CollectionOfDataApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		userRoleService.initializeRoles();//----
	}
}
