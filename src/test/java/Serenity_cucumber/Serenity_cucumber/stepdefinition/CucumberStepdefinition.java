package Serenity_cucumber.Serenity_cucumber.stepdefinition;

import java.util.List;

import com.serenity.steps.FirstScreenPageSteps;

import cucumber.api.DataTable;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.deps.com.thoughtworks.xstream.annotations.XStreamAlias;
import net.thucydides.core.annotations.Steps;

public class CucumberStepdefinition {
	@Steps
	FirstScreenPageSteps firstscreenpagesteps;
	
	@Given("^user login to the screen$")
	public void user_login_to_the_screen() throws Throwable {
		System.out.println("step1");
	}

	@When("^user in expected screen$")
	public void user_in_expected_screen() throws Throwable {
		System.out.println("step2");
	}

	@Then("^Check the title of the screen$")
	public void check_the_title_of_the_screen() throws Throwable {
		System.out.println("step3");
	}
	
	
	
	
	@Given("^Launch the app$")
	public void user_login_to_the_screen1() throws Throwable {
		System.out.println("step1****");
	}

	@When("^get the message$")
	public void user_in_expected_screen1() throws Throwable {
		System.out.println("step2****");
	}

	@Then("^Close the message$")
	public void check_the_title_of_the_screen1() throws Throwable {
		System.out.println("step3****");
	}
	
	
	
	
	
	
	
	@Given("^launch the App for ([^\"]*) and ([^\"]*)$")
	public void launch_the_App_for_State_and(String state,String product) throws Throwable {
		
		System.out.println(state);
		System.out.println(product);
	}

	/*@When("^Click on Go button$")
	public void click_on_Go_button() throws Throwable {
		System.out.println("step2");
	}*/

	@Then("^Check COPPA model window Text for ([^\"]*)$")
	public void check_COPPA_model_window_Text_for_StateList(String product) throws Throwable {
		System.out.println(product);
	}
	

	@Given("^launch the App for state and product$")
	public void launch_the_App_for_state_and_product(DataTable table) throws Throwable {
		List<List<String>> data=table.raw();
		System.out.println(data.get(1).get(0));
		System.out.println(data.get(2).get(0));
		
		System.out.println(data.get(1).get(1));
		System.out.println(data.get(2).get(1));
		
		
	}

	@When("^Click on Go button$")
	public void click_on_Go_button() throws Throwable {
	   
	}

	@Then("^Check COPPA model window Text for StataList$")
	public void check_COPPA_model_window_Text_for_StataList(DataTable table) throws Throwable {
		List<List<String>> data=table.raw();
		System.out.println(data.get(1).get(0));
		System.out.println(data.get(2).get(0));
	}

	
	
	
	@Given("^User Launch the App$")
	public void user_Launch_the_App() throws Throwable {
		firstscreenpagesteps.launchApp();
	}

	/*@Then("^([^\"]*) should display$")
	public void google_should_display(String title) throws Throwable {
		firstscreenpagesteps.VerifyTitle(title );
	}*/

	@Then("^([^\"]*) must display$")
	@But("^([^\"]*) should display$")
	public void google_must_display(String title) throws Throwable {
		firstscreenpagesteps.VerifyTitle(title);
	}
	
	
	
	@Then("^Enter text in Text field$")
	public void Enter_text_in_Text_field() {
		firstscreenpagesteps.EnterText();
	}
	
	/*@Then("Click on link")
	public void Click_on_Link(){
		firstscreenpagesteps.clickonlink();
	}*/
	
}