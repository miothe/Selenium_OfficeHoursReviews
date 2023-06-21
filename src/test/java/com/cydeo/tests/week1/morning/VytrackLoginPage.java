package com.cydeo.tests.week1.morning;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class VytrackLoginPage {
    //**  TC001 As a user I should be able to see Login label is displayed
    //




    public static void main(String[] args) {
        //  1-open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //  2-goto https://vytrack.com/
        driver.get("https://vytrack.com/");

        //  3-verify Login is displayed
        WebElement loginLink = driver.findElement(By.linkText("LOGIN"));
        String actualText = loginLink.getText();

        String expectedText = "LOGIN";
        if(actualText.equals(expectedText)){
            System.out.println("Text Verification PASSED!!");
        }else{
            System.out.println("Text verification FAILED!!");
        }

        if(loginLink.isDisplayed()){
            System.out.println("Login link is displayed");

        }else{
            System.out.println("Login link is not displayed");
        }


    }

}
