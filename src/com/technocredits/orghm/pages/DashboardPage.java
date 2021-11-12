package com.technocredits.orghm.pages;

import java.util.List;

import com.technocredits.orghm.base.PredefinedActions;

public class DashboardPage extends PredefinedActions {

	public String getPageHeaderTitle() {
		return driver.getTitle();
	}

	public String getPageTitle() {
		return getElement("XPATH", "//li[text()='Dashboard']", false).getText();
	}

	public int getTotalWidgets() {
		return getElements("XPATH", "//div[@id='widget.id']", false).size();
	}

	public List<String> getAllWidgetsText() {
		return getTextOfAllElements("//div[@class = 'widget-header']/span[2]");
	}

	public String getAllWidgetTextBasedOnIndex(int index) {
		List<String> widgetsList = getAllWidgetsText();
		return widgetsList.get(index);
	}
}
