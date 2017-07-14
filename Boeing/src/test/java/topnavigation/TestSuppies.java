package topnavigation;

import api.SaadAPI;
import homepage.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * Created by saadi on 7/14/2017.
 */
public class TestSuppies extends SaadAPI{

    @Test
    public void suppliesPage(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickOnSupplies();
    }
}
