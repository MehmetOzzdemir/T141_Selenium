package tests.day02_webDriverMethodlari_locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverNavigateMethodlari {
    public static void main(String[] args) throws InterruptedException {

        //System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        //test otomasyonu anasayfasina gidin
        driver.get("https://www.testotomasyonu.com");

        //url in testotomasyonu icerdigini test edin
        String expectedUrl = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl)) {
            System.out.println("Test Otomasyonu URL TEST PASSED");
        } else
            System.out.println("Test Otomasyonu URL TEST FAILED");
        Thread.sleep(3000);
        //youtube sayfasina gidin
        driver.navigate().to("https://www.youtube.com");

        //url in youtube icerdigini test edin
        expectedUrl = "youtube";
        actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl)) {
            System.out.println("Youtube URL TEST PASSED");
        } else
            System.out.println("Youtube URL TEST FAILED");
        Thread.sleep(3000);
        //yeniden test otomasyonu sayfasina donun
        driver.navigate().back();

        //title in "Test Otomasyonu" icerdigini tes edin
        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Test Otomasyonu Title TEST PASSED");
        } else
            System.out.println("Test Otomasyonu Title TEST FAILED");
        Thread.sleep(3000);
        //bir daha youtube sayfasina gidin
        driver.navigate().forward();

        //title in Youtube icerdigini test edin
        expectedTitle = "Youtube";
        actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("YoutubeTitle TEST PASSED");
        } else
            System.out.println("Youtube Title TEST FAILED");


        Thread.sleep(3000);

        driver.quit();

    }
}
