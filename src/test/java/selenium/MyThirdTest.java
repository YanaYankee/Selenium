package selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyThirdTest extends TestBase {

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
    @Test
    public void test5() {
        driver.navigate().to("http://www.google.com");
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("webdriver");
        searchField.sendKeys(Keys.ENTER);
        wait.until(titleIs("webdriver - Пошук Google"));
    }
    @Test
    public void test6() {
        driver.navigate().to("http://www.google.com");
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("webdriver");
        searchField.sendKeys(Keys.ENTER);
        wait.until(titleIs("webdriver - Пошук Google"));
    }
    @Test
    public void test7() {
        driver.navigate().to("http://www.google.com");
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("webdriver");
        searchField.sendKeys(Keys.ENTER);
        wait.until(titleIs("webdriver - Пошук Google"));
    }
    @Test
    public void test8() {
        driver.navigate().to("http://www.google.com");
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("webdriver");
        searchField.sendKeys(Keys.ENTER);
        wait.until(titleIs("webdriver - Пошук Google"));
    }
    @Test
    public void test9() {
        driver.navigate().to("http://www.google.com");
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("webdriver");
        searchField.sendKeys(Keys.ENTER);
        wait.until(titleIs("webdriver - Пошук Google"));
    }
    @Test
    public void test10() {
        driver.navigate().to("http://www.google.com");
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("webdriver");
        searchField.sendKeys(Keys.ENTER);
        wait.until(titleIs("webdriver - Пошук Google"));
    }



}

