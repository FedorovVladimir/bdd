import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MyStepdefs {

    private String url = "http://ya.ru/";//"http://127.0.0.1:8000";
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

    @Then("^I see index page$")
    public void iSeeIndexPage() {
        String titleText = driver.findElement(By.tagName("title")).getText();
        if (!titleText.equals("create patterns")) {
            System.out.println("test failed");
        }
        driver.quit();
    }
}
