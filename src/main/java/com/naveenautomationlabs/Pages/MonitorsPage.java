package com.naveenautomationlabs.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.TestBase.TestBase;

public class MonitorsPage extends TestBase{
	
	public MonitorsPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "button[data-original-title*='Wish List']")
	List<WebElement> addToWishListBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Wish')]")
	WebElement wishListBtn;
	
	public void addAllMonitorsToWishList() {
		for(WebElement button : addToWishListBtn) {
			button.click();
		}
	}
	
	public MyWishListPage clickWishList() {
		wishListBtn.click();
		return new MyWishListPage();
	}
	
	public int numberOfProducts() {
		return addToWishListBtn.size();
	}

}
