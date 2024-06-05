package tests.day01.webDriverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_WebDriverMethodlari {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("Webdriver.chrome.driver", "src/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        // 1. testotomasyonu sayfasina gidelim. https://www.testotomasyonu
        driver.get("https://www.testotomasyonu.com");

        // 2. Sayfa basligini (title ) yazdirin
        System.out.println(driver.getTitle());
        System.out.println();

        // 3. Sayfa basliginin "Test Otomasyonu" icerdigini test edin
        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("TITLE TEST PASSED");
        } else {
            System.out.println("TITLE TEST FAILED");
        }
        System.out.println();

        // 4.Sayfa adressini(url) yazdirin
        System.out.println(driver.getCurrentUrl());
        System.out.println();

        // 5. Sayfa url nin https://testotomasyonu.com oldugunu test edin
        String expectedUrl = "https://testotomasyonu.com";
        String actualUrl = driver.getCurrentUrl();
        if (expectedUrl.equals(actualUrl)) {
            System.out.println("URL TEST PASSED");
        } else {
            System.out.println("URL TEST FAILED");
            System.out.println("Expected URL : " + expectedUrl);
            System.out.println("Actual URL : " + actualUrl);
        }
        System.out.println();

        // 6. Sayfa Handle degerini yazdirin
        System.out.println(driver.getWindowHandle());
        System.out.println();

        // 7. Sayfa HTML kodlarinda "otomasyon" kelimesi gectigini test edin

        String actualSayfaKaynagi = driver.getPageSource();
        String expectedSayfaKaynagi = "otomasyon";


        if (actualSayfaKaynagi.contains(expectedSayfaKaynagi)) {
            System.out.println("SAYFA KAYNAGI TEST PASSED");
        } else {
            System.out.println("SAYFA KAYNAGI TEST FAILED");
        }
        System.out.println();


        Thread.sleep(3000);
        // SAYFAYİ KAPATIN
        driver.quit();

    }
}
