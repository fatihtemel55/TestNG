package testNG;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	
WebDriver driver;
	
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@BeforeMethod
	public void bMethod() {
		driver.get("http://amazon.com");
	}
	
	@Test
	public void search() {
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("iphone");
		String expected = "iPhone";
		List<WebElement> lst = driver.findElements(By.xpath("//h2[contains(text(),'iPhone')]"));
		for (WebElement webElement : lst) {
			Assert.assertEquals(webElement, expected,"Search criteria does NOT match");
		}
		
	}
	
	@AfterClass
	public void end() {
		driver.quit();
	}
}