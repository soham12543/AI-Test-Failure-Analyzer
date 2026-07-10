package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(className = "title")
    private WebElement productsTitle;

    public void enterUsername(String user) {
        type(username, user);
    }

    public void enterPassword(String pass) {
        type(password, pass);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }

    public boolean isProductsPageDisplayed() {
        return isDisplayed(productsTitle);
    }
}



