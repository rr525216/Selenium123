package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	// 1. By Locators: OR


	private  By bestseller =By.xpath("(//a[contains(text(),'Best Sellers')])[1]");

	// 2. Constructor of the page class:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions: features(behavior) of the page the form of methods:

	public String getLoginPageTitle() {
		return driver.getTitle();
	}


	public void  best() {

		driver.findElement(bestseller).click();
	}

}
