import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

import java.time.Duration;

public class Activity5 {
    private WebDriver driver;

    @BeforeMethod
    public void Setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/crm");
    }

    @Test
    public void TestCase() {
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//*[@id=\"bigbutton\"]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        WebElement toolbar = driver.findElement(By.id("ygddfdiv"));
        System.out.println("Page navigation toolbar colour is : " + toolbar.getCssValue("color"));
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
