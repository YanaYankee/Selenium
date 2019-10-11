package selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class CartTest extends TestBase{

//  ready method Wait in selenium
//WebDriverWait wait= new WebDriverWait(driver, 30);
//
//WebElement element = wait.until(
//        d->d.findElement(locator)
//);


    WebDriverWait wait = new WebDriverWait(driver, 10/*seconds*/);
    //with labda expression
    WebElement element = wait.until(presenceOfElementLocated(By.name("q")));
    //without labda expression
    WebElement element2 = wait.until((WebDriver d) -> d.findElement(By.name("q")));


    public WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds,String found )
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");

        System.out.println(found);

        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }


    @Test
    public void testTimeOutExample() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Helpers helpers = new Helpers();
        helpers.logInToAdmin("admin", "admin");
        Assert.assertTrue(helpers.isElementPresent(driver, By.id("logout_link")));
    }


//     Wait method looks like this eprox

//
//    public void compareListsOfCountries(By by) throws TimeoutException{
//        for (int count=0;;count ++)
//            if(count>=30) {
//                throw new TimeoutException();
//                try{
//                        driver.findElement(by);
//                        break;
//                    } catch(NoSuchFieldException e){
//    Thread.sleep(1000);
//                    }
//            }
//
//
//    }





}
