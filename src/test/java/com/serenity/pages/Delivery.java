package com.serenity.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.serenity.Constants.SampleConstants;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class Delivery extends PageObject {
	WebDriver driver;

	public Delivery(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//div[@id='checkoutTitle']/h1")
	public WebElementFacade deliveryTitle;

	@FindBy(xpath = "//div[contains(@class,'selectDeliveryAddress')]//ul[@class='checkModCheckList']/li[1]//span")
	public WebElementFacade selectExsistingAddress1;

	@FindBy(xpath = "//*[@id='checkoutDeliveryAddNewAddress']")
	public WebElementFacade newAddressorClickCollectButton;

	@FindBy(xpath = "//h4[.='Standard delivery']/../span")
	public WebElementFacade standardDelivaryOption;

	@FindBy(xpath = "//h4[.='Standard delivery']/../..//strong")
	public WebElementFacade standardDelivaryprice;

	@FindBy(id = "continueSecurelyButton")
	public WebElementFacade continueSecurelyButton;

	@FindBy(id = "firstName")
	WebElementFacade firstName;

	@FindBy(id = "lastName")
	WebElementFacade lastName;

	@FindBy(id = "phone")
	WebElementFacade telephoneNo;

	@FindBy(id = "addressPredictLook")
	WebElementFacade addressOrPostalCode;

	@FindBy(xpath = "//span[@id='addressPredictLook-results']/ul/li")
	WebElementFacade addressFirstLine;

	@FindBy(xpath = "//span[@id='addressPredictLook-results']/ul/li[3]")
	WebElementFacade addressSecondLine;

	@FindBy(xpath = "//span[@data-e2e='checkout-useAsBillingAddress']")
	WebElementFacade billingAddressCheckBox;

	public String verifyDeliveryTitle() {
		return deliveryTitle.getText();
	}

	public void existingUserStandardDelivery() {
		selectExsistingAddress1.click();
		standardDelivaryOption.click();
		continueSecurelyButton.click();
	}

	public void guestUserStandardDelivery() throws InterruptedException {
		Serenity.setSessionVariable(SampleConstants.DELIVERYAMOUNT).to(standardDelivaryprice.getText());
		standardDelivaryOption.click();
		firstName.sendKeys("Sample");
		lastName.sendKeys("Test");
		telephoneNo.sendKeys("9030407519");
		addressOrPostalCode.sendKeys("BL98RR");
		addressFirstLine.click();
		if (addressSecondLine.isDisplayed()) {
			addressSecondLine.click();
		}
		Thread.sleep(5000);
		Serenity.setSessionVariable(SampleConstants.ADDRESS_FNAME).to(firstName.getAttribute("value"));
		Serenity.setSessionVariable(SampleConstants.ADDRESS_LNAME).to(lastName.getAttribute("value"));
		billingAddressCheckBox.click();
		continueSecurelyButton.click();
	}

}
