package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import pages.User;

public class TestBase {
    public WebDriver driver;
    public LoginPage loginPage;
    public User user;

    public void start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        user = PageFactory.initElements(driver, User.class);
    }

    public void finish() {
        driver.quit();
    }
}
