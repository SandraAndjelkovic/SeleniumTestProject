package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    String baseUrl = "https://www.saucedemo.com/";
    By usernameInputBy = By.id("user-name");
    By passwordInputBy = By.id("password");
    By loginBtnBy = By.id("login-button");
    By errorElementBy = By.xpath("//h3[@data-test='error']");
    
    public LoginPage goToLoginPage(){
        driver.get(baseUrl);
        return this;
    }

    public LoginPage login(String username, String password){
        entertext(usernameInputBy, username);
        entertext(passwordInputBy, password);
        clikElement(loginBtnBy);
        return this;
    }
    public LoginPage verifyUnsuccessfullLogin(String expectedError){
        String actualErrorMessage = readText(errorElementBy);
        verifyTextIsTheSame(expectedError, actualErrorMessage);
        return this;
    }
    
 public LoginPage verifySuccessfulLogOut(){
    verifyElementIsVisible(loginBtnBy);
    return this;

 }
}
