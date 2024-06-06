package tests.day05_locators_maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Xpath_textKullanimi {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("Webdriver.chrome.driver", "src/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


        //1- https://testotomasyonu.com/addremove/ adresine gidin
        driver.get("https://testotomasyonu.com/addremove/");

        //2- Add Element butonuna basin

        driver.findElement(By.xpath("//button[text()='Add']")).click();


        //3- Remove butonu’nun gorunur oldugunu test edin
        WebElement removeButton = driver.findElement(By.xpath("//button[text()='Remove']"));

        if (removeButton.isDisplayed()) {
            System.out.println("remove Button Display TEST PASS");
        } else {

            System.out.println("remove Button Display TEST FAILED");
        }


        //4- Remove tusuna basin
        removeButton.click();
        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemoveTextElement = driver.findElement(By.xpath("//h2[text()='Add/Remove Elements']"));
        if (addRemoveTextElement.isDisplayed()) {
            System.out.println("Add/Remove Text Display TEST PASS");
        } else {

            System.out.println("Add/Remove Button Display TEST FAILED");
        }


        Thread.sleep(3000);
        driver.quit();
    }

}
