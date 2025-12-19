package AppiumTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AppiumTestLogin {

    static AndroidDriver driver;

    public static void main(String[] args) {
        try {
            openMobileApp();
            performLogin(); // New method call
        } catch (Exception e) {
            System.out.println("The test failed.");
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
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

        // Set an implicit wait so Appium searches for elements for up to 10s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Application successfully opened!");
    }

    public static void performLogin() {
        // Initialize Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // 1. Click Menu
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("View menu"))).click();
        System.out.println("Menu clicked.");

        // 2. Click 'Log In'
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text='Log In']"))).click();
        System.out.println("Navigating to Login page...");

        // 3. Wait for the Username field to be visible before typing
        try {
            // Corrected the wait syntax here
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.EditText[@resource-id='com.saucelabs.mydemoapp.android:id/nameET']")))
                .sendKeys("bob@example.com");
            System.out.println("Username entered.");
        } catch (Exception e) {
            System.out.println("Wait failed, attempting direct entry for username.");
            driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='com.saucelabs.mydemoapp.android:id/nameET']"))
                .sendKeys("bob@example.com");
        }

        // 4. Enter Password
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='com.saucelabs.mydemoapp.android:id/passwordET']"))
            .sendKeys("10203040");

        // 5. Click Login
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='Tap to login with given credentials']"))
            .click();
        System.out.println("Login button clicked!");
    }
}