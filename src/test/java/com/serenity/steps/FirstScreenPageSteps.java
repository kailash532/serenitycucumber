package com.serenity.steps;


import java.io.IOException;
import java.util.Random;

import com.serenity.Constants.SampleConstants;
import com.serenity.pages.FirstScreen;
import com.serenity.pages.LoginPage;
import com.serenity.pages.Basket;
import com.serenity.pages.BillingAndReview;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import static org.junit.Assert.*;
public class FirstScreenPageSteps extends ScenarioSteps{
	
	FirstScreen firstscreen;
	Basket basket;
	LoginPage login;
	BillingAndReview payment;
	
	
	@Step
	public void launchApp() throws IOException{
		
		firstscreen.openPage();
		
	}
	
	@Step
	public String productTitle(){
		Serenity.setSessionVariable(SampleConstants.SELECTEDPRODUCT_NAME).to(firstscreen.productTitle());
		return firstscreen.productTitle();
				 
	}
	
	@Step
	public void searchForProduct(String searchtext){
		firstscreen.EnterSearchText(searchtext);
		firstscreen.clickSearchButton();
	}
	
	@Step
	public String getCurrentURL(){
		return firstscreen.currentURL();
	}
	
	
	@Step
	public void selectRandomProduct(){
		int productsCount=getDriver().findElements(org.openqa.selenium.By.xpath("//ul[@id='productListMain']/li")).size();
		Random rand = new Random();
		int  randomNumber = rand.nextInt(productsCount) + 1;
		getDriver().findElement(org.openqa.selenium.By.xpath("//ul[@id='productListMain']/li["+randomNumber+"]")).click();
		
	}
	
	@Step
	public void selectSize(){
		int sizesavailable=getDriver().findElements(By.xpath("//div[@class='options']/button[contains(@title,'Select Size')]")).size();
		Random rand = new Random();
		int  randomSize = rand.nextInt(sizesavailable) + 1;
		String selectedSize=getDriver().findElement(By.xpath("//div[@class='options']/button[contains(@title,'Select Size')]["+randomSize+"]")).getText();
		getDriver().findElement(By.xpath("//div[@class='options']/button[contains(@title,'Select Size')]["+randomSize+"]")).click();
		Serenity.setSessionVariable(SampleConstants.SELECTEDPRODUCT_SIZE).to(selectedSize);
	}
	
	@Step
	
	public void clickAddtoBasket(){
		firstscreen.addtoBasketbutton.click();
	}
	
	@Step	
	public void getItemPrice(){
		waitABit(5000);
		String itemprice=firstscreen.getItemPriceValue();
		Serenity.setSessionVariable(SampleConstants.SELECTEDPRODUCT_PRICE).to(itemprice);
		System.out.println(itemprice);
	}

	@Step
	public void verifybasketDetails(){
		basket.verifyBasketDetails();
	}
	
	@Step
	public void getProductCode(){
		String productCode=firstscreen.product_code.getText().replaceAll("Product Code: ", "");
		Serenity.setSessionVariable(SampleConstants.SELECTPRODUCT_PLU).to(productCode);
	}
	
	@Step
	public void clickonCheckoutButton(){
		basket.checkoutButton.click();
	}
	
	@Step
	public void verifyLoginPageTitle(){
		System.out.println(login.VerfiyLoginPageTitle());
		assertEquals("Login",login.VerfiyLoginPageTitle() );
	}
	
	
	public void VerifyPaymentPageandEnterCardDetails(){
		waitABit(5000);
		payment.verifyBillingPageAvailable();
		waitABit(3000);
		payment.payWithCard();
		
	}
}
