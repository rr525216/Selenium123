package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver;
	private  By bestseller =By.xpath("(//a[contains(text(),'Best Sellers')])[1]");


	private  By bestselleproduct =By.xpath("//a[contains(text(),'Software')]");


	private  By music = By.xpath("//span[contains(text(),'Software')]/following::a[contains(text(),'Music')][1]");

	private  By prodOne =By.xpath("(//span[starts-with(text(),'#1')])[1]");

	private  By tred =By.xpath("(//span[starts-with(text(),'#1')])[1]/following::a[2]");

	private  By wishlist =By.xpath("//a[contains(text(),'Add to Wish List')]");
	private  By cart =By.xpath("//span[contains(text(),'Add to Cart')]");
	private  By gotocart =By.xpath("(//a[contains(text(),'Go to Cart')])[2]");




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
	public void  bestselleproduct() {
		driver.findElement(bestselleproduct).click();
	}
	public void  music() {
		driver.findElement(music).click();
	}

	public void  prodOne() {
		driver.findElement(prodOne).click();
	}

	public void  tred() {
		driver.findElement(tred).click();
	}

	public void  wishlist() {
		driver.findElement(wishlist).click();
	}
	public void  cart() throws InterruptedException {

		WebElement element =driver.findElement(By.xpath("//span[contains(text(),'Add to Cart')]"));
		//element.isEnabled();
	//	element.click();
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].click();",element);

	}
	public void  gotocart() {
	//	driver.findElement(gotocart).click();

		WebElement element =driver.findElement(By.xpath("(//a[contains(text(),'Go to Cart')])[2]"));
		//element.isEnabled();
		//	element.click();
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].click();",element);
	}



}
