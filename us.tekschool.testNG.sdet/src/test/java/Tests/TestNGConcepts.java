package Tests;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGConcepts {
	
	@Test
	@Ignore
	public void signIn() {
		String a = "college";
		String b = "college";
		Assert.assertEquals(a,b);
		
		
	}
	// Test homePage depends on successfull execution of signIn test.
	@Test (dependsOnMethods = {"signIN"}, enabled = false)
	public void homePage() {
		System.out.println("this test is dependend on sign in test cases");
		
	}
	@Test (invocationCount = 10)
	public void checkTitle() {
		System.out.println("this test case will run 10 times");
	}
	@Test (groups = {"smokeTest"})
	public void logOut() {
		System.out.println("logout test");
	}
	@Test (groups = {"smokeTest"})
	public void dashBoard() {
		System.out.println("dashboard test");
	}
	@Test (groups = {"smokeTest"}) 
	public void customerTest() {
		System.out.println("customer test");
	}

}
