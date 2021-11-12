package com.technocredits.orghm.testscripts;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.technocredits.orghm.pages.MenuPage;
import com.technocredits.orghm.pages.PIM_AddEmployeePage;
import com.technocredits.orghm.pages.PIM_EmployeeListPage;
import com.technocredits.orghm.pojo.Employee;
import com.technocredits.orghm.util.ExcelOperations;

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
		String empId = pim_addEmpPage.getEmployeeId();
		pim_addEmpPage.setEmpFirstName("Techno").setEmpMiddleName("A").setEmpLastName("Credits")
				.setEmpLocation("Canadian Development Center").clickOnNext().setHobbies("Painting").clickOnNext()
				.setWorkShift("Twilight").setEffectiveFrom("20").setRegion("Region-1").setFte("0.75")
				.setTemporaryDepartment("Sub unit-1").clickOnSaveButton();

		boolean isSuccessfullySavedVisible = pim_addEmpPage.isSuccessfullySaved();
		Assert.assertTrue(isSuccessfullySavedVisible, "Successfully saved message not visible");

		boolean isUserNameDisplayed = pim_addEmpPage.isUsernameTitleDisplayed();
		Assert.assertTrue(isUserNameDisplayed, "Invalid Add Employee");

		PIM_EmployeeListPage pim_empListPage = new PIM_EmployeeListPage();
		System.out.println("STEP : Navigate to Employee List");
		menuPage.navigateTo("Employee List");

		/*System.out.println("STEP : Verify record counts according to default pagination");
		int actualRecord = pim_empListPage.getRecordCount();
		int expectedRecord = 50;
		softAssert.assertEquals(actualRecord, expectedRecord, "Invalid record counts");
		softAssert.assertAll();*/

		System.out.println("STEP : Verify added employee is present in employee list");
		List<Employee> listOfEmployee = pim_empListPage.setEmpIdInQuickSearch(empId).getListOfEmployee();
		Assert.assertEquals(listOfEmployee.get(0).getEmpId(), empId, "Invalid list of employee");
		Assert.assertTrue(listOfEmployee.size() == 1, "Invalid size");
	}

	@Test(dataProvider = "employeeDataProvider")
	public void verifyAddEmployeeUsingDataDriven(String firstName, String middleName, String lastName, String location,
			String hobbies, String workShift, String effectiveFrom, String region, String fte, String tempDept) {

		System.out.println("STEP : Navigate to PIM -> Add Employee");
		menuPage.navigateTo("PIM->Add Employee");
		PIM_AddEmployeePage pim_addEmpPage = new PIM_AddEmployeePage();
		
		System.out.println("STEP : Verify Add employee is successfully saved");
		String empId = pim_addEmpPage.getEmployeeId();
		pim_addEmpPage.setEmpFirstName(firstName).setEmpMiddleName(middleName).setEmpLastName(lastName)
				.setEmpLocation(location).clickOnNext().setHobbies(hobbies).clickOnNext()
				.setWorkShift(workShift).setEffectiveFrom(effectiveFrom).setRegion(region).setFte(fte)
				.setTemporaryDepartment(tempDept).clickOnSaveButton();

		boolean isSuccessfullySavedVisible = pim_addEmpPage.isSuccessfullySaved();
		Assert.assertTrue(isSuccessfullySavedVisible, "Successfully saved message not visible");

		boolean isUserNameDisplayed = pim_addEmpPage.isUsernameTitleDisplayed();
		Assert.assertTrue(isUserNameDisplayed, "Invalid Add Employee");

		PIM_EmployeeListPage pim_empListPage = new PIM_EmployeeListPage();
		System.out.println("STEP : Navigate to Employee List");
		menuPage.navigateTo("Employee List");

		System.out.println("STEP : Verify added employee is present in employee list");
		List<Employee> listOfEmployee = pim_empListPage.setEmpIdInQuickSearch(empId).getListOfEmployee();
		Assert.assertEquals(listOfEmployee.get(0).getEmpId(), empId, "Invalid list of employee");
		Assert.assertTrue(listOfEmployee.size() == 1, "Invalid size");
	}

	@DataProvider(name = "employeeDataProvider")
	public Object[][] getEmployeeData() throws IOException {
		return ExcelOperations.getData("./testdata/add_employee.xlsx", "emp");
	}

	@AfterMethod
	public void tearDown() {
		super.teardown();
	}
}
