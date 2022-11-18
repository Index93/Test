package com.Test.Test;


import java.io.FileNotFoundException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) throws FileNotFoundException 
	{
		SpringApplication.run(TestApplication.class, args);

	
		Preberi preberi = new Preberi();
		preberi.Preberi();


	}

}




