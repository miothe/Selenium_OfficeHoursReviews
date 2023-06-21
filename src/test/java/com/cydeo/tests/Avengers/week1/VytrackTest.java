package com.cydeo.tests.Avengers.week1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Browser;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.time.Duration;
import java.util.AbstractSet;
import java.util.List;

public class VytrackTest {
    //TC002 As a user I should be able to see the login page
    WebDriver driver;
    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://vytrack.com/");
    }
    @Test
    public void vytrack_aboutus_link_test(){


        // 3- Click "About us" link
        WebElement aboutusLink = driver.findElement(By.xpath("(//a[@href='https://vytrack.com/about-us/'])[1]"));
        aboutusLink.click();
        // 4- Verify the url contains "about-us"

       String actualURL = driver.getCurrentUrl();
       String expectedURL = "about-us";

        Assert.assertTrue(actualURL.contains(expectedURL),"About us link url verification failed");
    }
    @Test
    public void vytrack_login_hidden_password_test() throws InterruptedException {

        //TC003 As a user I should be able to see the password hidden as default
        //
        // 1- Setup the "browser driver"
        // 2- Go to "https://vytrack.com/"
        // 3- Click Login label
        driver.findElement(By.linkText("LOGIN")).click();

        // 4- Login to application with username as "User1" and password as "UserUser123"
        Thread.sleep(2000);
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("user1");

        WebElement password = driver.findElement(By.name("_password"));
        password.sendKeys("User123User123");

        // 5- Verify the password is hidden
        String actualPasswordAttribute = password.getAttribute("type");
        String expectedPasswordAttribute =   "password";

        Assert.assertEquals(actualPasswordAttribute,expectedPasswordAttribute,"Password hidden verification FAILED!");
    }

    @Test
    public void vytrack_all_links_test(){
        //TC005 As a user I should be able to see Home, About us, Our Approach, Product and Services, Contact and LOGIN labels are displayed
        //
        //  1-open a chrome browser
        //  2-goto https://vytrack.com/
        //  3-verify Home, About us, Our Approach, Product and Services, Contact and LOGIN labels are displayed
        List<WebElement> allTopLinks = driver.findElements(By.xpath("//ul[@id='top-menu']/li/a"));

        for (WebElement eachLink : allTopLinks) {
            System.out.println(eachLink.getText());
            Assert.assertTrue(eachLink.isDisplayed());
        }
        
    }



    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }
}
