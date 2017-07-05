package login;

import api.SaadAPI;
import homepage.Login;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * Created by saadi on 7/1/2017.
 */
public class TestLogin extends SaadAPI{

    @Test
    public void loginTheFacebook() throws InterruptedException {
        Login login = PageFactory.initElements(driver, Login.class);
        login.typeUsername("3365883507");
        login.typePassword("Saad_1234");
        sleepFor(5);
    }
}
