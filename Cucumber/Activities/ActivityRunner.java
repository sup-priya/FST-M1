import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features",
        glue = { "stepDefinitions" },
        plugin = {"pretty"},
        //plugin = {"html: test-reports"},
        //plugin = {"json: test-reports/json-report.json"},
        monochrome = true,
        tags = "@activity1 and @activity2 and @activity3 and @activity4 and @activity5"
)
public class ActivityRunner {
}