package com.chipher.loans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
@SpringBootApplication
public class CipherLoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(CipherLoansApplication.class, args);
	}
}
