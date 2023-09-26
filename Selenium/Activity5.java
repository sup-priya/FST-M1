import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

public class Activity5 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        Actions builder = new Actions(driver);
        driver.get("https://v1.training-support.net/selenium/input-events");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("Home page title: " + driver.getTitle());
        builder.click().pause(1000).build().perform();
        String Text = driver.findElement(By.className("active")).getText();
        System.out.println(Text);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        builder.doubleClick().pause(1000).build().perform();
        Text = driver.findElement(By.className("active")).getText();
        System.out.println(Text);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        builder.contextClick().pause(1000).build().perform();
        Text = driver.findElement(By.className("active")).getText();
        System.out.println(Text);
        driver.close();
    }
}