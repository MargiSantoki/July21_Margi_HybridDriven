package com.technocredits.orghm.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.technocredits.orghm.pages.MenuPage;
import com.technocredits.orghm.pages.PIM_AddEmployeePage;

public class PIM_AddEmployeeTest extends TestBase {

	private MenuPage menuPage;

	@BeforeMethod
	public void setUp() {
		menuPage = super.setup();
	}

	@Test
	public void verifyAddEmployee() {

		System.out.println("STEP : Navigate to PIM -> Add Employee");
		menuPage.navigateTo("PIM->Add Employee");
		PIM_AddEmployeePage pim_addEmpPage = new PIM_AddEmployeePage();
		System.out.println("STEP : Verify Add employee is successfully saved");
		pim_addEmpPage.setEmpFirstName("Techno").setEmpMiddleName("A").setEmpLastName("Credits")
				.setEmpLocation("Canadian Development Center").clickOnNext().setHobbies("Painting").clickOnNext()
				.setWorkShift("Twilight").setEffectiveFrom("20").setRegion("Region-1").setFte("0.75")
				.setTemporaryDepartment("Sub unit-1").clickOnSaveButton();
		Assert.assertTrue(pim_addEmpPage.isSuccessfullySaved(), "Invalid Add Employee");

	}

	@AfterMethod
	public void tearDown() {
		super.teardown();
	}
}
