Feature: Placing Order in JD UK

Scenario Outline:: User placing orders in JD UK desktop Application
	Given User Launch the App 
	And verify Page loaded
	When Search product with <PluNumber> or <productName>
	And Verify Corresponding Page opened
	And Add product to Basket
	And Verify Product added to the basket successfully
	When User clicks on checkout securely in MyBasket page
	Then Verify user at Login screen
	When user enters <EmailID> as Guest and Click on checkoutButton
	And Verify User at Delivary and Collections Options Page
	And User Continues as Guest with Standard Delivery Option
	And click on PaybyCard Enter Card details and click on placeOrderButton
	
	Examples:
	|PluNumber|productName|EmailID|
	|NONE|adidas Tango Pants Junior|guest@gmail.com|
	|250291|NONE|guest@gmail.com|
	|215282|NONE|guest@gmail.com|
	
	
		
	  
	
	 
	 