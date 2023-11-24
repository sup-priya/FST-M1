package liveProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import static examples.ActionsBase.doSwipe;


public class AppiumProject3 {

    WebDriver driver;
    WebDriverWait wait;
    int TimeOut = 200;

    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, options);
        driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://v1.training-support.net/selenium");
    }

    @Test
    public void googleChromeTest() {
        Dimension dims = driver.manage().window().getSize();

        driver.findElement(AppiumBy.androidUIAutomator("text(\"Get Started!\")")).click();

        driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);

        Point start = new Point((int)(dims.getWidth() * 0.5), (int)(dims.getHeight()* 0.8));
        Point end = new Point((int)(dims.getWidth() * 0.5), (int)(dims.getHeight()* 0.2));

        doSwipe((AppiumDriver) driver, start, end, 200);
        driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
        doSwipe((AppiumDriver) driver, start, end, 200);

        wait.until(ExpectedConditions.elementToBeClickable(
               AppiumBy.xpath("//android.view.View[contains(@text,'To-Do List')]"))
        ).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']"))
        ).click();

        WebElement addTaskInput = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']"));
        WebElement addTaskButton = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']"));

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
