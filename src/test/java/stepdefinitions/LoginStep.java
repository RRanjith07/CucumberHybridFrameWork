package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

import java.util.Date;

public class LoginStep {
    WebDriver driver;
    private LoginPage loginPage;
    private AccountPage accountPage;

    private CommonUtils commonUtils = new CommonUtils();
    private DriverFactory driverFactory = new DriverFactory();

    @Given("User Navigates to LoginPage")
    public void User_Navigates_to_LoginPage()
    {
        driver = driverFactory.getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.clickonMyAccount();
        loginPage = homePage.clickonLogin();
    }

    @When("^User enters the Valid Email Address (.+)$")
    public void user_enters_the_valid_email_address(String emailAddress) {
        loginPage.enterEmailAddress(emailAddress);
    }

    @When("^User enters the Valid Password (.+)$")
    public void user_enters_the_valid_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("User clicks on Login Button")
    public void user_clicks_on_login_button() {
        accountPage = loginPage.clickOnLogin();
    }

    @Then("User should logged in Successfully")
    public void user_should_logged_in_successfully() {
        Assert.assertTrue(accountPage.verifyeditYourAccountInformationOption());
    }

    @When("User enters the inValid Email Address")
    public void user_enters_the_in_valid_email_address() {
        loginPage.enterEmailAddress(commonUtils.getEmailAddress());
    }

    @When("User enters the inValid Password {string}")
    public void user_enters_the_in_valid_password(String invalidPassword) {
        loginPage.enterEmailAddress(invalidPassword);
    }

    @Then("User should should get a warning message")
    public void user_should_should_get_a_warning_message() {
        Assert.assertTrue(loginPage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
    }

    @When("User do not enters the  Email Address")
    public void user_do_not_enters_the_email_address() {
        loginPage.enterEmailAddress("");
    }

    @When("User do not enters the Password")
    public void user_do_not_enters_the_password() {
        loginPage.enterPassword("");
    }
}