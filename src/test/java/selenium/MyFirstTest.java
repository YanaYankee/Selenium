package selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver","TOOLS/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public  void myFirstTest() {
        driver.get("http://localhost/litecart/admin/");
        WebElement login_fld = driver.findElement(By.name("username"));
        login_fld.sendKeys("admin");

        WebElement password_fld = driver.findElement(By.name("password"));
        password_fld.sendKeys("admin");
    //    searchField.sendKeys(Keys.ENTER);

        driver.findElement(By.name("login")).click();
  //      wait.until(titleIs("webdriver - поиск в Google"));
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
