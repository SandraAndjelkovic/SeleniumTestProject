package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public WebDriver driver;
    String validUsername = "standard_user";
    String validPassword = "secret_sauce";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        
    }

    @After
    public void tearDown() {
        driver.quit();
    }
    
}
