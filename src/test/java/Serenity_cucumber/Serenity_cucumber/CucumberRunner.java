package Serenity_cucumber.Serenity_cucumber;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		
		features={"src/test/resource/"}
		
		)

public class CucumberRunner {
	
}
