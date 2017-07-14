package topnavigation;

import api.SaadAPI;
import homepage.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * Created by saadi on 7/14/2017.
 */
public class TestNews extends SaadAPI{

    @Test
    public void newsPage(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickOnNews();
    }
}
