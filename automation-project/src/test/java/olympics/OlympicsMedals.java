package olympics;

import static org.testng.Assert.assertTrue;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OlympicsMedals {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(" https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	public void test1() {

		List<WebElement> list = driver.findElements(
				By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//td[1]"));
		List<Integer> ls = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			ls.add(Integer.parseInt(list.get(i).getText()));
		}
		SortedSet<Integer> s = new TreeSet<Integer>(ls);
		boolean asser = false;
		Iterator<Integer> iter = s.iterator();
		for (int i = 0; i < ls.size(); i++) {
			if (ls.get(i) == iter.next()) {
				asser = true;
			} else {
				asser = false;
				break;
			}
		}
		Assert.assertTrue(asser);
	}

	@Test(priority = 2)
	public void test2() throws InterruptedException {

		driver.findElement(By.xpath("(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//th)[2]"))
				.click();
		Thread.sleep(2000);

		List<WebElement> list = driver
				.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//a"));
		List<String> ls = new ArrayList<String>();

		for (int i = 0; i < 10; i++) {
			ls.add(list.get(i).getText());
		}

		SortedSet<String> s = new TreeSet<String>(ls);
		boolean asser = false;
		Iterator<String> iter = s.iterator();
		for (int i = 0; i < ls.size(); i++) {
			if (ls.get(i) == iter.next()) {
				asser = true;
			} else {
				asser = false;
				break;
			}
		}
		Assert.assertTrue(asser);

	}
	
	@Test(priority = 4)
	public void test4() throws InterruptedException {

		driver.findElement(By.xpath("(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//th)[2]"))
				.click();
		Thread.sleep(2000);

		List<WebElement> list = driver
				.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//a"));
		List<String> ls = new ArrayList<String>();

		for (int i = 0; i < 10; i++) {
			ls.add(list.get(i).getText());
		}

		SortedSet<String> s = new TreeSet<String>(ls);
		boolean asser = false;
		Iterator<String> iter = s.iterator();
		for (int i = 0; i < ls.size(); i++) {
			if (ls.get(i) == iter.next()) {
				asser = true;
			} else {
				asser = false;
				break;
			}
		}
		Assert.assertFalse(asser);
		
		
		
	
	}
	
	@Test(priority = 5)
	public void test5() {
		
		List<WebElement> list = driver.findElements(
				By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//td[1]"));
		List<Integer> ls = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			ls.add(Integer.parseInt(list.get(i).getText()));
		}
		SortedSet<Integer> s = new TreeSet<Integer>(ls);
		boolean asser = false;
		Iterator<Integer> iter = s.iterator();
		for (int i = 0; i < ls.size(); i++) {
			if (ls.get(i) == iter.next()) {
				asser = true;
			} else {
				asser = false;
				break;
			}
		}
		Assert.assertFalse(asser);
			
	}
	@Test(priority = 6)
	public void test6() {
	driver.get(" https://en.wikipedia.org/wiki/2016_Summer_Olympics");
	
	}
	@Test(priority = 7)
    public void test7() {
        Map<Integer,String> data=new HashMap<Integer, String>();
        List<WebElement> listOfgold=driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//td[2]"));
        List<WebElement> listOfCountry = driver
                .findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//a"));
        for (int i = 0; i < 10; i++) {
            data.put(Integer.parseInt(listOfgold.get(i).getText()), listOfCountry.get(i).getText());
        }
        
        SortedSet<Integer> keys = new TreeSet<Integer>(data.keySet());
        //System.out.println(keys.last());
        System.out.println(data.get(keys.last()));
        System.out.println(data);
        String expected="United States";
        Assert.assertEquals(data.get(keys.last()), expected);
    }
    
    @Test(priority = 8)
    public void test8() {
        Map<Integer,String> data=new HashMap<Integer, String>();
        List<WebElement> listOfgold=driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//td[3]"));
        List<WebElement> listOfCountry = driver
                .findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//a"));
        for (int i = 0; i < 10; i++) {
            data.put(Integer.parseInt(listOfgold.get(i).getText()), listOfCountry.get(i).getText());
        }
        
        SortedSet<Integer> keys = new TreeSet<Integer>(data.keySet());
        //System.out.println(keys.last());
        System.out.println(data.get(keys.last()));
        System.out.println(data);
        
        String expected="United States";
        
        Assert.assertEquals(data.get(keys.last()), expected);
        
    }
    
    @Test(priority = 9)
    public void test9() {
        
        Map<Integer,String> data=new HashMap<Integer, String>();
        List<WebElement> listOfgold=driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//td[4]"));
        List<WebElement> listOfCountry = driver
                .findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//a"));
        for (int i = 0; i < 10; i++) {
            data.put(Integer.parseInt(listOfgold.get(i).getText()), listOfCountry.get(i).getText());
        }
        
        SortedSet<Integer> keys = new TreeSet<Integer>(data.keySet());
        //System.out.println(keys.last());
        System.out.println(data.get(keys.last()));
        System.out.println(data);
        String expected="United States";
        
        Assert.assertEquals(data.get(keys.last()), expected);
        
    }
    @Test(priority = 10)
    public void test10() {
    	
    	 List<WebElement> listOfCountry=driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//td[4]"));
         List<WebElement> listOfsilver = driver
                 .findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//a"));
         
         String actual = "";
         
         for (int i = 0; i < 10; i++) {
        	 if(listOfsilver.get(i).getText().equals("18"));
    }
         String expected = "China France";
         Assert.assertEquals(actual.trim(), expected);
         
         
    }
   
    @Test(priority = 11)
    public void test11() {
    	
    	 List<WebElement> listOfCountry=driver.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//td[4]"));
         List<WebElement> listOfsilver = driver
                 .findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//a"));
         
    
    
}
}

















