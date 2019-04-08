import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;

public class OpenPage {

    private String url = "http://127.0.0.1:8000";
    private static final ChromeDriver driver;

    static {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        options.addArguments("--headless");
        driver = new ChromeDriver();
    }

    @When("^Open index page site$")
    public void openIndexPageSite() {
        driver.get(url);
    }

    @Then("^I see index page and title \"create patterns\"$")
    public void iSeeIndexPage() {
        String titleText = driver.getTitle();
        assertEquals("create patterns", titleText);
    }

    @After
    public void close() {
        driver.quit();
    }
}
