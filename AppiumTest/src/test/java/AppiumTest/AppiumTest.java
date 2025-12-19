package AppiumTest;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;

public class AppiumTest {

    static AndroidDriver driver;

    public static void main(String[] args) {
        try {
            openMobileApp();
        } catch (Exception e) {
            System.out.println("The test failed to start.");
            e.printStackTrace();
        }
    }

    public static void openMobileApp() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("platformName", "Android");
        cap.setCapability("appium:automationName", "UIAutomator2");
        cap.setCapability("appium:deviceName", "sdk_gphone64_x86_64");
        cap.setCapability("appium:udid", "emulator-5554");
        cap.setCapability("appium:appPackage", "com.saucelabs.mydemoapp.android");
        cap.setCapability("appium:appActivity", "com.saucelabs.mydemoapp.android.view.activities.SplashActivity");

       
        URL url = new URL("http://127.0.0.1:4723/");
        
        driver = new AndroidDriver(url, cap);

        System.out.println("Application successfully opened!");
    }
}