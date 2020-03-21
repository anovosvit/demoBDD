package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class User extends BasePage {
    public User(WebDriver driver) {
        super(driver);
    }

    public User fillInEmail(String login) {
        writeText(By.xpath("//input[@id='email']"), login);
        return this;
    }

    public User fillInPassword(String password) {
        writeText(By.xpath("//input[@id='pass']"), password);
        return this;
    }

    public User loginButtonClick() {
        click(By.xpath("//button[@id='send2']"));
        return this;
    }

    public User checkAllElementsOnPagePresent() {
        isElementDisplayed(By.xpath("//input[@id='email']"));
        isElementDisplayed(By.xpath("//input[@id='pass']"));
        isElementDisplayed(By.xpath("//button[@id='send2']"));
        return this;
    }

    public User isLoginCorrect() {
        isElementDisplayed(By.xpath("//h1[text()='My Dashboard']"));
        return this;
    }

    public User isLoginWrong() {
        isElementDisplayed(By.xpath("//li[@class='error-msg']"));
        return this;
    }

    public User checkPageInfo() {
        isTextCorrect("LOGIN OR CREATE AN ACCOUNT", By.tagName("h1"));
        return this;
    }
}
