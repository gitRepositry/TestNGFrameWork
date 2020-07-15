package PageObj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Core.Base;
import Utilities.DriverUtility;

public class HotelLoginPageObj extends Base {
	
	public HotelLoginPageObj() {
		PageFactory.initElements(driver, this);
	}
	// 5 minutes to store below WebElements in private WebElement using @FindBy
	// annotations.
	// find WebElement of Sign in
	@FindBy(how = How.XPATH, using = "//span[@class='hide_xs']")
	private WebElement signIn;
	// find WebElement of email field
	@FindBy(how = How.ID, using = "email")
	private WebElement emailAddress;
	// find WebElement of password field
	@FindBy(how = How.ID, using = "passwd")
	private WebElement password;
	// find WebElement of login button
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Sign in')]")
	private WebElement SignInButton;
	public void clickonSignIn() {
		signIn.click();
	}
	public void enterEmail(String emailID) {
		DriverUtility.enterText(emailAddress, emailID);
	}
	public void enterPassword(String passwordID) {
		DriverUtility.enterText(password, passwordID);
	}
	public void clickonSignInButton() {
		SignInButton.click();
	}
	public boolean createSignInisPresent() {
		boolean signPresent = DriverUtility.isElementDisplayed(signIn);
		return signPresent;
	}
	}