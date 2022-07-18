package hw_16.external_config.config;

public enum Browser {
    CHROME("99"),
    FIREFOX("97"),
    OPERA("84");

    private final String browserVersion;

    Browser(String browserVersion) {
        this.browserVersion = browserVersion;
    }

    public String getBrowserVersion() {
        return browserVersion;
    }
}