package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VisibleOrderPage {
    private final WebDriver driver;
    private final By orderStatus = By.cssSelector(".Order_Modal__YZ-d3");


    public VisibleOrderPage (WebDriver driver){
        this.driver=driver;
    }
    public void visibleOrderProcessed() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(orderStatus));
        assert driver.findElement(orderStatus).isDisplayed();
    }
}
