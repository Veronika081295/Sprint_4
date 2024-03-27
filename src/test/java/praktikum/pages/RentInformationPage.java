package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RentInformationPage {
    private final WebDriver driver;
    private final By buttonOrder = By.xpath(".//div/div[2]/div[3]/button[2]");
    private final By date = By.cssSelector("[aria-label='Choose суббота, 30-е марта 2024 г.']");
    private final By term = By.className("Dropdown-placeholder");
    private final By day = By.xpath("//div/div[2]/div[2]/div[2]/div[2]/div[1]");
    private final By color = By.id("black");
    private final By colorTwo = By.id("grey");
    private final By Comment = By.xpath(".//div/div[2]/div[2]/div[4]/input");
    private final By calendar=By.xpath(".//div/div[2]/div[2]/div[1]/div[1]/div/input");

    public RentInformationPage (WebDriver driver){
        this.driver=driver;
    }

    public void clickRentButton() {
        driver.findElement(buttonOrder).click();
    }

    public void enterRentInformation(String comment) {
        new WebDriverWait(driver, Duration.ofSeconds(6))
                .until(ExpectedConditions.visibilityOfElementLocated(calendar));
        // про аренду
        driver.findElement(calendar).click();
        driver.findElement(date).click();
        driver.findElement(term).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(day));
        driver.findElement(day).click();
        driver.findElement(color).click();
        driver.findElement(Comment).sendKeys(comment);
    }
    public void enterRentInformationTwo(String comment) {
        new WebDriverWait(driver, Duration.ofSeconds(6))
                .until(ExpectedConditions.visibilityOfElementLocated(calendar));
        // про аренду
        driver.findElement(calendar).click();
        driver.findElement(date).click();
        driver.findElement(term).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(day));
        driver.findElement(day).click();
        driver.findElement(colorTwo).click();
        driver.findElement(Comment).sendKeys(comment);
    }
}
