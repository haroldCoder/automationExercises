import org.openqa.selenium.JavascriptExecutor;

public class Test10 implements App {
    void NavigateFooter(){
        JavascriptExecutor js = (JavascriptExecutor) this.driver;

        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        Thread.sleep(300);
    }
}
