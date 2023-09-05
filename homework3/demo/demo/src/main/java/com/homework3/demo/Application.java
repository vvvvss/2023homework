package com.homework3.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Application {


	public static void main(String[] args) {
		KeelungSightsCrawler crawler = null;
		try {
			crawler = new KeelungSightsCrawler();
		} catch (IOException e) {
			System.err.println(e);
			System.out.println("error");
			System.exit(0);
		}
		Sight[] sights = crawler.getItems("七堵");
		for (Sight s : sights) {
			System.out.println(s);
		}
		SpringApplication.run(Application.class, args);
	}

}
