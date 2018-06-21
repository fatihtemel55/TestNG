package com.cbt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/fatihtemel/Documents/selenium dependencies/drivers/chromedriver");
		
		
		WebDriver driver = new ChromeDriver();
	driver.get("http://facebook.com");	
	}

}
