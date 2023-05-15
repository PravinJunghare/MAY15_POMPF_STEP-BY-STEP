package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	private WebDriver driver;

	// 1. class constructor
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}

	// 2. private locators
	private By logoutlink = By.linkText("Logout");
	private By accountPageHeader = By.xpath("//div[@id ='content']/h2");
	private By search = By.name("search");

	// 3 Page action
	public String getAccountsPageTile() {
		String accPageTile = driver.getTitle();
		System.out.println("Acc page Tile:" + accPageTile);
		return accPageTile;
	}

	public String getAccountsUrl() {
		String accPageUrl = driver.getCurrentUrl();
		System.out.println("Acc page Tile:" + accPageUrl);
		return accPageUrl;
	}

	public boolean isLogoutLinkExists() {
		return driver.findElement(logoutlink).isDisplayed();
	}

	public List<String> getAccountsPageHeaderList() {

		List<WebElement> accHeaderList = driver.findElements(accountPageHeader);
		List<String> accHeaderValueList = new ArrayList<String>();

		for (WebElement e : accHeaderList) {
			String text = e.getText();
			accHeaderValueList.add(text);
		}
		return accHeaderValueList;

	}

}
