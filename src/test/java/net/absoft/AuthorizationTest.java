package net.absoft;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AuthorizationTest extends BaseTest{

    @BeforeMethod
    public void setUp() {
        driver.get("http://webdriveruniversity.com/Login-Portal/index.html");
    }

    @Test
    public void TestEmptyPassword() {
        driver.findElement(By.id("text")).sendKeys("kristichk@gmail.com");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-button")).click();

        assertEquals(driver.switchTo().alert().getText(), "validation failed",
                "Unexpected alert text");

    }
}

