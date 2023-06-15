package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accountPageSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}

	@Test(priority = 1)
	public void verifyAccountsPageTilteTest() {
		String actualTitle = accPage.getAccountsPageTile();
		Assert.assertEquals(actualTitle, AppConstants.ACCOUNT_PAGE_TITLE_VALUE);
	}

	@Test(priority = 2)
	public void verifyAccountUrlTest() {
		String actualUrl = accPage.getAccountsUrl();
		Assert.assertTrue(actualUrl.contains(AppConstants.ACCOUNT_PAGE_URL_FRICTION_VALUE));
	}

	@Test(priority = 3)
	public void logoutlinkExistTest() {
		Assert.assertTrue(accPage.isLogoutLinkExists());
	}

	@Test(priority = 4)
	public void accountHeaderCountTest() {
		List<String> actualAccPageHeaderList = accPage.getAccountsPageHeaderList();
		System.out.println("Account Page Headerlist" + actualAccPageHeaderList);
		Assert.assertEquals(actualAccPageHeaderList.size(), AppConstants.ACCOUNTS_PAGE_HEADER_COUNT);

	}

	@Test(priority = 5)
	public void accountHeaderValueTest() {
		List<String> actualAccPageHeaderList = accPage.getAccountsPageHeaderList();
		System.out.println("Account Page Headerlist" + actualAccPageHeaderList);
		Assert.assertEquals(actualAccPageHeaderList, AppConstants.EXPECTED_ACCOUNTS_PAGE_HEADER_LIST);
	}

	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] { { "Macbook" }, { "imac" }, { "Samsung" }, { "Apple" }, };

	}

	@Test(priority = 6, dataProvider = "getProductData")
	public void searchProduct(String productName) {
		searchPage = accPage.performSearch(productName);
		Assert.assertTrue(searchPage.getSearchProductCount() > 0);

	}

	@DataProvider
	public Object[][] getProductTestData() {
		return new Object[][] { { "Macbook", "MacBook Pro" }, { "Macbook", "MacBook Air" }, { "Macbook", "MacBook" },
				{ "iMac", "iMac" }, { "Samsung", "Samsung Galaxy Tab 10.1" }, { "Samsung", "Samsung SyncMaster 941BW" },
				{ "Apple", "Apple Cinema 30\"" }, };
	}

	@Test(priority = 7, dataProvider = "getProductTestData")
	public void selectProductTest(String searchkey, String productName) {
		searchPage = accPage.performSearch(searchkey);
		if (searchPage.getSearchProductCount() > 0) {
			productInfoPage = searchPage.selectProduct(productName);
			String actualHeadervalue = productInfoPage.getProductHeaderValue();
			Assert.assertEquals(actualHeadervalue, productName);

		}

	}

}
