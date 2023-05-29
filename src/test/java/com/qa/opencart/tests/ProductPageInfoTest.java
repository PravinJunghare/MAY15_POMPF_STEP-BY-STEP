package com.qa.opencart.tests;

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
		return new Object[][] { { "Macbook", "MacBook Pro",4 }, { "Macbook", "MacBook Air",4},
			
				{ "iMac", "iMac",3 }, { "Samsung", "Samsung Galaxy Tab 10.1" ,7 }, { "Samsung", "Samsung SyncMaster 941BW",1  },
				{ "Apple", "Apple Cinema 30\"",6 }, };
	}

	@Test(dataProvider = "getProductImagesTestData")
	public void productImageCountTest(String searchkey,String productName,int imageCount) {
		searchPage = accPage.performSearch(searchkey);
		productInfoPage = searchPage.selectProduct(productName);
		int actImageCount = productInfoPage.getImageCount();
		Assert.assertEquals(actImageCount, imageCount);
	}

}
