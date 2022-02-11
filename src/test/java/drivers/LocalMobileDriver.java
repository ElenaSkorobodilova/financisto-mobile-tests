package drivers;

import com.codeborne.selenide.WebDriverProvider;
import helpers.TestFileUtils;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import tests.config.LocalDeviceConfig;

import java.net.MalformedURLException;
import java.net.URL;

public class LocalMobileDriver implements WebDriverProvider {
    static LocalDeviceConfig testConfig =
            ConfigFactory.create(LocalDeviceConfig.class);

    public static URL getLocalDeviceUrl() {
        try {
            return new URL(testConfig.getLocalDeviceUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", testConfig.getDevice());
        desiredCapabilities.setCapability("version", testConfig.getOSVersion());
        desiredCapabilities.setCapability("locale", "en");
        desiredCapabilities.setCapability("language", "en");
        desiredCapabilities.setCapability("app",
                TestFileUtils.getAbsolutePath(testConfig.getApp()));

        return new AndroidDriver(getLocalDeviceUrl(), desiredCapabilities);
    }
}
