package api;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
//import utility.reporting.ExtentManager;
//import utility.reporting.ExtentTestManager;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by saadi on 6/17/2017.
 */
public class SaadAPI {

    public static WebDriver driver = null;
    private String saucelabs_username = "";
    private String browserstack_username = "";
    private String saucelabs_accesskey = "";
    private String browserstack_accesskey = "";

    @Parameters({"useCloudEnv", "cloudEnvName", "os", "os_version", "browserName", "browserVersion", "url"})
    @BeforeMethod
    public void setUp(@Optional("false") boolean useCloudEnv, @Optional("false") String cloudEnvName,
                      @Optional("Windows") String os, @Optional("10") String os_version, @Optional("firefox") String browserName, @Optional("34")
                              String browserVersion, @Optional("https://www.amazon.com") String url) throws IOException {
        if (useCloudEnv == true) {
            if (cloudEnvName.equalsIgnoreCase("browserstack")) {
                getCloudDriver(cloudEnvName, browserstack_username, browserstack_accesskey, os, os_version, browserName, browserVersion);
            } else if (cloudEnvName.equalsIgnoreCase("saucelabs")) {
                getCloudDriver(cloudEnvName, saucelabs_username, saucelabs_accesskey, os, os_version, browserName, browserVersion);
            }
        } else {
            //run in local
            getLocalDriver(os, browserName);
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
    }

    public WebDriver getLocalDriver(@Optional("mac") String OS, String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            if (OS.equalsIgnoreCase("OS X")) {
                System.setProperty("webdriver.chrome.driver", "../Generic/driver/chromedriver");
            } else if (OS.equalsIgnoreCase("Windows")) {
                System.setProperty("webdriver.chrome.driver", "../Generic/driver/chromedriver.exe");
            }
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            if (OS.equalsIgnoreCase("OS X")) {
                System.setProperty("webdriver.gecko.driver", "../Generic/driver/geckodriver");
            } else if (OS.equalsIgnoreCase("Window")) {
                System.setProperty("webdriver.gecko.driver", "../Generic/driver/geckodriver.exe");
            }
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "../Generic/driver/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        return driver;
    }

    //    public WebDriver getLocalGridDriver(String browserName){
//        if (browserName.equalsIgnoreCase("chrome")){
//            System.setProperty("webdriver.chrome.driver", "../Generic/driver/chromedriver");
//            driver = new ChromeDriver();
//        }else if (browserName.equalsIgnoreCase("firefox")){
//            System.setProperty("webdriver.gecko.driver", "../Generic/driver/geckodriver");
//            driver = new FirefoxDriver();
//        }else if (browserName.equalsIgnoreCase("ie")){
//            System.setProperty("webdriver.ie.driver", "../Generic/browser-driver/IEDriverServer.exe");
//            driver = new InternetExplorerDriver();
//        }
//        return driver;
//
//    }
    public WebDriver getCloudDriver(String envName, String envUsername, String envAccessKey, String os, String os_version, String browserName,
                                    String browserVersion) throws IOException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("browser", browserName);
        desiredCapabilities.setCapability("browser_version", browserVersion);
        desiredCapabilities.setCapability("os", os);
        desiredCapabilities.setCapability("os_version", os_version);
        if (envName.equalsIgnoreCase("Saucelabs")) {
            driver = new RemoteWebDriver(new URL("http://" + envUsername + ":" + envAccessKey +
                    "@ondemand.saucelabs.com:80/wd/hub"), desiredCapabilities);
        } else if (envName.equalsIgnoreCase("Browserstack")) {
            desiredCapabilities.setCapability("resolution", "1024x768");
            driver = new RemoteWebDriver(new URL("http://" + envUsername + envAccessKey +
                    "@hub-cloud.browserstack.com/wd/hub"), desiredCapabilities);
        }
        return driver;

    }

    @AfterMethod
    public void cleanUp() {
        System.out.println("It has been called");
        driver.quit();
    }

