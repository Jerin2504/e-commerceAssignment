package com.naveenautomationlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.TestBase.TestBase;

public class MyAccountPage extends TestBase {

	Actions action;
	
	public MyAccountPage() {
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
	}

	@FindBy(css = "div.list-group > a:last-of-type")
	WebElement logout;
	
	@FindBy(css = "div.list-group > a:nth-of-type(3)")
	WebElement password;
	
	@FindBy(css = "div.list-group > a:nth-of-type(2)")
	WebElement editInformation;
	
	@FindBy(css = "div.list-group > a:nth-of-type(4)")
	WebElement addressBook;
	
	@FindBy(xpath = "//div[@class='list-group'] //a[text()='Newsletter']")
	WebElement newsletter;
	
	@FindBy(css = "div.alert-success")
	WebElement newsletterSuccessMessage;
	
	@FindBy(css = "ul.nav>li:nth-of-type(3) a")
	WebElement components;
	
	@FindBy(css = "ul.nav>li:nth-of-type(3) li:nth-of-type(2) a")
	WebElement monitors;
	
	@FindBy(xpath = "//a[contains(text(),'Wish')]")
	WebElement wishList;
	
	@FindBy(xpath = "//div[@id='account-account'] //div")
	WebElement successMessage;

	public void clickLogout() {
		logout.click();
	}
	
	public void clickPassword() {
		password.click();
	}
	
	public MyWishListPage clickWishList() {
		wishList.click();
		return new MyWishListPage();
	}
	
	public void clickNewsletter() {
		newsletter.click();
	}
	
	public String getNewsletterSuccessMessage() {
		return newsletterSuccessMessage.getText().trim();
	}
	
	public MonitorsPage selectMonitors() {
		action.moveToElement(components).build().perform();
		monitors.click();
		
		return new MonitorsPage();
	}
	
	public AddressBookPage clickAddressBook() {
		addressBook.click();
		return new AddressBookPage();
	}
	
	public String getSuccessMessage() {
		return successMessage.getText().trim();
	}
	
	public void clickEditInformation() {
		editInformation.click();
	}
}


