package tests;

import helper.TestNGListener;
import helper.WDListener;
import manager.AppManager;
import models.Gender;
import models.PetDTO;
import models.Type;
import models.UserDTO;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import utils.Reader;

import java.io.IOException;
@Listeners(TestNGListener.class)
public class BaseTest {
    Logger logger = LoggerFactory.getLogger(BaseTest.class);

   static AppManager app = new AppManager();

    UserDTO user =  UserDTO.builder()
            .email(Reader.getProperty("web.email"))
            .password(Reader.getProperty("web.password"))
            .build();

            PetDTO pet =  PetDTO.builder()
                .type(Type.CAT)
                .Sex(Gender.FEMALE)
                .Breed("test")
                .color("grey")
                .DistinctiveFeatures("test")
                .description("test description")
                .location("Tel Aviv")
                .contactsPhone("2345676543")
                .email("test@mail.com")
                .build();

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
