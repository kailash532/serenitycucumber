package com.serenity.pages;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://uat-uatmesh-jdsports-desktop.mesh.mx/")
public class FirstScreen extends PageObject {

	WebDriver driver;
	
	@FindBy(id="srchInput")
	WebElementFacade SearchInput;
	
	@FindBy(id="srchButton")
	WebElementFacade SearchButton;
	
	@FindBy(xpath="//div[@id='productItemTitle']/h1")
	 	WebElementFacade productTitle;
	
	@FindBy(id="addToBasket")
	public WebElementFacade addtoBasketbutton;
	
	@FindBy(xpath="")
	public WebElementFacade selectedProductplu;
	
	@FindBy(xpath="//li[@class='basketListItem']/div[@class='itemCost itemCostPerItem']/span[@class='was']")
	public WebElementFacade itemprice_Was;
	
	
	@FindBy(xpath="//li[@class='basketListItem']/div[@class='itemCost itemCostPerItem']/span[@class='now']")
	public WebElementFacade itemprice_Now;
	
	@FindBy(xpath="//div[@class='itemPrices']/span[@class='pri']")
	public WebElementFacade itemprice;
	
	@FindBy(xpath="//span[@class='product-code']")
	public WebElementFacade product_code;
	

	public FirstScreen(final WebDriver driver) throws MalformedURLException {
		super(driver);
		this.driver = driver;

		/*
		 * CustomMobileDriver cd=new CustomMobileDriver();
		 * this.driver=cd.newDriver();
		 */

	}

	/*
	 * @Before
	 * 
	 * public void setIEpath(){ System.setProperty("webdriver.ie.driver",
	 * "D:/selenium_servers/IEDriverServer_x64_2.53.1/IEDriverServer.exe"); }
	 */

	public void openPage() throws IOException {
		driver.manage().deleteAllCookies();
	//	Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");
		this.open();
		Runtime.getRuntime().exec("C:\\Users\\kailash.sopparapu\\Desktop\\popUp.exe");
		driver.manage().window().maximize();
		setImplicitTimeout(10, TimeUnit.SECONDS);
	}

	public String productTitle() {
		return productTitle.getText();

	}
	
	public void EnterSearchText(String searchtext){
		SearchInput.sendKeys(searchtext);
	}
	
	public void clickSearchButton(){
		SearchButton.click();
	}
	
	public String currentURL(){
		return driver.getCurrentUrl();
		
	}
	
	public String getItemPriceValue(){
		//li[@class='basketListItem']/div[@class='itemCost']/span
		String itemvalue="";
		int numberOfPrices=driver.findElements(By.xpath("//li[@class='basketListItem']/div[@class='itemCost itemCostPerItem']/span")).size();
		if(numberOfPrices>1){
			itemvalue=itemprice_Now.getText().replace("£", "");
		}else{
			itemvalue=itemprice.getText().replace("£", "");
		}
		
		
		return itemvalue;
		
	}
	
	

}
