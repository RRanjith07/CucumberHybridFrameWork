package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {

    WebDriver driver;
    private ElementUtils elementUtils;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        elementUtils = new ElementUtils(driver);
    }

    @FindBy(xpath = "//span[text()='My Account']")
    private WebElement myAccountDropMenu;

    @FindBy(xpath = "//*[text()='Login']")
    private WebElement loginOption;

    @FindBy(linkText = "Register")
    private WebElement registerOption;

    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchField;

    @FindBy(xpath = "//button[contains(@class,'btn-default')]")
    private WebElement searchButton;

    public void searchProduct(String productName)
    {
        elementUtils.typeTextIntoElement(searchField,productName, CommonUtils.EXPLICIT_WAIT_TIME);
    }

    public SearchResultPage clickonSearch()
    {
        elementUtils.clickOnElement(searchButton,CommonUtils.EXPLICIT_WAIT_TIME);
        return new SearchResultPage(driver);
    }

    public void clickonMyAccount()
    {
        elementUtils.clickOnElement(myAccountDropMenu,CommonUtils.EXPLICIT_WAIT_TIME);
    }

    public RegisterPage clickonRegister()
    {
        elementUtils.clickOnElement(registerOption,CommonUtils.EXPLICIT_WAIT_TIME);
        return new RegisterPage(driver);
    }

    public LoginPage clickonLogin()
    {
        elementUtils.clickOnElement(loginOption,CommonUtils.EXPLICIT_WAIT_TIME);
        return new LoginPage(driver);
    }
}