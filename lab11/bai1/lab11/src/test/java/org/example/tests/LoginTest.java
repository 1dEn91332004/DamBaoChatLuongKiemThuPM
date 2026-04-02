package org.example.tests;

import org.example.core.DriverFactory;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLoginSuccess() {
        // Lấy password từ cấu hình môi trường (Chuẩn bị cho Bài 3)
        String password = System.getenv("APP_PASSWORD"); 
        if(password == null) password = "secret_sauce"; 

        loginPage.login("standard_user", password);
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}