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
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
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



        public AppManager() {
        browser = System.getProperty("browser", Browser.CHROME.browserName());
//        // public ApplicationManager(String browser) { this.browser = browser;
////    }
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

          AppManager app = new AppManager();
          System.out.println("browser: " + browser);
          if(browser.equals(Browser.CHROME.browserName())) {
            ChromeOptions options = new ChromeOptions();
            //   if(true) {
            // options.addArguments("--headless=new");
            WebDriver original = new ChromeDriver(options);
            AbstractWebDriverEventListener listener = new WDListener();
            driver = new EventFiringDecorator(listener.getClass()).decorate(original);
            logger.warn(browser);

        } else if (browser.equals(Browser.FIREFOX.browserName())){
            FirefoxOptions options = new FirefoxOptions();
            // options.addArguments("--headless");
            WebDriver original = new FirefoxDriver(options);
              WDListener listener = new WDListener();
            driver = new EventFiringDecorator(listener.getClass()).decorate(original);
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
