package selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class ProductPageTest extends TestBase {


    //  ************************** Task 9 test  **************************
// 10. a - Titles are equal on Home and Prod                                (1 test)
// 10. b - Prices and discount prices are equal on Home and Prod            (2 tests)
// 10. c - Prices are decorated and grey on Home and Prod                   (4 tests)
// 10. d - Discount price bold and red on Home and Prod                     (4 tests)
// 10. e - Discount price font size is greater than regular price font size (2 tests)
//                                                                    total: 13 tests
// ------------ 10. a - Titles are equal on Home and Prod
        @Test
        public void testCheckIfTitlesAreEqual() {
                    System.out.println("10. a - Titles are equal on Home and Prod");

           WebElement home_title = this.initHomeAndGetProd(" div.name");
            String home_title_text = home_title.getAttribute("textContent");
                    System.out.println("Home title text: " + home_title_text);
            home_title.click();
            WebElement prod_title = getElementOnProd(" h1");
            String prod_title_text = prod_title.getAttribute("textContent");
                    System.out.println("Prod title text: " + prod_title_text);
            Assert.assertEquals(home_title_text, prod_title_text);
        }


// ------------ 10. b - Prices prices are equal on Home and Prod
    @Test
    public void testRegPriceAreEq() {
                System.out.println("10. b - Prices prices are equal on Home and Prod");
        WebElement home_title = this.initHomeAndGetProd(" div.name");
        WebElement home_price = getElementOnHome(" div.price-wrapper s.regular-price");

        String home_price_text = home_price.getAttribute("textContent");
                System.out.println("Home reg price text: " + home_price_text);

        home_title.click();
        WebElement prod_price = getElementOnProd(" div.price-wrapper s.regular-price");
        String prod_price_text = prod_price.getAttribute("textContent");
                System.out.println("Prod reg price text: " + prod_price_text);
        Assert.assertEquals(home_price_text, prod_price_text);
    }
// ------------ 10. b - Discount prices are equal on Home and Prod
    @Test
    public void testDiscPriceAreEq() {
                System.out.println("10. b - Discount prices are equal on Home and Prod");
        WebElement home_title = this.initHomeAndGetProd(" div.name");
        WebElement home_discount = getElementOnHome(" div.price-wrapper strong.campaign-price");

        String home_discount_text = home_discount.getAttribute("textContent");
                System.out.println("Home disc price test " + home_discount_text);

        home_title.click();
        WebElement prod_discount = getElementOnProd(" div.price-wrapper strong.campaign-price");
        String prod_discount_text = prod_discount.getAttribute("textContent");
                System.out.println("Prod disc price test " + prod_discount_text);
        Assert.assertEquals(home_discount_text, prod_discount_text);
    }

// ------------ 10. c - Prices are decorated on Home
    @Test
    public void testRegPriceDecorOnHome() {
                System.out.println("10. c - Prices are decorated on Home");
        this.initPage("http://localhost/litecart/");
        WebElement home_price = getElementOnHome(" div.price-wrapper s.regular-price");
        String home_price_text_decor = home_price.getCssValue("text-decoration-line"); //?
                System.out.println("Home preg price decor exp. - : line-through, act.: " + home_price_text_decor);
        Assert.assertEquals("line-through",home_price_text_decor);
    }
    // 10. c - Prices are decorated on Prod
    @Test
    public void testRegPriceDecorOnProd() {
                System.out.println("10. c - Prices are decorated on Prod");
        WebElement home_title = this.initHomeAndGetProd(" div.name");
        home_title.click();
        WebElement prod_price = getElementOnProd(" div.price-wrapper s.regular-price");
        String prod_price_text_decor = prod_price.getCssValue("text-decoration-line"); //?
                System.out.println("Prod preg price decor exp. - : line-through, act.: " + prod_price_text_decor);
        Assert.assertEquals("line-through", prod_price_text_decor);
    }
    // 10. c - Prices are grey on Home
    @Test
    public void testRegPriceGreyHome() {
                System.out.println("10. c - Prices are grey on Home");
     this.initPage("http://localhost/litecart/");
        WebElement home_price = getElementOnHome(" div.price-wrapper s.regular-price");
        String home_price_text_color = home_price.getCssValue("color");
                System.out.println(home_price_text_color);


        String r = parseColor(home_price_text_color)[0];
        String g = parseColor(home_price_text_color)[1];
        String b = parseColor(home_price_text_color)[2];
                System.out.println("R: " + r);
                System.out.println("G: " + g);
                System.out.println("B: " + b);
        assertTrue(r.equals(g) && g.equals(b));

    }
    // 10. c - Prices are grey on Prod
    @Test
    public void testRegPriceGreyProd() {
                System.out.println("10. c - Prices are grey on Prod");
        WebElement home_title = this.initHomeAndGetProd(" div.name");

        home_title.click();
        WebElement prod_price = getElementOnProd(" div.price-wrapper s.regular-price");
        String prod_price_text_color = prod_price.getCssValue("color");
                System.out.println(prod_price_text_color);

        String r = parseColor(prod_price_text_color)[0];
        String g = parseColor(prod_price_text_color)[1];
        String b = parseColor(prod_price_text_color)[2];
                System.out.println("R: " + r);
                System.out.println("G: " + g);
                System.out.println("B: " + b);

        assertTrue(r.equals(g) && g.equals(b));
    }

// ------------ 10. d - Discount price bold on Home

    @Test
    public void testDiscPriceBoldHome() {
                System.out.println("10. d - Discount price bold on Home");
        this.initPage("http://localhost/litecart/");
        WebElement home_discount = getElementOnHome(" div.price-wrapper strong.campaign-price");
        String home_font_weight = home_discount.getCssValue("font-weight"); //?
                System.out.println(home_font_weight);
       float weight = priceOrPxToFloat(home_font_weight);

                assertTrue(weight > 500);
    }
    // 10. d - Discount price bold Prod
    @Test
    public void testDiscPriceBoldProd() {
                System.out.println("10. d - Discount price bold Prod");
        WebElement home_title = this.initHomeAndGetProd(" div.name");
        home_title.click();
        WebElement prod_discount = getElementOnProd(" div.price-wrapper strong.campaign-price");
        String prod_font_weight = prod_discount.getCssValue("font-weight"); //?
                System.out.println(prod_font_weight);
        float weight = priceOrPxToFloat(prod_font_weight);

        assertTrue(weight > 500);

    }
    // 10. d - Discount price red on Home
    @Test
    public void testDiscPriceRedHome() {
                System.out.println("10. d - Discount price red on Home");
        this.initPage("http://localhost/litecart/");
        WebElement home_discount = getElementOnHome(" div.price-wrapper strong.campaign-price");
        String home_discount_color = home_discount.getCssValue("color"); //?
        String g = parseColor(home_discount_color)[1];
        String b = parseColor(home_discount_color)[2];

                System.out.println("G: " + g);
                System.out.println("B: " + b);
        assertTrue(g.equals("0") && b.equals("0") );

    }
    // 10. d - Discount price red on Prod
    @Test
    public void testDiscPriceRedProd() {
                System.out.println("10. d - Discount price red on Prod");
        WebElement home_title = this.initHomeAndGetProd(" div.name");
        home_title.click();
        WebElement prod_discount = getElementOnProd(" div.price-wrapper strong.campaign-price");
        String prod_discount_color = prod_discount.getCssValue("color"); //?
        String g = parseColor(prod_discount_color)[1];
        String b = parseColor(prod_discount_color)[2];

                System.out.println("G: " + g);
                System.out.println("B: " + b);
        assertTrue(g.equals("0") && b.equals("0") );

    }

// ------------ 10. e - Discount price font size is greater than regular price font size on home page
    @Test
    public void testDiscPriceFontGreaterOnHome() {
                System.out.println("10. e - Discount price font size is greater than regular price font size on home page");
        this.initPage("http://localhost/litecart/");
        WebElement home_discount = getElementOnHome(" div.price-wrapper strong.campaign-price");
        String home_disc_font_size = home_discount.getCssValue("font-size");
        float home_disc_fs_float = priceOrPxToFloat(home_disc_font_size);
                System.out.println("Home disc price text size float: " + home_disc_fs_float);

        WebElement home_price = getElementOnHome(" div.price-wrapper s.regular-price");

        String home_price_font_size = home_price.getCssValue("font-size");
        float home_price_fs_float = priceOrPxToFloat(home_price_font_size);
                System.out.println("Home reg price text size float: " + home_price_fs_float);

        assertTrue("Assert that discount price greater than regular on home page",
                    home_disc_fs_float > home_price_fs_float);
        }
// 10. e - Discount price font size is greater than regular price font size on product page
    @Test
    public void testDiscPriceFontGreaterOnProd() {
                System.out.println("10. e - Discount price font size is greater than regular price font size on product page");
        WebElement home_title = this.initHomeAndGetProd(" div.name");
        home_title.click();

        WebElement prod_price = getElementOnProd(" div.price-wrapper s.regular-price");
        String prod_price_font_size = prod_price.getCssValue("font-size");
        float prod_price_fs_float = priceOrPxToFloat(prod_price_font_size);
                System.out.println("Prod reg price text size float: " + prod_price_fs_float);

        WebElement prod_discount = getElementOnProd(" div.price-wrapper strong.campaign-price");
        String prod_disc_font_size = prod_discount.getCssValue("font-size");
        float prod_discount_fs_float = priceOrPxToFloat(prod_disc_font_size);
                System.out.println("Prod disc price text size float: " + prod_discount_fs_float);

        assertTrue("Assert that discount price greater than regular on home page",
                prod_discount_fs_float > prod_price_fs_float);
    }


    public WebElement initHomeAndGetProd(String selector) {
        String product_path = "div#box-campaigns div.content ul.products li.product:first-child";
        this.initPage("http://localhost/litecart/");
        WebElement element = driver.findElement(
                By.cssSelector(product_path + selector));
        return element;
    }

    public WebElement getElementOnHome(String selector) {
        String product_path = "div#box-campaigns div.content ul.products li.product:first-child";

        WebElement element = driver.findElement(
                By.cssSelector(product_path + selector));

        return element;
    }
    public WebElement getElementOnProd(String selector) {
        String product_path = "div#box-product";
        WebElement element = driver.findElement(
                By.cssSelector(product_path + selector));

        return element;
    }

    public float priceOrPxToFloat(String price){
        float home_price_float = Float.parseFloat(price.replace("$","").replace("px",""));
        return home_price_float;
    }

    public void initPage(String url) {
        driver.get(url);
        System.out.println(url + " is inited");
    }

    public String[] parseColor(String str) {

        str = str
                .substring(0, str.length() - 1)
                .substring(str.indexOf("(")+1)
                .replace(",", "");

        System.out.println("Str: " + str);

        String result[] = str.split(" ");
        System.out.println("result: " + result);

        return result;
    }
}