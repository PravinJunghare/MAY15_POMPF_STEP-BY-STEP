package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class SearchPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	private By searchResults = By.cssSelector("div#content div.product-layout");

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		eleUtil=new ElementUtil(driver);
	}

	public int getSearchProductCount() {

		int productCount = eleUtil.waitForElementsVisible(searchResults, AppConstants.DEFAULT_MEDIUM_TIMEOUT).size();
		System.out.println("Search Product count:" + productCount);
		return productCount;

	}

	public ProductInfoPage selectProduct(String productName) {
		By productLocator = By.linkText(productName);
		eleUtil.waitForElementVisible(productLocator, AppConstants.DEFAULT_MEDIUM_TIMEOUT).click();
		return new ProductInfoPage(driver);
	}

}
