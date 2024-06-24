package com.naveenautomationlabs.Pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naveenautomationlabs.TestBase.TestBase;

public class AddressBookPage extends TestBase{
	
	CommonUtilities common;
	Select select;
	WebDriverWait wait;
	
	public AddressBookPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'New Address')]")
	WebElement newAddress;
	
	@FindBy(css = "fieldset>div:first-of-type input")
	WebElement firstName;
	
	@FindBy(css = "fieldset>div:nth-of-type(2) input")
	WebElement lastName;
	
	@FindBy(css = "fieldset>div:nth-of-type(4) input")
	WebElement address1;
	
	@FindBy(css = "fieldset>div:nth-of-type(6) input")
	WebElement city;
	
	@FindBy(css = "fieldset>div:nth-of-type(7) input")
	WebElement postalCode;
	
	@FindBy(css = "fieldset>div:nth-of-type(8) select")
	WebElement country;
	
	@FindBy(css = "fieldset>div:nth-of-type(9) select")
	WebElement region;
	
	@FindBy(css = "fieldset>div:nth-of-type(10) div>label:first-of-type input")
	WebElement defaultAddressYesRadioBtn;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement continueBtn;
	
	@FindBy(css = "div[id='account-address'] div")
	WebElement successMessage;
	
	
	public void addNewAddress() {
		newAddress.click();
		fillDetails();
		continueBtn.click();
	}


	private void fillDetails() {
		common = new CommonUtilities();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		firstName.sendKeys(common.getRandomFirstName());
		lastName.sendKeys(common.getRandomLastName());
		address1.sendKeys("45 Street Rd");
		city.sendKeys(common.getRandomCityName());
		postalCode.sendKeys(common.getRandomPostalCode());
		
		select = new Select(country);
		select.selectByVisibleText("Canada");
		
		wait.until(ExpectedConditions.visibilityOf(region));
		select = new Select(region);
		select.selectByValue("610");
		
		defaultAddressYesRadioBtn.click();
	}
	
	public String getSuccessMessage() {
		return successMessage.getText().trim();
	}

}
