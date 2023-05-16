package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	// default value of driver is null
	// Every class has own private elementutil

	// 1 private By Loactors

	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginButton = By.xpath("//input[@value='Login']");
	private By forgotPassword = By.linkText("Forgotten Password");

	// 2 Page Constructor
	// here driver is get initalizes

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

		// here we have created elementutil object because it also hava driver
		// same driversesion will mainatined
	}

	// 3.Page Actions Method
	// Here we are using private by loactors in public method ie
	// encapsulation concept

	public String getLoginPageTitle() {
	//	String title = driver.getTitle();
		String title=eleUtil.waitForTitleContainsAndFetch(10, "Account Login");
		System.out.println("Login Page Title is :" + title);
		return title;
	}

	public String getLoginUrl() {
		String url = driver.getCurrentUrl();
		//String url= eleUtil.waitForURLIsAndFetch(10,"route=account/login");
		System.out.println("Login Page Url is :" + url);
		return url;

	}

	public boolean forgotPasswordLinkExits() {
		//return driver.findElement(forgotPassword).isDisplayed();
		return eleUtil.waitForElementVisible(forgotPassword, 10).isDisplayed();

	}

	public AccountsPage doLogin(String un, String pwd) {
		// driver.findElement(emailId).sendKeys(un);
		// driver.findElement(password).sendKeys(pwd);
		// driver.findElement(loginButton).click();
		eleUtil.waitForElementVisible(emailId, 0).sendKeys(un);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginButton);
		return new AccountsPage(driver);

		// here after clicking on login we are navingating to accounts page
		// methods responsiblity is return the landing page object

		// Here it suggesting create AccountsPage class
		// this is Test Driven Develpoment (TDD) approch
		// to fullfull my test case whatever class or methods are require create it
	}

}