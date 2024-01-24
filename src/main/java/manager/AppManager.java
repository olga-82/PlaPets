package manager;


import helper.HelperGreatorPage;
import helper.HelperHomePage;
import helper.HelperUser;
import helper.WDListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.Reader;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AppManager {

   Logger logger = LoggerFactory.getLogger(AppManager.class);

    EventFiringWebDriver driver;


    HelperUser user;
    HelperHomePage homePage ;
    HelperGreatorPage greatPage ;
    Properties properties;
    String browser;

    public AppManager( ) {
        browser =  System.getProperty("browser", BrowserType.CHROME);;
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
//    public String getPassword() {
//        return properties.getProperty("web.password");
//    }


    @BeforeSuite(alwaysRun = true)
        public void init(){

        if(browser.equals(BrowserType.CHROME)) {
            driver = new EventFiringWebDriver(new ChromeDriver());
            logger.info("Test start on Chrome");
        }else if(browser.equals(BrowserType.FIREFOX)){
           driver = new EventFiringWebDriver(new FirefoxDriver());
            logger.info("Test start on FireFox");
        } else if (browser.equals(BrowserType.SAFARI)) {
              driver = new EventFiringWebDriver(new SafariDriver());
            logger.info("Test start on Safari");
        }
            driver.navigate().to(Reader.getProperty("web.baseUrl"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.register(new WDListener());
            user = new HelperUser(driver);
            homePage=new HelperHomePage(driver);
            greatPage =new HelperGreatorPage(driver);


    }

@AfterSuite(alwaysRun = true)

public void tearDown() {
    driver.quit();

}

}
