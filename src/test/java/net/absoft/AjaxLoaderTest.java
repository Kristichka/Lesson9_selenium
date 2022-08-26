package net.absoft;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.*;

public class AjaxLoaderTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        driver.get("http://webdriveruniversity.com/Ajax-Loader/index.html");
    }

    @Test(groups = "implicitlyWait")
    void testImplicitlyWait() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.id("button1")).click();
        Thread.sleep(2000);

        assertTrue(driver.findElement(By.xpath("//*[@id=\"myModalClick\"]/div")).isDisplayed(), "User did not click on the button");
        driver.findElement(By.xpath("//*[@id=\"myModalClick\"]/div/div/div[3]/button")).click();

        assertTrue(driver.findElement(By.id("myDiv")).isDisplayed(), "The close button was not pressed");
    }
}
