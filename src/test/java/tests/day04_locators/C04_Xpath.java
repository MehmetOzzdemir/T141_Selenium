package tests.day04_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Xpath {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver", "src/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //1- https://testotomasyonu.com/addremove/ adresine gidin
        driver.get("https://www.testotomasyonu.com/addremove/");

        //2- Add Element butonuna basin
        // WebElement addButton = driver.findElement(By.xpath("//button[@id='sub-btn']"));
        // addButton.click();
        driver.findElement(By.xpath("//button[@id='sub-btn']")).click();

        //3- Remove butonu’nun gorunur oldugunu test edin
        WebElement removeButton = driver.findElement(By.xpath("//button[@class='remove-btn']"));
        if (removeButton.isDisplayed()){
            System.out.println("Remove Button Test Passed");
        }else
            System.out.println("Remove Button Test Failed");


        //4- Remove tusuna basin
        removeButton.click();

        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        //WebElement addRemoveYaziElementi = driver.findElement(By.xpath("//h2"));
        WebElement addRemoveYaziElementi = driver.findElement(By.tagName("h2"));

        if (addRemoveYaziElementi.isDisplayed()){
            System.out.println("Add Remove Yazisi Test Passed");
        }else
            System.out.println("Add Remove Yazisi Test Failed");








        Thread.sleep(3000);
        driver.quit();

    }
}
