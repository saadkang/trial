package symphony;

import api.SaadAPI;
import homepage.FavSymphony;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * Created by saadi on 6/22/2017.
 */
public class Symphony extends SaadAPI{

    @Test
    public void myFavSymphony() throws InterruptedException {
        FavSymphony favSymphony = PageFactory.initElements(driver, FavSymphony.class);
        favSymphony.goToSearchBar();
//        favSymphony.goToSearchButton();
//        favSymphony.goToSymphony();
//        Thread.sleep(15000);
    }
}
