package com.technocredits.orghm.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.technocredits.orghm.base.PredefinedActions;
import com.technocredits.orghm.pages.LoginPage;

public class LoginTest {

	SoftAssert softAssert = new SoftAssert();

	@BeforeMethod
	public void setup() {
		PredefinedActions.start();
	}

	@Test
	public void loginTest() {
		System.out.println("STEP : Verify Logo is displayed on Login page");
		LoginPage loginPage = new LoginPage();
		boolean isLogoDisplayed = loginPage.isLogoDisplayed();
		softAssert.assertTrue(isLogoDisplayed, "Logo is not displayed");

		System.out.println("STEP : Verify Logo panel is displayed on Login page");
		boolean isLogoPanelDisplayed = loginPage.isLoginPanelDisplayed();
		softAssert.assertTrue(isLogoPanelDisplayed, "Logo Panel is not displayed");

		System.out.println("STEP : Enter Credentials");
		loginPage.enterCredentials("Admin", "CSxe9EW@e0");
		softAssert.assertAll();

		System.out.println("STEP : Click on Login button");
		loginPage.clickOnLoginButton();
	}

	@Test
	public void loginTestWithoutPassword() {
		System.out.println("STEP : Verify Logo is displayed on Login page");
		LoginPage loginPage = new LoginPage();
		boolean isLogoDisplayed = loginPage.isLogoDisplayed();
		softAssert.assertTrue(isLogoDisplayed, "Logo is not displayed");

		System.out.println("STEP : Verify Logo panel is displayed on Login page");
		boolean isLoginPanelDisplayed = loginPage.isLoginPanelDisplayed();
		softAssert.assertTrue(isLoginPanelDisplayed, "Login Panel is not displayed");

		System.out.println("STEP : Enter Credentials");
		loginPage.enterCredentials("Admin", "");
		softAssert.assertAll();

		System.out.println("STEP : Click on Login button");
		loginPage.clickOnLoginButton();

		String expectedErrorMessage = "Password cannot be empty";
		String actualErrorMessage = loginPage.getLoginErrorMessage();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid Password error message");
	}

	@AfterMethod
	public void teardown() {
		PredefinedActions.closeBrowser();
	}
}
