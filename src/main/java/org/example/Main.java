package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {
    public static void main(String[] args) {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Open a website
        driver.get("https://parabank.parasoft.com");

        // Print the page title to check if it loaded successfully
        System.out.println("Page title: " + driver.getTitle());

        // Close browser
        driver.quit();
    }
}
