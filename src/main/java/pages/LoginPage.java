package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage {

    WebDriver driver;
    private ElementUtils elementUtils;
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        elementUtils = new ElementUtils(driver);
    }

    @FindBy(id = "input-email")
    private WebElement emailField;

    @FindBy(id ="input-password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement login;

    @FindBy(xpath = "//div[contains(@class,'alert-danger')]")
    private WebElement warningMessage;


    public void enterEmailAddress(String emailAddress)
    {
        elementUtils.typeTextIntoElement(emailField,emailAddress, CommonUtils.EXPLICIT_WAIT_TIME);
    }

    public void enterPassword(String password)
    {
        elementUtils.typeTextIntoElement(passwordField,password,CommonUtils.EXPLICIT_WAIT_TIME);
    }

    public AccountPage clickOnLogin()
    {
        elementUtils.clickOnElement(login,CommonUtils.EXPLICIT_WAIT_TIME);
        return new AccountPage(driver);
    }

    public String getWarningMessageText()
    {
        return elementUtils.getTextFromElement(warningMessage,CommonUtils.EXPLICIT_WAIT_TIME);
    }
}

