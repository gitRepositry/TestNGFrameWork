package Tests;

import org.testng.annotations.AfterMethod;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Core.Base;
import PageObj.HotelLoginPageObj;
import Utilities.DriverUtility;

@Listeners(Utilities.TestNGListeners.class)
public class HotelLogin extends Base {
	
	HotelLoginPageObj hotelpageObj;
	@BeforeMethod
	public void beforeMethod() {
		Base.initializeDriver();
		logger.info("Browser opened successfully");
	}
	@Test (enabled = false)// it will scape this testcase. @Ignore also can be used.
	@Ignore
	public void loginToHotelPage() {
		hotelpageObj = new HotelLoginPageObj();
		hotelpageObj.clickonSignIn();
		logger.info("user clicked on Sign in");
		hotelpageObj.enterEmail(getUserName());
		logger.info("user entered email address");
		hotelpageObj.enterPassword(getPassword());
		logger.info("user entered password");
		hotelpageObj.clickonSignInButton();
		logger.info("user clicked on sign in button");
		DriverUtility.wait(5000);
		DriverUtility.screenShot();
	}
	
	@Test (priority = 1)
	@Parameters({"userName","password"})
	public void loginWithParameter() {
		hotelpageObj = new HotelLoginPageObj();
		hotelpageObj.clickonSignIn();
		logger.info("user clicked on Sign in");
		hotelpageObj.enterEmail("student@test.com");
		logger.info("user entered email address");
		hotelpageObj.enterPassword("welcome1");
		logger.info("user entered password");
		hotelpageObj.clickonSignInButton();
		logger.info("user clicked on sign in button");
		DriverUtility.wait(5000);
		DriverUtility.screenShot();
	}
	//@Test (priority = 4)
	@Ignore
	public void testThree() {
		logger.info("This is just sample3");
	}
	//@Test (priority = 3)
	@Ignore
	public void testFour() {
		logger.info("This is just sample4");
	}
	//@Test (priority = 0)
	@Ignore
	public void testZero() {
		logger.info("This is will execute before proiority one");
	}
	 //@Test 
	@Ignore
	public void testSix() {
		logger.info("This is without proiority");
	}
	//@AfterMethod
	@Ignore
	public void afterMethod() {
		Base.tearDown();
		logger.info("Browser closed");
	}
}
