package tests.day04_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_ByLinkText {
    public static void main(String[] args) throws InterruptedException {


        //1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //2- https://www.automationexercise.com/ adresine gidin

        driver.get("https://www.automationexercise.com/ ");
        Thread.sleep(1000);

        // cookies kabul edin
       // List<WebElement> cookiesKabulListe = driver.findElements(By.className("fc-button-label"));
       // cookiesKabulListe.get(0).click();
       // Thread.sleep(1000);

        //3- Sayfada 147 adet link bulundugunu test edin.
        List<WebElement> linkElementList = driver.findElements(By.tagName("a"));
        System.out.println(linkElementList.size());
        int expectedLinkNumber = 147;
        int actualLinkNumber = linkElementList.size();

        if (expectedLinkNumber ==actualLinkNumber){
            System.out.println("Link Number Test PASSED");
        }else {
            System.out.println("Link Number Test FAILED");
        }

        //4- Products linkine tiklayin
        //WebElement productLinkElementi = driver.findElement(By.linkText(" Products"));
        //productLinkElementi.click();
        // bunu bulamadigi icin partialLinkText()

        WebElement productPartialLinkTextElement = driver.findElement(By.partialLinkText("Products"));
        productPartialLinkTextElement.click();

        //5- special offer yazisinin gorundugunu test edin

        WebElement specialOffer = driver.findElement(By.id("sale_image"));
        if (specialOffer.isDisplayed()){
            System.out.println("Special Offer Test Passed");
        }else
            System.out.println("Special Offer Test Failed");


        //6- Sayfayi kapatin
        Thread.sleep(3000);

        driver.quit();
    }
}
