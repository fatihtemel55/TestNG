package Porsche;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

		public class Porche {
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
			
				
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				driver.get("https://www.porsche.com/usa/modelstart/");

				driver.findElement(By.className("b-teaser-link")).click();

				driver.findElement(By.className("m-14-quick-link")).click();
				
				String base = driver.findElement(By.className("m-14-model-price")).getText();
					String c = "";
				for (int i = 0; i < base.length(); i++) {
					if(base.charAt(i) == '.')
						break;
					if(Character.isDigit(base.charAt(i))) {
						 c+=base.charAt(i);
					 }	
				}
				System.out.println(c);
				driver.findElement(By.className("m-14-model-price")).click();
			
				
				ArrayList<String> hus2 = new ArrayList<String>( driver.getWindowHandles());
				
				driver.switchTo().window(hus2.get(1));
				
				String bs = driver.findElement(By.xpath("(//section[@id='s_price']//div[@class='ccaPrice'])[1]")).getText();
				System.out.println(bs);
					String bs2 = "";
					
					for (int i = 0; i < bs.length(); i++) {
						if(bs.charAt(i) == '.')
							break;
						if(Character.isDigit(bs.charAt(i))) {
							 bs2 +=bs.charAt(i);
						 }	
					}
					System.out.println(bs2);
				
					System.out.println(bs2);
				if(c.equalsIgnoreCase(bs2)) {
					System.out.println("Base Price is PASSED");
				}
				else {
					System.out.println("Base Price is FAIL");
				}
				
				String eqp2 = "";
				String eqp = driver.findElement(By.xpath("(//section[@id='s_price']//div[@class='ccaPrice'])[2]")).getText();
				for (int i = 0; i < eqp.length(); i++) {
					if(Character.isDigit(eqp.charAt(i)))
						eqp2 += eqp.charAt(i);
				}
				System.out.println(eqp);
				System.out.println(eqp2);
				if(eqp2.equals("0"))
						{
						System.out.println("Equipment Price PASSED");}
				else {
					System.out.println("Equipment Price FAIL");
				}
				
				String dlvr = driver.findElement(By.xpath("(//section[@id='s_price']//div[@class='ccaPrice'])[3]")).getText();
					String dlvr2 = "";
				for (int i = 0; i < dlvr.length(); i++) {
					if(Character.isDigit(dlvr.charAt(i)))
						dlvr2 += dlvr.charAt(i);
				}
				System.out.println(dlvr);
				System.out.println("DLVR"+dlvr2);
			String total = driver.findElement(By.xpath("(//section[@id='s_price']//div[@class='ccaPrice'])[4]")).getText();

			String total2 = "";
			for (int i = 0; i < total.length(); i++) {
				if(Character.isDigit(total.charAt(i)))
					total2 += total.charAt(i);
			}
				
				int bs3 = Integer.parseInt(bs2);
				
				int eqp3 = Integer.parseInt(eqp2);
				int dlv3 = Integer.parseInt(dlvr2);
				
				int total3 = Integer.parseInt(total2);
				int expctTotal = bs3+eqp3+dlv3;
				
				if(expctTotal == total3) {
					System.out.println("Total price is MATCHING  " + expctTotal + " ---- "+total2);
				}
				else {
					System.out.println("Total price is NOT MATCHING");
				}
				
				driver.findElement(By.id("s_exterieur_x_FJ5")).click();
				
			
				String clr = driver.findElement(By.xpath("(//div[@class='tt_price tt_cell'])[1]")).getText();

				String clr2 = "";
				for (int i = 0; i < clr.length(); i++) {
				if(Character.isDigit(clr.charAt(i)))
					clr2 += clr.charAt(i);
			}
				
				
				String clrE = driver.findElement(By.xpath("(//section[@id='s_price']//div[@class='ccaPrice'])[2]")).getText();
				String clrE2 = "";
				for (int i = 0; i < clrE.length(); i++) {
				if(Character.isDigit(clrE.charAt(i)))
					clrE2 += clrE.charAt(i);}
				if(clr2.equals(clrE2)) {
					System.out.println("Color Price is MATCHING --" + clr2+"----"+clrE2);
				}
				
				driver.findElement(By.xpath("//*[@id=\"s_exterieur_x_MXRD\"]/span/span")).click();
				
//				String totalPriceEquipment = driver.findElement(By.xpath("//div[@id='main']/div[4]/section[2]/section[2]/div[1]/div[2]/div[2]")).getText();
//				int priceTotalEquipment13 = digitFromString(totalPriceEquipment);
//
//				List<WebElement> a4 = driver.findElements(By.xpath("//div[@class='tt_price tt_cell']"));
//				String wheelPrice1 = a4.get(1).getText();
//				int priceWheel = digitFromString(wheelPrice1);
//
//				if (priceTotalEquipment13 == priceWheel + bs3) {
//					System.out.println("Pass.Total equipment price is correct with wheel and color - test 13");
//				} else {
//					System.out.println("Fail.Total equipment price is not correct with wheel and color - test 13");
//					System.out.println("Total price - " + priceTotalEquipment13);
//					System.out.println("Wheel price - " + priceWheel);
//					System.out.println("Color price - " + bs3);
//				}
				
				
		        
		         
				
				
		}
		}
