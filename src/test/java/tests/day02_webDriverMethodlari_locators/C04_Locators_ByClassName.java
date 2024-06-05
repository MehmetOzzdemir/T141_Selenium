package tests.day02_webDriverMethodlari_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_Locators_ByClassName {
    public static void main(String[] args) throws InterruptedException {

        // gerekli ayarlari yapin
        System.setProperty("Webdriver.chrome.driver", "src/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // arama kutusunu locate edip kaydedin
        WebElement searchBox = driver.findElement(By.id("global-search"));

        // dress icin arama yapin
        searchBox.sendKeys("dress" + Keys.ENTER);
        //searchBox.submit();


        // bulunan urun sayisinin 3'den fazla oldugunu test edin
        //arama sonuc yazisini bir web element olarak kaydedeliö

        WebElement sonucYaziElementi = driver.findElement(By.className("product-count-text"));
        System.out.println(sonucYaziElementi);
        //Web elementler direk olarak YAZDIRILAMAZ
        //eger webelement uzerindeki yaziya ulasmak istersek

        String actualSonucYazisi = sonucYaziElementi.getText(); // 10 Products Found

        actualSonucYazisi = actualSonucYazisi.replaceAll("\\D", "");
        int bulunanSonucSayisi = Integer.parseInt(actualSonucYazisi); //10

        if (bulunanSonucSayisi > 3) {
            System.out.println("Dress Search TEST PASSED");
        } else {
            System.out.println("Dress Search TEST FAILED");
        }


        //2.bir yontemle daha test edelim
        List<WebElement> bulunanUrunResimlerList = driver.findElements(By.className("prod-img"));
        if (bulunanUrunResimlerList.size() > 3) {
            System.out.println("2. Yontemle Dress Search TEST PASSED");
        } else {
            System.out.println("2. Yontemle Dress Search TEST FAILED");
        }

        Thread.sleep(3000);
        // sayfayi kapatin
        driver.quit();
    }
}
