package tests;

import org.junit.Test;
import org.openqa.selenium.By;

import pages.LoginPage;
import pages.ProductListPage;

public class LoginTests extends BaseTest {

    String expectedErrorEmptyUsername = "Epic sadface: Username is required";
    String expectedErrorEmptyPassword = " Epic sadface: Username and password do not match any user in this service";
    String expectedErrorEmptyPassword2 = "Epic sadface: Password is required";
    String expectedErrorEmptyKredincijali = "Epic sadface: Username and password do not match any user in this service";
    String lockedUsername = "locked_out_user";
    String expectedErrorLockedUser = "Epic sadface: Sorry, this user has been locked out.";
    By hamburgerMenyBy = By.xpath("//button[@id = 'react-burger-menu-btn']");

    @Test
    public void verifySucessfullLogin(){
        LoginPage loginPage = new LoginPage(driver);
        ProductListPage productListPage = new ProductListPage(driver);
        

        loginPage.goToLoginPage();
        loginPage.login(validUsername, validPassword);
        productListPage.verifySuccessfulLogin();
        
    }
    
    @Test
    public void verifyUnsuccessfullLoginEmptyUsername(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
        loginPage.login("", validPassword);
        loginPage.verifyUnsuccessfullLogin(expectedErrorEmptyUsername);
    }
    @Test
    public void verifyUnsuccessfullPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
        loginPage.login(validUsername, "");
        loginPage.verifyUnsuccessfullLogin(expectedErrorEmptyPassword2);
    }
    @Test

    public void verifyUnsuccessfullPaswordandUsername(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
        loginPage.login("sandra", "1234");
        loginPage.verifyUnsuccessfullLogin(expectedErrorEmptyKredincijali);
        
    }
    @Test
    public void verifyUnsuccessfullLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
        loginPage.login(lockedUsername, validPassword);
        loginPage.verifyUnsuccessfullLogin(expectedErrorLockedUser);

    }
@Test
public void verifySuccessfulLogOut(){
    LoginPage loginPage = new LoginPage(driver);
    ProductListPage productListPage = new ProductListPage(driver);
    
    loginPage.goToLoginPage();
    loginPage.login(validUsername, validPassword);
    productListPage.expandMenu();
    productListPage.logout();
    loginPage.verifySuccessfulLogOut();

}
}
