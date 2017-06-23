package home;

import api.SaadAPI;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

/**
 * Created by saadi on 6/16/2017.
 */
public class TestHomePage extends SaadAPI{

    @Test
    public void testHomePage() throws InterruptedException {
        mouseHoverByCss("#menu0");
        Thread.sleep(3000);
    }

}
