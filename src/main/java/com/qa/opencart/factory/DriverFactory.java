package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	// initliaze thread local variable and create object at class level

	/**
	 * this method is initialzing the browser on basis of browser name
	 *
	 * @parambrowserName
	 * @return the driver
	 */
	public WebDriver initDriver(Properties prop) {

		optionManger = new OptionsManger(prop);
		highlight = prop.getProperty("highlight").trim();
		String browserName = prop.getProperty("browser").toLowerCase().trim();

		System.out.println("browsre Name is :" + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			// String path = System.getProperty("user. dir");

			System.setProperty("webdriver.chrome.driver",
					"G:\\NewPracticeworkspace\\POMPF_ECOM_ECART_APP\\DRIVERS\\chromedriver.exe");

			WebDriverManager.chromedriver().browserVersion("113.0.5672.93").setup();

			// driver = new ChromeDriver(optionManger.getChromeOption());
			tlDriver.set(new ChromeDriver(optionManger.getChromeOption()));
			// To Set Thread local driver

		}

		if (browserName.equalsIgnoreCase("firefox")) {
			// driver = new FirefoxDriver(optionManger.getFirefoxOption());

			tlDriver.set(new FirefoxDriver(optionManger.getFirefoxOption()));
		}

		// driver.manage().deleteAllCookies();
		// driver.manage().window().maximize();
		// driver.get(prop.getProperty("url"));
		// driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		// return driver;

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		// driver.get(prop.getProperty("url"));
		getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		return getDriver();

	}

	/*
	 * get local thread copy of driver
	 */

	public synchronized static WebDriver getDriver() {
		return tlDriver.get();
	}

	/**
	 * this method is reading the properties from .properties file
	 *
	 * @return
	 */
	public Properties initProp() {

		// maven clean install -Denv="qa";
		FileInputStream ip = null ;
		prop = new Properties();
     String envName= System.getProperty("env");
     System.out.println("Running on : "+envName);

     try {
     if(envName==null)

     {
    	 System.out.println("No environment is passed....Running on test env");
    	  ip = new FileInputStream(".src/test/resources/config/qa.config.properties");
     }

     else {
		switch (envName.toLowerCase().trim()) {
		case "qa":
			 ip = new FileInputStream(".src/test/resources/config/qa.config.properties");
			break;
		case "dev":
		     ip = new FileInputStream(".src/test/resources/config/dev.config.properties");
			break;
		case "prod":
			 ip = new FileInputStream(".src/test/resources/config/prod.config.properties");
			break;
		default:
			System.out.println("Wrong en no test casw will run");
			break;
		}
	}
     }
catch (Exception e) {
	// TODO: handle exception
}

     try {
		prop.load(ip);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		return prop;
	}

	/*
	 * Created screenshot method for failure test cases
	 */

	public static String getScreenshot() {
	File srcFile=((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
	// this line wil take screenshot
	String path=System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
	// this will giver the location of project and create screenshot folder and png file with current time
	File destFile=new File(path);
	// screen shot will be stored in new destionation
    try {
		//org.openqa.selenium.io.FileHandler.copy(srcFile, destFile);
    	FileUtils.copyFile(srcFile,destFile);

	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return path;


	}

}