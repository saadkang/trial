package navigationtab;

import api.SaadAPI;
import homepage.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * Created by saadi on 7/21/2017.
 */
public class TestHomeDecorTab extends SaadAPI{

    @Test
    public void homeDecorPage(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickOnHomeDecor();
    }
}
