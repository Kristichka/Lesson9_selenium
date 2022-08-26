package net.absoft;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ClickButtonsTest extends BaseTest {

    private JavascriptExecutor executor;

    @BeforeMethod
    public void setUp() {
        driver.get("http://webdriveruniversity.com/Click-Buttons/index.html");
    }

    @Test
    public void TestClickButtons()  throws InterruptedException {

        driver.findElement(By.xpath("//*[@id=\"button1\"]")).click();
        Thread.sleep(2000);
        assertTrue(driver.findElement(By.xpath("//*[@id=\"myModalClick\"]/div/div")).isDisplayed(), "Alert  was not displayed0");
        driver.findElement(By.xpath("//*[@id=\"myModalClick\"]/div/div/div[3]/button")).click();
        Thread.sleep(2000);

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("document.getElementById(\"button2\").click()");
        assertTrue(driver.findElement(By.cssSelector("#myModalJSClick > div > div")).isDisplayed(),
                "Alert  was not displayed1");
        executor.executeScript("document.querySelector(\"#myModalJSClick > div > div > div.modal-footer > button\").click()");

        new Actions(driver).moveToElement(driver.findElement(By.cssSelector("#button3"))).click().perform();
        Thread.sleep(2000);
        assertTrue(driver.findElement(By.cssSelector("#myModalMoveClick > div > div > div.modal-header > h4")).isDisplayed(),
                "Alert  was not displayed2");
    }
}

