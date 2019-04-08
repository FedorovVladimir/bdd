import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateSingleton {

    private String url = "http://127.0.0.1:8000";
    private static final WebDriver driver;

    static {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @When("^Open index page site$")
    public void openIndexPageSite() {
        driver.get(url);
    }

    @Then("^I see index page and title \"([^\"]*)\"$")
    public void iSeeIndexPageAndTitle(String arg0) throws Throwable {
        String title = driver.getTitle();
        if (!title.equals(arg0)) {
            throw new PendingException();
        }
    }



    @When("^Открываем главную страницу сайта$")
    public void открываемГлавнуюСтраницуСайта() {
        driver.get(url);
    }

    @And("^Заполняем поле для название класса$")
    public void заполняемПолеДляНазваниеКласса() {
        WebElement input = driver.findElement(By.id("name_input"));
        input.sendKeys("ClassName");
    }

    @And("^Нажимаем кнопку \"([^\"]*)\"$")
    public void нажимаемКнопку(String arg0) {
        WebElement button = driver.findElement(By.id("create_button"));
        if (!button.getText().equals(arg0)) {
            throw new PendingException();
        }
        button.click();
    }

    @Then("^Получаем страницу с кодом одиночки$")
    public void получаемСтраницуСКодомОдиночки() {
        String pattern = driver.findElement(By.id("code")).getText();
        String singleton = "public class ClassName {\n" +
                "    private static ClassName ourInstance = new ClassName();\n" +
                "\n" +
                "    public static ClassName getInstance() {\n" +
                "        return ourInstance;\n" +
                "    }\n" +
                "\n" +
                "    private ClassName() {\n" +
                "    }\n" +
                "}\n";
        Assert.assertEquals(true, equals(pattern, singleton));
    }

    private boolean equals(String s1, String s2) {
        s1 = s1.replace("\n", "");
        s2 = s2.replace("\n", "");
        if (s1.equals(s2)) {
            return true;
        }
        return false;
    }

//    @After
//    public void close() {
//        driver.quit();
//    }
}