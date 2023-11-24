import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
    private WebDriver driver;

    @BeforeMethod
    public void Setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        //Open browser
        driver.get("http://alchemy.hguy.co/crm");
    }

    @Test
    public void TestCase() {
        // Check the title of the page
        String title = driver.getTitle();

        //Print the title of the page
        System.out.println("Page title value is: " + title);

        //Assertion for page title
        Assert.assertEquals(title,"SuiteCRM");
    }

    @AfterMethod
    public void teardown() {
        //Close the browser
        driver.quit();
    }

}