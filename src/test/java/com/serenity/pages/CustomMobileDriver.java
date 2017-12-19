package com.serenity.pages;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import net.thucydides.core.webdriver.DriverSource;

public class CustomMobileDriver implements DriverSource {

	@Override
	public WebDriver newDriver() {
		DesiredCapabilities capabilities=DesiredCapabilities.android();
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
		capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"moto");
		capabilities.setCapability(MobileCapabilityType.UDID,"HKE6KY9F");
		capabilities.setCapability(MobileCapabilityType.VERSION,"6.0");
		
		URL url;
		WebDriver driver=null;
		try {
			url = new URL("http://127.0.0.1:4725/wd/hub");
			driver =new AndroidDriver(url,capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return driver;
	}

	@Override
	public boolean takesScreenshots() {
		// TODO Auto-generated method stub
		return false;
	}

}
