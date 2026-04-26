package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

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
}
