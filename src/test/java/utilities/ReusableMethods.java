package utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;



import java.time.Duration;


public class ReusableMethods {




    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }





    static Faker faker;
    static Actions actions;

    static Select select;

    static WebElement ddm;






    public static Select select(WebElement ddm) {
        return select = new Select(ddm);
    }



}

