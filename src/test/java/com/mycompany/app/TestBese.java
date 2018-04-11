package com.mycompany.app;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestBese {
	
  private static ChromeDriverService service;
  private WebDriver driver;
  
  @Test
  public void f() {
	  driver.get("https://www.baidu.com");
	  Assert.assertEquals(driver.getTitle(), "百度一下，你就知道", "Fail to login Baidu.");
  }
  
  @BeforeClass
  public void beforeClass() {
	  service = new ChromeDriverService.Builder()
			  .usingDriverExecutable(new File("src/main/resources/chromedriver.exe"))
			  .usingAnyFreePort()
		      .build();
	try{
		service.start();
	}catch(IOException e){
		System.out.println(e.getMessage());
	}
  }

  @AfterClass
  public void afterClass() {
	  service.stop();
  }

  @BeforeMethod
  public void beforeTest() {
		driver = new RemoteWebDriver(service.getUrl(), 
				new ChromeOptions());
  }

  @AfterMethod
  public void afterTest() {
	  driver.quit();
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
