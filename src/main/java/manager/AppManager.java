package manager;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AppManager {

   Logger logger = LoggerFactory.getLogger(AppManager.class);
   WebDriver driver = new ChromeDriver();
  // EventFiringWebDriver driver;

   Properties properties;
    HelperUser user;

    public HelperUser getUser() {
        return user;
    }

    public AppManager() {

    }

    @BeforeSuite(alwaysRun = true)
        public void init() {
            driver.manage().window().maximize();
            driver.navigate().to("https://propetscom.herokuapp.com/login");
            // driver.navigate().to(properties.getProperty("web.baseUrl"));
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            user = new HelperUser(driver);

        }

@AfterSuite(alwaysRun = true)

public void tearDown() {
    driver.quit();

}

}
