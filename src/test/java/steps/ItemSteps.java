package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.MobilePage;
import pages.User;

public class ItemSteps {
    public WebDriver driver = new ChromeDriver();
    public User user = PageFactory.initElements(driver, User.class);
    public MobilePage mobilePage = PageFactory.initElements(driver, MobilePage.class);

    @Given("I go to mobile page")
    public void iGoToMobilePage() {
        driver.manage().window().maximize();
        mobilePage.goToMobile();
    }

    @When("I click on the add to cart button")
    public void iClickOnTheAddToCartButton() {
        user.addToCart();
    }

    @Then("I see cart page")
    public void iSeeCartPage() {
        user.checkCartPage();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
