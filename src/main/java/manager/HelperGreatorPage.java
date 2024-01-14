package manager;

import models.PetsPostDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperGreatorPage extends HelperBase{
    public HelperGreatorPage(WebDriver driver) {
        super(driver);
    }
    private final String BUTTON_LOST_MY_PET = " //div[@data-test-id='account-header-lost-found']/button[1]";
    private final String BUTTON_FOUND_MY_PET = " //div[@data-test-id='account-header-lost-found']/button[2]";
    private final String INPUT_TEXT  = "//*[@id='root']/div[2]/div[2]/div/div/div[2]/div[1]/div[1]/div[2]/div";
    private final String  BROWSER_BUTTON = "//div[@data-test-id ='browse-button']";
    private final String INPUT_DESCRIPTION ="//*[@id='root']/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div";
    private final String  BUTTON_ADD_DESC = "//*[@id='root']/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/button";

   private final String INPUT_LOCATION =" //input[@placeholder ='Enter address']";
   private final String SELECT_LOCATION ="///html/body/div[9]/div[1]";
  private final  String INPUT_CONTACTS = "//input[@type='tel']";
  private final  String INPUT_EMAIL = "//input[@type='email']";
  private final  String BUTTON_PUBLISH ="//div[@data-test-id='buttons-container']/button[2]";
  private final String BUTTON_CANCEL = "//div[@data-test-id='buttons-container']/button[1]";


  public void fillNewPost(PetsPostDTO pets){
    //  type(By.xpath(INPUT_TEXT), pets.getText());
     // waitElementToBeClickable(By.xpath(BROWSER_BUTTON));
     // addPicture();

      inputDescription(pets.getDescription());
      clickButtonAddDesc();
      selectLocation(pets.getLocation());

      inputPhone(pets.getContactsPhone());
     // inputEmail(pets.getEmail());
      typeEmail(pets.getEmail());
      click(By.xpath(BUTTON_PUBLISH));



  }
   public void addPicture() {
       WebElement element =new WebDriverWait(driver, 20)
               .until(ExpectedConditions.elementToBeClickable(By.xpath(BROWSER_BUTTON)));
       Actions action =new Actions(driver);
       action.moveToElement(element).click().build().perform();
       action.sendKeys("/Users/olgakolchina/Documents/QA40/PlaPets/pexels-pixabay-45201.jpg");

   }
   public void selectLocation(String location){
     type(By.xpath(INPUT_LOCATION),location);
       click(By.className("pac-item"));

   }
   public void inputDescription(String text) {
       WebElement element = new WebDriverWait(driver, 20)
               .until(ExpectedConditions.elementToBeClickable(By.xpath(INPUT_DESCRIPTION)));
       Actions action = new Actions(driver);
       action.moveToElement(element).click();
       action.sendKeys(text).build().perform();
   }
    public void clickButtonAddDesc() {
       WebElement button =new WebDriverWait(driver, 20)
        .until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_ADD_DESC)));
       Actions action =new Actions(driver);
       action.moveToElement(button).click().build().perform();

   }
    public void inputPhone(String text) {
        WebElement element =new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(INPUT_CONTACTS)));
        Actions action =new Actions(driver);
        action.moveToElement(element).click();
        action.sendKeys(text).build().perform();

    }
    public void inputEmail(String text) {
        WebElement element =new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(INPUT_EMAIL)));
        Actions action =new Actions(driver);
        action.moveToElement(element).click();
        element.clear();
        action.sendKeys(text).build().perform();

    }
    public void typeEmail(String email){
        WebElement date = driver.findElement(By.xpath(INPUT_EMAIL));

        date.click();
        String os = System.getProperty("os.name");
        System.out.println("os: " + os);
        if(os.startsWith("Mac")){
            date.sendKeys(Keys.chord(Keys.COMMAND,"a"));
        }else {
            date.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        }
        date.sendKeys(email);
        date.sendKeys(Keys.ENTER);
    }


    }
//li[@data-value='0']
//button[@data-testid ='location-button']

