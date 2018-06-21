package test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import utils.Environment;

public class ElementTest {

	public static void main(String[] args) {
		Environment.setup();
				
		WebDriverManager.chromedriver().setup();
		//1. open browser
		WebDriver driver = new ChromeDriver();
		//2. goto internet.com 
		driver.get("http://opensource.demo.orangehrmlive.com/");
		    
		    List<WebElement>inputs = driver.findElements(By.xpath("//input"));
		  //  driver.findElement(By.id("somehit"));
		    List<WebElement>notHiddenInputs = new ArrayList<WebElement>();

		    System.out.println("Size:" +inputs.size());
		    for(WebElement w: inputs) {
		    	String value = w.getAttribute("type");
		    	System.out.println(value);
		    	
		    	if(!value.equals("hidden")) {
		    		notHiddenInputs.add(w);
		    		
		    	}
 	
		    }
          System.out.println("Size not hidden:"+ notHiddenInputs.size());
          notHiddenInputs.get(0).sendKeys("Admin");
          notHiddenInputs.get(1).sendKeys("admin");
          

	}

}
