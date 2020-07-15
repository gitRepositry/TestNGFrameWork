package classPractice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Core.Base;

public class Web extends Base {
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("this is before class");
	}
	@Test
	public void logOut() {
		System.out.println("It is  test");
	}
	@Test
	public void logOutOne() {
		System.out.println("It is  test");
	}
	@AfterClass
	public void logOutTwo() {
		System.out.println("It is after class");
	}
	@BeforeMethod
	public void logOutThree() {
		System.out.println("It is before method");
	}
	@BeforeSuite
	public void afterclass() {
		System.out.println("this is before suite");
	}
	@AfterMethod
	public void logOutThreeee() {
		System.out.println("It is after method");
	}
	@BeforeSuite
	public void afterclasss() {
		System.out.println("this is before suite");
	}
	@BeforeTest
	public void testb() {
		System.out.println("before test");
	}
	@AfterTest
	public void testA() {
		System.out.println("aftertest");
	}
}
