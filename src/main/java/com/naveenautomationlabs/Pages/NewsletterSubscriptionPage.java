package com.naveenautomationlabs.Pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naveenautomationlabs.TestBase.TestBase;

public class NewsletterSubscriptionPage extends TestBase{
	
	WebDriverWait wait;
	
	public NewsletterSubscriptionPage() {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@FindBy(css = "div.col-sm-10>label>input")
	WebElement subscribeYesBtn;
	
	@FindBy(css = "div.col-sm-10>label:last-of-type>input")
	WebElement subscribeNoBtn;
	
	@FindBy(css = "input[type='submit']")
	WebElement continueBtn;
	
	private void clickSubscribeYesBtn() {
		subscribeYesBtn.click();
	}
	
	private void clickSubscribeNoBtn() {
		subscribeNoBtn.click();
	}
	
	private void clickContinueBtn() {
		continueBtn.click();
	}
	
	public MyAccountPage subscribeNewsletter() {
		wait.until(ExpectedConditions.elementToBeClickable(subscribeYesBtn));
		clickSubscribeYesBtn();
		clickContinueBtn();
		
		return new MyAccountPage();
	}
	
	public MyAccountPage unsubscribeNewsletter() {
		wait.until(ExpectedConditions.elementToBeClickable(subscribeNoBtn));
		clickSubscribeNoBtn();
		clickContinueBtn();
		
		return new MyAccountPage();
	}

}
