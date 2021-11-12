package com.technocredits.orghm.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import com.technocredits.orghm.base.PredefinedActions;

public class PIM_AddEmployeePage extends PredefinedActions {

	public String getEmployeeId() {
		WebElement employeeId = getElement("XPATH", "//input[@id='employeeId']", true);
		return employeeId.getAttribute("value");
	}

	public PIM_AddEmployeePage setEmpFirstName(String fname) {
		getElement("XPATH", "//input[@id='first-name-box']", false).sendKeys(fname);
		return this;
	}

	public PIM_AddEmployeePage setEmpMiddleName(String mname) {
		getElement("XPATH", "//input[@id='middle-name-box']", false).sendKeys(mname);
		return this;
	}

	public PIM_AddEmployeePage setEmpLastName(String lname) {
		getElement("XPATH", "//input[@id='last-name-box']", false).sendKeys(lname);
		return this;
	}

	public PIM_AddEmployeePage setEmpLocation(String location) {
		clickOnElement(getElement("XPATH", "//i[text()='arrow_drop_down']", false));
		clickOnElement(getElement("XPATH", "//span[text()='" + location + "']//parent::a", false));
		return this;
	}

	public PIM_AddEmployeePage clickOnNext() {
		clickOnElement(getElement("XPATH", "//button[text()='Next']", false));
		return this;
	}

	public PIM_AddEmployeePage setHobbies(String hobbies) {
		getElement("XPATH", "//input[@id='5']", true).sendKeys(hobbies);
		return this;
	}

	public PIM_AddEmployeePage setWorkShift(String shiftValue) {
		clickOnElement(getElement("XPATH",
				"//div[@id='work_shift_id_inputfileddiv']//span[@class='caret']//following-sibling::input", true));
		clickOnElement(getElement("XPATH",
				"//ul[contains(@class,'dropdown-content select-dropdown')]//span[text()='" + shiftValue + "']", true));
		return this;
	}

	public PIM_AddEmployeePage setEffectiveFrom(String date) {
		date = date.split("\\.")[0];
		clickOnElement(getElement("XPATH", "//label[text()='Effective From']/following-sibling::span//i", false));
		clickOnElement(getElement("XPATH",
				"//input[@id='add_employee_effective_date']//following-sibling::span[1]//div[text()='" + date
						+ "'][contains(@class,'--infocus')]",
				true));
		return this;
	}

	public PIM_AddEmployeePage setRegion(String region) {
		clickOnElement(getElement("XPATH", "//label[text()='Region']/preceding-sibling::div/input", true));
		clickOnElement(getElement("XPATH", "//span[text()='" + region + "']", true));
		return this;
	}

	public PIM_AddEmployeePage setFte(String fteInput) {
		if (fteInput.equals("1.0"))
			fteInput = "1";
		clickOnElement(getElement("XPATH",
				"//div[@id='10_inputfileddiv']//span[@class='caret']//following-sibling::input", false));
		clickOnElement(getElement("XPATH", "//div[@id='10_inputfileddiv']//span[text()='" + fteInput + "']", true));
		return this;
	}

	public PIM_AddEmployeePage setTemporaryDepartment(String tempDept) {
		clickOnElement(getElement("XPATH",
				"//div[@id='11_inputfileddiv']//span[@class='caret']//following-sibling::input", false));
		clickOnElement(getElement("XPATH", "//div[@id='11_inputfileddiv']//span[text()='" + tempDept + "']", true));
		return this;
	}

	public void addEmployeeInfo(String fname, String mname, String lname, String location) {
		setEmpFirstName(fname);
		setEmpMiddleName(mname);
		setEmpLastName(lname);
		setEmpLocation(location);
	}

	public PIM_AddEmployeePage clickOnSaveButton() {
		clickOnElement(getElement("XPATH", "//button[text()='Save']", false));
		return this;
	}

	public boolean isSuccessfullySaved() {
		try {
			getElement("XPATH", "//div[@class='toast-message']", true);
			return true;
		} catch (NoSuchElementException | StaleElementReferenceException e) {
			return false;
		}
	}

	public boolean isUsernameTitleDisplayed() {
		try {
			getElement("XPATH", "//span[@id='pim.navbar.employeeName']", true);
			return true;
		} catch (TimeoutException te) {
			return false;
		}
	}
}
