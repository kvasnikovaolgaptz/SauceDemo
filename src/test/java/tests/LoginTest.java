package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void checkLoginWithPositiveCred(){
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        assertEquals(productsPage.getTitle(), "Products");
    }

    @Test
    public void checkLoginWithEmptyPassword(){
        loginPage.open();
        loginPage.login("standard_user","");
        assertEquals(loginPage.getErrorMassage(), "Epic sadface: Password is required");
    }

    @Test
    public void checkLoginWithEmptyLogin(){
        loginPage.open();
        loginPage.login("","secret_sauce");
        assertEquals(loginPage.getErrorMassage(), "Epic sadface: Password is required");
    }

    @Test
    public void checkLoginWithNegativeCred(){
        loginPage.open();
        loginPage.login("privet","privet");
        assertEquals(loginPage.getErrorMassage(), "Epic sadface: Username and password do not match any user in this service");
    }
}
