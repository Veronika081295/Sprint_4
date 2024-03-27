package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.pages.*;

public class PositivTest {
    private DriverRule driverRule=new DriverRule();

    @Before
    public void initDriver() {
        driverRule.initDriver();
    }

    @Test
    public void OrderScooterOneButtonOneTest() {
        // переход на страницу тестового приложения
        WebDriver driver=driverRule.getDriver();

        MainPage main=new MainPage(driver);
        //открытие страницы
        main.open();
        //кликаем заказать на главной страницы
        main.clickOrder();

        PersonalInformationPage personalInformation = new PersonalInformationPage(driver);
        //вводим данные для кого самокат
        personalInformation.enterPersonalInformation("Иван", "Петров", "Ленина д.5", "+79998887766");
        //кликаем далее
        personalInformation.clickNext();

        RentInformationPage rentInformation = new RentInformationPage(driver);
        //вводим информацию о самокате
        rentInformation.enterRentInformation("Тест1");
        //кликаем заказать на страницы аренды
        rentInformation.clickRentButton();

        VerificationPage verification = new VerificationPage(driver);
        //подтверждаем заказ
        verification .clickYesButton();

        VisibleOrderPage visibleOrder = new VisibleOrderPage(driver);
        //ждем сообщения об оформленном заказе
        visibleOrder.visibleOrderProcessed();
    }

    @Test
    public void OrderScooterOneButtonTwoTest() {
        // переход на страницу тестового приложения
        WebDriver driver=driverRule.getDriver();

        MainPage main=new MainPage(driver);
        //открытие страницы
        main.open();
        //кликаем заказать на главной страницы
        main.clickOrder();

        PersonalInformationPage personalInformation = new PersonalInformationPage(driver);
        //вводим данные для кого самокат
        personalInformation.enterPersonalInformationTwo("Анна", "Иванова", "Пирогова д.6 кв.123", "+7123423344");
        //кликаем далее
        personalInformation.clickNext();

        RentInformationPage rentInformation = new RentInformationPage(driver);
        //вводим информацию о самокате
        rentInformation.enterRentInformationTwo("Тест2");
        //кликаем заказать на страницы аренды
        rentInformation.clickRentButton();

        VerificationPage verification = new VerificationPage(driver);
        //подтверждаем заказ
        verification .clickYesButton();

        VisibleOrderPage visibleOrder = new VisibleOrderPage(driver);
        //ждем сообщения об оформленном заказе
        visibleOrder.visibleOrderProcessed();
    }

    @Test
    public void OrderScooterTwoButtonOneTest() {
        // переход на страницу тестового приложения
        WebDriver driver=driverRule.getDriver();

        MainPage main=new MainPage(driver);
        //открытие страницы
        main.open();
        //кликаем заказать на главной страницы
        main.clickOrderTwo();

        PersonalInformationPage personalInformation = new PersonalInformationPage(driver);
        //вводим данные для кого самокат
        personalInformation.enterPersonalInformation("Иван", "Петров", "Ленина д.5", "+79998887766");
        //кликаем далее
        personalInformation.clickNext();

        RentInformationPage rentInformation = new RentInformationPage(driver);
        //вводим информацию о самокате
        rentInformation.enterRentInformation("Тест3");
        //кликаем заказать на страницы аренды
        rentInformation.clickRentButton();

        VerificationPage verification = new VerificationPage(driver);
        //подтверждаем заказ
        verification .clickYesButton();

        VisibleOrderPage visibleOrder = new VisibleOrderPage(driver);
        //ждем сообщения об оформленном заказе
        visibleOrder.visibleOrderProcessed();
    }

    @Test
    public void OrderScooterTwoButtonTwoTest() {
        // переход на страницу тестового приложения
        WebDriver driver=driverRule.getDriver();

        MainPage main=new MainPage(driver);
        //открытие страницы
        main.open();
        //кликаем заказать на главной страницы
        main.clickOrderTwo();

        PersonalInformationPage personalInformation = new PersonalInformationPage(driver);
        //вводим данные для кого самокат
        personalInformation.enterPersonalInformation("Екатерина", "Семенова", "Карла д 7 кв 34", "+79564325544");
        //кликаем далее
        personalInformation.clickNext();

        RentInformationPage rentInformation = new RentInformationPage(driver);
        //вводим информацию о самокате
        rentInformation.enterRentInformationTwo("Тест4");
        //кликаем заказать на страницы аренды
        rentInformation.clickRentButton();

        VerificationPage verification = new VerificationPage(driver);
        //подтверждаем заказ
        verification .clickYesButton();

        VisibleOrderPage visibleOrder = new VisibleOrderPage(driver);
        //ждем сообщения об оформленном заказе
        visibleOrder.visibleOrderProcessed();
    }

    @After
    public void killDriver(){
        driverRule.getDriver().quit();
    }
}
