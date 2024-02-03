import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

public class Test13 extends Test12 {
    protected int quantity = 0;

    void viewProduct(int product){
        this.ClickOnProducts();
        driver.findElement(By.xpath(String.format("//a[contains(@href, '/product_details/%s')]", product))).click();
    }

    @Test
    public void isVisibleInfoProduct(){
        this.viewProduct(1);
        assertTrue(driver.findElement(By.className("product-details")).isDisplayed());
    }

    void setQuantity(int value){
        this.quantity = value;
        this.viewProduct(1);
        driver.findElement(By.id("quantity")).clear();
        driver.findElement(By.id("quantity")).sendKeys("4");
    }

    void AddProduct(){
        this.setQuantity(4);
        driver.findElement(By.className("cart")).click();
        this.clicksiginup();
    }

    @Test
    public void VerifyQuantity(){
        this.AddProduct();
        this.ClickCart();
        assertTrue(driver.findElement(By.className("cart_quantity")).findElement(By.className("disabled")).isDisplayed());
    }
}
