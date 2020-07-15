package classPractice;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Core.Base;

public class API extends Base{
	
	
	@Test
	public void ApiPersonalLoan() {
		System.out.println("It is personal loan");
	}
	@Test
	public void signIntwo() {
		System.out.println("It is before method");
	}
	@BeforeSuite
	public void signThree() {
		System.out.println("It is before suit");
	}
	@BeforeTest
	public void singinFour() {
		System.out.println("It is before test");
	}

}
