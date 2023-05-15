package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accountPageSetup() {
		accPage = loginPage.doLogin("pravinjunghare01@gmail.com", "Test@12345");
	}

	@Test(priority = 1)
	public void verifyAccountsPageTilteTest() {
		String actualTitle = accPage.getAccountsPageTile();
		Assert.assertEquals(actualTitle, "My Account");
	}

	@Test(priority = 2)
	public void verifyAccountUrlTest() {
		String actualUrl = accPage.getAccountsUrl();
		Assert.assertTrue(actualUrl.contains("route=account/account"));
	}

	@Test(priority = 3)
	public void logoutlinkExistTest() {
		Assert.assertTrue(accPage.isLogoutLinkExists());
	}
	
	@Test
	public void accountHeaderTest() {
		List<String> actualAccPageHeaderList=accPage.getAccountsPageHeaderList();
		Assert.assertEquals(actualAccPageHeaderList.size(), 4);
		
	}

}
