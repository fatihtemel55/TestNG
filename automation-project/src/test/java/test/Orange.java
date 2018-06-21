package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Orange {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/fatihtemel/Documents/selenium dependencies/drivers");
		
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    driver.get("http://opensource.demo.orangehrmlive.com");
	    String searchTitle = "OrangeHRM";
	    
	    WebElement input = driver.findElement(By.xpath("/html/head/title"));
	    Thread.sleep(1000);
	    String actual = driver.getTitle();
	    System.out.println(actual);
	    
	    if (actual.equals(searchTitle)) {
		      System.out.println("pass");
		    } else {
		      System.out.println("fail");
		    }
	    Thread.sleep(1000);
	    WebElement usename = driver.findElement(By.id("txtUsername"));
	    Thread.sleep(1000);
	    driver.findElement(By.name("txtUsername")).sendKeys("Admin");
	    Thread.sleep(1000);
	    WebElement password = driver.findElement(By.id("txtPassword"));
	    Thread.sleep(1000);
	    driver.findElement(By.name("txtPassword")).sendKeys("admin");
	    Thread.sleep(1000);
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(1000);


	    if (actual.equals(searchTitle)) {
		      System.out.println("pass");
		    } else {
		      System.out.println("fail");
		      System.out.println("expected:\t"+searchTitle);
		      System.out.println("found:\t"+actual);

	}

	}

	
}
