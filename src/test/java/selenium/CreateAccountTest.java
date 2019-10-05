package selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateAccountTest extends TestBase {


//  ************************** Task 11 test  **************************
//  Create account => logout => login test

    String email = "yanina.pavlyk+" + this.convertTimeToString() + "@gmail.com";

    @Test
    public void testLoginAndGoThroughMenu() {
        this.initPage("http://localhost/litecart/en/");

        this.findElementAndClick(
                By.cssSelector("footer table tr td.account nav ul li:nth-child(3) a"));

        this.findElementAndSendKeys(
                By.cssSelector("input[name=firstname]"),
                "User");
        this.findElementAndSendKeys(
                By.cssSelector("input[name=lastname]"),
                "UserSecond");
        this.findElementAndSendKeys(
                By.cssSelector("input[name=address1]"),
                "Scofield drive, 35");
        this.findElementAndSendKeys(
                By.cssSelector("input[name=postcode]"),
                "44444");
        this.findElementAndSendKeys(
                By.cssSelector("input[name=city]"),
                "Huston");
// Select country
        this.findElementAndClick(
                By.cssSelector("span.select2-selection__arrow"));
        this.findElementAndSendKeys(
                By.cssSelector("input.select2-search__field"),
                "United States");
        this.findElementAndSendKeysPad(
                By.cssSelector("input.select2-search__field"),
                Keys.ENTER);

//        this.findElementAndClick(
//                By.cssSelector("li#select2-country_code-0h-result-dq7l-US"));
// Select state
        this.findElementAndClick(
                By.cssSelector("select[name=zone_code]"));
        this.findElementAndClick(
                By.cssSelector("option[value=TX]"));

        this.findElementAndSendKeys(
                By.cssSelector("input[name=email]"),
                email);

        this.findElementAndSendKeys(
                By.cssSelector("input[name=password]"),
                "Test1234");
        this.findElementAndSendKeys(
                By.cssSelector("input[name=phone]"),
                "+17777777777");
        this.findElementAndSendKeys(
                By.cssSelector("input[name=confirmed_password]"),
                "Test1234");
        this.findElementAndClick(
                By.cssSelector("button[name=create_account]"));
// LOGOUT
        this.findElementAndClick(
                By.cssSelector("div#box-account div.content ul li:nth-child(4) a"));

// LOGIN
        this.findElementAndSendKeys(
                By.cssSelector("input[name=email]"),
                email);
        this.findElementAndSendKeys(
                By.cssSelector("input[name=password]"),
                "Test1234");
        this.findElementAndClick(
                By.cssSelector("button[name=login]"));
    }

    public void initPage(String url) {
        driver.get(url);
        System.out.println(url + " is inited");
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

    public void findElementAndClick(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }
    public void findElementAndSendKeys(By by, String keys) {
        WebElement element = driver.findElement(by);
        element.sendKeys(keys);
    }
    public void findElementAndSendKeysPad(By by, Keys keys) {
        WebElement element = driver.findElement(by);
        element.sendKeys(keys);
    }
//  *************** Methods to check if element is present on the page **************************


}