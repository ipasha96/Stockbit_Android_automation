package StepDefinitions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CommonStep {
    
    
    @Given("User on home page")
    public void user_on_home_page() {
        System.out.println("User on home page");
    }

    @When("User click demo app icon")
    public void user_click_demo_app_icon() throws MalformedURLException { 
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("appium:automationName", "UIAutomator2");
        cap.setCapability("appium:deviceName", "sdk_gphone64_x86_64");
        cap.setCapability("appium:udid", "emulator-5554");
        cap.setCapability("appium:appPackage", "com.saucelabs.mydemoapp.android");
        cap.setCapability("appium:appActivity", "com.saucelabs.mydemoapp.android.view.activities.SplashActivity");

        Basedriver.driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), cap);
        Basedriver.wait = new WebDriverWait(Basedriver.driver, Duration.ofSeconds(10));

        System.out.println("Application successfully opened!");
    }

       
    @And("User click view menu")
    public void user_click_view_menu() {
        Basedriver.wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("View menu"))).click();
        System.out.println("Menu clicked.");
    }

    @And("User click Log In menu")
    public void user_click_log_in_menu() {
        Basedriver.wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text='Log In']"))).click();
        System.out.println("Navigating to Login page...");
    }
    @And("User input password")
    public void user_input_password() {
        Basedriver.driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='com.saucelabs.mydemoapp.android:id/passwordET']"))
            .sendKeys("10203040");
    }

    @And("User click Login button")
    public void user_click_login_button() {
        Basedriver.driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='Tap to login with given credentials']"))
            .click();
        System.out.println("Login button clicked!");
    }

}
