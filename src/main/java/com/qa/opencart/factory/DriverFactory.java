package com.qa.opencart.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static String highlight;
	public WebDriver driver;

	public WebDriver initDriver(String browserName) {
		System.out.println("browsre Name is :" + browserName);

		if (browserName.trim().equalsIgnoreCase("chrome")) {
			String path = System.getProperty("user. dir");

			// System.setProperty("webdriver.chrome.driver",
			// "G:\\NewPracticeworkspace\\POMPF_ECOM_ECART_APP\\DRIVERS\\chromedriver.exe");

			WebDriverManager.chromedriver().browserVersion("113.0.5672.93").setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("enable-automation");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-infobars");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--disable-browser-side-navigation");
			options.addArguments("--disable-gpu");
			driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		}

		if (browserName.trim().equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		return driver;

	}

}
