package selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstTest extends TestBase {


    @Test
    public void test1() {
        driver.navigate().to("http://www.google.com");
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("webdriver");
        searchField.sendKeys(Keys.ENTER);
        wait.until(titleIs("webdriver - Пошук Google"));
    }

    @Test
    public void test3() {
        driver.navigate().to("http://www.google.com");
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("webdriver");
        searchField.sendKeys(Keys.ENTER);
        wait.until(titleIs("webdriver - Пошук Google"));
    }
    @Test
    public void test4() {
        driver.navigate().to("http://www.google.com");
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("webdriver");
        searchField.sendKeys(Keys.ENTER);
        wait.until(titleIs("webdriver - Пошук Google"));
    }
}