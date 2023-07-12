package com.qa.opencart.tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class LoginPageTest extends BaseTest {

	@Epic("100: To desgin login page for OpenCart Application")
	@Story("100: To Desgin login Page feature for opencart Application")
	// Story Description

    @Severity(SeverityLevel.MINOR)
	@Description("Getting title of page......")
	@Test(priority = 1)
	// Test Description
	public void verifyLoginPageTilteTest() {
		String actualTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE_VALUE);
	}


	 @Severity(SeverityLevel.MINOR)
	 @Description("Getting Url of page......")
	@Test(priority = 2)
	public void verifyLoginUrlTest() {
		String actualUrl = loginPage.getLoginUrl();
		Assert.assertTrue(actualUrl.contains(AppConstants.LOGIN_PAGE_URL_FRICTION_VALUE));
	}


	 @Severity(SeverityLevel.BLOCKER)
	 @Description("ForgotPasswordlink exist......")
	@Test(priority = 3)
	public void forgotPasswordlinkExistTest() {
		Assert.assertTrue(loginPage.forgotPasswordLinkExits());
	}

	 @Severity(SeverityLevel.BLOCKER)
	 @Description("Checking user is login to app using valid cred")

	@Test(priority = 4)
	public void dologinTest() {
		accPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertTrue(accPage.isLogoutLinkExists());

		// after login we are moving to account page so accPage where we can store
		// to verify login is successful or not we have asserted logoutlinkis exist or
		// not.

	}

}
