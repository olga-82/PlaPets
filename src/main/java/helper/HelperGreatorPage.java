package helper;

import models.Gender;
import models.PetDTO;
import models.PetsPostDTO;
import models.Type;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperGreatorPage extends HelperBase {
    public HelperGreatorPage(WebDriver driver) {
        super(driver);
    }

    private final String BUTTON_LOST_MY_PET = " //div[@data-test-id='account-header-lost-found']/button[1]";
    private final String BUTTON_FOUND_MY_PET = " //div[@data-test-id='account-header-lost-found']/button[2]";
    private final String INPUT_TEXT = "//*[@id='root']/div[2]/div[2]/div/div/div[2]/div[1]/div[1]/div[2]/div";
    private final String BROWSER_BUTTON = "//div[@data-test-id ='browse-button']";
    private final String INPUT_DESCRIPTION = "//*[@id='root']/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div";
    private final String BUTTON_ADD_DESC = "//*[@id='root']/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/button";

    private final String INPUT_LOCATION = " //input[@placeholder ='Enter address']";
    private final String SELECT_LOCATION = "//div[@data-testid='location-container']//input";
    private final String INPUT_CONTACTS = "//input[@type='tel']";
    private final String INPUT_EMAIL = "//input[@type='email']";
    private final String BUTTON_PUBLISH = "//div[@data-test-id='buttons-container']/button[2]";
    private final String BUTTON_CANCEL = "//div[@data-test-id='buttons-container']/button[1]";
    private final String SELECT_TYPE = " //li[@data-value='0']";
    private final String INPUT_TYPE = "  //div[@data-test-id='info-select-0']/div";
    private final String INPUT_SEX = "  //div[@data-test-id='info-select-1']/div";
    private final String SELECT_SEX = "//li[@data-value='1']";
    private final String INPUT_BREED = " //div[@data-test-id='info-textfield-2']//input";
    private final String INPUT_COLOR = " //div[@data-test-id='info-textfield-3']//input";
    private final String INPUT_Distinctive_FEATURES = "//*[@id='root']/div[2]/div[2]/div/div/div[2]/div[1]/div[1]/div[5]/div[2]";
    private final String GET_TEXT_PET_NAME = "//div[@data-test-id='pet-name']";


    public void fillFoundForm(PetDTO pet){
        clickButtonFoundMyPet();
        click(By.xpath(INPUT_TYPE));
        selectType(pet.getType());
        click(By.xpath(INPUT_SEX));
       selectorGender(pet.getSex());
        type(By.xpath(INPUT_BREED), pet.getBreed());
        type(By.xpath(INPUT_COLOR), pet.getColor());
        waitElementToBeClickable(By.xpath(INPUT_Distinctive_FEATURES));
        fillDistinctiveFeatures(pet.getDistinctiveFeatures());
        addPicture();
        inputDescription(pet.getDescription());
        clickButtonAddDesc();
        selectLocation(pet.getLocation());
        inputPhone(pet.getContactsPhone());
        typeEmail(pet.getEmail());
        click(By.xpath(BUTTON_PUBLISH));



    }
    public void fillLostForm(PetDTO pet){
        clickButtonLostMyPet();
        click(By.xpath(INPUT_TYPE));
        selectType(pet.getType());
        click(By.xpath(INPUT_SEX));
        selectorGender(pet.getSex());
        type(By.xpath(INPUT_BREED), pet.getBreed());
        type(By.xpath(INPUT_COLOR), pet.getColor());
        waitElementToBeClickable(By.xpath(INPUT_Distinctive_FEATURES));
        fillDistinctiveFeatures(pet.getDistinctiveFeatures());
        addPicture();
        inputDescription(pet.getDescription());
        clickButtonAddDesc();
        selectLocation(pet.getLocation());
        inputPhone(pet.getContactsPhone());
        typeEmail(pet.getEmail());
        click(By.xpath(BUTTON_PUBLISH));



    }
    public void fillNewPost(PetsPostDTO pets) {
        //  type(By.xpath(INPUT_TEXT), pets.getText());
        // waitElementToBeClickable(By.xpath(BROWSER_BUTTON));
        addPicture();

        inputDescription(pets.getDescription());
        clickButtonAddDesc();
        selectLocation(pets.getLocation());
        inputPhone(pets.getContactsPhone());
        typeEmail(pets.getEmail());
        click(By.xpath(BUTTON_PUBLISH));


    }
    public void fillDistinctiveFeatures(String text){
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(2000))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(INPUT_Distinctive_FEATURES)));
        Actions action = new Actions(driver);
        action.moveToElement(element).click();
        action.sendKeys(text).build().perform();
    }



    public void clickButtonLostMyPet() {
        click(By.xpath(BUTTON_LOST_MY_PET));
    }

    public void clickButtonFoundMyPet() {
        click(By.xpath(BUTTON_FOUND_MY_PET));
    }


  public void selectType(Type type){


            switch (type) {
                case DOG:
                    click(By.xpath(" //li[@data-value='0']"));
                    break;
                case CAT:
                    click(By.xpath(" //li[@data-value='1']"));
                    break;
                case BIRD:
                    click(By.xpath("//li[@data-value='2']"));
                    break;
                case RODENT:
                    click(By.xpath("//li[@data-value='3']"));
                    break;
                case REPTILE:
                    click(By.xpath("//li[@data-value='4']"));
                    break;
                case FERRET:
                    click(By.xpath("//li[@data-value='5']"));
                    break;
                case RABBIT:
                    click(By.xpath("//li[@data-value='6']"));
                    break;
                case TURTLE:
                    click(By.xpath("//li[@data-value='7']"));
                    break;
                case ExoticANIMAL:
                    click(By.xpath("//li[@data-value='8']"));
                    break;



            }
        }
    public  void selectorGender(Gender gender) {


        if (gender.equals(Gender.MALE)) {
            click(By.xpath("//li[@data-value='0']"));
        } else if (gender.equals(Gender.FEMALE)) {
            click(By.xpath("//li[@data-value='1']"));

        } else {
            click(By.xpath("//li[@data-value='2']"));

        }
    }
    public void addPicture() {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(2000))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(BROWSER_BUTTON)));
        Actions action = new Actions(driver);
        action.moveToElement(element).click();
        action.sendKeys("/Users/olgakolchina/pexels-pixabay-45201.jpg").build().perform();

    }

    public void selectLocation(String location) {
       type(By.xpath(SELECT_LOCATION),location);
        click(By.className("pac-item"));

    }

    public void inputDescription(String text) {
        WebElement element = new WebDriverWait(driver, Duration.ofNanos(2000))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(INPUT_DESCRIPTION)));
        Actions action = new Actions(driver);
        action.moveToElement(element).click();
        action.sendKeys(text).build().perform();
    }

    public void clickButtonAddDesc() {
        WebElement button = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(BUTTON_ADD_DESC)));
        Actions action = new Actions(driver);
        action.moveToElement(button).click().build().perform();

    }

    public void inputPhone(String text) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(INPUT_CONTACTS)));
        Actions action = new Actions(driver);
        action.moveToElement(element).click();
        action.sendKeys(text).build().perform();

    }

    public void typeEmail(String email) {
        WebElement date = driver.findElement(By.xpath(INPUT_EMAIL));

        date.click();
        String os = System.getProperty("os.name");
        System.out.println("os: " + os);
        if (os.startsWith("Mac")) {
            date.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        } else {
            date.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        }
        date.sendKeys(email);
        date.sendKeys(Keys.ENTER);
    }
    public void GetText() {
        WebElement text = driver.findElement(By.xpath(GET_TEXT_PET_NAME));
        System.out.println(text.getText());
      //  getTextAttribute("Dog, Test",By.xpath(GET_TEXT_PET_NAME));

    }


}
//li[@data-value='0']
//button[@data-testid ='location-button']

