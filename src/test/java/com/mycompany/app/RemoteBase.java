package com.mycompany.app;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.ITestContext;

import org.openqa.selenium.remote.server.*;
//import org.openqa.selenium.ser;

public class RemoteBase {
  
    public static SeleniumServer server;
    public static DefaultSelenium selenium;
    
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
	  selenium.stop();
  }

  @BeforeSuite
  public void beforeSuite(ITestContext context) {
	  String seleniumHost = context.getCurrentXmlTest().getParameter("selenium.host");
	  String seleniumPort = context.getCurrentXmlTest().getParameter("selenium.port");
	  String seleniumBrowser = context.getCurrentXmlTest().getParameter("selenium.browser");
	  String seleniumUrl = context.getCurrentXmlTest().getParameter("selenium.url");
	  
	  RemoteControlConfiguration rcc = new RemoteControlConfiguration();
	  rcc.setSingleWindow(true);
	  rcc.setPort(Integer.parseInt(seleniumPort));
	  
	  try {
	    server = new SeleniumServer(false, rcc);
	    server.boot();
	  } catch (Exception e) {
	    throw new IllegalStateException("Can't start selenium server", e);
	  }
	  
	  proc = new HttpCommandProcessor(seleniumHost, Integer.parseInt(seleniumPort),
	      seleniumBrowser, seleniumUrl);
	  selenium = new DefaultSelenium(proc);
	  selenium.start();
  }

  @AfterSuite
  public void afterSuite() {
	  server.stop();
  }

}
