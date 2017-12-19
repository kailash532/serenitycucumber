package com.serenity.pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.serenity.Constants.SampleConstants;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class Basket extends PageObject {

	WebDriver driver;

	@FindBy(xpath = "//*[@id='basketList']/div/div/div/div/ul/li/div[2]/h4/a")
	WebElementFacade basket_ProductName;

	@FindBy(xpath = "//*[@id='basketList']/div/div/div/div/ul/li/div[2]/span[2]/strong")
	WebElementFacade basket_ProductSize;

	@FindBy(xpath = "//*[@id='basketList']/div/div/div/div/ul/li/div[5]/span")
	WebElementFacade basket_Productprice;

	@FindBy(xpath = "//*[@id='basketList']/div/div/div/div/ul/li/div[2]/span[1]/strong")
	WebElementFacade basket_Productcode;
	
	@FindBy(xpath="//div[@class='basketContinue']/a[@title='Checkout securely']")
	public WebElementFacade checkoutButton;

	public Basket(final WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void verifyBasketDetails(){
		if(! Serenity.sessionVariableCalled(SampleConstants.PRODUCT_NAME).toString().equals("NONE")){
			assertEquals(Serenity.sessionVariableCalled(SampleConstants.PRODUCT_NAME), basket_ProductName.getText());
		}
		
		assertEquals(Serenity.sessionVariableCalled(SampleConstants.SELECTPRODUCT_PLU), basket_Productcode.getText());
		assertEquals(Serenity.sessionVariableCalled(SampleConstants.SELECTEDPRODUCT_SIZE), basket_ProductSize.getText());
		assertTrue(Serenity.sessionVariableCalled(SampleConstants.SELECTEDPRODUCT_PRICE).toString().contains(basket_Productprice.getText().trim().replace("£", "")));
		
	}

}
