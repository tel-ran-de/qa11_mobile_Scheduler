import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppManager {

    AppiumDriver driver;
    DesiredCapabilities caps;

    UserHelper user;

    public void init() throws MalformedURLException {
        caps = new DesiredCapabilities();

        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "8.0.0");
        caps.setCapability("deviceName", "qa11_mob");
        caps.setCapability("automationName", "Appium");
        caps.setCapability("appPackage", "com.example.svetlana.scheduler");
        caps.setCapability("appActivity", "presentation.splashScreen.SplashScreenActivity");
        caps.setCapability("app", "C:/Users/Tel-Ran.de/Documents/qa11/mobile/v.0.0.3.apk");

        driver = new AndroidDriver(new URL("http://127.0.01:4723/wd/hub"), caps);

        user = new UserHelper(driver);
    }

    public UserHelper user() {
        return user;
    }

    public void stop() {
        driver.quit();
    }
}