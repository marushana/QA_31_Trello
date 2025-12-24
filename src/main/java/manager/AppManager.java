package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class AppManager {
    private WebDriver driver;
    public Logger logger = LoggerFactory.getLogger(AppManager.class);

    public WebDriver getDriver() {
        return driver;
    }

    public AppManager() {
    }

    @BeforeMethod(alwaysRun = true)
    public void setup(Method method) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lang=en");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        logger.info("Start test -->" + method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(Method method) {
        if (driver != null)
            driver.quit();
        logger.info("Stop test -->" + method.getName());
    }
}
