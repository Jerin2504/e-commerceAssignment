package com.naveenautomationlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.TestBase.TestBase;

public class MyAccountInformationPage extends TestBase{
	
	MyAccountPage myaccount;
	
	public MyAccountInformationPage() {
		PageFactory.initElements(driver, this);
		myaccount = new MyAccountPage();
	}
	
	@FindBy(css = "input[name='firstname']")
	WebElement firstName;
	
	@FindBy(css = "input[name='lastname']")
	WebElement lastName;
	
	@FindBy(css = "input[name='email']")
	WebElement email;
	
	@FindBy(css = "input[name='telephone']")
	WebElement telephone;
	
	@FindBy(css = "input[type='submit']")
	WebElement continueBtn;
	
	public void modifyPersonalDetails(String firstName, String lastName, String email, String telephone) {
		myaccount.clickEditInformation();
		
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
		
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
		
		this.email.clear();
		this.email.sendKeys(email);
		
		this.telephone.clear();
		this.telephone.sendKeys(telephone);
		
		continueBtn.submit();
		
	}
	

}
