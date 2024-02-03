import org.openqa.selenium.By;

public class Test13 extends Test12 {
    void viewProduct(int product){
        this.ClickOnProducts();
        driver.findElements(By.className("nav-pills")).get(product).click();
    }
}
