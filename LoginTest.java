package com.testing.selenium_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

    public static void main(String[] args) {

        // Setup driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Open website
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();

        // Enter username
        driver.findElement(By.id("username")).sendKeys("tomsmith");

        // Enter password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        // Click login
        driver.findElement(By.tagName("button")).click();

        // Verify result
        String msg = driver.findElement(By.id("flash")).getText();

        if (msg.contains("You logged into a secure area!")) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        // Close browser
        driver.quit();
    }
}