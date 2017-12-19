package Serenity_cucumber.Serenity_cucumber.stepdefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.serenity.Constants.SampleConstants;
import com.serenity.commonUtility.ExcelReaderAndWriter;
import com.serenity.pages.BillingAndReview;
import com.serenity.pages.Delivery;
import com.serenity.pages.LoginPage;
import com.serenity.pages.OrderConfirmation;
import com.serenity.steps.FirstScreenPageSteps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class CucumberStepdefinition {
	@Steps
	FirstScreenPageSteps firstscreenpagesteps;
	
	LoginPage login;
	Delivery delivery;
	OrderConfirmation orderdetails;
	BillingAndReview payment;
	ExcelReaderAndWriter ec=new ExcelReaderAndWriter();
	
		
	@Given("^User Launch the App$")
	public void user_Launch_the_App() throws Throwable {
		firstscreenpagesteps.launchApp();
	}
	
	@And("^verify Page loaded$")
	public void verify_Page_loaded() throws IOException {
		
		firstscreenpagesteps.getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	    
	}

	@When("^Search product with (.*?) or (.*?)$")
	public void search_product_with_or_NONE(String plu,String productName)  {
	    Serenity.setSessionVariable(SampleConstants.PLU_NUMBER).to(plu);
	    Serenity.setSessionVariable(SampleConstants.PRODUCT_NAME).to(productName);
	    System.out.println(productName);
	    if(!plu.equals("NONE")){
	    	firstscreenpagesteps.searchForProduct(plu);
	    }
	    if(!productName.equals("NONE")){
	    	firstscreenpagesteps.searchForProduct(productName);
	    }
	}
	

	@When("^Verify Corresponding Page opened$")
	public void verify_Corresponding_Page_opened() {
	  System.out.println("*******"+Serenity.sessionVariableCalled(SampleConstants.PLU_NUMBER)+"****"+Serenity.sessionVariableCalled(SampleConstants.PRODUCT_NAME));
		if(! Serenity.sessionVariableCalled(SampleConstants.PLU_NUMBER).toString().equals("NONE")){
		  assertTrue(firstscreenpagesteps.getCurrentURL().contains(Serenity.sessionVariableCalled(SampleConstants.PLU_NUMBER).toString()));
	  }
	  
	  if(! Serenity.sessionVariableCalled(SampleConstants.PRODUCT_NAME).toString().equals("NONE"))
	  { 
		  firstscreenpagesteps.selectRandomProduct();
		  assertEquals(Serenity.sessionVariableCalled(SampleConstants.PRODUCT_NAME).toString(), firstscreenpagesteps.productTitle());
	}
	}
	
	@When("^Add product to Basket$")
	public void add_product_to_Basket() throws Throwable {
		firstscreenpagesteps.getProductCode();
	   
	    firstscreenpagesteps.selectSize();
	    firstscreenpagesteps.clickAddtoBasket();
	}

	@When("^Verify Product added to the basket successfully$")
	public void verify_Product_added_to_the_basket_successfully() throws Throwable {
		firstscreenpagesteps.getItemPrice();
		firstscreenpagesteps.verifybasketDetails();
		
	}

	@When("^User clicks on checkout securely in MyBasket page$")
	public void user_clicks_on_checkout_securely_in_MyBasket_page() throws Throwable {
	   firstscreenpagesteps.clickonCheckoutButton();
	    
	}

	@Then("^Verify user at Login screen$")
	public void verify_user_at_Login_screen() throws Throwable {
		firstscreenpagesteps.verifyLoginPageTitle();
		
	}

	@When("^user enters (.*?) as Guest and Click on checkoutButton$")
	public void user_enters_EmailID_as_Guest(String Emailid){
		login.checkoutAsGuest(Emailid);
		Serenity.setSessionVariable(SampleConstants.EMAILADDRESS).to(Emailid);
	}

	@When("^Verify User at Delivary and Collections Options Page$")
	public void verify_User_at_Delivary_and_Collections_Options_Page()  {
		assertEquals("Delivery & Collection Options", delivery.verifyDeliveryTitle());
	}

	@When("^User Continues as Guest with Standard Delivery Option$")
	public void user_Continues_as_Guest_with_Standard_Delivery_Option() throws InterruptedException  {
	   delivery.guestUserStandardDelivery();
	}
	
	@When("^click on PaybyCard Enter Card details and click on placeOrderButton$")
	public void click_on_PaybyCard_Enter_Card_details_and_click_on_placeOrderButton() throws FileNotFoundException, IOException {
		payment.captureDeliveryAddress();
	    firstscreenpagesteps.VerifyPaymentPageandEnterCardDetails();
	    orderdetails.verifyDetailsInOrderConfirmationPage();
	    String orderID=Serenity.sessionVariableCalled(SampleConstants.ORDERID);
	    if(orderID!=""){
	    	ec.WriteExcelFile(orderID);
	    }
	    
	}
	

}