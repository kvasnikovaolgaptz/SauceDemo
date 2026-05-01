package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CardTest  extends BaseTest {

    @Test
    public void checkAddCard() {
        cardPage.open();
        cardPage.login("standard_user","secret_sauce");
        cardPage.addProductsToCart();
        cardPage.openCart();
        cardPage.isPageOpened();
        cardPage.setNameProducts();
    }

    @Test
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

    @Test
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

    @Test
    public void checkCheckout(){
        cardPage.open();
        cardPage.login("standard_user","secret_sauce");
        cardPage.addProductsToCart();
        cardPage.openCart();
        cardPage.isPageOpened();
        cardPage.checkout();
        cardPage.isPageCheckoutOpened();
    }

    @Test
    public void check() {
        cardPage.open();
        cardPage.login("standard_user","secret_sauce");
        cardPage.addProductsToCart();
        cardPage.openCart();
        cardPage.isPageOpened();
        cardPage.рroductCounter();
    }
}



