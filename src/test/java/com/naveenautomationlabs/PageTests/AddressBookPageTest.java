package com.naveenautomationlabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.Pages.AccountLoginPage;
import com.naveenautomationlabs.Pages.AddressBookPage;
import com.naveenautomationlabs.Pages.MyAccountPage;
import com.naveenautomationlabs.TestBase.TestBase;

public class AddressBookPageTest extends TestBase{
	
	AccountLoginPage accountLogin;
	AddressBookPage addressBook;
	MyAccountPage myAccount;
	
	@BeforeMethod
	public void setUp() {
		initialise();
		accountLogin = new AccountLoginPage();
		addressBook = new AddressBookPage();
		myAccount = new MyAccountPage();
		accountLogin.loginToMyAccount("mail@domain.com", "abc123");

	}
	
	@Test
	public void validateNewAddressCreation() {
		addressBook = myAccount.clickAddressBook();
		addressBook.addNewAddress();
		Assert.assertEquals(addressBook.getSuccessMessage(), "Your address has been successfully added", "New address cannot be added");
	}
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
