import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

public class Activity6 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        Actions builder = new Actions(driver);
        driver.get("https://v1.training-support.net/selenium/input-events");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        System.out.println("Home page title: " + driver.getTitle());
        builder.sendKeys("S").build().perform();
        System.out.println("key entered : S");
        builder.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build().perform();
        System.out.println("Action performed : Ctrl+A & Ctrl+C");
        driver.close();
    }
}