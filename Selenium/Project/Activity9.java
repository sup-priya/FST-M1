import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class Activity9 {
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
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        WebElement toolbar = driver.findElement(By.id("grouptab_0"));
        toolbar.click();

        WebElement toolbar1 = driver.findElement(By.id("moduleTab_9_Leads"));
        toolbar1.click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[1]/td[10]/*")));

        for (int i=1; i<=10; i++) {
            WebElement nameValue = driver.findElement(By.xpath("//table/tbody/tr["+ i + "]/td[3]/b/a"));
            WebElement userValue = driver.findElement(By.xpath("//table/tbody/tr["+ i + "]/td[8]/a"));
            System.out.println("Row name is : " + nameValue.getText());
            System.out.println("Row user is : " + userValue.getText());
        }
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}