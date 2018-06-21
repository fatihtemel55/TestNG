package com.diced;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceJobSearch {
	public static void main(String[] args) {
		
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<String> search=new ArrayList<>();
		ArrayList<String> afterSearch=new ArrayList<>();

		try {
			fr = new FileReader("searching.txt");
			br = new BufferedReader(fr);
			String value;
			while ((value = br.readLine()) != null) {
				search.add(value);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e2) {
				// TODO: handle exception
			}

		}
		
		
		// Set uo chrome driver path
		WebDriverManager.chromedriver().setup();

		// Step 1. Launch browser and navigate to https://dice.commit
		// Expected: dice home page should Open

		WebDriver driver = new ChromeDriver();

		// full screen
		 driver.manage().window().maximize();

		// set universal wait time in case web page is slow
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String url = "https://www.dice.com/";
		driver.get(url);

		String actualTitle = driver.getTitle();
		String expectedTitle = "Job Search for Technology Professionals | Dice.com";

		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Step PASS. Dice homepage successfully loaded");
		} else {
			System.out.println("Step FAIL. Dice homepage did not load successfully");
			throw new RuntimeException("Step FAIL. Dice homepage did not load successfully");
		}
		
		
		
		for (int i = 0; i < search.size(); i++) {
			driver.findElement(By.id("search-field-location")).clear();
			driver.findElement(By.id("search-field-location")).sendKeys("60016");
			driver.findElement(By.id("search-field-keyword")).clear();
			driver.findElement(By.id("search-field-keyword")).sendKeys(search.get(i));
			driver.findElement(By.id("banner-inner")).click();
			driver.findElement(By.id("findTechJobs")).click();
			afterSearch.add(search.get(i)+" has "+driver.findElement(By.id("posiCountId")).getText()+" positions");	
			driver.navigate().to("https://www.dice.com/");
		}
		

		
		
//		String location = "77064";
//		driver.findElement(By.id("search-field-location")).clear();
//		driver.findElement(By.id("search-field-location")).sendKeys(location);
//		driver.findElement(By.id("findTechJobs")).click();

//		String count = driver.findElement(By.id("posiCountId")).getText();
//		System.out.println(count);

//		int countResult = Integer.parseInt(count.replaceAll(",", ""));
//		if (countResult > 0) {
//			System.out.println("Keyword:" + keyWord + "Search Result " + countResult + " result in :" + location);
//
//		} else {
//			System.out.println("Step Fail: " + keyWord + "Search result" + countResult + "result in " + location);
//
//		}

		driver.close();
		System.out.println(afterSearch);
		System.out.println("Test Completed "+LocalDateTime.now());

	}

}