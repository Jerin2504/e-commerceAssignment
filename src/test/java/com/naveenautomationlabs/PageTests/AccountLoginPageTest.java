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
		Assert.assertEquals("My Account", driver.getTitle());
	}
	
	@Test
	public void validateLoginWithInvalidCredentials() {
		loginPage.loginToMyAccount("invalidmail@domain.com", "abc123");
		Assert.assertEquals("My Account", driver.getTitle());
	}
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
