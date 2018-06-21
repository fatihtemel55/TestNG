package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WrongCredentialsTest {
	
	WebDriver driver;
	
	@BeforeClass
	
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
	}
	
//	@AfterClass
//	public void stup() {
//		driver.close();
//	}
	
	@BeforeMethod
	public void beforeMethod() {
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
	}

	@Test
	public void wrongCredentialsTest() throws InterruptedException {
		driver.findElement(By.id("email")).sendKeys("fatih@hotmail.com");
		driver.findElement(By.id("passwd")).sendKeys("123456"+Keys.ENTER);
		String a="Authentication failed.";
		String b=driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();
		Assert.assertTrue(b.contains(a));
	}
	@Test
	public void InvalidEmailAddress() {
		driver.findElement(By.id("email")).sendKeys("fatih@hotmail.com");
		driver.findElement(By.id("passwd")).sendKeys("123456"+Keys.ENTER);
		String a="Invalid email address.";
		String b=driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();
		Assert.assertTrue(b.contains(a));		
    }
	@Test
	public void AnemailAddressRequired() {
		driver.findElement(By.id("passwd")).sendKeys("123456"+Keys.ENTER);
		String a="An email address required.";
		String b=driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();
		Assert.assertTrue(b.contains(a));
	}
	@Test
	public void PasswordIsRequired() {
		driver.findElement(By.id("email")).sendKeys("fatih@hotmail.com"+Keys.ENTER);
		String a="Password is required.";
		String b=driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();
		System.out.println(b);
		Assert.assertTrue(b.contains(a));
		
	
	}
	
}