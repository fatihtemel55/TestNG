package com.cybertek;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyTitle {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    driver.get("http://opensource.demo.orangehrmlive.com");
	    String searchTitle = "OrangeHRM";
	    
	    WebElement input = driver.findElement(By.xpath("/html/head/title"));
	    
	    String actual = input.getAttribute("title");
	    System.out.println(actual);
	    
	    
	    
	    if (actual.equals(searchTitle)) {
		      System.out.println("pass");
		    } else {
		      System.out.println("fail");
		      System.out.println("expected:\t"+searchTitle);
		      System.out.println("found:\t"+actual);

	}

}
}
