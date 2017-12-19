package com.serenity.pages;

import java.awt.AWTException;
import java.awt.Robot;

import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class SecondScreen extends PageObject{

	
	
	WebDriver driver;
	
	
	@FindBy(how=How.ID,using="lst-ib")
	private WebElement googleTextfield;
	
	
	
	@FindBy(linkText="Selenium WebDriver")
	private WebElementFacade webdriverlink;
	
	
	public SecondScreen(final WebDriver driver){
		super();
		this.driver=driver;
	}
	
	public String getTitle(){
		return driver.getTitle();
		
		
	}
	
	public void EnterText(){
		googleTextfield.sendKeys("selenium webdriver ");
		
		Robot rb;
		try {
			rb = new Robot();
			rb.keyPress(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
	}
	
public void clickonWebdriverLink(){
	if(webdriverlink.isEnabled()){
		webdriverlink.click();
	}
		
	
}

}
