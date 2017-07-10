package myprofileurl;

import api.SaadAPI;
import homepage.Login;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by saadi on 7/10/2017.
 */
public class PageUrl extends SaadAPI{

    @FindBy(how = How.CSS, using = ".button .username")
    public static WebElement saadiKang;

    @FindBy(how = How.CSS, using = ".dropdown-menu.rendered div:nth-child(1)")
    public static WebElement myProfile;

    @FindBy(how = How.CSS, using = "div.list-item:nth-child(1) > div:nth-child(1) > a:nth-child(1) > div:nth-child(1)")
    public static WebElement ferrari;

    public void clickOnSaadikang(){
        saadiKang.click();
    }
    public void clickOnMyProfile(){
        myProfile.click();
    }
    public void clickOnFirstLink(){
        ferrari.click();
    }
}
