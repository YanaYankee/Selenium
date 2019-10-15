package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class Helpers extends TestBase{

    public void logInToAdmin(String username, String password) {
        this.initPage("http://localhost/litecart/admin/");

        driver.findElement(By.name("username")).sendKeys(username);
        //   System.out.println("keys to username sent");
        driver.findElement(By.name("password")).sendKeys(password);
        //    System.out.println("keys to username password");
        driver.findElement(By.name("login")).click();
        //   System.out.println("login clicked");
    }
    public void initPage(String url) {
        driver.get(url);
        System.out.println(url + " is inited");
    }

//   Boolean isElementPresent(WebDriver driver, By by) {
//        try {
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            return driver.findElements(by).size() > 0;
//        } finally {
//            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        }
//
//
//    }


    public void findElementAndClick(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }
    public String findElementAndGetValue(By by) {
        WebElement element = driver.findElement(by);
        String text = element.getAttribute("textContent");
        return text;
    }
    public void findElementAndSendKeys(By by, String keys) {
        WebElement element = driver.findElement(by);
        element.sendKeys(keys);
    }
    public void findElementAndClearAndSendKeys(By by, String keys) {
        WebElement element = driver.findElement(by);
        element.clear();
        element.sendKeys(keys);
    }

    public void findElementAndSendKeysPad(By by, Keys keys) {
        WebElement element = driver.findElement(by);
        element.sendKeys(keys);
    }
    public int getNumberOfElements(By by) {
        int elements = driver.findElements(by).size();
        System.out.println("Number of elements: " + elements);
        return elements;
    }

    public static String convertTimeToString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String strDate = dateFormat.format(date);


        strDate = strDate.replaceAll(" |-|:","");
        strDate = strDate.substring(8);
        System.out.println("converted Date to String: " + strDate);
        return strDate;
    }
    //  *************** Methods to check if element is present on the page **************************
    public int getAmountOfElements(By by) {
        List elements = driver.findElements(by);
        return elements.size();
    }
    public void assertElementPresent(By by, String error_message, String element){
        int amount_of_elements = getAmountOfElements(by);
        if (amount_of_elements < 1 ) {
            String default_message = "An element '" + by.toString() + "' supposed to be present";
            throw new AssertionError(default_message + " " + error_message);
        } else if (amount_of_elements > 1 ) {
            String default_message = "Not more than one element '" + by.toString() + "' supposed to be present";
            throw new AssertionError(default_message + " " + error_message);
        } else {
            System.out.println( element + " is present on the page");
        }
    }


}
