package com.naveenautomationlabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.Pages.AccountLoginPage;
import com.naveenautomationlabs.Pages.ChangePasswordPage;
import com.naveenautomationlabs.Pages.MyAccountInformationPage;
import com.naveenautomationlabs.Pages.MyAccountPage;
import com.naveenautomationlabs.Pages.NewsletterSubscriptionPage;
import com.naveenautomationlabs.TestBase.TestBase;

public class MyAccountPageTest extends TestBase {

	MyAccountPage myAccount;
	NewsletterSubscriptionPage newsletterSubscription;
	AccountLoginPage accountLogin;
	ChangePasswordPage changePassword;
	MyAccountInformationPage myAccountInformation;

	@BeforeMethod
	public void setUp() {
		initialise();
		accountLogin = new AccountLoginPage();
		accountLogin.loginToMyAccount("mail@domain.com", "abc123");
		myAccount = new MyAccountPage();
		newsletterSubscription = new NewsletterSubscriptionPage();
		changePassword = new ChangePasswordPage();
		myAccountInformation = new MyAccountInformationPage();
		
	}

	@Test
	public void validateLogout() {
		myAccount.clickLogout();
		
		Assert.assertEquals(driver.getTitle(), "Account Logout");
	}
	
	@Test
	public void validateNewsletterSubscription() {
		myAccount.clickNewsletter();
		myAccount = newsletterSubscription.subscribeNewsletter();
		Assert.assertEquals(myAccount.getNewsletterSuccessMessage(), "Success: Your newsletter subscription has been successfully updated!");
	}
	
	@Test
	public void validateNewsletterOptOut() {
		myAccount.clickNewsletter();
		myAccount = newsletterSubscription.unsubscribeNewsletter();
		Assert.assertEquals(myAccount.getNewsletterSuccessMessage(), "Success: Your newsletter subscription has been successfully updated!");
	}
	
	@Test
	public void validatePasswordModification() {
		myAccount.clickPassword();
		myAccount = changePassword.changePassword();
		Assert.assertEquals(myAccount.getSuccessMessage(), "Success: Your password has been successfully updated.", "Password could not be changed");
	}
	
	@Test
	public void validateAccountInformationModification() {
		myAccountInformation.modifyPersonalDetails("Jerin", "Raj", "mail@domain.com", "963852741");
		Assert.assertEquals(myAccount.getSuccessMessage(), "Success: Your account has been successfully updated.");
	}
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}
