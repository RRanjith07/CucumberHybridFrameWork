package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;
import utils.ElementUtils;

public class SearchResultPage {

    WebDriver driver;
    private ElementUtils elementUtils;

    public SearchResultPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        elementUtils = new ElementUtils(driver);
    }

    @FindBy(linkText = "HP LP3065")
    private WebElement displayedProduct;

    @FindBy(xpath = "//input[@id='button-search']/following-sibling::p")
    private WebElement noProductWarningMessage;

    public boolean verifySearchProduct()
    {
        return elementUtils.isDisplayedElement(displayedProduct, CommonUtils.EXPLICIT_WAIT_TIME);
    }

    public String verifyWarningMessage_No_ProductMatch()
    {
        return elementUtils.getTextFromElement(noProductWarningMessage, CommonUtils.EXPLICIT_WAIT_TIME);
    }
}
