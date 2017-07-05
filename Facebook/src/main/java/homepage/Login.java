package homepage;

import api.SaadAPI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by saadi on 7/1/2017.
 */
public class Login extends SaadAPI{

    @FindBy(how = How.CSS, using = "#email")
    public static WebElement username;

    @FindBy(how = How.CSS, using = "#pass")
    public static WebElement password;

    public void clickOnUsername(){
        username.click();
    }
    public void clickOnPassword(){
        password.click();
    }
    public void typeUsername(String userName){
        clickOnUsername();
        username.sendKeys(userName);
    }
    public void typePassword(String passWord){
        clickOnPassword();
        password.sendKeys(passWord, Keys.ENTER);
    }
}
