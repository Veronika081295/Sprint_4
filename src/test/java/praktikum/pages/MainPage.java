package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class MainPage {
    private final WebDriver driver;
    private final By buttonOrderTwo = By.cssSelector(".Button_Middle__1CSJM");
    private final By buttonOrderOne = By.className("Button_Button__ra12g");
    private By accordionPanel;
    private By accordionHeading;

    public MainPage (WebDriver driver){
        this.driver=driver;
    }

    public void clickOrderTwo() {
        //вторая кнопка заказать
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(buttonOrderTwo));
        driver.findElement(buttonOrderTwo).click();
    }

    public void clickOrder() {
        driver.findElement(buttonOrderOne).click();
    }

    public void open() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public void checkList(int id, String result) {
        // Прокрутка страницы до последней стрелочки
        accordionPanel = By.id("accordion__panel-" + id);
        accordionHeading = By.id("accordion__heading-" + id);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(accordionHeading));
        driver.findElement(accordionHeading).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(accordionPanel));
        assertEquals(result, driver.findElement(accordionPanel).getText());
    }
}
