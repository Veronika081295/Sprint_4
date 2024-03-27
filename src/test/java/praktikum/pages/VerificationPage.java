package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VerificationPage {
    private final WebDriver driver;
    private final By buttonYes = By.xpath(".//div/div[2]/div[5]/div[2]/button[2]");

    public VerificationPage (WebDriver driver){
        this.driver=driver;
    }

    public void clickYesButton() {
        new WebDriverWait(driver, Duration.ofSeconds(6))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonYes));
        //Хотите оформить заказ?
        driver.findElement(buttonYes).click();
    }
}
