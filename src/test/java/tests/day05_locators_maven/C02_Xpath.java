package tests.day05_locators_maven;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_Xpath {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("Webdriver.chrome.driver", "src/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //2- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/ ");


        //3- Browseri tam sayfa yapin
        driver.manage().window().maximize();

        //4- Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //5- Sayfa basliginin “Test Otomasyonu” ifadesi icerdigini test edindin
        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Title Test Passed");
        } else {
            System.out.println("Title Test Failed");
        }


        //6- Furniture linkine tiklayin
        driver.findElement(By.xpath("(//a[text()='Furniture'])[3]")).click();


        //7- price range filtresinde min degere 40, max degere 200 yazip filtreleyin
        WebElement minBox = driver.findElement(By.xpath("//input[@name='min']"));
        minBox.clear();
        minBox.sendKeys("40");
        WebElement maxBox = driver.findElement(By.xpath("//input[@name='max']"));
        maxBox.clear();
        maxBox.sendKeys("200", Keys.PAGE_DOWN);
        Thread.sleep(5000);

        // deger yolladiktan sonra Filtre Button basalim
        driver.findElement(By.xpath("//button[text()='Filter Price']")).click();

        //8- filtreleme sonucunda urun bulunabildigini test edin
        List<WebElement> bulunanUrunResimlerList = driver.findElements(By.className("prod-img"));
        if (bulunanUrunResimlerList.size() > 0) {
            System.out.println("PRODUCT TEST PASSED");
        } else {
            System.out.println("PRODUCT TEST FAILED");
        }


        //10-Ilk urunu tiklayin
        bulunanUrunResimlerList.get(0).click();


        //11- Urun fiyatinin 40 ile 200 arasinda oldugunu test edin
        WebElement firstProductElementText = driver.findElement(By.xpath("//span[@id='priceproduct']"));
        String productPriceStr = firstProductElementText.getText().replaceAll("\\D", "");
        double productPrice = Double.parseDouble(productPriceStr) / 100;
        if (productPrice >= 40 && productPrice <= 200) {
            System.out.println("Product Price Test Passed");
        } else
            System.out.println("Product Price Test Failed");


        //12-Sayfayi kapatin

        Thread.sleep(3000);
        driver.quit();


    }
}
