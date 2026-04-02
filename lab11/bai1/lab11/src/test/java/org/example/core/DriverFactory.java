package org.example.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    public static WebDriver getDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // Chạy ngầm, KHÔNG giao diện
        options.addArguments("--no-sandbox"); 
        options.addArguments("--disable-dev-shm-usage"); 
        return new ChromeDriver(options);
    }
}