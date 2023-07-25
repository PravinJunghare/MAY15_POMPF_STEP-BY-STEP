package com.qa.opencart.tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class LoginPageTest extends BaseTest
{
	
	@Test(priority =1 )
	public void verifyLoginPageTilteTest()
	{
		String actualTitle=loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, "Account Login");
	}

	
	@Test(priority = 2)
	public void verifyLoginUrlTest()
	{
		String actualUrl=loginPage.getLoginUrl();
		Assert.assertTrue(actualUrl.contains("route=account/login"));
	}
	

	
	@Test(priority = 3)
	public void forgotPasswordlinkExistTest()
	{
	  Assert.assertTrue( loginPage.forgotPasswordLinkExits());
	}
	
	
	@Test(priority = 4)
	public void dologinTest()
	{
		accPage=loginPage.doLogin("pravinjunghare01@gmail.com", "Test@12345");
		Assert.assertTrue(accPage.isLogoutLinkExists());
		
		// after login we are moving to account page so accPage where we can store
		//to verify login is successful or not we have asserted logoutlinkis exist or not.
		
	}
	
	
	
}
