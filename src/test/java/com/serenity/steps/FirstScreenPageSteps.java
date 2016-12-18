package com.serenity.steps;


import org.junit.*;

import com.gargoylesoftware.htmlunit.javascript.configuration.BrowserName;
import com.serenity.pages.FirstScreen;
import com.serenity.pages.SecondScreen;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class FirstScreenPageSteps extends ScenarioSteps{
	
	FirstScreen firstscreen;
	SecondScreen secscreen;
	
	
	
	@Step
	public void launchApp(){
		
		firstscreen.openPage();
		
	}
	
	@Step
	public void VerifyTitle(String title){
		firstscreen.getTitle();
		Assert.assertEquals(title, firstscreen.getTitle());
		
		 
	}
	
	@Step
	public void EnterText(){
		secscreen.EnterText();
		
	}
	
	
	@Step
	public void clickonlink(){
		secscreen.clickonWebdriverLink();
	}
	

}
