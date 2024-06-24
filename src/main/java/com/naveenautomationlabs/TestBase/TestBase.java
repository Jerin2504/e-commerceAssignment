package com.naveenautomationlabs.TestBase;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	private final String browser = "Chrome";
	private final String URL = "https://naveenautomationlabs.com/opencart/index.php?route=account/login";

	public void initialise() {
		initialiseWebDriver();
//		driver.manage().window().maximize();
		driver.get(URL);
	}

	private void initialiseWebDriver() {
		switch (browser) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			throw new InvalidArgumentException("Invalid browser" + browser);
		}
	}

	public void tearDown() {
		driver.quit();
	}
}
