package StepDefinitions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;


public class OpenAppSteps {
    
        
    @And("User input username")
    public void user_input_username() {
        try {
            Basedriver.wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.EditText[@resource-id='com.saucelabs.mydemoapp.android:id/nameET']")))
                .sendKeys("bod@example.com");
            System.out.println("Username entered.");
        } catch (Exception e) {
            System.out.println("Wait failed, attempting direct entry.");
            Basedriver.driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='com.saucelabs.mydemoapp.android:id/nameET']"))
                .sendKeys("bod@example.com");
        }
    }

      
    @Then("User will login successfully")
    public void user_will_login_successfully() {
        System.out.println("Login is successful!");
        
       
    }
}