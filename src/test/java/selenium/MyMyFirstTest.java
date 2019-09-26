//package selenium;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.*;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.safari.SafariDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.io.File;
//
//import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
//
//public class MyMyFirstTest {
//
//    private WebDriver driver;
//    private WebDriverWait wait;
//
//    @Before
//    public void start() {
//        System.setProperty("webdriver.chrome.driver","TOOLS/chromedriver");
//        System.setProperty("webdriver.gecko.driver","TOOLS/geckodriver");
//        DesiredCapabilities caps = new DesiredCapabilities();
//// ------------------- Chrome -------------------------
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-fullscreen");
//
////        ChromeOptions options = new ChromeOptions();
////        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
////        options.addArguments("start-maximized");
////        WebDriver driver = new ChromeDriver(options);
////        driver = new ChromeDriver();
//
//
//// ------------------- Mozilla -------------------------
//// ------------------- Old scheeme  -------------------------
////        DesiredCapabilities caps = new DesiredCapabilities();
////        caps.setCapability(FirefoxDriver.MARIONETTE, true);
//// ------------------- New scheeme  -------------------------
//
////        FirefoxOptions options = new FirefoxOptions().setLegacy(false);
////        driver = new FirefoxDriver(options);
//// ------------------- Nightly  -------------------------
//
////        File file = new File("Applications/Firefox\\ Nightly.app");
////        FirefoxProfile profile = new FirefoxProfile();
////driver = new FirefoxDriver(new FirefoxBinary(file),
////    profile,
////        caps
////);
//
//
//
////        ProfilesIni profile = new ProfilesIni();
////        FirefoxProfile testprofile = profile.getProfile("debanjan");
////        DesiredCapabilities dc = DesiredCapabilities.firefox();
////        dc.setCapability(FirefoxDriver.PROFILE, testprofile);
////        FirefoxOptions opt = new FirefoxOptions();
////        opt.merge(dc);
////        driver =  new FirefoxDriver(opt);
//
//
////        DesiredCapabilities caps = new DesiredCapabilities();
////        caps.setCapability("unexpectedAlertBehavior", "dismiss");
//// ------------------- SAFARI -------------------------
////    driver = new SafariDriver();
//        //  wait = new WebDriverWait(driver, 10);
//    }
//
//    @Test
//    public  void myFirstTest() {
//        driver.get("http://localhost/litecart/admin/");
//        WebElement login_fld = driver.findElement(By.name("username"));
//        login_fld.sendKeys("admin");
//
//        WebElement password_fld = driver.findElement(By.name("password"));
//        password_fld.sendKeys("admin");
//    //    searchField.sendKeys(Keys.ENTER);
//
//        driver.findElement(By.name("login")).click();
//  //      wait.until(titleIs("webdriver - поиск в Google"));
//    }
//
//    @After
//    public void stop() {
//        driver.quit();
//        driver = null;
//    }
//}
