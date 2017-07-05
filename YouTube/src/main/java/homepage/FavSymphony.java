package homepage;

import api.SaadAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by saadi on 6/22/2017.
 */
public class FavSymphony extends SaadAPI{

    @FindBy(how = How.CSS, using = ".masthead-search-terms-border")
    public static WebElement SearchBar;

    @FindBy(how = How.CSS, using = "#search-btn")
    public static WebElement SearchButton;

    @FindBy(how = How.CSS, using = "#item-section-763337 > li:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > h3:nth-child(1) > a:nth-child(1)")
    public static WebElement Symphony;


    public static WebElement getSearchBar() {
        return SearchBar;
    }
    public static WebElement getSearchButton() {
        return SearchButton;
    }
    public static WebElement getSymphony() {
        return Symphony;
    }

    public void clickOnSearchBar(){
        getSearchBar().click();
    }
    public void clickOnSearchButton(){
        getSearchButton().click();
    }
    public void clickOnSymphony(){
        getSymphony().click();
    }

    public void goToSearchBar(){
        clickOnSearchBar();
        SearchBar.sendKeys("Bolero");
    }
    public void goToSearchButton(){
        clickOnSearchButton();
    }
    public void goToSymphony(){
        clickOnSymphony();
    }
}
