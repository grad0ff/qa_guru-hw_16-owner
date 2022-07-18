package hw_16.external_config;

import hw_16.external_config.config.WebDriverProviderExternal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.sleep;

@Tag("googleTest")
public class GoogleTest {

    static WebDriver driver;

    @BeforeAll
    static void init() {
        driver = new WebDriverProviderExternal().get();
    }

    @Test
    void googleTest() {
        sleep(5000);
        assert driver.getCurrentUrl().contains("google");
    }

    @AfterEach
    void clean() {
        driver.quit();
    }
}
