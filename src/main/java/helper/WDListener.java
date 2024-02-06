package helper;



import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WDListener extends AbstractWebDriverEventListener {

    WebDriver driver;

    public WDListener(WebDriver driver) {
        this.driver = driver;
    }

    Logger logger = LoggerFactory.getLogger(WDListener.class);
    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        super.afterNavigateTo(url, driver);
        logger.info("NavigateTo URL: " + url);

    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        super.beforeClickOn(element, driver);
        logger.info("click on " + element.getText());
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        super.afterClickOn(element, driver);
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
        super.afterGetScreenshotAs(target, screenshot);

    }



    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        super.afterFindBy(by, element, driver);
        logger.info("Element with locator ----> " + by + " is found");

    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        super.beforeFindBy(by, element, driver);
        logger.info("Start searching element " + by);
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        super.onException(throwable, driver);
        logger.info("Something went wrong!");
        logger.info(throwable.getMessage());
        logger.info(throwable.fillInStackTrace().getMessage());
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String link = "src/test/screenshots/screen-"+ i +".png";

        HelperBase helperBase = new HelperBase( driver);
        helperBase. takeScreenshot(link);
        logger.info("This is a link to screenshot with error ----->" + link);

    }


    public WDListener() {
        super();
    }
}


