package stepDefinitions.uiStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.BeymenPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.*;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static utilities.ReusableMethods.select;

public class BeymenStepDefinitions {

    BeymenPage beymen = new BeymenPage();

    @Given("Beymen sitesi acilir.")
    public void beymenSitesiAcilir() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("Beymen"));
        ReusableMethods.waitForClickablility(beymen.cerezleriKabulEt, 5);
        beymen.cerezleriKabulEt.click();
        ReusableMethods.waitForClickablility(beymen.genderManButton, 5);
        beymen.genderManButton.click();


    }

    @When("Ana sayfanin acildigi kontrol edilir.")
    public void anaSayfaninAcildigiKontrolEdilir() {
        String ExpectedTitle = "Beymen.com – Türkiye’nin Tek Dijital Lüks Platformu";
        String ActualTitle = Driver.getDriver().getTitle();
        assertEquals(ExpectedTitle, ActualTitle);
    }

    @When("Arama kutucuguna şort kelimesi girilir.")
    public void aramaKutucugunaŞortKelimesiGirilir() throws IOException, InterruptedException {
        //beymen.searchBox.click();
        //Thread.sleep(2000);

        String dosyaYolu = "src/test/resources/beymen.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        String sort = workbook
                .getSheet("Sayfa1")
                .getRow(0)
                .getCell(0)
                .toString();


        System.out.println(sort);

        beymen.searchBox.sendKeys(sort);

        Thread.sleep(2000);


    }

    @Then("Arama kutucuguna girilen şort kelimesi silinir.")
    public void aramaKutucugunaGirilenŞortKelimesiSilinir() {
        beymen.searchBox.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).build().perform();

    }

    @Then("Arama kutucuguna gömlek kelimesi girilir.")
    public void aramaKutucugunaGömlekKelimesiGirilir() throws IOException {
        String dosyaYolu = "src/test/resources/beymen.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        String gomlek = workbook
                .getSheet("Sayfa1")
                .getRow(0)
                .getCell(1)
                .toString();

        System.out.println(gomlek);

        beymen.searchBox.sendKeys(gomlek);
    }


    @Then("Klavye uzerinden Enter tusuna basilir.")
    public void klavyeUzerindenEnterTusunaBasilir() throws InterruptedException {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(5000);
    }

    @Then("Sonuca gore sergilenen urunlerden rastgele bir urun secilir.")
    public void sonucaGoreSergilenenUrunlerdenRastgeleBirUrunSecilir() {
        Random random = new Random();
        List<WebElement> webList = beymen.productList;
        int randomProduct = 1 + random.nextInt(webList.size() - 1);
        webList.get(randomProduct).click();


    }

    @Then("Secilen urunun bilgisi ve tutar bilgisi txt dosyasina yazilir.")
    public void secilenUrununBilgisiVeTutarBilgisiTxtDosyasinaYazilir() throws IOException {
        WebElement urunBilgisi = beymen.productDetailWrapper;
        String productInfo = urunBilgisi.getText();
        File file = new File("dosya.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(file, false);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        bWriter.write(productInfo);
        bWriter.close();


    }

    @Then("Secilen urun sepete eklenir.")
    public void secilenUrunSepeteEklenir() throws InterruptedException {
        Thread.sleep(5000);
        try {
            beymen.urunBedenS.click();
        } catch (Exception e) {
            beymen.urunBeden38.click();
        }
        Thread.sleep(2000);
        //JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //js.executeScript("arguments[0].scrollIntoView(true);", beymen.addBasket);

        beymen.addBasket.click();

        Thread.sleep(5000);



    }

    @Then("Urun sayfasindaki fiyat ile sepette yer alan urun fiyatinin dogrulugu karsilastirilir.")
    public void urunSayfasindakiFiyatIleSepetteYerAlanUrunFiyatininDogruluguKarsilastirilir() throws InterruptedException {

        String price = beymen.priceNew.getText();

        Thread.sleep(2000);

        beymen.sepetim.click();

        Thread.sleep(2000);

        String basketPrice = beymen.sepetFiyat.getText();

        Thread.sleep(2000);

        Assert.assertTrue(basketPrice.contains(price));

    }

    @Then("Adet arttirilarak urun adedinin iki oldugu dogrulanir.")
    public void adetArttirilarakUrunAdedininIkiOlduguDogrulanir() {
        Select select = new Select(beymen.adetDropDown);
        select.selectByValue("2");

        String adetYazi = beymen.adetDropDown.getText();
        Assert.assertTrue(adetYazi.contains("2"));
    }

    @And("Urun sepetten silinerek septin bos oldugu kontrol edilir.")
    public void urunSepettenSilinerekSeptinBosOlduguKontrolEdilir() throws InterruptedException {
        Thread.sleep(2000);

        beymen.deleteBasket.click();

        Thread.sleep(2000);

        String actualYazi = beymen.sepetBosYazisi.getText();
        System.out.println(actualYazi);
        String expectedYazi = "SEPETINIZDE ÜRÜN BULUNMAMAKTADIR";
        Assert.assertTrue(actualYazi.contains(expectedYazi));
        Thread.sleep(5000);
    }


    @And("Sayfa kapatilir.")
    public void sayfaKapatilir() {
        Driver.quitDriver();
    }
}
