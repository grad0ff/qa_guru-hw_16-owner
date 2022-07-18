package hw_16.owner_config.config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class WebDriverProviderOwner {

    private final WebDriverConfigOwner config;

    public WebDriverProviderOwner() {
        config = ConfigFactory.create(WebDriverConfigOwner.class, System.getProperties());
        Configuration.browser = config.getBrowser();
        Configuration.baseUrl = config.getBaseUrl();
        if (System.getProperty("host", "local").equals("remote")) {
            DesiredCapabilities capabilities = setRemoteCapabilities();
            Configuration.remote = config.getHostUrl();
            Configuration.browserCapabilities = capabilities;
        }
    }

    private DesiredCapabilities setRemoteCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", config.getBrowser());
        capabilities.setCapability("browserVersion", config.getBrowserVersion());
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        return capabilities;
    }
}
