package tests;

import manager.AppManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class BaseTest {
    Logger logger = LoggerFactory.getLogger(BaseTest.class);

static AppManager app = new AppManager();
  @BeforeSuite
    public void setUp() throws IOException {

       app.init ();
       logger.info("Test started");
    }



    @AfterSuite(alwaysRun = true)

    public void stop() {
        app.tearDown();
        logger.info("Test stopped");





    }
}
