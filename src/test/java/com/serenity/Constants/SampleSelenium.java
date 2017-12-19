package com.serenity.Constants;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SampleSelenium {

	public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<String> EanList=new ArrayList<String>();
		
		ArrayList<String> EanNumList=new ArrayList<String>();
		ArrayList<String> soHList=new ArrayList<String>();
		ArrayList<String> ccATSList=new ArrayList<String>();
		
		System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		driver.get("https://jds.sandbox.console.fluentretail.com/#/inventory");
		driver.findElement(By.id("username-input")).sendKeys("jdsportsmy_admin");
		driver.findElement(By.id("password-input")).sendKeys("QSXGH8");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Inventory']")).click();
		int numberOfproducts=5;
		ExcelReadAndWrite readwrite=new ExcelReadAndWrite();
		EanList=readwrite.ReadExcelAndGiveEAN(numberOfproducts);
		for(int i=0;i<EanList.size();i++){
			if(EanList.get(i)!="NULL"){
				driver.findElement(By.id("inventory-search-0")).clear();
				EanNumList.add(EanList.get(i));
				driver.findElement(By.id("inventory-search-0")).sendKeys(EanList.get(i));
				Thread.sleep(3000);
				if(driver.findElements(By.xpath("//table[@id='inventory-sku']/tbody/tr[1]/td[6]")).size()>0){
					String soH=driver.findElement(By.xpath("//table[@id='inventory-sku']/tbody/tr[1]/td[6]")).getText();
					soHList.add(soH);
					Thread.sleep(1000);
					String ccATS=driver.findElement(By.xpath("//table[@id='inventory-sku']/tbody/tr[1]/td[8]")).getText();
					ccATSList.add(ccATS);
				}else{
					soHList.add("NULL");
					ccATSList.add("NULL");
				}
				
				
			}else{
				continue;
			}
			
			
			
		}
		readwrite.WriteExcelFile(EanNumList, soHList, ccATSList);
		driver.quit();
		
	}

}
