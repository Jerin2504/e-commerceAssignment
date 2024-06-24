package com.naveenautomationlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.TestBase.TestBase;

public class AccountLoginPage extends TestBase {
	
	public AccountLoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-email")
	WebElement emailField;

	@FindBy(id = "input-password")
	WebElement pwdField;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginBtn;
	
	@FindBy(css = "div.alert")
	WebElement warningMessage;
	
	private void enterEmail(String email) {
		emailField.sendKeys(email);
	}
	
	private void enterPassword(String pwd) {
		pwdField.sendKeys(pwd);
	}
	
	private void clickLoginBtn() {
		loginBtn.click();
	}
	
	public String getWarningMessage() {
		return warningMessage.getText().trim();
	}
	
	public MyAccountPage loginToMyAccount(String email, String pwd) {
		enterEmail(email);
		enterPassword(pwd);
		clickLoginBtn();
		
		return new MyAccountPage();
	}
}
