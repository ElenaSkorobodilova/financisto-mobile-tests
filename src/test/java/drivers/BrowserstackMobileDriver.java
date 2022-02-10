package drivers;
import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import tests.config.BrowserStackConfig;

import java.net.MalformedURLException;
import java.net.URL;
    public class BrowserstackMobileDriver implements WebDriverProvider {
        static BrowserStackConfig testConfig =
                ConfigFactory.create(BrowserStackConfig.class);

        public static URL getBrowserstackUrl() {
            try {
                return new URL(testConfig.getBrowserstackUrl());
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

            // Set your access testConfig
            desiredCapabilities.setCapability("browserstack.user", testConfig.getBrowserstackUser());
            desiredCapabilities.setCapability("browserstack.key", testConfig.getBrowserstackKey());

            // Set URL of the application under test
            desiredCapabilities.setCapability("app", testConfig.getApp());

            // Specify device and os_version for testing
            desiredCapabilities.setCapability("device", testConfig.getDevice());
            desiredCapabilities.setCapability("os_version", testConfig.getOSVersion());

            // Set other BrowserStack capabilities
            desiredCapabilities.setCapability("project", "First Java Project");
            desiredCapabilities.setCapability("build", "browserstack-build-1");
            desiredCapabilities.setCapability("name", "first_test");

            desiredCapabilities.setCapability("browser", "CHROME");

            // Initialise the remote Webdriver using BrowserStack remote URL
            // and desired capabilities defined above
            return new AndroidDriver(getBrowserstackUrl(), desiredCapabilities);
        }
}
