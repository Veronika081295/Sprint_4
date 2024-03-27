package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalInformationPage {
    private final WebDriver driver;
    private final By buttonNext=By.cssSelector(".Button_Middle__1CSJM");
    private final By Name = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/input");
    private final By Surname = By.xpath(".//div/div[2]/div[2]/div[2]/input");
    private final By Address = By.xpath(".//div/div[2]/div[2]/div[3]/input");
    private final By Metro = By.xpath(".//div/div[2]/div[2]/div[4]/div/div/input");
    private final By Station = By.cssSelector("[data-index='1']");
    private final By StationTwo = By.cssSelector("[data-index='2']");
    private final By Phone = By.xpath(".//div/div[2]/div[2]/div[5]/input");

    public PersonalInformationPage (WebDriver driver){
        this.driver=driver;
    }

    public void clickNext() {
        driver.findElement(buttonNext).click();
    }

    public void enterPersonalInformation(String name, String surname, String address, String phoneNumber) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(Name));
        // для кого самокат
        driver.findElement(Name).sendKeys(name);
        driver.findElement(Surname).sendKeys(surname);
        driver.findElement(Address).sendKeys(address);
        driver.findElement(Metro).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(Station));
        driver.findElement(Station).click();
        driver.findElement(Phone).sendKeys(phoneNumber);
    }

    public void enterPersonalInformationTwo(String name, String surname, String address, String phoneNumber) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(Name));
        // для кого самокат
        driver.findElement(Name).sendKeys(name);
        driver.findElement(Surname).sendKeys(surname);
        driver.findElement(Address).sendKeys(address);
        driver.findElement(Metro).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(StationTwo));
        driver.findElement(StationTwo).click();
        driver.findElement(Phone).sendKeys(phoneNumber);
    }
}
