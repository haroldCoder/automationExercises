import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Test12 extends Test11{
    int productsList = 0;

    void ClickOnProducts(){
        driver.findElement(By.xpath("//a[contains(@href, '/products')]")).click();
    }

    void ClickOnProduct(int product){
        List<WebElement> products = driver.findElements(By.className("col-sm-4"));
        Actions actions = new Actions(driver);

        actions.moveToElement(products.get(product)).perform();

        driver.findElement(By.className("add-to-cart")).click();
        productsList += 1;
    }

    void ContinueShopping(){
        ClickOnProduct(1);
        driver.findElement(By.className("btn-success")).click();
    }

    void GotoCart(){
        ClickOnProducts();
        ClickOnProduct(2);
        ContinueShopping();
        this.ClickCart();
    }

    @Test
    public void FoundProductsIntCart(){
        this.GotoCart();
        for(int i = 1; i<=productsList; i++){
            assertTrue(driver.findElement(By.id("product-"+i)).isDisplayed());
        }
    }
}
