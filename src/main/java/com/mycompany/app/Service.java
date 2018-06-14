package selenium;

import java.io.File;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Service {
    public static ChromeDriverService chromeDriverService;
    public static InternetExplorerDriverService ieDriverService;
    public static EdgeDriverService edgeDriverService;
    public static Logger logger;
    public static WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new RemoteWebDriver(chromeDriverService.getUrl(), new ChromeOptions());
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @BeforeSuite
    public void beforeSuite() {
        chromeDriverService = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("src/main/resources/chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        logger = LogManager.getLogger("leno");
        try{
            chromeDriverService.start();
        }catch(IOException e) {
            logger.fatal(e.getMessage());
        }
    }

    @AfterSuite
    public void afterSuite() {
        chromeDriverService.stop();
    }
}
