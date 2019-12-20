package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import core.Base;

public class LoginPageObject extends Base {

	public LoginPageObject() {

		PageFactory.initElements(driver, this);

	}

	// @FindBy this annotation is part of PageFactory class which helps us to
	// initialize the element
	@FindBy(how = How.XPATH, using = "//a[text()='Test Environment']")
	private WebElement testEnvironmentLink;

	@FindBy(how = How.XPATH, using = "//a[text()='Login to Class']")
	private WebElement loginToClassLink;

	@FindBy(how = How.ID, using = "mc4wp_email")
	private WebElement subsEmailField;

	/**
	 * This method will click on Test Environment Link on Tek School Page
	 */
	public void clickOnTestEnvironmentLink() {
		testEnvironmentLink.sendKeys(Keys.ENTER);
	}

	/**
	 * This method will Click on Login to Class Link on Tek School page
	 */
	public void clickOnLoginToClassLink() {
		loginToClassLink.sendKeys(Keys.ENTER);
	}

	/**
	 * This method will enter email value in Subscribe email field in Tek School
	 * page
	 * 
	 * @param emailValue
	 */
	public void sendValueToSubsEmailField(String emailValue) {
		subsEmailField.sendKeys(emailValue);

	}
	/**
	 * This Method will return Tek School Page title
	 * @return
	 */

	public String pageTitle() {

		String TekSchoolPageTitle = driver.getTitle();
		return TekSchoolPageTitle;
	}

}











