package homepage;

import api.SaadAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by saadi on 7/14/2017.
 */
public class HomePage extends SaadAPI{

    @FindBy(how = How.CSS, using = ".top li:nth-child(1)")
    public static WebElement news;

    @FindBy(how = How.CSS, using = ".top li:nth-child(2)")
    public static WebElement investors;

    @FindBy(how = How.CSS, using = ".top li:nth-child(3)")
    public static WebElement employeeAndRetiree;

    @FindBy(how = How.CSS, using = ".top li:nth-child(4)")
    public static WebElement merchandise;

    @FindBy(how = How.CSS, using = ".top li:nth-child(5)")
    public static WebElement supplies;

    @FindBy(how = How.CSS, using = ".top li:nth-child(6)")
    public static WebElement featuresAndMultimedia;

    public static WebElement getNews() {
        return news;
    }
    public static WebElement getInvestors() {
        return investors;
    }
    public static WebElement getEmployeeAndRetiree() {
        return employeeAndRetiree;
    }
    public static WebElement getMerchandise() {
        return merchandise;
    }
    public static WebElement getSupplies() {
        return supplies;
    }
    public static WebElement getFeaturesAndMultimedia() {
        return featuresAndMultimedia;
    }
    public void clickOnNews(){
        getNews().click();
    }
    public void clickOnInvestors(){
        getInvestors().click();
    }
    public void clickOnEmployeeAndRetiree(){
        getEmployeeAndRetiree().click();
    }
    public void clickOnMerchandise(){
        getMerchandise().click();
    }
    public void clickOnSupplies(){
        getSupplies().click();
    }
    public void clickOnFeaturesAndMultimedia(){
        getFeaturesAndMultimedia().click();
    }
}
