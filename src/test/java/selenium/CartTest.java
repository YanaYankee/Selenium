package selenium;

import org.junit.Test;
import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBeLessThan;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;


public class CartTest extends Helpers{
    //  ************************** Task 13 test  **************************
    //  Add to cart and remove from cart test

    @Test
    public void testAddToCart(){

        this.initPage("http://localhost/litecart/");

        int i = 1;
        int number_of_products_to_add = 3;
        while (i <= number_of_products_to_add) {
            if (i < 2) {
                this.findElementAndClick(By.cssSelector("div#logotype-wrapper"));
            }
            this.findElementAndClick(By.cssSelector("li.product"));
            int size_selector = this.getAmountOfElements(By.cssSelector("select[name='options[Size]']"));
            if (size_selector > 0) {
                this.findElementAndClick(By.cssSelector("select[name='options[Size]']"));
                this.findElementAndClick(By.cssSelector("option[value='Small']"));
            }
            this.findElementAndClick(By.cssSelector("button[name='add_cart_product']"));
            wait.until(textToBePresentInElementLocated(By.cssSelector("div#cart span.quantity"),
                    String.valueOf(i)));
                System.out.println("Product #" + i + " added to cart");
            ++i;
        }

        this.findElementAndClick(By.cssSelector("div#cart a.link"));

        while (i > 0) {
            this.findElementAndClick(By.cssSelector("button[name='remove_cart_item']"));
            wait.until(numberOfElementsToBeLessThan(By.cssSelector("table.dataTable tr"), 5 + i));
            --i;
            if (i >0) {
                System.out.println("Product is removed from cart, products left " + i);
            }
        }
    }


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
//    }





}
