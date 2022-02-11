package ru.serdyuk.SpringbootBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication {

	public static void main(String[] args) {
		SpringApplication app = new  SpringApplication(SpringbootBackendApplication.class);
		app.setLazyInitialization(true);
		app.run(args);
	}

}
