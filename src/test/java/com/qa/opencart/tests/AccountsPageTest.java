package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
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
		Assert.assertEquals(actualAccPageHeaderList, AppConstants.EXPECTED_ACCOUNTS_PAGE_HEADER_LIST);;

	}

}
