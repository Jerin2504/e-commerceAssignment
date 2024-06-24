package com.naveenautomationlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.TestBase.TestBase;

public class ChangePasswordPage extends TestBase{
	
	MyAccountPage myaccount;
	
	public ChangePasswordPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "input[name='password']")
	WebElement password;
	
	@FindBy(css = "input[name='confirm']")
	WebElement confirmPassword;
	
	@FindBy(css = "input[type='submit']")
	WebElement continueBtn;
	
	public MyAccountPage changePassword() {
		String newPassword = "abc123";
		password.sendKeys(newPassword);
		confirmPassword.sendKeys(newPassword);
		continueBtn.submit();
		
		return new MyAccountPage();
	}

}
