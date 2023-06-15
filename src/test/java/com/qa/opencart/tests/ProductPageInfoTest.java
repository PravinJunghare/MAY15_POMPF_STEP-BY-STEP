package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class ProductPageInfoTest extends BaseTest {

	@BeforeClass
	public void ProductInfoPageSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

	}

	@DataProvider
	public Object[][] getProductImagesTestData() {
		return new Object[][] { { "Macbook", "MacBook Pro", 4 }, { "Macbook", "MacBook Air", 4 },

				{ "iMac", "iMac", 3 }, { "Samsung", "Samsung Galaxy Tab 10.1", 7 },
				{ "Samsung", "Samsung SyncMaster 941BW", 1 }, { "Apple", "Apple Cinema 30\"", 6 }, };
	}

	@Test(dataProvider = "getProductImagesTestData")
	public void productImageCountTest(String searchkey, String productName, int imageCount) {
		searchPage = accPage.performSearch(searchkey);
		productInfoPage = searchPage.selectProduct(productName);
		int actImageCount = productInfoPage.getImageCount();
		Assert.assertEquals(actImageCount, imageCount);
	}

	@Test
	public void getProdcutInfoTest() {
		searchPage = accPage.performSearch("MacBook");
		productInfoPage = searchPage.selectProduct("MacBook Pro");
		Map<String, String> actProductInfoMap = productInfoPage.getProdcutInfo();

		// Soft Assertion Concept
		// When u want to verify multiple things

		softassert.assertEquals(actProductInfoMap.get("Brand"), "Apple");
		softassert.assertEquals(actProductInfoMap.get("Product Code"), "Product 18");
		softassert.assertEquals(actProductInfoMap.get("Reward Points"), "800");
		softassert.assertEquals(actProductInfoMap.get("Availability"), "In Stock");
		softassert.assertEquals(actProductInfoMap.get("productPrice"), "$2,000.00");
		softassert.assertEquals(actProductInfoMap.get("productname"), "MacBook Pro");
		softassert.assertAll();

	}

	@Test
	public void addTocartTest() {
		searchPage = accPage.performSearch("MacBook");
		productInfoPage = searchPage.selectProduct("MacBook Pro");
		productInfoPage.enterQuantity(2);
		String addCartmessg=productInfoPage.addToCart();
		//Success: You have added MacBook Pro to your shopping cart!
		softassert.assertTrue(addCartmessg.indexOf("Success")>=0);

		softassert.assertTrue(addCartmessg.indexOf("MacBook Pro")>=0);
		softassert.assertAll();

	}

}
