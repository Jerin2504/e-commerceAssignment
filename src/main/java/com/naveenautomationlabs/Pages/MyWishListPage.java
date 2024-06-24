package com.naveenautomationlabs.Pages;

import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.TestBase.TestBase;

public class MyWishListPage extends TestBase {

	public MyWishListPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "tbody>tr")
	List<WebElement> products;

	@FindBy(css = "tbody>tr a[data-original-title='Remove']")
	List<WebElement> removeIcons;

	@FindBy(css = "div.col-sm-9 p")
	WebElement wishListEmptyMessage;

	public int numberOfProducts() {
		return products.size();
	}

	public String getWishListEmptyMessage() {
		return wishListEmptyMessage.getText().trim();
	}

	public MyWishListPage removeAllProductsFromWishList() {
		for (WebElement removeIcon : removeIcons) {
			try {
				removeIcon.click();
			} catch (StaleElementReferenceException e) {
				PageFactory.initElements(driver, this);
				removeAllProductsFromWishList();
			}
		}
		return new MyWishListPage();
	}
}
