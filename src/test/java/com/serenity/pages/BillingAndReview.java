package com.serenity.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class BillingAndReview extends PageObject {
	WebDriver driver;
	public static String[] addressdetails = null;
	
	@FindBy(xpath = "//div[@id='checkoutTitle']/h1")
	public WebElementFacade billingPageTitle;

	@FindBy(xpath = "//span[text()='Pay By Card']")
	WebElementFacade payByCard;

	@FindBy(xpath = "//span[text()='Pay with Paypal']")
	WebElementFacade payWithPayPal;

	@FindBy(xpath = "//span[text()='Pay Later with Klarna']")
	WebElementFacade payWithKlarna;

	@FindBy(xpath = "//label[text()='Card Number']")
	WebElementFacade cardNumberLabel;

	@FindBy(name = "card_number")
	WebElementFacade cardNumberInput;

	@FindBy(name = "exp_month")
	WebElementFacade expMonthInput;

	@FindBy(name = "exp_year")
	WebElementFacade exp_YearInput;

	@FindBy(name = "cv2_number")
	WebElementFacade securityCodeInput;

	@FindBy(id = "continue")
	WebElementFacade placeOrderButton;

	@FindBy(xpath = "//div[@id='selectedDeliveryAddress']/div[2]/div/div/ul/li/div[1]/p")
	WebElementFacade deliveryAddress;

	public BillingAndReview(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void payWithCard() {
		payByCard.click();
		try {
			waitABit(6000);
			WebElement ele=driver.findElement(By.className("paymentFrame"));
			getDriver().switchTo().frame(ele);
			cardNumberInput.sendKeys("4444 3333 2222 1111");
			expMonthInput.sendKeys("08");
			exp_YearInput.sendKeys("2018");
			securityCodeInput.sendKeys("737");
			placeOrderButton.click();
			if(driver.findElements(By.xpath("//input[@value='Authenticated']")).size()>0){
				driver.findElement(By.xpath("//input[@value='Authenticated']")).click();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			
		}
	}

	public String verifyBillingPageAvailable() {
		return billingPageTitle.getText();
	}

	public void captureDeliveryAddress() {

		String address = deliveryAddress.getText();
		waitABit(2000);
		String[] addressdetails = address.trim().split("\\,");
		for(int i=0;i<addressdetails.length;i++){
			System.out.println(addressdetails[i]);
		}
	}
}
