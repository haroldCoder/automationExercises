import org.openqa.selenium.By;

public class Test11 extends Test10 {
    public Test11(){
        this.HomeVisiblity();
    }

    void ClickCart(){
        driver.findElement(By.xpath("//a[contains(@href, 'view_cart')]")).click();
    }
}
