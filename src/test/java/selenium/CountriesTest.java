package selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountriesTest extends TestBase {

    //  ************************** Task 9 test  **************************

    @Test
    public void testCheckCountriesElementsAlphabetOrder() {
        Helpers helpers = new Helpers();

// Task 1. A - Check if countries are in alphabet
        helpers.initPage("http://localhost/litecart/admin/?app=countries&doc=countries");
        helpers.logInToAdmin("admin", "admin");
        helpers.initPage("http://localhost/litecart/admin/?app=countries&doc=countries");

        this.compareListsOfCountries(By.cssSelector("tr.row td:nth-child(5)"), "Countries");

// Task 1. B - Find Countries with >0 Zones number and check if countries are in alphabet

        int i = 2;
        int number_of_countries = driver.findElements(By.cssSelector("tr.row")).size();

        while (i < number_of_countries) {

            WebElement element = driver.findElement(By.cssSelector("tr.row:nth-child(" + i + ") td:nth-child(6)"));
            int number_of_zones = Integer.parseInt(element.getText());
            if (number_of_zones > 0) {

                WebElement link = driver.findElement(By.cssSelector("tr.row:nth-child(" + i + ") td:nth-child(5) a"));
                System.out.println(link.getText() + " has " + number_of_zones + " zones");
                link.click();

                this.compareListsOfCountries(
                        By.cssSelector("table.dataTable tr:not(:last-child):not(:first-child)  td:nth-child(3)"),
                        "Zones");
                driver.findElement(By.name("cancel")).click();
            }
            ++i;
        }
    }

// Task 2. Open each country and check if zones are in alphabet
    @Test
    public void testCheckIfZonesInAlphabet() {
        Helpers helpers = new Helpers();
        helpers.initPage("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        helpers.logInToAdmin("admin", "admin");
        helpers.initPage("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");

        int i = 1;
        int number_of_countries = driver.findElements(By.cssSelector("table.dataTable tr:not(:last-child):not(:first-child)")).size();

        while (i <= number_of_countries) {
            ++i;
            WebElement link = driver.findElement(By.cssSelector("tr.row:nth-child(" + i + ") td:nth-child(3) a"));
            //  System.out.println(link.getText() + " has " + number_of_zones + " zones");
            link.click();

            this.compareListsOfCountries(
                    By.cssSelector("table.dataTable tr:not(:last-child):not(:first-child)  td:nth-child(3) select option[selected = selected]"),
                    "Zones");
            driver.findElement(By.name("cancel")).click();

        }

    }

// Check if sorted list equals initial

    public void compareListsOfCountries(By by, String list) {
        ArrayList<String> list_of_countries = new ArrayList<>();
        List<WebElement> listOfCountries = driver.findElements(by);
       // System.out.println(listOfCountries);

        for (WebElement element : listOfCountries) {
            String country = element.getText();
            list_of_countries.add(country);
        }
        System.out.println(list_of_countries);

        ArrayList<String> list_of_countries_copied  = list_of_countries;
        Collections.sort(list_of_countries_copied);
        System.out.println(list_of_countries_copied);

        Assert.assertEquals(list_of_countries, list_of_countries_copied);
        System.out.println(list + " compared");
    }

}
