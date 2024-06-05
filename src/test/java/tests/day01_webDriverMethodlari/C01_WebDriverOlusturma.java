package tests.day01_webDriverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_WebDriverOlusturma {
    public static void main(String[] args) throws InterruptedException {



        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver");
        /*
            Selenium 4 ile birlikte
            Selenium kendi webDriver ini kodlarin icine koydu

            selenium 4 sonrasinda
            yukarda 11. satirda yazdigimiz driver ayari OPSIYONEL hale geldi

            Eger calistigimi sirket
            ozel bir webDriver kullanmamizi isterse
            bize kullanacagimiz webDriver'in kurulum dosyasini verirler
            bizde 11. satirda verilen WebDriveri tanimlariz

            Eger calistigimiz sirket
            webDriver secimini bize birakirsa
            veya Selenium'un kendi webbDriver'ini kullan derlerse
            14.satiri HİİİCCC Kullanmayiz
         */
        WebDriver driver = new ChromeDriver();

        /*
                Biz web de yapacagimiz tum testler icin webDriver objesine ihtiyac duyariz
                webDriver objesi bizim elimiz gozumuz klavyemiz ve mouse muzdur
                dolayisiyla bir test yazacaksak
                ONCE webDriver objesi olusturmaliyiz

                29.satirda kodu yazdigimiizda
                Selenium esitligin saginda hangi constructor'i kullandi isek
                o browser in bir kopyasini olusturur
                ve bizim kullanimimiza sunar

                olusturulan kopya browser'da
                chrome is beind controlled by automated software yazar


         */

        //test otomasyonu ana sayfasina gidin
        driver.get("https://www.testotomasyonu.com");

        /*
                bir web sayfasina gittigimizde
                webDriver.get("istenenURL") kullanilir


               gitmek istedigimiz web sayfasinin url inde
               www yazmasak da sayfa acilir
               ANCAK Https yazmazdak sayfa acilmaz
         */

        //5 saniye bekleyin
        Thread.sleep(5000);
        /*
                Bu method Java dan gelir
                ve kodlari yazilan milisaniye kadar bekletir

                Biz genelde bir testi ilk defa calistirmak istedigimizde
                adimlarin dogru olarak ilerledigini gormek icin aralara
                Thread.sleep(...); koyariz

                testin uzerinde calismamiz bittiginde
                artik testimiz sorunsuz calisiyor dedigimizde
                Thread.sleep(...); leri silmeniz tavsiye olunur
         */


        //sayfayi kapat
        //driver.quit();
        driver.close();

        /*
        29.satirda
        WebDriver driver = new ChromeDriver(); yazdigimizda
        olusturulan webDriver objesini kapatir

        driver.close(); da ayni islemi yapar
        ancak bazi yeni surumlerde
        driver.close() calismayabilir onun icin quit() tercih edilir

        Selenium kapatma islevi 2 farklı method'la yapma sebebi

        driver.close() : uzerinde calisilan bir browseri kapatir

         driver.quit(); ise test sirasinda birden fazla browser acildi ise
                           actigi tum browser'lari kapatir
         */

    }
}
