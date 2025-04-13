package StepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;

public class LoginDataTable {
    WebDriver driver;
    int i = 0;

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ultimateqa.com/filling-out-forms/");
    }

    @When("User enters the following credentials")
    public void userEntersCredentials(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);


        for (Map<String, String> data : credentials) {
            String username = data.get("username");
            String password = data.get("password");
            System.out.println("Logging in with: " + username + " / " + password);

            WebElement input1 = driver.findElement(By.xpath("//input[@id='et_pb_contact_name_0']"));
            WebElement input2 = driver.findElement(By.xpath("//textarea[@id='et_pb_contact_message_0']"));
            WebElement Submit = driver.findElement(By.xpath("//button[@name='et_builder_submit_button']"));
            input1.sendKeys(username);
            input2.sendKeys(password);
            Submit.click();
            Thread.sleep(5000);
            driver.navigate().refresh();
            Thread.sleep(2000);

        }
    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        System.out.println("Browser Closed");
        driver.quit();
        //asad
    }
}
