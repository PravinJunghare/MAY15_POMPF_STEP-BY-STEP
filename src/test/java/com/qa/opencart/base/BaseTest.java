package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {
	/**
	 * here we need to do init browser enter url so will have to call init Driver
	 * method inDriverfactory class so created object do not inherit it becase it
	 * not a parnet class of BaseTest class as initDriver returning driver so we
	 * created the Webdriver driver to store driver refrence
	 **/

	DriverFactory df;
	WebDriver driver;


	// only access to child class in same or diffret packages
	protected Properties prop;
	protected LoginPage loginPage;
	protected AccountsPage accPage;

	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = df.initProp();
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
