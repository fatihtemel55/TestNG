package mockaroo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import com.github.javafaker.File;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MockarooDataValidation {

	List<String> cities;
	List<String> countries;
	WebDriver driver;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(" https://mockaroo.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test(priority=1)
	public void testTitle() {
		String webTitle = driver.getTitle();
		String expectedTitle = "Mockaroo - Random Data Generator and API Mocking Tool" + " | JSON / CSV / SQL / Excel";

		// System.out.println(webTitle);
		Assert.assertEquals(webTitle, expectedTitle);
	}

	@Test(priority=2)
	public void displayTest() {

		WebElement mackaroo = driver.findElement(By.xpath("//div[@class='brand']"));

		Assert.assertTrue(mackaroo.isDisplayed());

		String expected1 = "Mockaroo";
		String expected2 = "realistic data generator";
		String brand1 = driver.findElement(By.xpath("//div[@class='brand']")).getText();
		String brand2 = driver.findElement(By.xpath("//div[@class='tagline']")).getText();
		Assert.assertTrue(expected1.equalsIgnoreCase(brand1));
		Assert.assertTrue(expected2.equalsIgnoreCase(brand2));
		//
	}

	@Test(priority=3)
	public void remoteIconTest() throws InterruptedException {
		List<WebElement> icons = driver.findElements(By.xpath("//a[@data-association='columns']"));
		for (int i = 0; i < 6; i++) {
			icons.get(i).click();
		}

	}

	@Test(priority=4)
	public void displayFieldname() {
		WebElement field = driver.findElement(By.xpath("(//div[@class='table-header']//div)[1]"));
		Assert.assertTrue(field.isDisplayed());

		WebElement type = driver.findElement(By.xpath("(//div[@class='table-header']//div)[2]"));
		Assert.assertTrue(type.isDisplayed());

		WebElement option = driver.findElement(By.xpath("(//div[@class='table-header']//div)[3]"));
		Assert.assertTrue(option.isDisplayed());

		String expected = "Field Name";
		String webText = driver.findElement(By.xpath("(//div[@class='table-header']//div)[1]")).getText();
		Assert.assertEquals(webText, expected);

	}

	@Test(priority=5)
	public void buttonEnable() {

		WebElement button = driver.findElement(By.xpath("(//a[@data-blueprint-id='columns_fields_blueprint'])[1]"));
		Assert.assertTrue(button.isEnabled());
	}

	@Test(priority=6)
	public void default100() {
		String expected = "1000";
		String web = driver.findElement(By.xpath("//input[@name='schema[num_rows]']")).getAttribute("value");
		Assert.assertEquals(web, expected);
	}

	@Test(priority=7)
	public void defaultCVS() {
		String expected = "CSV";
		WebElement web = driver.findElement(By.xpath("//select[@id='schema_file_format']"));
		// Assert.assertEquals(web, expected);

		Select slct = new Select(web);
		String webs = slct.getFirstSelectedOption().getText();
		Assert.assertEquals(webs, expected);
	}

	@Test(priority=8)
	public void endingLineTest() {
		String web = driver.findElement(By.xpath("//select[@id='schema_line_ending']")).getAttribute("value");
		String expected = "unix";
		Assert.assertEquals(web, expected);
	}

	@Test(priority=9)
	public void checkboxTest() {
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='schema_include_header']")).isSelected());
		Assert.assertFalse(driver.findElement(By.xpath("//input[@id='schema_bom']")).isSelected());
	}

	@Test(priority=10)
	public void addCity() {
		driver.findElement(By.xpath("(//a[@data-blueprint-id='columns_fields_blueprint'])[1]")).click();
		driver.findElement(By.xpath("(//input[@placeholder='enter name...'])[7]")).sendKeys("City");

	}

	@Test(priority=11)
	public void choseTypeDisplayed() {
		WebElement field = driver.findElement(By.xpath("(//input[@placeholder='choose type...'])[7]"));
		Assert.assertTrue(field.isDisplayed());
	}

	@Test(priority=12)
	public void searchCity() throws InterruptedException {
		driver.findElement(By.xpath("(//input[@placeholder='choose type...'])[7]")).click();
		// driver.findElement(By.xpath("//input[@id='type_search_field']")).click();
		
		driver.findElement(By.xpath("//input[@id='type_search_field']")).sendKeys("City");
		driver.findElement(By.xpath("//div[@class='type-name']")).click();

	}

	@Test(priority=13)
	public void addCountry() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@data-blueprint-id='columns_fields_blueprint'])[1]")).click();
		driver.findElement(By.xpath("(//input[@placeholder='enter name...'])[8]")).sendKeys("Country");

	}

	@Test(priority=14)
	public void searchCountry() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@placeholder='choose type...'])[8]")).click();
		// driver.findElement(By.xpath("//input[@id='type_search_field']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='type_search_field']")).sendKeys("Country");
		driver.findElement(By.xpath("(//div[@class='type-name'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='download']")).click();

	}

	@Test(priority=15)
	public void firstRowMatchwithFieldName() throws InterruptedException {
		Thread.sleep(5000);
		buffreadMethod();
		String cityWeb = driver.findElement(By.xpath("(//input[@placeholder='enter name...'])[7]"))
				.getAttribute("value");
		String countryWeb = driver.findElement(By.xpath("(//input[@placeholder='enter name...'])[8]"))
				.getAttribute("value");
		Assert.assertEquals(cities.get(0), cityWeb);
		Assert.assertEquals(countries.get(0), countryWeb);
	}

	@Test(priority=16)
	public void recordsOf1000() throws InterruptedException {
		Thread.sleep(5000);
		buffreadMethod();
		int recordExpected = 1000;
		// first index of list represents fields name , so we have to remove them in
		// order to check actual records
		cities.remove(0);
		int recordSize = cities.size();
		Assert.assertEquals(recordSize, recordExpected);

	}

	@Test(priority=17)
	public void findLongestandShortestname() throws InterruptedException {
		Thread.sleep(5000);
		buffreadMethod();
		int longestNam = 0;
		String longestName = "";
		int shortestNam = 1000;
		String shortestName = "";
		for (int i = 0; i < cities.size(); i++) {
			if (longestNam < cities.get(i).length()) {
				longestNam = cities.get(i).length();
				longestName = cities.get(i);
			}

			if (shortestNam > cities.get(i).length()) {
				shortestNam = cities.get(i).length();
				shortestName = cities.get(i);
			}

		}
		Collections.sort(cities);
		System.out.println(cities.get(0));
		System.out.println("Longest name: " + longestName);
		System.out.println("Shortest name: " + shortestName);

	}

	@Test(priority=18)
	public void howManyTimesEachCountry() {
		buffreadMethod();
		List<String> l1 = new ArrayList<String>();

		int count = 0;
		for (int i = 0; i < countries.size(); i++) {
			for (int j = 0; j < countries.size(); j++) {
				if (countries.get(i).equals(countries.get(j))) {
					count++;
				}
			}
			if (count >= 1) {
				l1.add(countries.get(i) + "-" + count);
			}
			count = 0;
		}
		HashSet<String> countriesNew = new HashSet<String>(l1);
		System.out.println(countriesNew);
	}

	@Test(priority=19)
	public void setCityHasSet() {
		buffreadMethod();
		HashSet<String> citiesSet = new HashSet<String>(cities);
		// testing unique cities with hashset
		List<String> uniqueList = new ArrayList<String>();
		for (String uni : cities) {
			if (!uniqueList.contains(uni))
				uniqueList.add(uni);
		}
		System.out.println("Unique city size= " + citiesSet.size());
		Assert.assertTrue(uniqueList.size() == citiesSet.size());

	}

	@Test(priority=20)
	public void setCountryHasSet() {
		buffreadMethod();
		HashSet<String> countriesSet = new HashSet<String>(countries);
		List<String> uniqueList = new ArrayList<String>();
		for (String uni : countries) {
			if (!uniqueList.contains(uni))
				uniqueList.add(uni);
		}
		System.out.println(cities);
		System.out.println("Unique country size= " + countriesSet.size());
		Assert.assertTrue(uniqueList.size() == countriesSet.size());

	}

	public void buffreadMethod() {

		String csvFile = getLatestFilefromDir("/Users/fatihtemel/Downloads/").getAbsolutePath().toString();
		

		BufferedReader br = null;
		String line = "";

		cities = new ArrayList<String>();
		countries = new ArrayList<String>();
		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] country = line.split(",");

				//System.out.println(country[0] + "," + country[1]);
				cities.add(country[0]);
				countries.add(country[1]);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static File getLatestFilefromDir(String dirPath) {
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}
}