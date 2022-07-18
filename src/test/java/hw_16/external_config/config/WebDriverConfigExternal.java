package hw_16.external_config.config;

public class WebDriverConfigExternal {

    private Browser browser;

    public Browser getBrowser() {
        String browserName = System.getProperty("browser", Browser.CHROME.name());
        browser = Browser.valueOf(browserName);
        return browser;
    }

    public String getBrowserVersion() {
        return System.getProperty("browserVersion", browser.getBrowserVersion());
    }

    public String getBaseUrl() {
        return "https://google.com";
    }
}