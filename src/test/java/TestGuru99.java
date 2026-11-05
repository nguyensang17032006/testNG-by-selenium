
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Sang
 */
public class TestGuru99 {

    WebDriver driver;
    String HOME_URL = "https://demo.guru99.com/test/newtours/";
    String expectedTitle;
    String actualTitle;

    @BeforeClass
    public void openURL() {
        driver = new ChromeDriver();
        driver.get(HOME_URL);
    }

    public void goToHomepage() {
        driver.get(HOME_URL);
    }

    //test tiêu đề homepage
    @Test(priority = 0)
    public void verifyHomepageTitle() {
        expectedTitle = "Welcome: Mercury Tours";
        actualTitle = driver.getTitle();

        assertEquals(actualTitle, expectedTitle);
    }

    //test click register và tiêu đề
    @Test(priority = 1)
    public void verifyREGISTERTitle() {
        WebElement btnRegister = driver.findElement(By.linkText("REGISTER"));
        btnRegister.click();

        expectedTitle = "Register: Mercury Tours";
        actualTitle = driver.getTitle();

        goToHomepage();

        assertEquals(actualTitle, expectedTitle);
    }

    //test đi qua support
    @Test(priority = 2)
    public void verifySUPPORTTitle() {
        WebElement btnRegister = driver.findElement(By.linkText("SUPPORT"));
        btnRegister.click();

        expectedTitle = "Register: Mercury Tours";
        actualTitle = driver.getTitle();

        goToHomepage();
        assertEquals(actualTitle, expectedTitle);
    }

    @Test(priority = 3)
    public void verifyLoginSuccess() {
        WebElement inputUser = driver.findElement(By.name("userName"));
        WebElement inputPass = driver.findElement(By.name("password"));
        WebElement btnSubmit = driver.findElement(By.cssSelector("input[type='submit'][value='Submit']"));

        inputUser.sendKeys("tutorial");
        inputPass.sendKeys("tutorial");

        btnSubmit.click();

        //Kiểm tra link có từ login
        boolean actualURL = driver.getCurrentUrl().contains("login");
        boolean expURL = true;
        assertEquals(actualURL, expURL);

        //Kiểm tra title
        expectedTitle = "Login: Mercury Tours";
        actualTitle = driver.getTitle();
        assertEquals(actualTitle, expectedTitle);

        //Kiểm tra cái message
        WebElement message = driver.findElement(By.cssSelector("h3"));

        String expectedText = "Login Successfully";
        String actualText = message.getText();

        assertEquals(actualText, expectedText);
    }

    @AfterClass
    public void closeBrower() {
        driver.quit();
    }
}
