package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

import java.util.Date;
import java.util.Map;

public class RegisterStep {

    DriverFactory driverFactory = new DriverFactory();

    WebDriver driver = driver = driverFactory.getDriver();
    private RegisterPage registerPage;
    private AccountSuccessPage accountSuccessPage;

    CommonUtils commonUtils = new CommonUtils();

    HomePage homePage = new HomePage(driver);

    @Given("User navigates to Register Account Page")
    public void user_navigates_to_register_account_page() {
        homePage.clickonMyAccount();
        registerPage = homePage.clickonRegister();
    }

    @When("user enters the details into below field")
    public void user_enters_the_details_into_below_field(DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        registerPage.enterFirstName(dataMap.get("FirstName"));
        registerPage.enterLasstName(dataMap.get("LastName"));
        registerPage.enterEmailAddress(commonUtils.getEmailAddress());
        registerPage.enterTelephoneNumber(dataMap.get("Telephone"));
        registerPage.enterPassword(dataMap.get("Password"));
        registerPage.confirmPassword(dataMap.get("Password"));
    }

    @When("User selects Privacy Policy")
    public void user_selects_privacy_policy() {
        registerPage.clickonPrivacyPolicy();
    }

    @When("User clicks on Continue button")
    public void user_clicks_on_continue_button() {
         accountSuccessPage = registerPage.clickonContinueButton();
    }

    @When("User selects Yes for the Newsletter")
    public void user_selects_Yes_for_the_newsletter() {
        registerPage.clickYesToNewsLetter();
    }

    @Then("User account should get created successfully")
    public void user_account_should_get_created_successfully() {
        Assert.assertEquals(accountSuccessPage.verifyAccountSuccessMessage(),
                                            "Your Account Has Been Created!");
    }

    @Then("User should get the warning message about duplicate email address")
    public void user_account_should_get_the_warning_message() {
        Assert.assertEquals(registerPage.verifyWarningMessage(),
                                            "Warning: E-Mail Address is already registered!");
    }

    @When("User do not enter any details into the field")
    public void user_do_not_enter_any_details_into_the_field() {
        //Intentionally kept blank
    }

    @When("user enters the details into below field with duplicate email")
    public void userEntersTheDetailsIntoBelowFieldWithDuplicateEmail(DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        registerPage = new RegisterPage(driver);
        registerPage.enterFirstName(dataMap.get("FirstName"));
        registerPage.enterLasstName(dataMap.get("LastName"));
        registerPage.enterEmailAddress(dataMap.get("E-Mail"));
        registerPage.enterTelephoneNumber(dataMap.get("Telephone"));
        registerPage.enterPassword(dataMap.get("Password"));
        registerPage.confirmPassword(dataMap.get("Password"));
    }

    @Then("User should get the warning messages for every mandatory fields")
    public void user_account_should_get_the_warning_messages_for_every_mandatory_fields() {
        Assert.assertEquals(registerPage.verifyWarningMessage(),
                "Warning: You must agree to the Privacy Policy!");

        Assert.assertEquals(registerPage.verifyFirstNameWarningMessage(),
                "First Name must be between 1 and 32 characters!");

        Assert.assertEquals(registerPage.verifyLastNameWarningMessage(),
                "Last Name must be between 1 and 32 characters!");

        Assert.assertEquals(registerPage.verifyEmailWarningMessage(),
                "E-Mail Address does not appear to be valid!");

        Assert.assertEquals(registerPage.verifyTelephoneWarningMessage(),
                "Telephone must be between 3 and 32 characters!");

        Assert.assertEquals(registerPage.verifyPasswordWarningMessage(),
                "Password must be between 4 and 20 characters!");

    }
}