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


public class AppiumProject2 {

    WebDriver driver;
    int TimeOut = 200;

    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity("com.google.android.apps.keep.ui.activities.BrowseActivity");
        options.noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL,options);
    }

    @Test
    public void googleKeepTest() {
        driver.findElement(AppiumBy.accessibilityId("New text note")).click();
        driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);

        driver.findElement(AppiumBy.id("editable_title")).sendKeys("NoteTitle");

        driver.findElement(AppiumBy.id("edit_note_text")).sendKeys("AddNotes");

        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();

        driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
        String result = driver.findElement(AppiumBy.xpath("//androidx.cardview.widget.CardView[@content-desc=\"NoteTitle. AddNotes. \"]")).getTagName();
        //String result = driver.findElement(AppiumBy.xpath("//androidx.cardview.widget.CardView[@content-desc=\"NoteTitle. AddNotes. \"]")).getAttribute("content-desc");
        assertEquals(result,"NoteTitle. AddNotes. ");

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}