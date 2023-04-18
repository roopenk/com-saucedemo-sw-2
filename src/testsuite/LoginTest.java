package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    // Verifying that user can get logged in by valid credentials
    public void userShouldLoginSuccessfullyWithValid() {
        // Locating the username element and sending the value to it
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // Locating the Password element and sending the values to it
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        // Locating the Login button element and performing the click operation on it
        driver.findElement(By.id("login-button")).click();
        String expectedMessage = "Products";
        // Locating and storing the "Products" text
        WebElement actualTextElement = driver.findElement(By.xpath("//span[text()='Products']"));
        String actualMessage = actualTextElement.getText();
        // Comparing the messages
        Assert.assertEquals("Invalid Message", expectedMessage, actualMessage);
    }

    @Test
    // Verifying that Upon logging in, Six products are displayed on the page
    public void verifyThatSixProductsAreDisplayedOnPage() {
        // Locating the username element and sending the value to it
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // Locating the Password element and sending the values to it
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        // Locating the Login button element and performing the click operation on it
        driver.findElement(By.id("login-button")).click();
        int expectedNumberOfProducts = 6;
        int actualNumberOfProducts = driver.findElements(By.className("inventory_item")).size();
        Assert.assertEquals("Number Of Products Mismatched", expectedNumberOfProducts, actualNumberOfProducts);
    }

    @After
    public void cutOff() {
        closeBrowser();
    }
}

