package classPractice;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Core.Base;

public class Mobile extends Base {

	@Test
	@BeforeClass
	public void login() {
		System.out.println("It is before class");
	}
	@BeforeMethod
	public void loginTwo() {
		System.out.println("It is before method");
	}
	@BeforeSuite
	public void loginThree() {
		System.out.println("It is before suit");
	}
	@BeforeTest
	public void loginFour() {
		System.out.println("It is before test");
	}
	
}
