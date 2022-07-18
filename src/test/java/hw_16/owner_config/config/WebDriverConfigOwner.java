package hw_16.owner_config.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${host}.properties"})
public interface WebDriverConfigOwner extends Config {

    @Key("browser")
    String getBrowser();

    @Key("browserVersion")
    String getBrowserVersion();


    @Key("hostUrl")
    String getHostUrl();

    @DefaultValue("https://yandex.ru")
    String getBaseUrl();
}
