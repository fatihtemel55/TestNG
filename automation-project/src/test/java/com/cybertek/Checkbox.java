package com.cybertek;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkbox {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		//1. open browser
		WebDriver driver = new ChromeDriver();
		//2. goto internet.com 
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		
		WebElement checkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
		WebElement checkbox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		
		//System.out.println(checkbox1.isSelected());
	
		//3. verify if first box is not selected
		if(!checkbox1.isSelected()) {
			System.out.println("step 3 PASSED. box 1 is not selected");
		}else {
			System.out.println("step 3 failed");
		}
        //4. verify if checkbox2 is selected
		if(checkbox2.isSelected()) {
			System.out.println("step 2 PASSED. box2 is selected");
		}else {
			System.out.println("step 3 failed");
		}
		//5. click on checkbox1
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    checkbox1.click();
	    System.out.println("step 5. check first box");
		
	
		
		//6. verify checkbox1 is selected
		if(checkbox1.isSelected()) {
			System.out.println("step 6 PASSED. box 1 is selected");
		} else {
			System.out.println("step 6 failed");
		}
		//7. verify second box is selected
		if(checkbox2.isSelected())
			System.out.println("step 7 PASSED. chechbox 2 is selected");
		//8. click on check box 2 
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		checkbox2.click();
		System.out.println("step 8. uncheck second box");
		//9 verify that first box is selected
		if(checkbox1.isSelected()) {
			System.out.println("step 9 PASSED. checkbox 1 is selected");
		}else {
        System.out.println("step 9 failed. checkbox 1 is not selected");
		}
		//10. verify box 2 is not selected
		if(!checkbox2.isSelected()) {
			System.out.println("step 10 PASSED. checkbox 2 is not selected");
		} else {
        System.out.println("step 10 failed. checkbox 2 is selected");
		}
		
		
		driver.close();
	}	
	}