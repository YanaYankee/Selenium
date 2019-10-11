package selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.File;

public class AddProductTest extends TestBase {

//  ************************** Task 12 test  **************************
//  Add product and check that it was added within admin
Helpers helpers = new Helpers();
    public String prod_name = "New Product" + helpers.convertTimeToString();
    @Test
    public void testLoginAndGoThroughMenu() {
        this.openAdNewProductPage();
        this.fillOutDataOnGeneralTab();
        this.uploadImageToFileuploaderOnGeneralTab();
        this.fillOutInformationTabData();
        this.fillOutPricesTabData();

        helpers.findElementAndClick(By.cssSelector("button[name=save]"));
        System.out.println("<Save> btn clicked");

        this.checkIfProductWasCreated();
    }

// -------------------------------- HELPERS METHODS


// -------------------------------- TEST STEPS METHODS


    public void openAdNewProductPage() {

        helpers.logInToAdmin("admin", "admin");
        helpers.findElementAndClick(
                By.cssSelector("td#sidebar a[href='http://localhost/litecart/admin/?app=catalog&doc=catalog']")
        );
        helpers.findElementAndClick(
                By.cssSelector("a.button[href='http://localhost/litecart/admin/?category_id=0&app=catalog&doc=edit_product']")
        );
        System.out.println("<Add new Product> page opened");

    }

    public void fillOutDataOnGeneralTab(){
        helpers.findElementAndClick(
                By.cssSelector("div#tab-general td:first-child input[type=radio][value='1']")
        );
            System.out.println("<Status> enabled checked");

        helpers.findElementAndSendKeys(
                By.cssSelector("div#tab-general  input[name='name[en]']"),
                prod_name
        );
            System.out.println("Keys sent to <Name> input");

        helpers.findElementAndSendKeys(
                By.cssSelector("div#tab-general  input[name='code']"),
                "np" + helpers.convertTimeToString()
        );
            System.out.println("Keys sent to <Code> input");

        helpers.findElementAndClick(
                By.cssSelector("div#tab-general  input[data-name='Root']")
        );
            System.out.println("<Root> deselected on <Categories>");

        helpers.findElementAndClick(
                By.cssSelector("div#tab-general  input[data-name='Rubber Ducks']")
        );
        System.out.println("<Rubber Ducks> selected on <Categories>");

        helpers.findElementAndClick(
                By.cssSelector("div#tab-general  input[name='product_groups[]'][value='1-3']")
        );
            System.out.println("<Unisex> selected on <Product Groups>");

        helpers.findElementAndClearAndSendKeys(
                By.cssSelector("div#tab-general  input[name='quantity']"),
                "7.00"
        );
            System.out.println("Keys sent to <Quantity> input");

        helpers.findElementAndClearAndSendKeys(
                By.cssSelector("div#tab-general  input[name='date_valid_from']"),
                helpers.convertTimeToString()
        );
        System.out.println("Keys sent to <DateValidFrom> input");
    }

    public void uploadImageToFileuploaderOnGeneralTab(){
        helpers.findElementAndClick(
                By.cssSelector("div#tab-general  input[name='new_images[]'][type='file']")
        );

//+++++ Upload img
        File imgDirectory = new File("src/img");
        System.out.println(imgDirectory);

        File file = new File(imgDirectory + "/1-yellow-duck-777.png");
        System.out.println(imgDirectory + "/1-yellow-duck-777.png");

//        WebElement fileBrowser = driver.findElement(By.xpath("//input[@type='file']"));
//        fileBrowser.click();
        String path = file.getAbsolutePath();
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(path);

//        Actions action = new Actions(driver);
//        action.sendKeys(Keys.ESCAPE).perform();

    }

    public void fillOutInformationTabData(){
        helpers.findElementAndClick(
                By.cssSelector("div.tabs ul li:nth-child(2) a")
        );
        System.out.println("<Information> tab clicked");

        helpers.findElementAndClick(
                By.cssSelector("div.tabs select[name=manufacturer_id]")
        );
        System.out.println("<Manufacturer> input clicked");

        helpers.findElementAndClick(
                By.cssSelector("div.tabs select[name=manufacturer_id] option[value='1']")
        );
        System.out.println("<ACME> selected");

        helpers.findElementAndSendKeys(
                By.cssSelector("div#tab-information input[name='keywords']"),
                "keyword"
        );
        System.out.println("<keywords> sent");

        helpers.findElementAndSendKeys(
                By.cssSelector("div#tab-information input[name='short_description[en]']"),
                "Some short desc"
        );
        System.out.println("<Short desc> sent");

        helpers.findElementAndSendKeys(
                By.cssSelector("div#tab-information div.trumbowyg-editor"),
                "Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like)."
        );
        System.out.println("<Desc text> sent");

        helpers.findElementAndSendKeys(
                By.cssSelector("div#tab-information input[name='head_title[en]']"),
                "somthing bla bla"
        );
        System.out.println("<head_title> sent");

        helpers.findElementAndSendKeys(
                By.cssSelector("div#tab-information input[name='meta_description[en]']"),
                "something bla bla somthing bla bla somthing bla bla"
        );
        System.out.println("<meta_description> sent");
    }

    public void fillOutPricesTabData(){
        helpers.findElementAndClick(
                By.cssSelector("div.tabs ul li:nth-child(4) a")
        );
        System.out.println("<Prices> tab clicked");

        helpers.findElementAndClearAndSendKeys(
                By.cssSelector("div#tab-prices input[name='purchase_price']"),
                "3.00"
        );
        System.out.println("<Prices> tab clicked");

        helpers.findElementAndClick(
                By.cssSelector("div#tab-prices select[name=purchase_price_currency_code]")
        );
        System.out.println("<Currency> input clicked");

        helpers.findElementAndClick(
                By.cssSelector("div#tab-prices select[name=purchase_price_currency_code] option[value='USD']")
        );
        System.out.println("<USD> option selected");

        helpers.findElementAndSendKeys(
                By.cssSelector("div#tab-prices input[name='prices[USD]']"),
                "10.00"
        );
        System.out.println("Price keys are sent to <Price> input");
    }

    public void checkIfProductWasCreated() {
        helpers.findElementAndSendKeys(
                By.cssSelector("input[type=search]"),
                prod_name
        );
        System.out.println("Keys sent to <Search> input to find newly created product");

        helpers.findElementAndSendKeysPad(
                By.cssSelector("input[type=search]"),
                Keys.ENTER
        );
        System.out.println("Enter pressed");

        WebElement new_prod_name = driver.findElement(
                By.cssSelector("table.dataTable tr.row td:nth-child(3) a"));
        String name_of_newly_created_prod = new_prod_name.getAttribute("textContent").trim();
        System.out.println("Get text of link found");


        Assert.assertEquals(prod_name, name_of_newly_created_prod);
    }
}