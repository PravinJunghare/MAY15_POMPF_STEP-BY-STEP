package com.qa.opencart.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ExcelUtil;

public class RegistrationPageTest extends BaseTest {

	// precondition
	@BeforeClass
	public void regPageSetUp() {
		registrationPage = loginPage.navigateToRegisterPage();
	}

	// Email generation random
	public String getRandomEmail() {
		Random random = new Random();
		// String email="automation"+ random.nextInt(1000) + "@gmail.com";
		String email = "automation" + System.currentTimeMillis() + "@gmail.com";
		// automation because of automation engineer created that data
		return email;
	}

	@DataProvider
	public Object[][] getRegTestData() {
		Object regdata[][] = ExcelUtil.getTestData(AppConstants.REGISTER_SHEET_NAME);
		return regdata;

	}

	@Test(dataProvider = "getRegTestData")
	public void userRegTest(String firstName, String lastName, String telephone, String password,
			String subscribe) {

		Assert.assertTrue(
				registrationPage.registerUser(firstName, lastName, getRandomEmail(), telephone, password, subscribe));

		// hardcoded values

		/*
		 * public void userRegTest(String firstName,String lastName,String email,String
		 * telephone, String password,String subscribe) {
		 * Assert.assertTrue(registrationPage.regiterUser("Test", "USer",
		 * "Testuser0101@gmail.com", "9090909090", "Test1234", "Yes"));
		 */

	}

}
