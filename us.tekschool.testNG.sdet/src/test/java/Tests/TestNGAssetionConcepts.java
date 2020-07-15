package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Core.Base;
import PageObj.CreateAccountPageObj;
import PageObj.HotelLoginPageObj;

public class TestNGAssetionConcepts extends Base {

	HotelLoginPageObj hotelLoginPageObj;
	CreateAccountPageObj createAccountPageObj; 
	@BeforeMethod
	public void beforeMethod() {
		Base.initializeDriver();
		logger.info("Browser opened successfully");
	}
	@Test
	@Ignore
	public void assertionTest() {
		String title = driver.getTitle();
		String expectedTitle = "Tek School Hotel website";// This hard assertion will stop when fails
		// hard Assertion
		Assert.assertEquals(title, expectedTitle);
		hotelLoginPageObj = new HotelLoginPageObj();
		hotelLoginPageObj.enterEmail(Base.getUserName());
		hotelLoginPageObj.enterPassword(Base.getPassword());
		hotelLoginPageObj.clickonSignInButton();
	}
	@Test
	public void sofAssertionConcept() {
		String title = driver.getTitle();
		String expectedTitle = "Tek School Hotel website";// This soft assertion will run to end and print the failure.
	// add soft Assertion 
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(title, expectedTitle);
		hotelLoginPageObj = new HotelLoginPageObj();
		hotelLoginPageObj.clickonSignIn();
		hotelLoginPageObj.enterEmail(Base.getUserName());
		hotelLoginPageObj.enterPassword(Base.getPassword());
		hotelLoginPageObj.clickonSignInButton();
		softAssert.assertAll();
	}
	
		
	
	@AfterMethod
	public void afterMethod() {
		Base.tearDown();
		logger.info("Browser closed");

	}
}
