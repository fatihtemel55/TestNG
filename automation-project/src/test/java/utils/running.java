package utils;

import java.awt.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class running {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		String url = "https://tutorialehtml.com/en/html-tutorial-drop-down-lists-menu/";
		driver.get(url);
		
		// first select tag
		WebElement selectTag= driver.findElement(By.name("my_html_select_box"));
		// second select object from select tag
		Select list= new Select(selectTag);
		// getFirstSelectedOption()--> it selects first drop down value
		// print the selected value: option 1
//        list.getFirstSelectedOption();
        WebElement selected = list.getFirstSelectedOption();
        System.out.println(selected.getText());
        System.out.println(list.getFirstSelectedOption().getText());
        //print all the available options
        // returns a list of all the options(selected and not selected everything
        
        ArrayList<WebElement> options = (ArrayList<WebElement>) list.getOptions();
        System.out.println("------------");
       for (WebElement webElement : options) {
		System.out.println(webElement.getText());
	}
       System.out.println("----------------");
        // select using the visible text
       list.selectByVisibleText("Bucharest");
       System.out.println("selected: "+ list.getFirstSelectedOption().getText());
       // select using the index
       // count starts from 0
       list.selectByIndex(2);
       System.out.println("selected: "+list.getFirstSelectedOption().getText());

	}

}
