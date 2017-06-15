package api;

import com.beust.jcommander.Parameter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by saadi on 6/14/2017.
 */
public class SaadAPI {

    public static WebDriver driver = null;
    private String saucelabs_username = "saadi_kang@hotmail.com";
    private String browserstack_username = "chirayupatel1";
    private String saucelabs_accesskey = "77980a15-1902-410c-aa3f-a8984ff2935d";
    private String browserstack_accesskey = "cwYAjPCffCz8wpqYfEQm";

    @Parameter({"useCloudEnv", "cloudEnvName", "os", "os_version", "browserName", "browserVersion", "url"})
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
//            run in local
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
            } else if (OS.equalsIgnoreCase("Win")) {
                System.setProperty("webdriver.chrome.driver", "../Generic/driver/chromedriver.exe");
            }
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            if (OS.equalsIgnoreCase("OS X")) {
                System.setProperty("webdriver.gecko.driver", "../Generic/driver/geckodriver");
            } else if (OS.equalsIgnoreCase("Windows")) {
                System.setProperty("webdriver.gecko.driver", "../Generic/driver/geckodriver.exe");
            }
            driver = new FirefoxDriver();
        }else if (browserName.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver", "..Generic/driver/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        return driver;
    }
    public WebDriver getCloudDriver(String envName, String envUsername, String envAccessKey, String os, String os_version, String browserName,
                                    String browserVersion) throws IOException{
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("browser", browserName);
        cap.setCapability("browser_version", browserVersion);
        cap.setCapability("os", os);
        cap.setCapability("os_version", os_version);
        if (envName.equalsIgnoreCase("Saucelabs")){
            driver = new RemoteWebDriver(new URL("https://"+envUsername+":"+envAccessKey+
            "@ondemand.saucelabs.com:80/wd.hub"), cap);
        }else if (envName.equalsIgnoreCase("Browserstack")){
            cap.setCapability("resolution", "1024x768");
            driver = new RemoteWebDriver(new URL("https://"+envUsername+":"+envAccessKey+
            "@hub-cloud.browserstack.com/wd/hub"), cap);
        }
        return driver;
    }
    @AfterMethod
    public void cleanUp(){
        System.out.println("It has been called");
        driver.quit();
    }
}

