package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class searchLocators extends BaseTest{

    @Test
    public void test(){
        driver.get("https://www.saucedemo.com/"); // Открывает страницу по указанному URL

        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys("standard_user");//вводим логин
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce");//вводим пароль
        driver.findElement(By.xpath("//*[@id='login-button']")).click();//нажимаем кнопку авторизации

        driver.findElement(By.id("root"));// ПОИСК ПО id
        driver.findElement(By.name("viewport"));// ПОИСК  по имени
        driver.findElement(By.className("footer"));// ПОИСК ПО названию класса
        driver.findElement(By.tagName("footer"));// ПОИСК ПО тегу
        driver.findElement(By.linkText("Twitter"));// ПОИСК ПО ссылке
        driver.findElement(By.partialLinkText("Twitter"));// ПОИСК ПО части ссылки

        //xpath
        driver.findElement(By.xpath("//div[@id='root']"));// ПОИСК ПО атрибуту
        driver.findElement(By.xpath("//*[text()='Products']"));// ПОИСК ПО тексту
        driver.findElement(By.xpath("//div[contains(@id,'wrapper')]"));// ПОИСК по частичному совпадению атрибута
        driver.findElement(By.xpath("//div[contains(text(),'Backpack')]"));// ПОИСК по частичному совпадению текста
        driver.findElement(By.xpath("//div[@id='root']/ancestor::body"));// ancestor
        driver.findElement(By.xpath("//div[@id='root']/descendant::div[@id='']"));// - descendant
        driver.findElement(By.xpath("//div/following::a[@data-test='social-twitter']"));// - - following
        driver.findElement(By.xpath("//a[@id='about_sidebar_link']/parent::nav"));// - - parent, поиск родительского элемента
        driver.findElement(By.xpath("//div[@class='header_label']/preceding::div[1]"));// - preceding
        driver.findElement(By.xpath("//a[@id='about_sidebar_link' and @class='bm-item menu-item']"));// - // - *поиск элемента с условием AND

         //css
        driver.findElement(By.cssSelector(".footer"));// ПОИСК ПО названию класса
        driver.findElement(By.cssSelector(".footer .social"));// ПОИСК ПО названию класса
        driver.findElement(By.cssSelector("#root"));// ПОИСК ПО id
        driver.findElement(By.cssSelector("[name = 'viewport']"));// к любому тегу по значению
        driver.findElement(By.cssSelector("[class = 'bm-item-list']"));// tagname.class
        driver.findElement(By.cssSelector("[class = 'bm-item-list']"));// [attribute=value]
        driver.findElement(By.cssSelector("[class ~= 'bm-item-list']"));// [attribute~=value]
        driver.findElement(By.cssSelector("[class |= 'bm-item-list']"));// [attribute|=value]
        driver.findElement(By.cssSelector("[class ^= 'bm-item-list']"));// [attribute^=value]
        driver.findElement(By.cssSelector("[class $= 'bm-item-list']"));// [attribute$=value]
        driver.findElement(By.cssSelector("[class *= 'bm-item-list']"));// [attribute*=value]
        driver.quit(); // закрывает полностью браузер
    }
}

