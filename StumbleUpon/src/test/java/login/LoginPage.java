package login;

import api.SaadAPI;
import homepage.Login;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * Created by saadi on 6/22/2017.
 */
public class LoginPage extends SaadAPI{

    @Test
    public void loginHomePage() throws InterruptedException {
        Login login = PageFactory.initElements(driver, Login.class);
        login.goToLoginPage();
        login.goToUsername();
        login.goToPassword();
        login.goToFinalLoginButton();
        Thread.sleep(3000);
    }
}
