package manager;


import helper.HelperGreatorPage;
import helper.HelperHomePage;
import helper.HelperUser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

    WebDriver driver = new ChromeDriver();


    HelperUser user;
    HelperHomePage homePage ;
    HelperGreatorPage greatPage ;
    Properties properties;


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




    public AppManager() {

    }


    @BeforeSuite(alwaysRun = true)
        public void init(){
            driver.navigate().to(Reader.getProperty("web.baseUrl"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            user = new HelperUser(driver);
            homePage=new HelperHomePage(driver);
           greatPage =new HelperGreatorPage(driver);


    }

@AfterSuite(alwaysRun = true)

public void tearDown() {
    driver.quit();

}

}
