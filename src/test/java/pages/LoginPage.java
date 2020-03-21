package pages;

import org.openqa.selenium.WebDriver;

public class LoginPage {
    final String url = "http://live.demoguru99.com/index.php/customer/account/login/";
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToLogin() {
        driver.get(url);
    }

}
