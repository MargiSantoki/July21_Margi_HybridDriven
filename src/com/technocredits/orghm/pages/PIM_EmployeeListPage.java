package com.technocredits.orghm.pages;

import org.openqa.selenium.By;

import com.technocredits.orghm.base.PredefinedActions;

public class PIM_EmployeeListPage extends PredefinedActions {

	public PIM_EmployeeListPage searchEmployee(String name) {
		driver.findElement(By.xpath("//input[@id='employee_name_quick_filter_employee_list_value']")).sendKeys(name);
		return this;
	}

	public void clickOnSearchIcon() {
		driver.findElement(By.xpath("//i[@id='quick_search_icon']")).click();
	}

	public boolean isEmpPresent(String empName) {
		return driver.findElement(By.xpath("//table[@id='employeeListTable']//td[contains(text(),'" + empName + "')]"))
				.isDisplayed();
	}
	
	public int getRecordCount() {
		return driver.findElements(By.xpath("//table[@id='employeeListTable']/tbody//tr")).size();
	}
}
