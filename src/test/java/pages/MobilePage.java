package pages;

import org.openqa.selenium.WebDriver;

public class MobilePage {
    final String url = "http://live.demoguru99.com/index.php/mobile.html";
    WebDriver driver;

    public MobilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToMobile() {
        driver.get(url);
    }
}
