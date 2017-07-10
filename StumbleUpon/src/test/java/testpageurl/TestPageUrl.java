package testpageurl;

import api.SaadAPI;
import homepage.Login;
import myprofileurl.PageUrl;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * Created by saadi on 7/10/2017.
 */
public class TestPageUrl extends SaadAPI{

    @Test
    public void pageContent(){
        Login login = PageFactory.initElements(driver, Login.class);
        PageUrl pageUrl = PageFactory.initElements(driver, PageUrl.class);
        login.clickOnLogin();
        login.clickOnUsernameAndType("saadi_kang@hotmail.com");
        login.clickOnPasswordAndType("Saad_1234");
        login.clickOnTheLoginButton();
        pageUrl.clickOnSaadikang();
        pageUrl.clickOnMyProfile();
        pageUrl.clickOnFirstLink();
        getCurrentPageUrl();
    }
}
