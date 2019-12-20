package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.Base;
import pageObjects.LoginPageObject;




public class LoginTest extends Base {
	LoginPageObject loginpage;
	
	@BeforeMethod
	public void setUp() {
		Base.initializeDriver();

	}
	
	@Test
	public void loginToCanvasTest(){
		loginpage = new LoginPageObject();
		System.out.println(loginpage.pageTitle());
		loginpage.clickOnLoginToClassLink();
		System.out.println(driver.getTitle());
		System.out.println("this is test");
	}
	
	@Test
	public void loginToTestEnvironmentTest(){
		loginpage = new LoginPageObject();
		System.out.println(loginpage.pageTitle());
		loginpage.clickOnLoginToClassLink();
		System.out.println(driver.getTitle());
		System.out.println("this is test");
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		
		Base.teardown();
		System.out.println("this is after test");
	}

}
