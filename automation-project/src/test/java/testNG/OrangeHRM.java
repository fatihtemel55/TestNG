package testNG;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrangeHRM {
	
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/fatihtemel/Documents/selenium dependencies/drivers/chromedriver");
		driver = new ChromeDriver();
	
	}
	
	@BeforeMethod
	public void bMethod() {
		driver.get("http://opensource.demo.orangehrmlive.com");
	}
	
	
	
	@Test
	public void titleVerification() {
		String expectedTitle = "Orange";
		System.out.println("Title: " + driver.getTitle());
		
		Assert.assertEquals( driver.getTitle(),expectedTitle, "Orange title verification failed: ");
		System.out.println("Title verification is done here");
	}
	
	@Test
	public void loginTest() {
		WebElement username = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		WebElement loginBtn = driver.findElement(By.id("btnLogin"));
		username.sendKeys("Admin");
		password.sendKeys("admin");
		loginBtn.click();
		
		String expectedUrl = "http://opensource.demo.orangehrmlive.com/index.php/dashboard";
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "App login failed: ");
		
		
	}
	
	@AfterClass
	public void closing() {
		//driver.quit();
	}
	
	
}
