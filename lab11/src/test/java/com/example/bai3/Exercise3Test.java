package com.example.bai3;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise3Test {

    @Test
    public void secretShouldBePresent() {
        String password = System.getenv("MY_PASSWORD");
        if (password == null) {
            System.out.println("MY_PASSWORD not found in environment (null)");
        } else {
            System.out.println("Đã lấy được password thành công từ GitHub Secrets!");
        }
        Assert.assertNotNull(password, "Expected MY_PASSWORD to be provided via environment variables");
    }
}
