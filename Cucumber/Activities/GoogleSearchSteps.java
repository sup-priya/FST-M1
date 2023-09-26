package stepDefinitions;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GoogleSearchSteps {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Given("^ User is on Google home page $")
    public void userIsOnTheGoogleHomePage() {
        driver.get("https://google.com");
       //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("W0wltc")));
        //driver.findElement(By.id("W0wltc")).click();
    }

    @When("^ User types in Cheese and hits ENTER $")
    public void userTypesCheese() {
        driver.findElement(By.id("APjFqb")).click();
        driver.findElement(By.id("APjFqb")).sendKeys("Cheese", Keys.RETURN);
    }

    @Then("^ Show how many search results were found $")
    public void showSearchResultsNum() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result-stats")));
        WebElement stats = driver.findElement(By.id("result-stats"));
        System.out.println("Result text is:" + stats.getText());
    }

    @And("^ Close the browser $ ")
    public void teardown() {
        driver.close();
    }
}
