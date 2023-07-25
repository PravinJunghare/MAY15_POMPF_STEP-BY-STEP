package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	
	private By productHeader=By.tagName("h1");
	private By prodcutImanges=By.cssSelector("ul.thumbnails img");

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}
	
	public String getProductHeaderValue()
	{
		String productHeaderValue=eleUtil.doElementGetText(productHeader);
		System.out.println(productHeaderValue);
		return productHeaderValue;
	}
	
	public int getImageCount() {
		int imagesCount=eleUtil.waitForElementsVisible(prodcutImanges, AppConstants.DEFAULT_MEDIUM_TIMEOUT).size();
		System.out.println("Total image count:" +imagesCount);
		return imagesCount;
	}
	
	
	

}
