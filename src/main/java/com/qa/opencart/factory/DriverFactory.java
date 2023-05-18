package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static String highlight;
	public WebDriver driver;
	public Properties prop;
	public OptionsManger optionManger;

	/**
	 * this method is initialzing the browser on basis of browser name
	 * 
	 * @parambrowserName
	 * @return the driver
	 */
	public WebDriver initDriver(Properties prop) {
	
		optionManger = new OptionsManger(prop);
		highlight=prop.getProperty("highlight").trim();
		String browserName = prop.getProperty("browser").toLowerCase().trim();

		System.out.println("browsre Name is :" + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			// String path = System.getProperty("user. dir");

			// System.setProperty("webdriver.chrome.driver",
			// "G:\\NewPracticeworkspace\\POMPF_ECOM_ECART_APP\\DRIVERS\\chromedriver.exe");

			WebDriverManager.chromedriver().browserVersion("113.0.5672.93").setup();

			driver = new ChromeDriver(optionManger.getChromeOption());

		}

		if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver(optionManger.getFirefoxOption());
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		return driver;

	}

	/**
	 * this method is reading the properties from .properties file
	 * 
	 * @return
	 */
	public Properties initProp() {
		prop = new Properties();

		try {
			FileInputStream ip = new FileInputStream("src\\test\\resources\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

}
