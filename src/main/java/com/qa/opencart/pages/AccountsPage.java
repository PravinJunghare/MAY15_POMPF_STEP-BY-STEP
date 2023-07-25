package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1. class constructor
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 2. private locators
	private By logoutlink = By.linkText("Logout");
	private By accountPageHeader = By.xpath("//div[@id ='content']/h2");
	private By search = By.name("search");

	// 3 Page action
	public String getAccountsPageTile() {
		// String accPageTile = driver.getTitle();
		String accPageTitle = eleUtil.waitForTitleContainsAndFetch(10, "My Account");
		System.out.println("Acc page Tile:" + accPageTitle);
		return accPageTitle;
	}

	public String getAccountsUrl() {
		String accPageUrl = driver.getCurrentUrl();
		System.out.println("Acc page Tile:" + accPageUrl);
		return accPageUrl;
	}

	public boolean isLogoutLinkExists() {
		// return driver.findElement(logoutlink).isDisplayed();
		return eleUtil.waitForElementVisible(logoutlink, 10).isDisplayed();
	}

	public List<String> getAccountsPageHeaderList() {

		// List<WebElement> accHeaderList = driver.findElements(accountPageHeader);
		List<WebElement> accHeaderList = eleUtil.waitForElementsPresence(accountPageHeader, 10);
		List<String> accHeaderValueList = new ArrayList<String>();

		for (WebElement e : accHeaderList) {
			String text = e.getText();
			accHeaderValueList.add(text);
		}
		return accHeaderValueList;

	}

}
