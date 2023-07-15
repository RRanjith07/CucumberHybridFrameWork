package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterPage {

    WebDriver driver;
    private ElementUtils elementUtils;

    public RegisterPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        elementUtils = new ElementUtils(driver);
    }

    @FindBy(id = "input-firstname")
    private WebElement firstNameField;

    @FindBy(id = "input-lastname")
    private WebElement lastNameField;

    @FindBy(id = "input-email")
    private WebElement emailField;

    @FindBy(id = "input-telephone")
    private WebElement telePhoneField;

    @FindBy(id = "input-password")
    private WebElement passwordField;

    @FindBy(id = "input-confirm")
    private WebElement confirmPasswordField;

    @FindBy(id = "input-confirm")
    private WebElement confirmButton;

    @FindBy(xpath = "//input[@name='agree']")
    private WebElement privacyPolicy;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//*[@name='newsletter'][@value=1]")
    private WebElement yesToNewsLetter;

    @FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
    private WebElement warningMessageDuplicateEmail;

    @FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
    private WebElement firstNameWarningMessage;

    @FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
    private WebElement lastNameWarningMessage;

    @FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
    private WebElement emailWarningMessage;

    @FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
    private WebElement telephoneWarningMessage;

    @FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
    private WebElement passwordWarningMessage;

    public void enterFirstName(String firstName)
    {
        elementUtils.typeTextIntoElement(firstNameField,firstName, CommonUtils.EXPLICIT_WAIT_TIME);
    }

    public void enterLasstName(String lastName)
    {
        elementUtils.typeTextIntoElement(lastNameField,lastName,CommonUtils.EXPLICIT_WAIT_TIME);
    }

    public void enterEmailAddress(String emailAddress)
    {
        elementUtils.typeTextIntoElement(emailField,emailAddress,CommonUtils.EXPLICIT_WAIT_TIME);
    }

    public void enterTelephoneNumber(String phoneNumber)
    {
        elementUtils.typeTextIntoElement(telePhoneField,phoneNumber,CommonUtils.EXPLICIT_WAIT_TIME);
    }

    public void enterPassword(String password)
    {
        elementUtils.typeTextIntoElement(passwordField,password,CommonUtils.EXPLICIT_WAIT_TIME);
    }

    public void confirmPassword(String password)
    {
        elementUtils.typeTextIntoElement(confirmPasswordField,password,CommonUtils.EXPLICIT_WAIT_TIME);
    }

    public void clickonConfirmButton()
    {
        elementUtils.clickOnElement(confirmButton,CommonUtils.EXPLICIT_WAIT_TIME);
    }

    public void clickonPrivacyPolicy()
    {
        elementUtils.clickOnElement(privacyPolicy,CommonUtils.EXPLICIT_WAIT_TIME);
    }

    public AccountSuccessPage clickonContinueButton()
    {
        elementUtils.clickOnElement(continueButton,CommonUtils.EXPLICIT_WAIT_TIME);
        return new AccountSuccessPage(driver);
    }

    public void clickYesToNewsLetter()
    {
        elementUtils.clickOnElement(yesToNewsLetter,CommonUtils.EXPLICIT_WAIT_TIME);
    }

    public String verifyWarningMessage()
    {
        return elementUtils.getTextFromElement(warningMessageDuplicateEmail,CommonUtils.EXPLICIT_WAIT_TIME);

    }

    public String verifyFirstNameWarningMessage()
    {
        return elementUtils.getTextFromElement(firstNameWarningMessage,CommonUtils.EXPLICIT_WAIT_TIME);
    }

    public String verifyLastNameWarningMessage()
    {
        return elementUtils.getTextFromElement(lastNameWarningMessage,CommonUtils.EXPLICIT_WAIT_TIME);
    }

    public String verifyEmailWarningMessage()
    {
        return elementUtils.getTextFromElement(emailWarningMessage,CommonUtils.EXPLICIT_WAIT_TIME);
    }

    public String verifyTelephoneWarningMessage()
    {
        return elementUtils.getTextFromElement(telephoneWarningMessage,CommonUtils.EXPLICIT_WAIT_TIME);
    }

    public String verifyPasswordWarningMessage()
    {
        return elementUtils.getTextFromElement(passwordWarningMessage,CommonUtils.EXPLICIT_WAIT_TIME);
    }
}
