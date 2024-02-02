import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Test10 extends App {
    void NavigateFooter(){
        WebElement formSubs = driver.findElement(By.className("footer-widget"));

        JavascriptExecutor js = (JavascriptExecutor) this.driver;

        js.executeScript("arguments[0].scrollIntoView(true);", formSubs);
    }

    @Test
    public void VerifyTextSubscript(){
        this.NavigateFooter();
        assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'single-widget')]")).findElement(By.tagName("h2")).getText() != "");
    }

    void SignEmail(){
        this.NavigateFooter();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[contains(@placeholder, 'Your email address')]")).sendKeys("koderxc2005@gmail.com");
        driver.findElement(By.id("subscribe")).click();
    }

    @Test
    public void isSubscribedSuccessfully(){
        this.SignEmail();
        assertTrue(driver.findElement(By.className("alert-success alert")).isDisplayed());
    }

}
