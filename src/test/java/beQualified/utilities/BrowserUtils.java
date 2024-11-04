package beQualified.utilities;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

    public static void refreshPage()
    { Driver.getDriver().navigate().refresh();}

    /**
     * navigate to back
     */
    public static void navigateBack(){
        Driver.getDriver().navigate().back();
    }

    /**
     * navigate to forward
     */
    public static void navigateForward(){
        Driver.getDriver().navigate().forward();
    }


    /**
     * to get url
     * @param url
     */
    public static void getUrl(String url){
        Driver.getDriver().get(url);
    }


    /**
     * This method will accept a String as expected value and verify actual URL CONTAINS the value.
     */
    public static void verifyURLContains(String expectedInURL){
        Assert.assertEquals(expectedInURL, Driver.getDriver().getCurrentUrl());
    }


    /**
     * Performs a pause
     *
     * @param seconds
     */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * wait untill elelment to visit
     * @param element
     * @param time
     * @return
     */
    public static WebElement waitForVisibility(WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }



    /**
     * Waits for element matching the locator to be clickable
     *
     * @param locator
     * @param time
     * @return
     */
    public static WebElement waitForClickablility(By locator, int time) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Waits for the given WebElement to be clickable
     *
     * @param element the WebElement to wait for
     * @param time the maximum wait time in seconds
     * @return the WebElement once it is clickable
     */
    public static WebElement waitForToClickElement(WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void compareProductLists(List<String> expectedProductsList, List<String> actualProductsList) {
        Assert.assertEquals("The lists should have the same number of products", expectedProductsList.size(), actualProductsList.size());

        for (int i = 0; i < expectedProductsList.size(); i++) {
            Assert.assertEquals("Product information does not match at index " + i,
                    expectedProductsList.get(i), actualProductsList.get(i));
        }
    }

    /*
  This method will accept int (in seconds)
  and execute Thread.sleep method for given duration
  Arg: int second
   */
    public static void sleep(int second){
        second *= 1000;
        try{
            Thread.sleep(second);
        }catch (InterruptedException e){

        }
    }

}