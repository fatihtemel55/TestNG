package testNG;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGDemo {
	
	//@BeforeTest
	@BeforeClass
	public void setUpClass() {
		System.out.println("runs once before everything in this class");
	}
	
	@BeforeMethod
	public void setUpMethod() {
		System.out.println("runs before every method");
	}
	
	@AfterMethod
	public void lastMethod() {
		System.out.println("runs after every method");
	}
	
	//@Ignore
	@Test
	public void testOne() {
		System.out.println("First one");
	}
	
	@Test
	public void testTwo() {
		System.out.println("Second one");
	}
	
	@AfterClass
	public void tearDownClass() {
		System.out.println("runs once after everything in this class");
	}
	
}