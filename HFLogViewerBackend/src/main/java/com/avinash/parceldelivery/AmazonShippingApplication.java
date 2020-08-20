/**
 * Spring Boot Main class for starting the application.
 * @author Avinash Tingre
 */

package com.avinash.parceldelivery;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AmazonShippingApplication {
	
	private static final Logger LOG = LoggerFactory.getLogger(AmazonShippingApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(AmazonShippingApplication.class, args);
	}
	

}
