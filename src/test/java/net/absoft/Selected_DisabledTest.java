package net.absoft;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Selected_DisabledTest extends BaseTest {

//    @BeforeMethod
//    public void setUp() {
//        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
//    }

    @Test
    public void testSelectedDisabled() {
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        driver.findElement(By.cssSelector("#dropdowm-menu-1 > option:nth-child(1)")).click();
        driver.findElement(By.cssSelector("#dropdowm-menu-2 > option:nth-child(3)")).click();
        driver.findElement(By.cssSelector("#dropdowm-menu-3 > option:nth-child(1)")).click();
        driver.findElement(By.cssSelector("#checkboxes > label:nth-child(1) > input[type=checkbox]")).click();
        driver.findElement(By.cssSelector("#checkboxes > label:nth-child(5) > input[type=checkbox]")).click();
        driver.findElement(By.cssSelector("#checkboxes > label:nth-child(7) > input[type=checkbox]")).click();

        driver.findElement(By.cssSelector("#radio-buttons > input[type=radio]:nth-child(7)")).click();

        assertTrue(driver.findElement(By.cssSelector("#radio-buttons-selected-disabled > input[type=radio][value=\"pumpkin\"]")).isSelected(),
                "Other options are selected by default");
        assertFalse(driver.findElement(By.cssSelector("#fruit-selects > option[value=\"orange\"]")).isEnabled(),
                "Cabbage and Orange are available to choose from");
    }
}