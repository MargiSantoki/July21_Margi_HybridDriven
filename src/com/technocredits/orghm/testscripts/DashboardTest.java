package com.technocredits.orghm.testscripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.technocredits.orghm.pages.DashboardPage;

public class DashboardTest extends TestBase {

	@BeforeMethod
	public void setUp() {
		super.setup();
	}

	@Test
	public void verifyDashboard() {

		System.out.println("STEP : Verify page header title");
		DashboardPage dashboardPage = new DashboardPage();
		String actualPageHeaderTitle = dashboardPage.getPageHeaderTitle();
		String expectedPageHeaderTitle = "Dashboard";
		softAssert.assertEquals(actualPageHeaderTitle, expectedPageHeaderTitle, "Invalid page header title");

		System.out.println("STEP : Verify page title");
		String actualPageTitle = dashboardPage.getPageTitle();
		String expectedPageTitle = "Dashboard";
		softAssert.assertEquals(actualPageTitle, expectedPageTitle, "Invalid page title");

		System.out.println("STEP : Verify count of total widgets is 12");
		int actualCount = dashboardPage.getTotalWidgets();
		int expectedCount = 12;
		softAssert.assertEquals(actualCount, expectedCount, "Invalid count of total widgets");
		softAssert.assertAll();

		System.out.println("STEP : Verify widgets name");
		List<String> actualList = dashboardPage.getAllWidgetsText();

		List<String> expectedList = new ArrayList<String>();
		expectedList.add("Quick Access");
		expectedList.add("Buzz Latest Posts");
		expectedList.add("Employee Job Details");
		expectedList.add("My Actions");
		expectedList.add("Headcount by Location");
		expectedList.add("Employees on Leave Today");
		expectedList.add("Time At Work");
		expectedList.add("Performance Quick Feedback");
		expectedList.add("Annual basic payment by Location");
		expectedList.add("Latest Documents");
		expectedList.add("Latest News");
		expectedList.add("Yearly New Hires");
		Assert.assertEquals(actualList, expectedList, "Invalid widgets name");

	}

	@AfterMethod
	public void tearDown() {
		super.teardown();
	}
}
