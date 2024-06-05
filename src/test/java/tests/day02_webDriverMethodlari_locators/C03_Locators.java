package tests.day02_webDriverMethodlari_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Locators {
    public static void main(String[] args) throws InterruptedException {
        /*
            dr,ver method lari ile yapabilecegimiz islemler sinirlidir

            biz testlerimiz otomasyon ile ccalistirma istedigimizde
            driver a uzerinde calismasini istedigimiz webelementleri tarif etmeliyiz

            selenium driver a webelementleri tarif edebilecegimiz
            8 adet tarif edici (locator) olusturmustur

            ilk 6 tanesi web element in HTML kodlarina bagimlidir
            -By.id() : HTML kodlarinda id attribute u varsa kullanabiliriz , yoksda kullanamayiz
            -By.classname
            -By.name: HTML kodlarinda name attribute u varsa kullanabiliriz , yoksda kullanamayiz
            -By.tagname
            -By.linkText
            -By.partialLinkText

            son iki tanesi ise her turlu webElement'te calisacak sekilde dizayn edilmistir
            -By.xpath()
            -By.cssSelector()

            bu locator lar sayesinde driver a webelementi tarif edebiliriz
         */

        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //testotomasyonu anasayfasina gidin
        driver.get("https://www.testotomasyonu.com");

        //arama kutusunu locate edip,bir webelement olarak kaydedin
        WebElement searchBox = driver.findElement(By.id("global-search"));



        //arama kutusuna phone yazip aratin
        searchBox.sendKeys("phone");


        Thread.sleep(5000);

        searchBox.submit();

        Thread.sleep(5000);

        driver.quit();




    }
}
