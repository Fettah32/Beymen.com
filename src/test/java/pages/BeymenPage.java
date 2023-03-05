package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class BeymenPage {

    public BeymenPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@id = 'onetrust-accept-btn-handler']")
    public WebElement cerezleriKabulEt;

    @FindBy(xpath = "//button[@id = 'genderManButton']")
    public WebElement genderManButton;

    @FindBy(xpath = "//input[@maxlength = '50']")
    public WebElement searchBox;

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div[2]/div")
    public List<WebElement> productList;

    @FindBy(xpath = "//div[@class = 'col-md-6 col-lg-4 -detailWrapper']")
    public WebElement productDetailWrapper;

    @FindBy(xpath = "//div[@class = 'm-price__lastPrice']")
    public WebElement productPrice;

    @FindBy(id = "addBasket")
    public WebElement addBasket;

    @FindBy(xpath = "//span[. = 'S']")
    public WebElement urunBedenS;

    @FindBy(xpath = "//span[. = 'M']")
    public WebElement urunBedenM;

    @FindBy(xpath = "//span[. = 'L']")
    public WebElement urunBedenL;

    @FindBy(xpath = "//span[. = 'XL']")
    public WebElement urunBedenXL;

    @FindBy(xpath = "//span[. = '38']")
    public WebElement urunBeden38;

    @FindBy(xpath = "//a[@title = 'Sepetim']")
    public WebElement sepetim;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div/div[1]/div[2]/div[1]/div[2]/div/div[2]/div[1]/div[1]/div")
    public WebElement sepetFiyat;

    @FindBy(xpath = "/html/body/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]")
    public WebElement priceNew;

    @FindBy(xpath = "//*[@id='quantitySelect0-key-0']")
    public WebElement adetDropDown;

    @FindBy(xpath = "//*[@id='removeCartItemBtn0-key-0']")
    public WebElement deleteBasket;

    @FindBy(xpath = "//*[@id='emtyCart']/div/strong")
    public WebElement sepetBosYazisi;
}
