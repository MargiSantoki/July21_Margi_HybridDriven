package com.technocredits.orghm.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.technocredits.orghm.base.PredefinedActions;
import com.technocredits.orghm.pojo.Employee;

public class PIM_EmployeeListPage extends PredefinedActions {

	public PIM_EmployeeListPage searchEmployee(String name) {
		getElement("XPATH", "//input[@id='employee_name_quick_filter_employee_list_value']", false).sendKeys(name);
		return this;
	}

	public PIM_EmployeeListPage clickOnQuickSearchIcon(boolean isWaitRequired) {
		clickOnElement(getElement("XPATH", "//i[@id='quick_search_icon']", true));
		return this;
	}

	public boolean isEmpPresent(String empName) {
		return getElement("XPATH", "//table[@id='employeeListTable']//td[contains(text(),'" + empName + "')]", false).isDisplayed();
	}

	public int getRecordCount() {
		return getElements("XPATH", "//table[@id='employeeListTable']/tbody//tr", false).size();
	}
	
	public Employee getEmployeeDetailsById(boolean isEmployeeExpected) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		if(isEmployeeExpected)
		wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//table[@id='employeeListTable']/tbody/tr"), 1));
		return getListOfEmployee().get(0);
	}

	public List<Employee> getListOfEmployee() {
		int totalRows = getElements("XPATH", "//table[@id='employeeListTable']/tbody//tr", true).size();
		List<Employee> listOfEmp = new ArrayList<Employee>();
		for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
			Employee e = new Employee();
			e.setEmpId((getElement("XPATH", "//table[@id='employeeListTable']/tbody/tr[" + rowIndex + "]/td[2]", false)).getText());
			e.setEmpName((getElement("XPATH", "//table[@id='employeeListTable']/tbody/tr[" + rowIndex + "]/td[3]", false)).getText());
			e.setJobTitle((getElement("XPATH", "//table[@id='employeeListTable']/tbody/tr[" + rowIndex + "]/td[4]", false)).getText());
			e.setStatus((getElement("XPATH", "//table[@id='employeeListTable']/tbody/tr[" + rowIndex + "]/td[5]", false)).getText());
			e.setSubUnit((getElement("XPATH", "//table[@id='employeeListTable']/tbody/tr[" + rowIndex + "]/td[6]", false)).getText());
			e.setCostCenter((getElement("XPATH", "//table[@id='employeeListTable']/tbody/tr[" + rowIndex + "]/td[7]", false)).getText());
			e.setLocation((getElement("XPATH", "//table[@id='employeeListTable']/tbody/tr[" + rowIndex + "]/td[8]", false)).getText());
			e.setSupervisor((getElement("XPATH", "//table[@id='employeeListTable']/tbody/tr[" + rowIndex + "]/td[9]", false)).getText());
			listOfEmp.add(e);
		}
		return listOfEmp;
	}
	
	public PIM_EmployeeListPage setEmpIdInQuickSearch(String empId) {
		return setEmpNameInQuickSearch(empId);
	}
	
	public PIM_EmployeeListPage setEmpNameInQuickSearch(String empName) {
		getElement("XPATH","//input[@id='employee_name_quick_filter_employee_list_value']",true).sendKeys(empName);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e2) {
			e2.printStackTrace();
		}
		return this;
	}
	
	public void waitTillSuggestionBoxAppear() {
		System.out.println("wait until the list get populated and then click quick search");
		getElement("XPATH", "//div[@id='employee_name_quick_filter_employee_list_dropdown']/div[@class='angucomplete-row']", true);
	}
}
