package StepDef;

import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class LoginPage {

    @Given("User Launched Url")
    public void userLaunchedUrl() throws IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/broken_images");
        List<WebElement> ImgLinks = driver.findElements(By.tagName("img"));
        System.out.println("Total Image Count : " + ImgLinks.size());
        int count = 0;
        for (WebElement link : ImgLinks) {
            String Imgurl = link.getAttribute("src");

            URL urls = new URL(Imgurl);
            HttpURLConnection conn = (HttpURLConnection) urls.openConnection();

            conn.connect();
            int responseCode = conn.getResponseCode();
            if (responseCode >= 400) {
                System.out.println("Image Is Broken " + Imgurl);
                count++;
            }

        }

        System.out.println("Total Images Broken are : " + count);
        driver.quit();
    }

    @Given("User Launched Edge url")
    public void userLaunchedEdgeUrl() throws IOException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver=new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/broken_images");
        List<WebElement> ImgLinks = driver.findElements(By.tagName("img"));
        System.out.println("Total Image Count : " + ImgLinks.size());
        int count = 0;
        for (WebElement link : ImgLinks) {
            String Imgurl = link.getAttribute("src");

            URL urls = new URL(Imgurl);
            HttpURLConnection conn = (HttpURLConnection) urls.openConnection();

            conn.connect();
            int responseCode = conn.getResponseCode();
            if (responseCode >= 400) {
                System.out.println("Image Is Broken. " + Imgurl);
                count++;
            }

        }

        System.out.println("Total Images Broken are : " + count);
        driver.quit();
    }



}
