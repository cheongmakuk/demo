package mkc.exercise.ac1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the demo of RESTful api application for University of Cardiff
 * 
 * @author kcmak
 *
 */

@SpringBootApplication
public class Ac1Application {
	public static void main(String[] args) {
		SpringApplication.run(Ac1Application.class, args);
		System.out.println("Ac1 application started!");
	}
}
