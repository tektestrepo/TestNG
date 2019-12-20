package pageObjects;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import core.Base;

public class TekSchoolScenariosPageObject extends Base {

	public TekSchoolScenariosPageObject() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//span[text()='My Account']")
	private WebElement myAccountWebelement;

	@FindBy(how = How.XPATH, using = "//a[text()='Register']")
	private WebElement registerWebElement;

	@FindBy(how = How.XPATH, using = "//a[text()='Login']")
	private WebElement loginWebElement;

	@FindBy(how = How.ID, using = "input-email")
	private WebElement emailAddressFieldWebElement;

	@FindBy(how = How.ID, using = "input-password")
	private WebElement passwordFieldWebElement;

	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	private WebElement loginButtonWebElement;

	@FindBy(how = How.XPATH, using = "//h2[text()='My Account']")
	private WebElement myAccountTextWebElement;

	// ---------------------------------------------

	@FindBy(xpath = "//input[@id='input-firstname']")
	private WebElement firstNameFieldValue;

	@FindBy(xpath = "//input[@id='input-lastname']")
	private WebElement lastNameFieldValue;

	@FindBy(how = How.XPATH, using = "//input[@id='input-email']")
	private WebElement emailFieldValue;

	@FindBy(how = How.ID, using = "input-telephone")
	private WebElement telephoneFieldValue;

	@FindBy(how = How.NAME, using = "password")
	private WebElement passwordFieldValue;

	@FindBy(how = How.NAME, using = "confirm")
	private WebElement passwordConfirmationFieldValue;

	@FindBy(how = How.XPATH, using = "//input[@value='1' and @name='newsletter']")
	private WebElement subscribeYesButton;

	@FindBy(how = How.XPATH, using = "//input[@value='0' and @name='newsletter']")
	private WebElement subscribeNoButton;

	@FindBy(how = How.XPATH, using = "//input[@value='Continue']")
	private WebElement continueButton;

	@FindBy(how = How.XPATH, using = "//h1[text()='Your Account Has Been Created!']")
	private WebElement accountCreatedConfirmationText;

	// Writing action methods for WebElements we store in this obj repository class

	public void clickOnMyAccount() {
		try {

			myAccountWebelement.click();

		} catch (ElementNotInteractableException e) {

			myAccountWebelement.sendKeys(Keys.ENTER);

		}
	}

	public void clickonRegister() {
		try {
			registerWebElement.click();
		} catch (ElementNotInteractableException e) {

			registerWebElement.sendKeys(Keys.ENTER);

		}
	}

	public void clickOnLogin() {
		try {
			loginWebElement.click();
		} catch (ElementNotInteractableException e) {
			loginWebElement.sendKeys(Keys.ENTER);
		}

	}

	public void enterEmailAddress(String emailValue) {

		emailAddressFieldWebElement.sendKeys(emailValue.trim());
	}

	public void enterPassword(String passwordValue) {
		passwordFieldWebElement.sendKeys(passwordValue.trim());
	}

	public void clickOnLoginButton() {
		loginButtonWebElement.click();
	}

	public boolean verifyLoginToMyAccount() {

		boolean verificationPoint = myAccountTextWebElement.isDisplayed();
		return verificationPoint;

	}

	public void fillFirstName(String firstName) {
		firstNameFieldValue.sendKeys(firstName);
	}

	public void fillLastName(String lastName) {

		lastNameFieldValue.sendKeys(lastName);

	}

	public void fillEmail(String emailValue) {
		emailFieldValue.sendKeys(emailValue);

	}

	public void fillPhone(String phoneValue) {

		telephoneFieldValue.sendKeys(phoneValue);

	}

	public void fillPassword(String password) {
		passwordFieldValue.sendKeys(password);
	}

	public void fillPasswordConfirmation(String passwordConfirmation) {
		passwordConfirmationFieldValue.sendKeys(passwordConfirmation);

	}

	public void subscribeRadioButton(String yesOrNO) {

		if (yesOrNO.equalsIgnoreCase("yes")) {

			subscribeYesButton.click();
		} else {
			subscribeNoButton.click();
		}

	}

	public void clickOnContinue() {
		continueButton.click();
	}

	public boolean confirmationMessage() {
		boolean confirmationtext = accountCreatedConfirmationText.isDisplayed();
		return confirmationtext;
	}

}
