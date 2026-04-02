package org.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExampleComTest {

    @Test
    public void exampleDotCom_titleContainsExampleDomain() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);
        try {
            driver.get("https://example.com");
            String title = driver.getTitle();
            Assert.assertTrue(title.contains("Example Domain"), "Title should contain 'Example Domain'");
        } finally {
            driver.quit();
        }
    }
}
