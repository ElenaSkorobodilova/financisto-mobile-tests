package tests.config;
import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/browserstack.properties"
})
public interface BrowserStackConfig extends Config {
    @Key("browserstack.url")
    @DefaultValue("http://hub.browserstack.com/wd/hub")
    String getBrowserstackUrl();

    @Key("browserstack.user")
    String getBrowserstackUser();

    @Key("browserstack.key")
    String getBrowserstackKey();

    @Key("app")
    String getApp();

    @Key("device")
    @DefaultValue("Google Pixel 3")
    String getDevice();

    @Key("os_version")
    @DefaultValue("9.0")
    String getOSVersion();
}
