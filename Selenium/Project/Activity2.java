import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {
    private WebDriver driver;

    @BeforeMethod
    public void Setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
    }

    @Test
    public void TestCase() {
        WebElement url = driver.findElement(By.cssSelector(".companylogo > img"));
        System.out.println("Page header URL value is : " + url.getAttribute("src"));
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}