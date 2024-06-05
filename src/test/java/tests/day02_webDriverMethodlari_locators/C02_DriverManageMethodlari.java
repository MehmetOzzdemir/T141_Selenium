package tests.day02_webDriverMethodlari_locators;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_DriverManageMethodlari {
    public static void main(String[] args) throws InterruptedException {

        /*
            Bir web sayfasi ne kadar cok data barindirirsa
            server'dan o datalariin client tarafina yollanmasi o kadar uzun surecektir

            bizim istedigimiz web elementlerin sayfaya yuklenmesi zaman alacaktır
            bu gecikmeler de  kodumuzun dinamik olarak beklemesini saglamak icin
            implicitlyWait tanimlariz

            implicitlyWait icerisine yazdigimiz 10 saniye
            maximum bekleme suresidir
            eger 10 sn den once sayfa yuklenir veya aranan webelement bulunursa
            kodlar calismaya devam eder
            10 saniye bekledigimiz halde sayfa acilmaz
            veya aradigimiz webelement bulunamazsa
            exception firlatip , calismayi durdururğp

         */

        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        System.out.println("Maximize Position " + driver.manage().window().getPosition());
        System.out.println("Maximize Size " + driver.manage().window().getSize());
        Thread.sleep(3000);


        driver.manage().window().fullscreen();
        System.out.println("Fullscreen Position " + driver.manage().window().getPosition());
        System.out.println("Fullscreen Size " + driver.manage().window().getSize());
        Thread.sleep(3000);

        driver.manage().window().minimize();
        System.out.println("Minimize Position " + driver.manage().window().getPosition());
        System.out.println("Minimize Size " + driver.manage().window().getSize());
        Thread.sleep(3000);

        //browser in baslangic noktasini 300,300
        //boyutunu da 500,500

        driver.manage().window().setPosition(new Point(300, 300));
        driver.manage().window().setSize(new Dimension(500, 500));
        System.out.println("Special Position " + driver.manage().window().getPosition());
        System.out.println("Special Size " + driver.manage().window().getSize());
        Thread.sleep(3000);




        driver.quit();


    }
}
