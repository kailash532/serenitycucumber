package com.serenity.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends PageObject{
WebDriver driver;

	@FindBy(id="guestEmail")
	public WebElementFacade guestEmailId;
	
	@FindBy(id="checkoutGuest")
	public WebElementFacade checkoutGuestbutton;
	
	@FindBy(xpath="//div[@id='checkoutTitle']/h1[text()='Login']")
	public WebElementFacade loginPageTitle;
	
	@FindBy(id="email")
	public WebElementFacade regiesterdEmailId;
	
	@FindBy(id="passwrd")
	public WebElementFacade regiesterdPassword;
	
	@FindBy(id="checkoutRegistered")
	public WebElementFacade checkoutRegistered;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	

	public void checkoutAsGuest(String Email){
		guestEmailId.sendKeys(Email);
		checkoutGuestbutton.click();
		waitABit(5000);
	}
	
	public String VerfiyLoginPageTitle(){
		return loginPageTitle.getText();
	}
	
	
	public void checkoutAsRegiesterdUser(){
		regiesterdEmailId.sendKeys("");
		regiesterdPassword.click();
		checkoutRegistered.click();
	}
}
