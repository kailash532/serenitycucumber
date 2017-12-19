package com.serenity.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.serenity.Constants.SampleConstants;
import com.serenity.commonUtility.ExcelReaderAndWriter;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import static org.junit.Assert.*;

public class OrderConfirmation extends PageObject {

	WebDriver driver;

	@FindBy(xpath = "//div[@id='checkoutTitle']/h1")
	public WebElementFacade orderConfirmationTitle;

	@FindBy(xpath = "//div[@id='confirmationDetails']/h2/strong")
	WebElementFacade orderID;

	@FindBy(xpath = "//div[@id='confirmationInfo']/h2/strong")
	WebElementFacade emailID;

	@FindBy(xpath = "//a[@class='confirmationItemName']")
	WebElementFacade orderedProductName;

	@FindBy(xpath = "//a[@class='confirmationItemName']/span")
	WebElementFacade orderedProductQuantity;

	@FindBy(xpath = "//span[@class='confirmationItemDetails']")
	WebElementFacade orderedProductSize;

	@FindBy(xpath = "//span[@class='confirmationItemDetails']/span")
	WebElementFacade orderedProductPrice;

	@FindBy(xpath = "//span[@class='confirmationItemCode']")
	WebElementFacade orderedProductCode;

	@FindBy(xpath = "//span[@class='confirmationItemPrice']")
	WebElementFacade orderConfirmationItemPrice;

	@FindBy(xpath = "//div[@class='totalSubtotal']/strong")
	WebElementFacade orderConfirmation_subTotal;

	@FindBy(xpath = "//div[@class='totalDelivery']/strong")
	WebElementFacade orderConfirmation_totalDelivery;

	@FindBy(xpath = "//div[@class='totalGrand']/strong")
	WebElementFacade paidAmount;

	@FindBy(xpath = "//div[@id='confirmationDelivery']/p")
	WebElementFacade deliveryAddress;

	@FindBy(xpath = "//div[@id='confirmationBilling']/p")
	WebElementFacade billingAddress;

	public OrderConfirmation(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void saveOrderNumberInExcel() throws FileNotFoundException, IOException {
		String orderNumber = orderID.getText();
		ExcelReaderAndWriter write = new ExcelReaderAndWriter();
		write.WriteExcelFile(orderNumber);

	}

	public void verifyDetailsInOrderConfirmationPage(){
		try{
		waitABit(7000);
		
		System.out.println(orderID.getText());
		Serenity.setSessionVariable(SampleConstants.ORDERID).to(orderID.getText().replace("#", "").toString());
		assertEquals(Serenity.sessionVariableCalled(SampleConstants.EMAILADDRESS).toString(), emailID.getText());
		System.out.println(SampleConstants.ORDERCONFIRMATIONTITLE);
		assertEquals(SampleConstants.ORDERCONFIRMATIONTITLE, orderConfirmationTitle.getText());
		System.out.println(orderedProductName.getText());
		assertTrue(orderedProductName.getText().contains(Serenity.sessionVariableCalled(SampleConstants.PRODUCT_NAME).toString()));
		
		
		System.out.println(orderedProductQuantity.getText());
		assertTrue(orderedProductSize.getText().contains(Serenity.sessionVariableCalled(SampleConstants.SELECTEDPRODUCT_SIZE).toString()));
		System.out.println(orderedProductPrice.getText());
		
		assertTrue(Serenity.sessionVariableCalled(SampleConstants.SELECTEDPRODUCT_PRICE).toString().contains(orderedProductPrice.getText().replace("£", "")));
		
		assertTrue(orderedProductCode.getText().contains(Serenity.sessionVariableCalled(SampleConstants.SELECTPRODUCT_PLU).toString()) );
		
		assertEquals(Serenity.sessionVariableCalled(SampleConstants.SELECTEDPRODUCT_PRICE).toString(), orderConfirmationItemPrice.getText().replace("£", ""));
		assertEquals(Serenity.sessionVariableCalled(SampleConstants.SELECTEDPRODUCT_PRICE), orderConfirmation_subTotal.getText().replace("£", ""));
				
		assertEquals(Serenity.sessionVariableCalled(SampleConstants.DELIVERYAMOUNT), orderConfirmation_totalDelivery.getText());
		
		System.out.println(orderConfirmation_totalDelivery.getText());
		System.out.println(paidAmount.getText());
		System.out.println(deliveryAddress.getText());
		System.out.println(billingAddress.getText());
	}catch (Exception e) {
		// TODO: handle exception
		System.out.println("Swallow Exception");
		System.out.println();
		e.printStackTrace();
	}
	}
}
