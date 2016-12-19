package Serenity_cucumber.Serenity_cucumber;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.Managed;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		
		features={"src/test/resource/"},
		tags={"@SystemTest"}
		)

public class CucumberRunner {
	
}
