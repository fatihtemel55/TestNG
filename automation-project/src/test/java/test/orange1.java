package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class orange1 {

	public static void main(String[] args) {
				
		String extectedTitle = "OrangeHRM";
		
		WebDriverManager.chromedriver().setup();
		//1. open browser
		WebDriver driver = new ChromeDriver();
		//2. goto internet.com 
		driver.get("http://opensource.demo.orangehrmlive.com/");
		
		if(driver.getTitle().equals(extectedTitle)) {
			System.out.println("Pass");
		}else {
			System.out.println("fail");
		}
		
		WebElement username = driver.findElement(By.id("txtUsername"));
		WebElement password = driver.findElement(By.id("txtPassword"));
		WebElement loginBtn = driver.findElement(By.id("btnLogin"));
		username.sendKeys("Admin");
		password.sendKeys("admin");
		loginBtn.click();
		
		String expectedUrl = "http://opensource.demo.orangehrmlive.com/index.php/dashboard";
		if(driver.getCurrentUrl().equals(expectedUrl)) {
			System.out.println("pass");
		}else {
			System.out.println("fail");
		}


}
}
