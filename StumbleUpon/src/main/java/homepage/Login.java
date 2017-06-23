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

    public static WebElement getLogin() {
        return Login;
    }
    public static WebElement getUsername() {
        return Username;
    }
    public static WebElement getPassword() {
        return Password;
    }
    public static WebElement getLoginButton(){
        return LoginButton;
    }
    public void clickOnLoginButton() {
        getLogin().click();
    }
    public void clickOnUsername() {
        getUsername().click();
        driver.findElement(By.cssSelector("#email-username")).sendKeys("saadi_kang@gmail.com");
    }

    public void clickOnPassword() {
        getPassword().click();
        driver.findElement(By.cssSelector("#password-login")).sendKeys("Saad_1234");
    }
    public void clickOnFinaloginButton(){
        getLoginButton().click();
    }

    public void goToLoginPage() {
        clickOnLoginButton();
    }
    public void goToUsername() {
        clickOnUsername();
    }
    public void goToPassword(){
        clickOnPassword();
    }
    public void goToFinalLoginButton(){
        clickOnFinaloginButton();
    }
}