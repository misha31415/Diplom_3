package praktikum.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
    public static WebDriver getDriver(String browserName) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        if ("yandex".equalsIgnoreCase(browserName)) {
            String yandexPath = System.getProperty("yandex.path");
            if (yandexPath == null || yandexPath.isEmpty()) {
                throw new IllegalArgumentException(
                        "Укажите путь к Яндекс.Браузеру через -Dyandex.path=..."
                );
            }
            options.setBinary(yandexPath);
        }

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getDriver() {
        return getDriver("chrome");
    }
}
