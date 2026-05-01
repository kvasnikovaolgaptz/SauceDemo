package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import tests.BaseTest;

import static org.testng.Assert.assertEquals;

public class CardPage extends BasePage {

    private final By USERNANE_FIELD = By.xpath("//*[@id='user-name']");
    private final By PASSWORD_FIELD = By.xpath("//*[@id='password']");
    private final By LOGIN_BUTTON = By.xpath("//*[@id='login-button']");
    private final By PRODUCT_BACKPACK = By.id("add-to-cart-sauce-labs-backpack");// рюкзак
    private final By PRODUCT_BIKE_LIGHT = By.id("add-to-cart-sauce-labs-bike-light");// фонарь для велика
    private final By BUTTON_REMOVE = By.id("remove-sauce-labs-backpack");// локатор кнопки ремув рюкзак
    private final By BUTTON_CONTINUE_SHOPPING = By.id("continue-shopping");// локатор кнопки продолжить покупки
    private final By CART_BUTTON = By.id("shopping_cart_container");//локатор корзины
    private final By PAGE_TITLE = By.className("title");
    private final By NAME_PRODUCT_BACKPACK = By.xpath("//*[text()='Sauce Labs Backpack']");//
    private final By NAME_PRODUCT_BIKE_LIGHT = By.xpath("//*[text()='Sauce Labs Bike Light']");
    private final By BUTTON_CHECKOIUT = By.id("checkout");
    private final By CARD_BADGE = By.className("shopping_cart_badge");

    public CardPage(WebDriver driver) {
        super(driver);
    };

    // Открываем страницу по указанному URL
    public void open() {
            driver.get(BASE_URL);
        };
    //логинимся
   public void login(String user, String password){
        driver.findElement(USERNANE_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    };
    // добавляем рюкзак и фонарь
    public void addProductsToCart (){
        driver.findElement(PRODUCT_BACKPACK).click();
        driver.findElement(PRODUCT_BIKE_LIGHT).click();
        };
    //открываем корзину
    public void openCart() {
        driver.findElement(CART_BUTTON).click();
    }
    //проверка, что находимся на странице с корзиной
    public boolean isPageOpened() {
        return driver.findElement(PAGE_TITLE).isDisplayed();
    }
    //проверка, что в корзине рюкзак и фонарь
    public void setNameProducts() {
        String name1 = driver.findElement(NAME_PRODUCT_BACKPACK).getText();
        String name2 = driver.findElement(NAME_PRODUCT_BIKE_LIGHT).getText();
        Assert.assertEquals(name1,"Sauce Labs Backpack");//сравнивает
        Assert.assertEquals(name2,"Sauce Labs Bike Light");//сравнивает
    }
   //удалить из корзины
    public void removeBackpack() {
        driver.findElement(BUTTON_REMOVE).click();
    }
    //проверка, что в корзине остался фонарь
    public void setNameProduct() {
        String name = driver.findElement(NAME_PRODUCT_BIKE_LIGHT).getText();
        Assert.assertEquals(name,"Sauce Labs Bike Light");//сравнивает
    }
   //нажать кнопку продолжить покупки
    public void continueShopping(){
      driver.findElement(BUTTON_CONTINUE_SHOPPING).click();
    }
    //проверка информации
    public void checkout() {
        driver.findElement(BUTTON_CHECKOIUT).click();
    }
     public void isPageCheckoutOpened() {
       String text = driver.findElement(PAGE_TITLE).getText();
       Assert.assertEquals(text,"Checkout: Your Information");
    }
    //счетчик
    public boolean рroductCounter() {
        return driver.findElement(CARD_BADGE).isDisplayed();
    }
}







