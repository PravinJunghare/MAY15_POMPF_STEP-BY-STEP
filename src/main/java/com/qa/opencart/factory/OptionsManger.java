package com.qa.opencart.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManger {

	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;

	public OptionsManger(Properties prop) {
		this.prop = prop;
	}

	public ChromeOptions getChromeOption() {
		co = new ChromeOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless").trim())) {
			System.out.println("Running chrome in headless........");
			co.addArguments("--headless");
		}

		if (Boolean.parseBoolean(prop.getProperty("incognito").trim())) {
			System.out.println("Runnuing chrome in incognito");
			co.addArguments("--incognito");
		}


		return co;
	}

	public FirefoxOptions getFirefoxOption() {
		fo = new FirefoxOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless").trim()))
			fo.addArguments("--headless");
		if (Boolean.parseBoolean(prop.getProperty("incognito").trim()))
			fo.addArguments("--incognito");
		return fo;
	}
}
