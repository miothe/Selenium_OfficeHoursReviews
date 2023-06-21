package com.cydeo.tests.week1.morning;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class VytrackLoginTest {
WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://vytrack.com");
    }
    //** TC002 As a user I should be able to see the login page
    //
    // 1- Setup the "browser driver"
    // 2- Go to "https://vytrack.com"
    // 3- Click Login label
    // 3- Verify the title contains "Login"

    @Test(priority = 1)
    public void vytrack_title_verification_test(){
        // 1- Setup the "browser driver"
        // 2- Go to "https://vytrack.com"


        // 3- Click Login label
        WebElement loginLabel = driver.findElement(By.xpath("//a[@href='http://app.vytrack.com']"));
        loginLabel.click();

        // 3- Verify the title contains "Login"
        String actualTitle = driver.getTitle();
        String expectedTitle = "Login";

        Assert.assertTrue(actualTitle.contains(expectedTitle),"Title verification is failed");

        /*
        if(actualTitle.contains(expectedTitle)){
            System.out.println("Title verification PASSED!!");
        }else{
            System.out.println("Title verification FAILED!!");
        }

*/

    }
    @Test
    public void vytrack_login_test(){
        // ** TC003 As a user I should be able to login with valid credentials

        // 3- Click Login label
        WebElement loginLabel = driver.findElement(By.xpath("//a[@href='http://app.vytrack.com']"));
        loginLabel.click();

        // 4- Login to application with username as "User1" and password as "UserUser123"
        WebElement username = driver.findElement(By.xpath("//input[@name='_username']"));
        username.sendKeys("User1");
        WebElement password = driver.findElement(By.xpath("//input[@name='_password']"));
        password.sendKeys("UserUser123");
        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();
        // 5- Verify the title is "Dashboard"

        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
