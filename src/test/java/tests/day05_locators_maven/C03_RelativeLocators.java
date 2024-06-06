package tests.day05_locators_maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C03_RelativeLocators {
    public static void main(String[] args) throws InterruptedException {

            /*
            Relative locator selenium 4 ile tanitilan yeni bir ozellik

            EGER
            bir webElement'i gordugumuz ve HTML kodlarina ulastigimiz halde
            locate'imiz calismiyor ve webElement'i kullanamiyorsak

            ve etrafinda kullanabildigimiz baska webElementler varsa

            bu webelementi ulastigimiz bir bilgisi ve
            etrafindaki kullanabildigimiz webElementler sayesinde kullanabiliriz

            WebElement abc = elementin id'si "idAbc" ve suResmin altinda
         */
        System.setProperty("Webdriver.chrome.driver", "src/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1 ) https://testotomasyonu.com/relativeLocators adresine gidin
        driver.get("https://testotomasyonu.com/relativeLocators");


        //2 ) DSLR Camera’yi etrafindaki elementleri kullanarak
        // 3 farkli relative locator ile locate edip tiklayin

        //relative locator i kullanmak icin
        //A- kullanmak istedigimiz WebElemente ait bir locate bilgisi
        //<img id="pic7_thumb" src="https://testotomasyonu.com/uploads/product/1688040635pexels-pixabay-274973-removebg-preview.png" alt="">
        //biz id="pic7_tumb" kullanalim


        //B- etrafinda kullanabilecek bir webElement'e ihtiyacimiz var

        WebElement appleHeadphone = driver.findElement(By.xpath("//*[@id='pic6_thumb']"));

        WebElement dslrCamera = driver.findElement(RelativeLocator
                .with(By.id("pic7_thumb"))
                .toRightOf(appleHeadphone));
        dslrCamera.click();


        //3 ) Acilan urunun DSLR Camera oldugunu test edin.
        WebElement productNameElement = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String expectedName = "DSLR Camera";
        String actualName = productNameElement.getText();

        if (actualName.equals(expectedName)) {
            System.out.println("DSLR CAMERA Test PASSED");
        } else
            System.out.println("DSLR CAMERA Test FAILED");

        Thread.sleep(3000);
        //========================
        //geriye donup baska bir komsu ile bir kere daha locate edelim
        //BatKulaklikligin altinda Diyelim

        driver.get("https://testotomasyonu.com/relativeLocators");


        // relative locator icin 2 bilgiye ihtiyac var

        // A- kullanmak istedigimiz webElementin locate blgisine
        //    biz tagName = 'img' kullanalim

        // B- etrafinda kullanabilecegimiz bir WebElement

        WebElement batHeadPhone = driver.findElement(By.id("pic2_thumb"));
        WebElement dslrCamera2 = driver.findElement(
                RelativeLocator.with(By.tagName("img"))
                        .below(batHeadPhone));
        dslrCamera2.click();

        /*
            StaleElementReferenceException

            Daha onceden locate edip kuıllandigimiz bir WebElementi
            baska sayfalara gittikten sonra yeniden kullanmak istedigimizde olusur

            Selenium bize "tamam o elementi etmistin ama
            o islemden sonra coooook sey degisti,senin locate bayatladi" der
         */

        productNameElement = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        expectedName = "DSLR Camera";
        actualName = productNameElement.getText();

        if (actualName.equals(expectedName)) {
            System.out.println("DSLR CAMERA Test PASSED");
        } else
            System.out.println("DSLR CAMERA Test FAILED");


        Thread.sleep(3000);
        driver.quit();
    }
}
