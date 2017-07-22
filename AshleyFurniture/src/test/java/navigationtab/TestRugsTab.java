package navigationtab;

import api.SaadAPI;
import homepage.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * Created by saadi on 7/21/2017.
 */
public class TestRugsTab extends SaadAPI{

    @Test
    public void rugsPage(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickOnRugs();
    }
}
