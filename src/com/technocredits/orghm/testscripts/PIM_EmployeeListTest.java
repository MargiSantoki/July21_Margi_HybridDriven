package com.technocredits.orghm.testscripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.technocredits.orghm.pages.MenuPage;
import com.technocredits.orghm.pages.PIM_EmployeeListPage;

public class PIM_EmployeeListTest extends TestBase {

	private MenuPage menuPage;

	@BeforeMethod
	public void setUp() {
		menuPage = super.setup();
	}

	@Test
	public void verifyEmployeeList() {

		System.out.println("STEP : Navigate to PIM -> Employee List");
		menuPage.navigateTo("PIM->Employee List");
		PIM_EmployeeListPage pim_empListPage = new PIM_EmployeeListPage();

		System.out.println("STEP : Verify record counts according to default pagination");
		int actualRecord = pim_empListPage.getRecordCount();
		int expectedRecord = 50;
		softAssert.assertEquals(actualRecord, expectedRecord, "Invalid record counts");

		System.out.println("STEP : Verify added employee is present in employee list");
		pim_empListPage.searchEmployee("Techno A Credits").clickOnSearchIcon();
		softAssert.assertTrue(pim_empListPage.isEmpPresent("Techno A Credits"),
				"Invalid verification of availability of added employee");
		softAssert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		super.teardown();
	}
}
