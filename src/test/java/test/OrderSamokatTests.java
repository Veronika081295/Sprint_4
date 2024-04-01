package test;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.pages.*;

@RunWith(Parameterized.class)

public class OrderSamokatTests {

    @Rule
    public DriverRule driverRule = new DriverRule();
    private final boolean isHeader;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String phoneNumber;
    private final String metroStation;
    private final String deliveryDate;
    private final String comment;
    private final int daysRent;
    private final String colour;

    public OrderSamokatTests(boolean isHeader, String firstName, String lastName, String address, String metroStation, String phoneNumber, String deliveryDate, int daysRent, String colour, String comment) {
        this.isHeader = isHeader;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.metroStation = metroStation;
        this.deliveryDate = deliveryDate;
        this.daysRent = daysRent;
        this.colour = colour;
        this.comment = comment;

    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][]{
                {true,"Петр", "Иванов", "Москва, ул. Ленина, д. 5", "Черкизовская", "+79998887766", "30.03.2024", 4,"black", "Тест1"},
                {true,"Елена", "Сидорова", "Пирогова, д. 6", "Тверская", "+79543212233", "30.03.2024", 2,"grey", "Тест2"},

                {false,"Нина", "Александрова", "Москва, ул. Маркса, д. 453", "Сокольники", "+79321112233", "30.03.2024", 3,"grey", "Тест3"},
                {false,"Иван", "Петров", "Меридианная, д. 34 к.1", "Лубянка", "+79765453344", "30.03.2024", 1,"black", "Тест4"},

        };
    }

    @Before
    public void init() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.open();
    }
    @Test
    public void testOrderScooter() {
        OrderPage objOrderPage = new OrderPage(driverRule.getDriver());
        RentPage objRentPage = new RentPage(driverRule.getDriver());
        objOrderPage.createOrder(
                isHeader,
                firstName,
                lastName,
                address,
                metroStation,
                phoneNumber);
        objOrderPage.clickOnNextButton();
        objRentPage.aboutRent(
                deliveryDate,
                daysRent,
                colour,
                comment);
        objRentPage.clickOnFinalOrderButton();
        objRentPage.clickOnYesButton();

        // После нажатия кнопки "Да" проверяем состояние модального окна
        objRentPage.checkState();

    }

}
