package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test (priority = 1,
            testName = "Проверка входа в систему с позитивными кредами",
            description = "Проверка входа в систему с позитивными кредами")
    public void checkLoginWithPositiveCred(){
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        assertEquals(productsPage.getTitle(), "Products");
    }

    @Test (priority = 2,
            testName = "Проверка входа в систему с пустым паролем",
            description = "Проверка входа в систему с пустым паролем")
    public void checkLoginWithEmptyPassword(){
        loginPage.open();
        loginPage.login("standard_user","");
        assertEquals(loginPage.getErrorMassage(), "Epic sadface: Password is required");
    }

    @Test (priority = 2,
            testName = "Проверка входа в систему с пустым логином",
            description = "Проверка входа в систему с пустым логином")
    public void checkLoginWithEmptyLogin(){
        loginPage.open();
        loginPage.login("","secret_sauce");
        assertEquals(loginPage.getErrorMassage(), "Epic sadface: Username is required");
    }

    @Test (priority = 3,
            testName = "Проверка входа в систему с негативными кредами",
            description = "Проверка входа в систему с негативными кредами")
    public void checkLoginWithNegativeCred(){
        loginPage.open();
        loginPage.login("privet","privet");
        assertEquals(loginPage.getErrorMassage(), "Epic sadface: Username and password do not match any user in this service");
    }

    @DataProvider(name = "allCheckLoginWithNegativeCred")
    public Object[][] allCheckLoginWithNegativeCred() {
        return new Object[][]{
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"privet", "privet", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(dataProvider = "allCheckLoginWithNegativeCred",
            priority = 4,
            testName = "Проверка входа в систему с вариативностью негативных кредов",
            description = "Проверка входа в систему с вариативностью негативных кредов")
    public void checkLoginWithNegativeValue1(String user, String password, String expectedMessage) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(loginPage.getErrorMassage(),
                expectedMessage,
                "Сообщение не соответствует");
    }
}