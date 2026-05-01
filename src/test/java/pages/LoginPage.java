package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private final By USERNANE_FIELD = By.xpath("//*[@id='user-name']");  //final прописывается большими буквами
    private final By PASSWORD_FIELD = By.xpath("//*[@id='password']");
    private final By LOGIN_BUTTON = By.xpath("//*[@id='login-button']");
    private final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open(){
        driver.get(BASE_URL); // Открывает страницу по указанному URL
    }

    public void login(String user, String password){
        driver.findElement(USERNANE_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String getErrorMassage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
