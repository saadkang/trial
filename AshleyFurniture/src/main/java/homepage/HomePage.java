package homepage;

import api.SaadAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by saadi on 7/21/2017.
 */
public class HomePage extends SaadAPI{

    @FindBy(how = How.CSS, using = "#afhs-menu > li:nth-child(1) > a:nth-child(1)")
    public static WebElement furniture;

    @FindBy(how = How.CSS, using = "#afhs-menu > li:nth-child(2) > a:nth-child(1)")
    public static WebElement outdoor;

    @FindBy(how = How.CSS, using = "#afhs-menu > li:nth-child(3) > a:nth-child(1)")
    public static WebElement kids;

    @FindBy(how = How.CSS, using = "#afhs-menu > li:nth-child(4) > a:nth-child(1)")
    public static WebElement homeDecor;

    @FindBy(how = How.CSS, using = "#afhs-menu > li:nth-child(5) > a:nth-child(1)")
    public static WebElement rugs;

    @FindBy(how = How.CSS, using = "#afhs-menu > li:nth-child(6) > a:nth-child(1)")
    public static WebElement lighting;

    @FindBy(how = How.CSS, using = "#afhs-menu > li:nth-child(7) > a:nth-child(1)")
    public static WebElement mattressesAndBedding;


    public static WebElement getFurniture() {
        return furniture;
    }
    public static WebElement getOutdoor() {
        return outdoor;
    }
    public static WebElement getKids() {
        return kids;
    }
    public static WebElement getHomeDecor() {
        return homeDecor;
    }
    public static WebElement getRugs() {
        return rugs;
    }
    public static WebElement getLighting() {
        return lighting;
    }
    public static WebElement getMattressesAndBedding() {
        return mattressesAndBedding;
    }


    public void clickOnFurniture(){
        getFurniture().click();
    }
    public void clickOnOutdoor(){
        getOutdoor().click();
    }
    public void clickOnKids(){
        getKids().click();
    }
    public void clickOnHomeDecor(){
        getHomeDecor().click();
    }
    public void clickOnRugs(){
        getRugs().click();
    }
    public void clickOnLighting(){
        getLighting().click();
    }
    public void clickOnMattressesAndBedding(){
        getMattressesAndBedding().click();
    }
}
