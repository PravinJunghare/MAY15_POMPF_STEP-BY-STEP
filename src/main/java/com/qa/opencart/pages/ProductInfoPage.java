package com.qa.opencart.pages;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	private By productHeader = By.tagName("h1");
	private By prodcutImanges = By.cssSelector("ul.thumbnails img");
	private By productMetaData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]/li");
	private By productPriceData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[2]/li");
	private By quantity = By.id("input-quantity");
	private By addToCartBtn = By.id("button-cart");
	private By cartSuccessMesg = By.cssSelector("div.alert.alert-success");

	private Map<String, String> productInfoMap;

	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}

	public String getProductHeaderValue() {
		String productHeaderValue = eleUtil.doElementGetText(productHeader);
		System.out.println(productHeaderValue);
		return productHeaderValue;
	}

	public int getImageCount() {
		int imagesCount = eleUtil.waitForElementsVisible(prodcutImanges, AppConstants.DEFAULT_MEDIUM_TIMEOUT).size();
		System.out.println("Total image count:" + imagesCount);
		return imagesCount;
	}

	public void enterQuantity(int qty) {
		System.out.println("Prodcut Qunatity :" + qty);
		eleUtil.doSendKeys(quantity, String.valueOf(qty));
	}

	public String addToCart() {
		eleUtil.doClick(addToCartBtn);
		String successMesg = eleUtil.waitForElementVisible(cartSuccessMesg, AppConstants.DEFAULT_SHORT_TIMEOUT)
				.getText();

		StringBuilder sb =new StringBuilder(successMesg);
		String message=sb.substring(0, successMesg.length()-1).replace("\n","").toString();
		System.out.println("Cart Message is :"+message);
		return message;
	}

	public Map<String, String> getProdcutInfo() {

		// productInfoMap = new HashMap<String, String>();

		productInfoMap = new LinkedHashMap<String, String>();
		// Will maintain the order
		// productInfoMap = new TreeMap<String, String>();
		// will maintain order alphabetical

		// header
		productInfoMap.put("productname", getProductHeaderValue());
		getProductMetaData();
		getProductPriceData();
		System.out.println(productInfoMap);
		return productInfoMap;
	}

	// Fetching prodcutMetadata
	private void getProductMetaData() {
		// Brand: Apple
		// Product Code: Product 18
		// Reward Points: 800
		// Availability: In Stock
		// medata

		List<WebElement> metaList = eleUtil.getElements(productMetaData);
		for (WebElement e : metaList) {
			String meta = e.getText();
			String metaInfo[] = meta.split(":");
			String key = metaInfo[0].trim();
			String value = metaInfo[1].trim();
			productInfoMap.put(key, value);
		}

	}

	// Fetching productprice
	private void getProductPriceData() {
		// price data
		// $2,000.00
		// Ex Tax: $2,000.0

		List<WebElement> priceList = eleUtil.getElements(productPriceData);
		String price = priceList.get(0).getText();
		String exTax = priceList.get(1).getText();
		String extaxVal = exTax.split(":")[1];
		productInfoMap.put("productPrice", price);
		productInfoMap.put("exTax", extaxVal);
	}

}
