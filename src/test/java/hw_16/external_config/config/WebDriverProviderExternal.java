package hw_16.external_config.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.function.Supplier;

public class WebDriverProviderExternal implements Supplier<WebDriver> {

    private final WebDriverConfigExternal config;

    public WebDriverProviderExternal() {
        config = new WebDriverConfigExternal();
    }

    @Override
    public WebDriver get() {
        WebDriver driver;
        Browser browser = config.getBrowser();
        DesiredCapabilities capabilities = setBrowserCapabilities();
        if (System.getProperty("host", "local").equals("remote")) {
            driver = getRemoteWebDriver(capabilities);
        } else {
            driver = getLocalWebDriver(browser, capabilities);
        }
        driver.get(config.getBaseUrl());
        return driver;
    }

    private DesiredCapabilities setBrowserCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", config.getBrowser().name().toLowerCase());
        capabilities.setCapability("browserVersion", config.getBrowserVersion());
        return capabilities;
    }

    private WebDriver getRemoteWebDriver(DesiredCapabilities capabilities) {
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        try {
            return new RemoteWebDriver(new URL("http://user1:1234@selenoid.autotests.cloud:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private WebDriver getLocalWebDriver(Browser browser, DesiredCapabilities capabilities) {
        switch (browser) {
            case CHROME:
                WebDriverManager.chromedriver().capabilities(capabilities).setup();
                return new ChromeDriver();
            case FIREFOX:
                WebDriverManager.firefoxdriver().capabilities(capabilities).setup();
                return new FirefoxDriver();
            case OPERA:
                WebDriverManager.operadriver().capabilities(capabilities).setup();
                return new OperaDriver();
            default:
                throw new RuntimeException("No such browser");
        }
    }
}
