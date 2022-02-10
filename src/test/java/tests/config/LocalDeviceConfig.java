package tests.config;
import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/localdevice.properties"
})
public interface LocalDeviceConfig extends Config {
    @Key("local_device.url")
    @DefaultValue("http://127.0.0.1:4723/wd/hub")
    String getLocalDeviceUrl();

    @Key("device")
    @DefaultValue("Google Pixel 3")
    String getDevice();

    @Key("os_version")
    @DefaultValue("9.0")
    String getOSVersion();
}
