package com.serenity.pages;

import org.junit.Before;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.google.com")
public class FirstScreen extends PageObject{
	
	
	WebDriver driver;
	
	
	@FindBy(id="class")
	private WebElementFacade classname;
	
	
	
	@FindBy(className="XXXXX")
	private WebElementFacade classlabel;
	
	public FirstScreen(final WebDriver driver){
		super(driver);
		this.driver=driver;
	}
	
	/*@Before
	
	public void setIEpath(){
		System.setProperty("webdriver.ie.driver", "D:/selenium_servers/IEDriverServer_x64_2.53.1/IEDriverServer.exe");
	}*/
	
	
	
	
	public void openPage(){
		
		this.open();
	}
	public void setClass(String claname){
		
		element(classname).type(claname).sendKeys(Keys.TAB);
		
	}
	
	public String getclasslabelText(){
		return classname.getText();
	}
	
	public String getTitle(){
		return driver.getTitle();
		
		
	}

}
