import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        options.addArguments("--headless");
        ChromeDriver driver = new ChromeDriver();

        driver.get("http://ya.ru/");
        System.out.println(driver.toString());
        driver.quit();
    }
}
