package com.naveenautomationlabs.Pages;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class CommonUtilities {
	
	String[] firstName = {"Thomas", "Peter","Xavier"};
	String[] lastName = {"George", "Johnson","James"};
	String[] city = {"Brampton","London", "Toronto","Waterloo"};
	

	public String getRandomFirstName() {
		return firstName[generateRandomNumber(firstName.length)];
	}
	
	public String getRandomLastName() {
		return lastName[generateRandomNumber(lastName.length)];
	}
	
	public String getRandomCityName() {
		return city[generateRandomNumber(city.length)];
	}
	
	public String getRandomPostalCode() {
		return RandomStringUtils.randomAlphanumeric(6);
	}
	
	private int generateRandomNumber(int limit) {
		Random random = new Random();
		return random.nextInt(limit);
	}
}
