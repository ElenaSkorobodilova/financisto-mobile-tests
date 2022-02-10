package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import tests.config.SelenoidConfig;

import java.net.MalformedURLException;
import java.net.URL;

public class SelenoidMobileDriver implements WebDriverProvider {
    static SelenoidConfig testConfig =
            ConfigFactory.create(SelenoidConfig.class);

    public static URL getLocalDeviceUrl() {
        try {
            return new URL(String.format("https://%s:%s@%s", testConfig.login(),
                    testConfig.password(), testConfig.testUrl()));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "android");
        desiredCapabilities.setCapability("version", "8.1");
        desiredCapabilities.setCapability("locale", "en");
        desiredCapabilities.setCapability("language", "en");
        desiredCapabilities.setCapability("enableVNC", true);
        desiredCapabilities.setCapability("enableVideo", true);
        desiredCapabilities.setCapability("app", testConfig.apkUrl());

        return new AndroidDriver(getLocalDeviceUrl(), desiredCapabilities);
    }
}
