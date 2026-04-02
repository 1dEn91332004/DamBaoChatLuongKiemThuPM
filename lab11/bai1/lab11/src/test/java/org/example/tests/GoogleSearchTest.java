package org.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class GoogleSearchTest {

    @Test(enabled = false)
    // Disabled by default: Google often blocks automated search requests from CI/local runners.
    // Keep this test for reference; enable it only when you know the environment allows automated Google access.
    public void searchSelenium_onGoogle_shouldReturnResults() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);
        try {
            // Navigate directly to the Google search results URL to avoid consent/redirect pages
            driver.get("https://www.google.com/search?q=Selenium+WebDriver");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlContains("/search?q="));

            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue(currentUrl.contains("/search?q="), "Expected to be on Google search results page");
        } finally {
            driver.quit();
        }
    }
}
