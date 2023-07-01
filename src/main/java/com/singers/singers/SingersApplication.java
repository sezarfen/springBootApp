package com.singers.singers;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SingersApplication {

	public static void main(String[] args) {
		SpringApplication.run(SingersApplication.class, args);
	}

	@PostConstruct
	public void startApp()
	{
		System.out.println("Server initialized!");
	}

	@PreDestroy
	public void closeApp()
	{
		System.out.println("App is closing.. see you next time :)");
	}
}
