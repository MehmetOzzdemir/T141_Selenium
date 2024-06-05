package tests.day04_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_ByClassName {
    public static void main(String[] args) throws InterruptedException {
        //1-gerekli ayarlari yapin
        //System.setProperty("Webdriver.chrome.driver","kurulumDosyalari/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");

        //3- arama kutusuna phone yazip aratin
        WebElement searchBox = driver.findElement(By.id("global-search"));
        searchBox.sendKeys("phone", Keys.ENTER);
       // searchBox.submit();

        //4- Category bolumunde 8 element oldugunu test edin
        List<WebElement> categoryList= driver.findElements(By.className("panel-list"));

        //5- Category isimlerini yazdirin
        //System.out.println(categoryList);
        //Liste web elementlerden olusuyor ve biz webElementi direk yazdiramayiz
        //yazdirmak icin bir loop ile her bir wenElementi ele alip ,getText()il
        //uzerindeki yaziyi konsolda yazdirabiliriz

        for (WebElement eachElement : categoryList){
            System.out.println(eachElement.getText());
        }


        // arama sonucunda bulunan elementlerin isimlerini yazdirin

        //List<WebElement> urunIsimElementleriList = driver.findElements(By.className("prod-title mb-3 "));
        //System.out.println(urunIsimElementleriList);

        //class attribute unun degerinde karakterler arasinda space varsa
        //By.classname () genelde hata veriri
        //Yani class degerinde bozluk varsa kullanmamayi tercih ederiz


        Thread.sleep(3000);
        //6- Sayfayi kapatin
        driver.quit();

    }
}
