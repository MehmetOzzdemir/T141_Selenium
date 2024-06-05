package tests.day01.webDriverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_WebDriverMethodlari {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.testotomasyonu.com");

        System.out.println(driver.getCurrentUrl());
        //driver in icinde oldugu URL i getirir

        System.out.println(driver.getTitle());
        //driverin icinde olduu sayfanin title ini getirir


        System.out.println("===Sayfa Kaynagi==");
        System.out.println(driver.getPageSource());
        //Bütün sayfa kaynagini getirir
        //testlerde cok kullanilmaz


        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getWindowHandles());
        /*
            Bunu ayri bir konu olarak isleyecegiz
            getWindowHandle() driver in icinde oldugu sayfaya atadigi
            unique WindowHableDegerini getirir

            eger test sirasinda
            birden fazla browser acilirsa
            acilan tum sayfalarin WindowHandleDegerlerini
            bir set olarak bize getirir
         */


        Thread.sleep(3000);

        driver.quit();

    }
}
