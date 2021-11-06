package com.technocredits.orghm.testscripts;

import org.testng.asserts.SoftAssert;

import com.technocredits.orghm.base.PredefinedActions;
import com.technocredits.orghm.pages.LoginPage;
import com.technocredits.orghm.pages.MenuPage;

public class TestBase {

	SoftAssert softAssert = new SoftAssert();

	public MenuPage setup() {
		System.out.println("STEP : Launch OrgHm Application");
		PredefinedActions.start();
		System.out.println("STEP : Enter Credentials");
		LoginPage loginPage = new LoginPage();
		loginPage.enterCredentials("Admin", "CSxe9EW@e0");
		System.out.println("STEP : Click on Login button");
		return loginPage.clickOnLoginButton();
	}
	
	public void teardown() {
		PredefinedActions.closeBrowser();
	}
}
