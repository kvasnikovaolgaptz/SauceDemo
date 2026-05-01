package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CardTest  extends BaseTest {

    @Test (priority = 1,
            testName = "Проверка добавления товара в корзину",
            description = "Проверка добавления товара в корзину")
    public void checkAddCard() {
        cardPage.open();
        cardPage.login("standard_user","secret_sauce");
        cardPage.addProductsToCart();
        cardPage.openCart();
        cardPage.isPageOpened();
        cardPage.setNameProducts();
    }

    @Test (priority = 2,
            testName = "Проверка удаления товара из корзины",
            description = "Проверка удаления товара из корзины")
    public void checkRemove(){
        cardPage.open();
        cardPage.login("standard_user","secret_sauce");
        cardPage.addProductsToCart();
        cardPage.openCart();
        cardPage.isPageOpened();
        cardPage.setNameProducts();
        cardPage.removeBackpack();
        cardPage.setNameProduct();
    }

    @Test (priority = 4,
            testName = "Проверка переход на страницу продолжения покупок",
            description = "Проверка переход на страницу продолжения покупок")
    public void checkContinueShopping(){
        cardPage.open();
        cardPage.login("standard_user","secret_sauce");
        cardPage.addProductsToCart();
        cardPage.openCart();
        cardPage.isPageOpened();
        cardPage.setNameProducts();
        cardPage.removeBackpack();
        cardPage.setNameProduct();
        cardPage.continueShopping();
        cardPage.isPageOpened();
    }

    @Test (priority = 3,
            testName = "Проверка перехода для оформления заказа",
            description = "Проверка перехода для оформления заказа")
    public void checkCheckout(){
        cardPage.open();
        cardPage.login("standard_user","secret_sauce");
        cardPage.addProductsToCart();
        cardPage.openCart();
        cardPage.isPageOpened();
        cardPage.checkout();
        cardPage.isPageCheckoutOpened();
    }

    @Test (priority = 3,
            testName = "Проверка счетчика товаров в корзине",
            description = "Проверка счетчика товаров в корзине")
    public void checkCounterPoducts() {
        cardPage.open();
        cardPage.login("standard_user","secret_sauce");
        cardPage.addProductsToCart();
        cardPage.openCart();
        cardPage.isPageOpened();
        cardPage.рroductCounter();
    }
}



