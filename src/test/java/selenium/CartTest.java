package selenium;

import org.junit.Test;
import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBeLessThan;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;


public class CartTest extends Helpers{
    //  ************************** Task 13 test  **************************
//  Add to cart and remove from cart test




//  ready method Wait in selenium
//WebDriverWait wait= new WebDriverWait(driver, 30);
//
//WebElement element = wait.until(
//        d->d.findElement(locator)
//);




//    WebDriverWait wait = new WebDriverWait(driver, 10/*seconds*/);
//    //with labda expression
//    WebElement element = wait.until(presenceOfElementLocated(By.name("q")));
//    //without labda expression
//    WebElement element2 = wait.until((WebDriver d) -> d.findElement(By.name("q")));
//
//
//    public WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds,String found )
//    {
//        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
//        wait.withMessage(error_message + "\n");
//
//        System.out.println(found);
//
//        return wait.until(
//                ExpectedConditions.presenceOfElementLocated(by)
//        );
//    }
//
//
//    @Test
//    public void testTimeOutExample() {
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        Helpers helpers = new Helpers();
//        helpers.logInToAdmin("admin", "admin");
//        Assert.assertTrue(helpers.isElementPresent(driver, By.id("logout_link")));
//    }


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
