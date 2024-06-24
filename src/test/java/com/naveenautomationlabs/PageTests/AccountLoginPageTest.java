package com.naveenautomationlabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.Pages.AccountLoginPage;
import com.naveenautomationlabs.TestBase.TestBase;

public class AccountLoginPageTest extends TestBase{
	
	AccountLoginPage loginPage;
	
	@BeforeMethod
	public void setUp() {
		initialise();
		loginPage = new AccountLoginPage();
	}
	
	@Test
	public void validateLoginWithValidCredentials() {
		loginPage.loginToMyAccount("mail@domain.com", "abc123");
		Assert.assertEquals(driver.getTitle(), "My Account");
	}
	
	@Test
	public void validateLoginWithInvalidCredentials() {
		loginPage.loginToMyAccount("invalidmail1@domain.com", "abc123");
		Assert.assertEquals(loginPage.getWarningMessage(), "Warning: No match for E-Mail Address and/or Password.");
	}
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
