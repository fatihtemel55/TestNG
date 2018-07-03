package TestingFacebook;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestingFacebook {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String url= "https://www.facebook.com/";
		driver.get(url);
		
		driver.findElement(By.name("firstname")).clear();
		driver.findElement(By.name("firstname")).sendKeys("Salam");
		
		driver.findElement(By.name("lastname")).clear();
		driver.findElement(By.name("lastname")).sendKeys("Alik");
		
//		boxu@vpslists.com
		driver.findElement(By.name("reg_email__")).clear();
		driver.findElement(By.name("reg_email__")).sendKeys("boxu@vpslists.com");
		
		driver.findElement(By.name("reg_email_confirmation__")).clear();
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("boxu@vpslists.com");
		
		driver.findElement(By.name("reg_passwd__")).clear();
		driver.findElement(By.name("reg_passwd__")).sendKeys("1q2w3e4r5t");
		
		Select button1 = new Select(driver.findElement(By.name("birthday_month")));
		button1.selectByVisibleText("Feb");
		
		Select button2 = new Select(driver.findElement(By.name("birthday_day")));
		button2.selectByValue("5");
		
		Select button3 = new Select(driver.findElement(By.id("year")));
		button3.selectByIndex(20);
		
	     WebElement element= driver.findElement(By.id("u_0_9")); 
          element.click();
		 System.out.println(element.isSelected());
		
		 driver.findElement(By.id("u_0_u")).click();
		
		Thread.sleep(5000);
		driver.close();
		
		
		
		
	}

}