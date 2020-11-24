package com.zfnopCommerce.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver lDriver;
	
	public LoginPage(WebDriver rDriver) {
		lDriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"Email\"]")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(xpath = "//*[@id=\"Password\"]")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath = "/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/input")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath = "/html/body/div[3]/div[1]/div/div/ul/li[3]/a")
	@CacheLookup
	WebElement lnkLogout;
	
	public void setEmail(String email) {
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String password) {
		txtPassword.clear();
		txtPassword.sendKeys(password);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void clickLogout() {
		lnkLogout.click();
	}
}
