package com.naveenautomationlabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.Pages.AccountLoginPage;
import com.naveenautomationlabs.Pages.MonitorsPage;
import com.naveenautomationlabs.Pages.MyAccountPage;
import com.naveenautomationlabs.Pages.MyWishListPage;
import com.naveenautomationlabs.TestBase.TestBase;

public class MyWishListPageTest extends TestBase {

	AccountLoginPage accountLogin;
	MonitorsPage monitors;
	MyWishListPage myWishList;
	MyAccountPage myAccountPage;


	@BeforeMethod
	public void setUp() {
		initialise();
		accountLogin = new AccountLoginPage();
		accountLogin.loginToMyAccount("mail@domain.com", "abc123");
		monitors = new MonitorsPage();
		myWishList = new MyWishListPage();
		myAccountPage = new MyAccountPage();

	}

	@Test(priority = 1)
	public void validateAllProductsAreAddedToWishList()  {
		monitors = myAccountPage.selectMonitors();
		monitors.addAllMonitorsToWishList();
		int numberOfProductsAdded = monitors.numberOfProducts();
		myWishList = monitors.clickWishList();
		Assert.assertEquals(numberOfProductsAdded, myWishList.numberOfProducts(),
				"All product are not added to wish list");
	}
	
		
	@Test (priority = 2)
	public void validateAllProductsAreRemoved() {
		myWishList = myAccountPage.clickWishList();
		myWishList = myWishList.removeAllProductsFromWishList();
		Assert.assertEquals(myWishList.getWishListEmptyMessage(), "Your wish list is empty.");
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
