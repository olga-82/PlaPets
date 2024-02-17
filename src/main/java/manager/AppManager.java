package manager;


import helper.HelperGreatorPage;
import helper.HelperHomePage;
import helper.HelperUser;
import helper.WDListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.Reader;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AppManager {

   Logger logger = LoggerFactory.getLogger(AppManager.class);


    WebDriver driver;


    HelperUser user;
    HelperHomePage homePage ;
    HelperGreatorPage greatPage ;
    Properties properties;
    String browser;
    WDListener listener;



        public AppManager() {
            browser = System.getProperty("browser", Browser.CHROME.browserName());
            logger.info(browser);
        }
    public HelperUser getUser() {
        return user;
    }

    public HelperHomePage getHomePage() {
        return homePage;
    }

    public HelperGreatorPage getGreatPage() {
        return greatPage;
    }

//    public String getEmail() {
//        return properties.getProperty("web.email");
//    }



    @BeforeSuite(alwaysRun = true)
    public void init() {

        if (browser.equals(Browser.CHROME.browserName())) {
            ChromeOptions options = new ChromeOptions();
            WebDriver original = new ChromeDriver(options);
            listener = new WDListener(); // Initialize the listener instance
            driver = new EventFiringDecorator(listener).decorate(original); // Pass the listener instance
            logger.warn(browser);
        } else if (browser.equals(Browser.FIREFOX.browserName())) {
            FirefoxOptions options = new FirefoxOptions();
            WebDriver original = new FirefoxDriver(options);
            listener = new WDListener(); // Initialize the listener instance
            driver = new EventFiringDecorator(listener).decorate(original); // Pass the listener instance
            logger.warn(browser);
        }

        driver.navigate().to(Reader.getProperty("web.baseUrl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        user = new HelperUser(driver);
        homePage = new HelperHomePage(driver);
        greatPage = new HelperGreatorPage(driver);
    }



@AfterSuite(alwaysRun = true)

public void tearDown() {
    driver.quit();

}

}
