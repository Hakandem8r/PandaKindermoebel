import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class UserStory_1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\PandaKindermoebel_SeleniumProject\\ChromeDriver\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://pandakindermoebel.ch/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        WebElement cookies=driver.findElement(By.xpath("//button[@aria-label='Akzeptiere alle']"));
        cookies.click();

        WebElement meinKonto=driver.findElement(By.xpath("(//a[span='Mein Konto'])[2]"));
        meinKonto.click();

        Thread.sleep(500); //Nur um zu sehen
        WebElement registrieren=driver.findElement(By.id("bb-show-register-button"));
        registrieren.click();

        WebElement benutzerName=driver.findElement(By.id("reg_username"));
        benutzerName.sendKeys("hakandem8r");

        WebElement email=driver.findElement(By.id("reg_email"));
        email.sendKeys("hakandemr@gmail.com");

        WebElement password=driver.findElement(By.id("reg_password"));
        password.sendKeys("S123456789.9!^");

        WebElement neuesKonto=driver.findElement(By.xpath("//button[@name='register']"));
        neuesKonto.click();

        WebElement backToHomePage=driver.findElement(By.xpath("(//img[@class='site-logo'])[2]"));
        backToHomePage.click();

        Thread.sleep(1000);  //Nur um zu sehen

        Actions act=new Actions(driver);

        List<WebElement> menubarList=driver.findElements(By.xpath("(//ul[@class='dropdown menu'])[2]/li"));
        for (WebElement element:menubarList) {
            act.moveToElement(element).perform();
            Thread.sleep(500);
        }

        List<WebElement> menubarRandom=driver.findElements(By.xpath("(//ul[@class='dropdown menu'])[2]/li"));
        menubarRandom.get(new Random().nextInt(menubarRandom.size())).click();


        driver.quit();
    }
}
