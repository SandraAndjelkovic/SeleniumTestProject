package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductListPage extends BasePage{
    public ProductListPage(WebDriver driver){
        super(driver);
    }

    String expectedPageTitle = "Products";
    By pageTitleBy = By.xpath("//span[@class='title']");
    By hamburgerMenuBy = By.xpath("//button[@id = 'react-burger-menu-btn']");
    By logoutLinkBy = By.id("logout_sidebar_link");
    By cartBtnBy = By.id("shopping_cart_container");
    By sortBtnBy = By.xpath("//select[@class = 'product_sort_container']");
    By itemNamesBy = By.xpath("//div[@class='inventory_item_name ']");
    public ProductListPage verifySuccessfulLogin(){
        String actualText = readText(pageTitleBy);
        verifyTextIsTheSame(expectedPageTitle, actualText);
        return this;
    }
        public ProductListPage expandMenu(){
            clikElement(hamburgerMenuBy);
            return this;
        }

        public ProductListPage logout(){
            clikElement(logoutLinkBy);
            return this;


        }
        public ProductListPage navigateToCartPage(){
        clikElement(cartBtnBy);
            return this;
        }


        public ProductListPage sortProduct(String sortValue){
         selectOptionByValue(sortBtnBy, sortValue);
            return this;
        }

        public ProductListPage verifyFirstItemName(String expectedProductName){
            String actualProductTitle = readText(itemNamesBy);
            verifyTextIsTheSame(expectedProductName, actualProductTitle);
            return this;
        }
  }



