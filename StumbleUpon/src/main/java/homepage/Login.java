package homepage;

import api.SaadAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by saadi on 6/22/2017.
 */
public class Login extends SaadAPI {

    @FindBy(how = How.CSS, using = ".login-btn")
    public static WebElement Login;

    @FindBy(how = How.CSS, using = "#email-username")
    public static WebElement Username;

    @FindBy(how = How.CSS, using = "#password-login")
    public static WebElement Password;

    @FindBy(how = How.CSS, using = ".login-submit")
    public static WebElement LoginButton;

    public void clickOnLogin(){
        Login.click();
    }
    public void clickOnUsernameAndType(String userName){
        Username.click();
        Username.sendKeys(userName);
    }
    public void clickOnPasswordAndType(String passWord){
        Password.click();
        Password.sendKeys(passWord);
    }
    public void clickOnTheLoginButton(){
        LoginButton.click();
    }
}