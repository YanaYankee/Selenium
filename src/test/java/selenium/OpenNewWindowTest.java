package selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

public class OpenNewWindowTest extends Helpers  {

    @Test
    public void testCheckLinksOpeningInNewWindows() {

// Task 14. Check links are opening in new windows
        this.initPage("http://localhost/litecart/admin/?app=countries&doc=countries");
        this.logInToAdmin("admin", "admin");
        this.initPage("http://localhost/litecart/admin/?app=countries&doc=countries");
        int number_of_countries = driver.findElements(By.cssSelector("tr.row")).size()-1;
        int country_id = this.getRandomNumber(number_of_countries);

            WebElement link = driver.findElement(
                    By.cssSelector("tr.row:nth-child(" + country_id + "):not(:first-child):not(:last-child) td:nth-child(5) a"));
            //tr.row:nth-child(" + country_id + "):not(:first-child):not(:last-child) td:nth-child(5) a
            link.click();

        int i = 1;
        int number_of_icons_more_info = driver.findElements(By.cssSelector("form[method='post']  tr")).size();
        System.out.println(number_of_icons_more_info + " - Number of rows where square icons with open new window links can be located");

        String initialWindow = driver.getWindowHandle();
        System.out.println("Initial window id: " + initialWindow);

            while( i <= number_of_icons_more_info) {

                int if_icon_found = this.getAmountOfElements(
                        By.cssSelector("form[method='post']  tr:nth-child("+ i +") a[target='_blank']"));
                System.out.println("Iteration number " + i);
                    if (if_icon_found > 0) {
                        driver.findElement(By.cssSelector("form[method='post']  tr:nth-child("+ i +") a[target='_blank']"))
                                .click();
                        new WebDriverWait(driver,5).until(ExpectedConditions.numberOfWindowsToBe(2));

                        System.out.println("number " + i + " Square icon clicked and new window should open");

                        Set<String> listOfWindowIds = driver.getWindowHandles();
                        System.out.println("All windows ids (initial + new): " + listOfWindowIds);


                        for (String nthwWindowId : listOfWindowIds) {

                            System.out.println("Id of window out of windows list to compare: " + nthwWindowId);

                                String newWindow=nthwWindowId;
// Compare whether the main windows is not equal to child window. If not equal, we will close.

                                if(!initialWindow.equals(newWindow)) {
                                    driver.switchTo().window(newWindow);
                                    System.out.println("Switched to new window " + newWindow);
                                    driver.close();
                                    System.out.println(newWindow + " new window closed");
                                }
                        }
                } else {

                        System.out.println("New window Square icon to click is not found");
                    }
                driver.switchTo().window(initialWindow);

                ++i;

            }
    }

// wait for new window Opened to use as an argument for method to switch to new window

//    public ExpectedCondition<String> anyWindowOtherThan(Set<String> oldWindows) {
//        return new ExpectedCondition<String>() {
//            public String apply(WebDriver driver) {
//                Set<String> handles  = driver.getWindowHandles(); //list of opened windows
//                handles.removeAll(oldWindows);// remove from the list existing earlier
//                return handles.size() > 0 ? handles.iterator().next() : null;
//                // if some windows are left - means that at least one new window appeared
//            }
//        };
//    }
}
