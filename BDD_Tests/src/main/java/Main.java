import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        driver.get("ya.ru");
        driver.quit();
    }
}
