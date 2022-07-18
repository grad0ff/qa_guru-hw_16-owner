package hw_16.owner_config;

import com.codeborne.selenide.Selenide;
import hw_16.owner_config.config.WebDriverProviderOwner;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;

@Tag("yandexTest")
public class YandexTest {

    static WebDriverProviderOwner webDriverProvider;

    @BeforeAll
    static void init() {
        webDriverProvider = new WebDriverProviderOwner();
    }

    @Test
    void yandexTest() {
        open("/");
        sleep(5000);
        assert Selenide.webdriver().driver().url().contains("yandex");
    }

    @AfterEach
    void clean() {
        closeWebDriver();
    }
}
