package net.absoft;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ToDoListAppTest extends BaseTest {

    @BeforeMethod
    public void setUp() {
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
    }

    @Test
    public void testToDoListAdd() {
        driver.findElement(By.cssSelector("#container > input[type=text]")).sendKeys("New task");
        driver.findElement(By.cssSelector("#container > input[type=text]")).sendKeys(Keys.RETURN);

        assertTrue(driver.findElement(By.xpath("//*[@id=\"container\"]/ul/li[4]")).isDisplayed(),
                "text was not displayed");
    }


    @Test
    public void testToDoListDelete() throws InterruptedException {
        driver .findElement(By.xpath("//*[@id=\"container\"]/ul/li[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"container\"]/ul/li[1]/span")).click();
        assertEquals(driver.findElement(By.xpath("//*[@id=\"container\"]/ul/li[1]")).getText(), "Go to potion class",
                "Task not deleted");
        Thread.sleep(5000);
    }
}



