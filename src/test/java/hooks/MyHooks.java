package hooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ConfigReader;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class MyHooks {
    WebDriver driver;
    private DriverFactory driverFactory = new DriverFactory();
    private ConfigReader configReader = new ConfigReader();

    @Before
    public void setUp() throws IOException {
        Properties prop = configReader.getPropeties();
        driver = driverFactory.initializeBrowser(prop.getProperty("browser"));
        driver.get(prop.getProperty("url"));
    }
    @After
    public void tearDown(Scenario scenario)
    {
        String scenarioName = scenario.getName().replaceAll(" ", "_");
        if(scenario.isFailed())
        {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"img/png", scenarioName);
        }
        driver.quit();
    }

}
