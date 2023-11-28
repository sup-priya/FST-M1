package liveProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;


public class AppiumProject1 {

    WebDriver driver;
    int TimeOut = 200;

    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity("com.google.android.apps.tasks.ui.TaskListsActivity");
        options.noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, options);
        driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
    }

    @Test
    public void googleTasksTest() {
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
        driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Complete Activity with Google Tasks");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[4]")).click();
        driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);

        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
        driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Complete Activity with Google Keep");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[4]")).click();
        driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);

        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
        driver.findElement(AppiumBy.id("add_task_title")).sendKeys("Complete the second Activity Google Keep");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[4]")).click();
        driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);

        String result = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Tasks\"]")).getAttribute("content-desc");
        assertEquals(result,"Complete Activity with Google Tasks");

        String result1 = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Keep\"]")).getAttribute("content-desc");
        assertEquals(result1, "Complete Activity with Google Keep");

        String result2 = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Complete the second Activity Google Keep\"]")).getAttribute("content-desc");
        assertEquals(result2,"Complete the second Activity Google Keep");

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}