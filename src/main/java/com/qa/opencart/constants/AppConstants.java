package com.qa.opencart.constants;

import java.util.Arrays;
import java.util.List;

public class AppConstants {
	public static final int DEFAULT_MEDIUM_TIMEOUT = 10;
	public static final int DEFAULT_SHORT_TIMEOUT = 5;
	public static final int DEFAULT_LONG_TIMEOUT = 20;

	public static final String LOGIN_PAGE_TITLE_VALUE = "Account Login";
	public static final String LOGIN_PAGE_URL_FRICTION_VALUE = "route=account/login";

	public static final String ACCOUNT_PAGE_TITLE_VALUE = "My Account";
	public static final String ACCOUNT_PAGE_URL_FRICTION_VALUE = "route=account/account";
	public static final int ACCOUNTS_PAGE_HEADER_COUNT = 4;

	public static final List<String> EXPECTED_ACCOUNTS_PAGE_HEADER_LIST=Arrays.asList("My Account","My Orders",
			"My Affiliate Account","Newsletter");
}
