package br.com.cipher.loans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"br.com.cipher.loans.service"})
@ComponentScan({"br.com.cipher.loans.repository"})
@ComponentScan({"br.com.cipher.loans.controller"})
@SpringBootApplication
public class CipherLoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(CipherLoansApplication.class, args);
	}
}
