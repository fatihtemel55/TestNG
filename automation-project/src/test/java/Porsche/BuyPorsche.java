package Porsche;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BuyPorsche {

	public static int digitFromString(String a) {
		String b = "";

		for (int i = 0; i < a.length(); i++) {
			char c7 = a.charAt(i);
			if (a.charAt(i) == '.')
				break;
			if (Character.isDigit(c7)) {
				b += c7;
			}
		}
		int t = Integer.parseInt(b);
		return t;
	}

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();// Set up chromedriver path

		WebDriver d = new ChromeDriver();

		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		d.manage().window().fullscreen(); // makes browser fullscreen

		String url = "https://www.porsche.com/usa/modelstart/";

		d.get(url);

		d.findElement(By.xpath("//img[@alt='Porsche - 718']")).click();

		// ===============================================================================================================

		// test 4
		String basePricebefore = d
				.findElement(By.xpath("//div[@id='model-result-row']/div[1]/div/div[1]/div[2]/div[2]")).getText();

		int priceBaseBefore = digitFromString(basePricebefore);

		// ===============================================================================================================

		d.findElement(By.linkText("Build & Price")).click();
		// change to another browser window
		String parentWindow = d.getWindowHandle();
		Set<String> handles = d.getWindowHandles();
		for (String windowHandle : handles) {
			if (!windowHandle.equals(parentWindow)) {
				d.switchTo().window(windowHandle);
			}
		}
		// ===============================================================================================================
		// test 5
		// base price
		String basePriceAfter = d.findElement(By.xpath("//section[@id='s_price']/div[1]/div[1]/div[2]")).getText();

		int priceBaseAfter = digitFromString(basePriceAfter);

		// ===============================================================================================================

		// test 6

		if (priceBaseBefore == priceBaseAfter) {
			System.out.println("Pass.price the same - test 6");
		} else {
			System.out.println("Fail.Price is different - test 6");
		}

		// ===============================================================================================================
		// test 7
		// equipment price
		String equipmPr = d.findElement(By.xpath("//section[@id='s_price']/div[1]/div[2]")).getText();

		int actualEqPrice = digitFromString(equipmPr); // actual equipment price
		int expectedEqPrice = 0;

		if (actualEqPrice == expectedEqPrice) {
			System.out.println("Pass.Price of Equipment is correct - test 7");
		} else {
			System.out.println("Fail.Price of Equipment is not correct - test 7");
		}

		// ===============================================================================================================
		// test 8
		// delivery price
		String delivery = d.findElement(By.xpath("//section[@id='s_price']/div[1]/div[3]")).getText();
		int priceDelivery = digitFromString(delivery);

		// ===============================================================================================================

		// totalprice 1
		String lastPrice = d.findElement(By.xpath("//section[@id='s_price']/div[1]/div[4]")).getText();

		int totalPrice8 = digitFromString(lastPrice);

		if (totalPrice8 == priceDelivery + priceBaseAfter) {
			System.out.println("Pass.Total price is correct - test 8");
		} else {
			System.out.println("Fail.Total price is not correct - test 8");
		}
		// ===============================================================================================================
		// test 9
		// click on blue color
		WebElement doublCl = d.findElement(By.xpath("//span[@style='background-color: rgb(0, 120, 138);']"));

		Actions action = new Actions(d);// create Action object for mouse

		action.moveToElement(doublCl).doubleClick().build().perform();

		// ===============================================================================================================
		// test 10
		// equipment total price
		String equipmPrColor = d.findElement(By.xpath("//section[@id='s_price']/div[1]/div[2]")).getText();
		int priceEquipmentTotal = digitFromString(equipmPrColor);

		// color price
		String exPri = d.findElement(By.xpath("//div[@id='s_exterieur_x_IAF']/div[2]/div[1]/div[1]/div[2]")).getText();
		int priceColor = digitFromString(exPri);

		if (priceEquipmentTotal == priceColor) {
			System.out.println("Pass.Price of Equipment is correct! After adding color - test 10");
		} else {
			System.out.println("Fail.Price of Equipment is not correct! After adding color - test 10");
		}

		// ===============================================================================================================
		// test 11
		// last total price
		String totalPrice11 = d.findElement(By.xpath("//section[@id='s_price']/div[1]/div[4]")).getText();

		int priceTotal11 = digitFromString(totalPrice11);

		if (priceTotal11 == priceEquipmentTotal + priceBaseAfter + priceDelivery) {
			System.out.println("Pass.Total price is correct - test 11");
		} else {
			System.out.println("Fail.Total price is not correct - test 11");
		}

		// ===============================================================================================================
		// test 12
		// select wheels
		WebElement wheel = d.findElement(By.xpath("//div[@id='ARA']/ul/li[8]/span/span"));
		Thread.sleep(2000);
		action.moveToElement(wheel).click().build().perform();

		// =================================================================================================================

		// //test 13
		// //equipment price with wheel

		String totalPriceEquipment = d
				.findElement(By.xpath("//div[@id='main']/div[4]/section[2]/section[2]/div[1]/div[2]/div[2]")).getText();
		int priceTotalEquipment13 = digitFromString(totalPriceEquipment);

		List<WebElement> a4 = d.findElements(By.xpath("//div[@class='tt_price tt_cell']"));
		String wheelPrice1 = a4.get(1).getText();
		int priceWheel = digitFromString(wheelPrice1);

		if (priceTotalEquipment13 == priceWheel + priceEquipmentTotal) {
			System.out.println("Pass.Total equipment price is correct with wheel and color - test 13");
		} else {
			System.out.println("Fail.Total equipment price is not correct with wheel and color - test 13");
			System.out.println("Total price - " + priceTotalEquipment13);
			System.out.println("Wheel price - " + priceWheel);
			System.out.println("Color price - " + priceEquipmentTotal);
		}

		// =================================================================================================================
		// test 14
		// Verify that total price

		String totalPrice5 = d
				.findElement(By.xpath("//div[@id='main']/div[4]/section[2]/section[2]/div[1]/div[4]/div[2]")).getText();
		int priceTotal14 = digitFromString(totalPrice5);

		if (priceTotal14 == priceBaseAfter + priceTotalEquipment13 + priceDelivery) {
			System.out.println("Pass. All correct. - test 14");
		} else {
			System.out.println("Fail.Price is not correct - test 14");
			System.out.println("Total price - " + priceTotal14);
			System.out.println("Equipment price - " + priceTotalEquipment13);
			System.out.println("Delivery price - " + priceDelivery);
		}
		// =================================================================================================================
		// test 15
		// Select seats ‘Power Sport Seats (14-way) with Memory Package’
		WebElement overview = d.findElement(By.xpath("//div[@id='menucontent']/section/div[1]/div"));
		WebElement wheelClick = d.findElement(By.xpath("//div[@id='submenu_exterieur_x_AA_submenu_x_IRA']"));
		WebElement radio = d.findElement(By.xpath("//div[@id='seats_73']/div[2]/span"));
		
		Thread.sleep(3000);
		action.moveToElement(overview).click().build().perform();
		Thread.sleep(3000);
		action.moveToElement(wheelClick).click().build().perform();

		Thread.sleep(3000);
		
		action.moveToElement(radio).doubleClick().build().perform();
		Thread.sleep(3000);

		// d.findElement(By.xpath("//*[@id='s_conf_submenu']/div/div")).click();
		// d.findElement(By.xpath("//*[@id='submenu_interieur_x_AI_submenu_x_submenu_parent']")).click();
		// Thread.sleep(1000);
		// d.findElement(By.xpath("//*[@id='submenu_interieur_x_AI_submenu_x_submenu_seats']/a")).click();
		// Thread.sleep(1000);
		// d.findElement(By.xpath("//*[@id='s_interieur_x_PP06']")).click();
		// ====================================================================================================================\
		// test 16
		// Verify that Price for Equipment is the sum of Miami Blue price + 20" Carrera
		// Sport Wheels + Power Sport Seats (14-way) with Memory Package
		// seat price
		String seat = d.findElement(By.xpath("//div[@id='seats_73']/div[2]/div[1]/div[3]/div[1]")).getText();
		int priceSeat = digitFromString(seat);
		//
		String totalPriceEquipment16 = d
				.findElement(By.xpath("//div[@id='main']/div[4]/section[2]/section[2]/div[1]/div[2]/div[2]")).getText();
		int priceTotalEquipment16 = digitFromString(totalPriceEquipment16);

		if (priceTotalEquipment16 == priceSeat + priceWheel + priceColor) {
			System.out.println("Pass. Total equipment price with color,wheel,seat are correct - test 16");
		} else {
			System.out.println("Fail. Total equipment price with color,wheel,seat are not correct - test 16");
			System.out.println("Total price is - " + priceTotalEquipment16 + " Seat price is -" + priceSeat
					+ " Wheel price is " + priceWheel + " Color price is - " + priceColor);

		}
		// =================================================================================================================
		// test 17
		// Verify that total price is the sum of base price + Price for Equipment +
		// Delivery,
		// Processing and Handling Fee
		String totalPrice7 = d
				.findElement(By.xpath("//div[@id='main']/div[4]/section[2]/section[2]/div[1]/div[4]/div[2]")).getText();
		int priceTotal17 = digitFromString(totalPrice7);
		if (priceTotal17 == priceBaseAfter + priceDelivery + priceTotalEquipment16) {
			System.out.println("Pass.Total price is correct - test 17");
		} else {
			System.out.println("Fail. Total price is not correct - test 17");
		}
		// =================================================================================================================
		// test 18
		WebElement click1 = d.findElement(By.xpath("//div[@id='IIC_wrapper']/div/div"));
		Thread.sleep(3000);
		// d.findElement(By.xpath("//div[@id='IIC_subHdl']']")).click();
		action.moveToElement(click1).click().build().perform();
	}
}
		// =================================================================================================================
		// test 19
		// .Select Interior Trim in Carbon Fiber i.c.w. Standard Interior
		// d.findElement(By.xpath("//*[@id='s_conf_submenu']/div/div")).click();
		// d.findElement(By.xpath("//*[@id='s_conf_submenu']/div/div")).click();
		// Thread.sleep(1000);
		// d.findElement(By.xpath("//*[@id='submenu_individualization_x_individual_submenu_x_submenu_parent']")).click();
		// Thread.sleep(2000);
		// d.findElement(By.xpath("//*[@id='submenu_individualization_x_individual_submenu_x_IIC']/a")).click();
		// Thread.sleep(2000);
		// d.findElement(By.xpath("//*[@id='vs_table_IIC_...