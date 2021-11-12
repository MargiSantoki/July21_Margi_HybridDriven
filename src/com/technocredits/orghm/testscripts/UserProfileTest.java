package com.technocredits.orghm.testscripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.technocredits.orghm.pages.UserProfilePage;

public class UserProfileTest extends TestBase {

	@BeforeMethod
	public void setUp() {
		super.setup();
	}

	@Test
	public void verfiyUserMenuOptions() {
		UserProfilePage userProfilePage = new UserProfilePage();
		System.out.println("STEP : Verify user profile picture is displayed");
		softAssert.assertTrue(userProfilePage.isProfilePictureDisplayed());

		System.out.println("STEP : Click on user dropdown");
		userProfilePage.clickOnUserDropdown();

		System.out.println("STEP : Verify total options");
		int actualCount = userProfilePage.getTotalAvailableOptions();
		int expectedCount = 3;
		softAssert.assertEquals(actualCount, expectedCount, "Invalid number of options");
		softAssert.assertAll();

		System.out.println("STEP : Verify Drop down options");
		List<String> actualList = userProfilePage.getListOfUserDropdownOptions();
		List<String> expectedList = new ArrayList<>();
		expectedList.add("About");
		expectedList.add("Change Password");
		expectedList.add("Logout");
		softAssert.assertEquals(actualList, expectedList, "Invalid options");

		System.out.println("STEP : Click on About");
		userProfilePage.clickOnAbout();

		System.out.println("STEP : Verify employee count is more than 0");
		softAssert.assertTrue(userProfilePage.isEmpCountGreaterThanZero());

		System.out.println("STEP : Verify company name");
		String actualCompanyName = userProfilePage.getCmpNameFromAboutPopup();
		String expectedCompanyName = "OrangeHRM (Pvt) Ltd(Parallel Demo)";
		softAssert.assertEquals(actualCompanyName, expectedCompanyName);

		System.out.println("STEP : Verify version");
		String actualVersion = userProfilePage.getVersionFromAboutPopup();
		String expectedVersion = "OrangeHRM 7.2.159485";
		softAssert.assertEquals(actualVersion, expectedVersion);

//		System.out.println("STEP : Verify employees");
//		String actualEmployees = userProfilePage.getEmployeesFromAboutPopup();
//		String expectedEmployees = "101 (299 more allowed)";
//		softAssert.assertEquals(actualEmployees, expectedEmployees);

		System.out.println("STEP : Verify users");
		String actualUsers = userProfilePage.getUsersFromAboutPopup();
		String expectedUsers = "77 (723 more allowed)";
		softAssert.assertEquals(actualUsers, expectedUsers);

		System.out.println("STEP : Verify Renewal On");
		String actualRenewalOn = userProfilePage.getRenewalOnFromAboutPopup();
		String expectedRenewalOn = "Wed, 01 Jun 2022";
		softAssert.assertEquals(actualRenewalOn, expectedRenewalOn);
		softAssert.assertAll();

		System.out.println("STEP : Click on OK Button");
		userProfilePage.clickOnOkButton();
		softAssert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		super.teardown();
	}
}
