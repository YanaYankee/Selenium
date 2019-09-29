package selenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.TestBase;

public class LoginPageObject extends TestBase {


    public void logInToAdmin() {
        driver.get("http://localhost/litecart/admin/");
        System.out.println("admin/ is opened");
        WebElement login_fld = driver.findElement(By.name("username"));
        System.out.println("username found");
        login_fld.sendKeys("admin");
        System.out.println("keys to username sent");

        WebElement password_fld = driver.findElement(By.name("password"));
        System.out.println("password found");
        password_fld.sendKeys("admin");
        System.out.println("keys to username password");
        //    searchField.sendKeys(Keys.ENTER);

        driver.findElement(By.name("login")).click();
        System.out.println("login clicked");
        //      wait.until(titleIs("webdriver - поиск в Google"));
    }

}
