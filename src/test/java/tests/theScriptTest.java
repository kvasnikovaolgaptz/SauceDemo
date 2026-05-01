package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class theScriptTest extends BaseTest{
    @Test
    public void script(){
        driver.get("https://www.saucedemo.com/"); // Открывает страницу по указанному URL

        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user");//вводим логин
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce");//вводим пароль
        driver.findElement(By.xpath("//*[@id='login-button']")).click();//нажимаем кнопку авторизации
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")).click();//выбрала товар
        driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a")).click();//перешла в корзину
        String nameProduct = driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']")).getText();
        Assert.assertEquals(nameProduct,"Sauce Labs Backpack");//сравнивает

        String cost = driver.findElement(By.xpath("//*[@id='cart_contents_container']/div/div[1]/div[3]/div[2]/div[2]/div")).getText();
        Assert.assertEquals(cost,"$29.99");//сравнивает
        driver.quit(); // закрывает полностью браузер
    }

    public static class LoginTest extends BaseTest {

        @Test (priority = 1,
                testName = "Проверка входа в систему позитивными кредами")
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
                testName = "Проверка входа в систему негативными кредами",
                description = "Проверка входа в систему негативными кредами")
        public void checkLoginWithNegativeCred(){
            loginPage.open();
            loginPage.login("privet","privet");
            assertEquals(loginPage.getErrorMassage(), "Epic sadface: Username and password do not match any user in this service");
        }

        @DataProvider(name = "inputNegativeCred" )
        public Object[][] inputNegativeCred() {
            return new Object[][]{
                    {"standard_user", "", "Epic sadface: Password is required"},
                    {"", "secret_sauce", "Epic sadface: Username is required"},
                    {"privet", "privet", "Epic sadface: Username and password do not match any user in this service"}
            };
        }

        @Test (priority = 4,
                dataProvider = "inputNegativeCred",
                testName = "Проверка входа в систему с вариантами негативных кредов",
                description = "Проверка входа в систему с вариантами негативных кредов")
        public void checkLoginWithNegativeCredAll (String user, String password, String expectedMessage)  {
            loginPage.open();
            loginPage.login(user, password);
            assertEquals(loginPage.getErrorMassage(), expectedMessage);
            }

    }
}
