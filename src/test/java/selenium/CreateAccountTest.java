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
Helpers helpers = new Helpers();
    String email = "yanina.pavlyk+" + helpers.convertTimeToString() + "@gmail.com";

    @Test
    public void testLoginAndGoThroughMenu() {
        helpers.initPage("http://localhost/litecart/en/");

        helpers.findElementAndClick(
                By.cssSelector("footer table tr td.account nav ul li:nth-child(3) a"));

        helpers.findElementAndSendKeys(
                By.cssSelector("input[name=firstname]"),
                "User");
        helpers.findElementAndSendKeys(
                By.cssSelector("input[name=lastname]"),
                "UserSecond");
        helpers.findElementAndSendKeys(
                By.cssSelector("input[name=address1]"),
                "Scofield drive, 35");
        helpers.findElementAndSendKeys(
                By.cssSelector("input[name=postcode]"),
                "44444");
        helpers.findElementAndSendKeys(
                By.cssSelector("input[name=city]"),
                "Huston");
// Select country
        helpers.findElementAndClick(
                By.cssSelector("span.select2-selection__arrow"));
        helpers.findElementAndSendKeys(
                By.cssSelector("input.select2-search__field"),
                "United States");
        helpers.findElementAndSendKeysPad(
                By.cssSelector("input.select2-search__field"),
                Keys.ENTER);

//        this.findElementAndClick(
//                By.cssSelector("li#select2-country_code-0h-result-dq7l-US"));
// Select state
        helpers.findElementAndClick(
                By.cssSelector("select[name=zone_code]"));
        helpers.findElementAndClick(
                By.cssSelector("option[value=TX]"));

        helpers.findElementAndSendKeys(
                By.cssSelector("input[name=email]"),
                email);

        helpers.findElementAndSendKeys(
                By.cssSelector("input[name=password]"),
                "Test1234");
        helpers.findElementAndSendKeys(
                By.cssSelector("input[name=phone]"),
                "+17777777777");
        helpers.findElementAndSendKeys(
                By.cssSelector("input[name=confirmed_password]"),
                "Test1234");
        helpers.findElementAndClick(
                By.cssSelector("button[name=create_account]"));
// LOGOUT
        helpers.findElementAndClick(
                By.cssSelector("div#box-account div.content ul li:nth-child(4) a"));

// LOGIN
        helpers.findElementAndSendKeys(
                By.cssSelector("input[name=email]"),
                email);
        helpers.findElementAndSendKeys(
                By.cssSelector("input[name=password]"),
                "Test1234");
        helpers.findElementAndClick(
                By.cssSelector("button[name=login]"));
    }



}