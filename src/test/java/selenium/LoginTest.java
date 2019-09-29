package selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends TestBase {

//  ************************** Task 7 test  **************************
//  1. log in to admin
//  2. click all the elements in the left menu including sub-elements
//  3. Check if title (h1 element) is present on each page

    @Test
    public void testLoginAndGoThroughMenu() {
        this.logInToAdmin("admin", "admin");
        this.elementsToClick();
    }


//  ************************** Log In method **************************

    public void logInToAdmin(String username, String password) {
        driver.get("http://localhost/litecart/admin/");
              //  System.out.println("admin/ is opened");
        driver.findElement(By.name("username")).sendKeys(username);
             //   System.out.println("keys to username sent");
        driver.findElement(By.name("password")).sendKeys(password);
            //    System.out.println("keys to username password");
        driver.findElement(By.name("login")).click();
            //   System.out.println("login clicked");
    }

//  *************** Get elements to click method (menu elements and subelements **************************

    public void elementsToClick() {
        int number_of_elements_elements = driver.findElements(
                By.cssSelector("ul#box-apps-menu li")).size();
//        System.out.println("Number of elements: " + number_of_elements_elements);

        Boolean all_menu_elements_clicked = false;
        int i = 1;

        while (i <= number_of_elements_elements) {

            if (!all_menu_elements_clicked) {
                  WebElement nth_element = driver.findElement(
                   By.cssSelector("ul#box-apps-menu li#app-:nth-child(" + i + ")"));
                String link =  nth_element.getText();
                //   System.out.println("Element #" + i + " is " + link);
                   nth_element.click();
                //   System.out.println("Element #" + i + " " + link + " clicked");
                this.assertElementPresent(
                        By.cssSelector("td#content h1"),
                        "h1 element is not present on the page" + link,
                        "Page: "+ link + ", title h1 element");
                int elements_of_nth_elements = driver.findElements(
                        By.cssSelector("ul#box-apps-menu li.selected:nth-child(" + i + ") ul:nth-child(2) li")).size();
                //System.out.println(link + " menu has " + elements_of_nth_elements + " subchildren");

                if (elements_of_nth_elements > 0) {
                    Boolean all_subchildren_clicked = false;
                    int j = 1;

                    while (j <= elements_of_nth_elements) {
                        if (!all_subchildren_clicked) {

                               WebElement child_of_nth_element = driver.findElement(
                               By.cssSelector("ul#box-apps-menu li.selected ul li:nth-child(" + j + ")"));
                               String sublink = child_of_nth_element.getText();
                            //   System.out.println("SubElement #" + j + " is " + sublink);
                               child_of_nth_element.click();
                            //   System.out.println("SubElement #" + j  + " " +  sublink + " clicked");
                            this.assertElementPresent(
                                    By.cssSelector("td#content h1"),
                                    "h1 element is not present on the page" + sublink,
                                    "Page: "+ sublink + ", title h1 element");
                            if (j == elements_of_nth_elements) {
                                all_subchildren_clicked = true;
                             //   System.out.println("All "+ j +" subchildren are clicked: " + all_subchildren_clicked);
                                j = 1; }
                            else {try { Thread.sleep(500); } catch (Throwable t) { }}
                        }
                        ++j;
                    }
                }
                if (i == number_of_elements_elements) { all_menu_elements_clicked = true; }
                else {try { Thread.sleep(200); } catch (Throwable t) { }}
            }
            ++i;
        }
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
