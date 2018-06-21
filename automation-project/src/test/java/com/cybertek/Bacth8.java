package com.cybertek;

import com.github.javafaker.Faker;

public class Bacth8 {
	
	public static void main(String[] args) {
		System.out.println("sadff");
		
		Faker faker = new Faker();
		String creditCard = faker.book().author();
			System.out.println(creditCard);
			
			System.out.println(faker.chuckNorris().fact());
		
		
	}

}
