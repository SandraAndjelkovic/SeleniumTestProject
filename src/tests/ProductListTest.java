package tests;

import org.junit.Test;

import pages.CartPage;
import pages.LoginPage;
import pages.ProductListPage;

public class ProductListTest  extends BaseTest{
    
    String expectedCartPageTitle ="Your Cart";
    String expectedFirstItemNameLoHi = "Sauce Labs Onesie";
    String expectedFirstItemNameHilo = "Sauce Labs Fleece Jacket";
    String expectedAddToCart = "Sauce Labs Backpack";

    @Test

    public void VerifyCartNavigation(){

    LoginPage loginPage = new LoginPage(driver);
    ProductListPage productListPage = new ProductListPage(driver);
    CartPage cartPage = new CartPage(driver);

    loginPage.goToLoginPage();
    loginPage.login(validUsername, validPassword);
    productListPage.navigateToCartPage();
    cartPage.verifyCartNavigation(expectedCartPageTitle);
    }
    

    @Test
    public void veruifySortByPriceLowToHigh(){
        LoginPage loginPage = new LoginPage(driver);
        ProductListPage productListPage = new ProductListPage(driver);

        loginPage.goToLoginPage();
        loginPage.login(validUsername, validPassword);
        productListPage.sortProduct("lohi");
        productListPage.verifyFirstItemName(expectedFirstItemNameLoHi);

    }
    
        @Test

        public void verifySortByPriceHighToLow(){
        LoginPage loginPage = new LoginPage(driver);
        ProductListPage productListPage = new ProductListPage(driver);

        loginPage.goToLoginPage();
        loginPage.login(validUsername, validPassword);
        productListPage.sortProduct("hilo");
        productListPage.verifyFirstItemName(expectedFirstItemNameHilo);

        }
    
    @Test 

    public void verifyNumberOfProducts(){
        LoginPage loginPage = new LoginPage(driver);
        ProductListPage productListPage = new ProductListPage(driver);
        loginPage.goToLoginPage();
        loginPage.login(validUsername, validPassword);
        productListPage.verifyNumberOfProducts(6);

    }
    @Test

    public void addProductsToCart(){
        
        LoginPage loginPage = new LoginPage(driver);
        ProductListPage productListPage = new ProductListPage(driver);
        loginPage.goToLoginPage();
        loginPage.login(validUsername, validPassword);
        
        


    }

     


}
