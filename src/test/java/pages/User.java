package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    public User sortItemsByName() {
        new Select(driver.findElement(By.cssSelector("select[title=\"Sort By\"]"))).selectByVisibleText("Name");
        return this;
    }

    public User checkSortList() {
        List<String> itemNames = new ArrayList<>();
        for (WebElement item : driver.findElements(By.className("item last"))) {
            itemNames.add(item.getText());
        }
        List<String> expectedList = new ArrayList<>(itemNames);
        Collections.sort(expectedList);
        assertEquals(expectedList, itemNames);
        return this;
    }

    public User addToCart() {
        click(By.xpath("//button[@title='Add to Cart']"));
        return this;
    }

    public User checkCartPage() {
        isElementDisplayed(By.xpath("//h1[text()='Shopping Cart']"));
        return this;
    }
}