    public void clickByCss(String locator) {
        driver.findElement(By.cssSelector(locator)).click();
    }

    public void clickByXpath(String locator) {
        driver.findElement(By.xpath(locator));
    }

    public void typeByCss(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }

    public void typeByCssEnter(String locator, String value) {
        driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
    }

    public void typeByXpath(String locator, String value) {
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }

    public void takeEnterKey(String locator) {
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
    }

    public void clearInputField(String locator) {
        driver.findElement(By.cssSelector(locator)).clear();
    }

    public List<WebElement> getListOfWebElementsById(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.id(locator));
        return list;
    }

    public List<String> getTextFromWebElements(String locator) {
        List<WebElement> element = new ArrayList<WebElement>();
        List<String> text = new ArrayList<String>();
        element = driver.findElements(By.cssSelector(locator));
        for (WebElement web : element) {
            text.add(web.getText());
        }
        return text;
    }
    public List<WebElement> getListOfWebElementsByCss(String locator){
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.cssSelector(locator));
        return list;
    }
    public List<WebElement> getListOfWebElementsByXpath(String locator){
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.xpath(locator));
        return list;
    }
    public String getCurrentPageUrl(){
        String url = driver.getCurrentUrl();
        return url;
    }
    public void navigateBack(){
        driver.navigate().back();
    }
    public void navigateForward(){
        driver.navigate().forward();
    }
    public String getTextByCss(String locator){
        String st = driver.findElement(By.cssSelector(locator)).getText();
        return st;
    }
    public String getTextById(String locator){
        String st = driver.findElement(By.id(locator)).getText();
        return st;
    }
    public String getTextByName(String locator){
        String st = driver.findElement(By.name(locator)).getText();
        return st;
    }
    public List<String> getListOfString(List<WebElement> list){
        List<String> items = new ArrayList<String>();
        for (WebElement element : list){
            items.add(element.getText());
        }
        return items;
    }
    public void selectOptionByVisibleText(WebElement element, String value){
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }
    public void sleepFor(int sec) throws InterruptedException{
        Thread.sleep(sec * 1000);
    }
    public void mouseHoverByCss(String locator){
        try{
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions actions = new Actions(driver);
            Actions hover = actions.moveToElement(element);
        }catch (Exception ex){
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();
        }
    }
    //handling Alert
    public void okAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public void cancelAlert(){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    //iFrame Handle
    public void iframeHandle(WebElement element){
        driver.switchTo().frame(element);
    }
    public void goBackToHomeWindow(){
        driver.switchTo().defaultContent();
    }
    //get Links
    public void getLinks(String locator){
        driver.findElement(By.linkText(locator)).findElement(By.tagName("a")).getText();
    }
    public static void captureScreenShot(WebDriver driver, String screenShotName){
        DateFormat dateFormat = new SimpleDateFormat("(MM.dd.yyyy-HH:mm)");
        Date date = new Date();
        dateFormat.format(date);
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(System.getProperty("user.dir")+"/screenshots/"+screenShotName+" "+dateFormat.format(date)+".png"));
            System.out.println("ScreenShot Captured");
        }catch (Exception ex){
            System.out.println("Exception while taking ScreenShot "+ex.getMessage());
        }
    }
    //Taking Screen Shots
    public void takeScreenShot() throws IOException{
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("ScreenShots.png"));
    }
    //Synchronization
    public void waitUntilClickAble(By locator){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        WebElement element = webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void waitUntilVisible(By locator){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        WebElement element = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public void waitUntilSelectAble(By locator){
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        boolean element = webDriverWait.until(ExpectedConditions.elementToBeSelected(locator));
    }
    public void upLoadFile(String locator, String path){
        driver.findElement(By.cssSelector(locator)).sendKeys(path);
    }
    public void cleanInput(String locator){
        driver.findElement(By.cssSelector(locator)).clear();
    }
    public void keysInput(String locator){
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
    }
    public String convertToString(String st){
        String splitString;
        splitString = StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(st), ' ');
        return splitString;
    }
}