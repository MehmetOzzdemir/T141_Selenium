package tests.day04_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_WebElementMethodlari {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.testotomasyonu.com");

        WebElement searchBox = driver.findElement(By.id("global-search"));

        //searchBox.sendKeys("phone"); webelemente yazi yollar

        //searchBox.click(); web elementte click yapar

        //searchBox.getText(); //web element uzerinde text i alir

        //searchBox.submit(); // webelement de ENTER a bamsmak ile ayni islemi yapar

        //searchBox.clear(); // web element de yazi varsa siler

        //searchBox.isDisplayed(); // true-false webelement erisilebiliyor mu sorusunun cevabini verir

        //searchBox.isSelected(); // true-false
        // webelement checkbox veya radio button ise secili mi sorusunun cevabini verir


        System.out.println(searchBox.getAttribute("id")); //global-search
        System.out.println(searchBox.getAttribute("class")); //search-input
        System.out.println(searchBox.getAttribute("naber"));


        Thread.sleep(1000);
        driver.quit();


    }
}
