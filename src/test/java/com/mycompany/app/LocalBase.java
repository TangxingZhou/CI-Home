package com.mycompany.app;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class LocalBase {
	
	public static ChromeDriverService service;
	public static WebDriver driver;
	
    @BeforeMethod
    public void beforeMethod() {
	    driver = new RemoteWebDriver(service.getUrl(), 
	    		new ChromeOptions());
	}

    @AfterMethod
    public void afterMethod() {
	    driver.quit();
    }

    @BeforeSuite
    public void beforeSuite() {
	    service = new ChromeDriverService.Builder()
	    		.usingDriverExecutable(new File("src/main/resources/chromedriver.exe"))
	    		.usingAnyFreePort()
	    		.build();
	    try{
	    	service.start();
	    }catch(IOException e) {
	    	System.out.println(e.getMessage());
	    }
    }

    @AfterSuite
    public void afterSuite() {
	    service.stop();
    }
}
