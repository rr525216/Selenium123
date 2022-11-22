package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	private  By bestseller =By.xpath("(//a[contains(text(),'Best Sellers')])[1]");
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	public void  best() {
		driver.findElement(bestseller).click();
	}

	public void pageLogin(String url){

		driver.get(url);

	}

}
