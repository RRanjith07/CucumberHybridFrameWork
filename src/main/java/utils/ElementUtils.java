package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementUtils {

    WebDriver driver;

    public ElementUtils(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickOnElement(WebElement element, long durationInSeconds)
    {
        WebElement webElement = waitForElement(element, durationInSeconds);
        webElement.click();
    }

    public void typeTextIntoElement(WebElement element, String text, long durationInSeconds)
    {
        WebElement webElement = waitForElement(element, durationInSeconds);
        webElement.click();
        webElement.clear();
        webElement.sendKeys(text);
    }

    public WebElement waitForElement(WebElement element, long durationInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void selectOptionInDropDown(WebElement element, String dropDownOption, long durationInSeconds)
    {
        WebElement webElement = waitForElement(element, durationInSeconds);
        Select select = new Select(webElement);
        select.selectByVisibleText(dropDownOption);
    }

    public Alert waitForAletToBeDisplayed(long durationInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert;
    }

    public void acceptAlert(long durationInSeconds)
    {
        Alert alert = waitForAletToBeDisplayed(durationInSeconds);
        alert.accept();
    }

    public void dismissAlert(long durationInSeconds)
    {
        Alert alert = waitForAletToBeDisplayed(durationInSeconds);
        alert.dismiss();
    }

    public void mouseHoverAndClick(WebElement element, long durationInSeconds)
    {
        WebElement webElement = visibilityOfElement(element, durationInSeconds);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public WebElement visibilityOfElement(WebElement element, long durationInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
        WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));
        return webElement;
    }

    public void javaScriptClick(WebElement element, long durationInSeconds)
    {
        WebElement webElement = visibilityOfElement(element, durationInSeconds);
        JavascriptExecutor jse = ((JavascriptExecutor)driver);
        jse.executeScript("arguments[0].click;", webElement);
    }

    public void javaScriptType(WebElement element, long durationInSeconds, String text)
    {
        WebElement webElement = visibilityOfElement(element, durationInSeconds);
        JavascriptExecutor jse = ((JavascriptExecutor)driver);
        jse.executeScript("arguments[0].value='"+text+"'", webElement);
    }

    public String getTextFromElement(WebElement element, long durationInSeconds )
    {
        WebElement webElement = visibilityOfElement(element,durationInSeconds);
        return webElement.getText();
    }

    public boolean isDisplayedElement(WebElement element, long durationInSeconds)
    {
        WebElement webElement = visibilityOfElement(element, durationInSeconds);
        return webElement.isDisplayed();
    }
}