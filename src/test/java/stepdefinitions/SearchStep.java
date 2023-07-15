package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.SearchResultPage;

public class SearchStep{

    DriverFactory driverFactory = new DriverFactory();
    WebDriver driver = driverFactory.getDriver();
    private HomePage homePage;
    private SearchResultPage searchResultPage;

    @Given("User is on Home Page of the application")
    public void user_is_on_home_page_of_the_application() {
        WebDriver driver = driverFactory.getDriver();
    }

    @When("user searches a valid product {string} into search box field")
    public void user_searches_a_valid_product_into_search_box_field(String productName) {
        homePage = new HomePage(driver);
        homePage.searchProduct(productName);
    }

    @When("User clicks on Search button")
    public void user_clicks_on_search_button() {
        HomePage homePage = new HomePage(driver);
        searchResultPage = homePage.clickonSearch();
    }

    @Then("User should get valid product displayed")
    public void user_should_get_valid_product_displayed() {
        Assert.assertTrue(searchResultPage.verifySearchProduct());
    }

    @When("user searches a invalid product {string} into search box field")
    public void user_searches_a_invalid_product_into_search_box_field(String invalidProductName) {
        HomePage homePage=new HomePage(driver);
        homePage.searchProduct(invalidProductName);
    }

    @Then("User should should get proper warning message about no product matching")
    public void user_should_should_get_proper_warning_message_about_no_product_matching() {
        Assert.assertEquals(searchResultPage.verifyWarningMessage_No_ProductMatch(),
                                                    "There is no product that matches the search criteria.");
    }

    @When("user do not enter any product name in the search box field")
    public void user_do_not_enter_any_product_name_in_the_search_box_field() {
        //Intemtionally left blank
    }









}
