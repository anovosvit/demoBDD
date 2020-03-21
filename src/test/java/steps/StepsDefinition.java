package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import pages.User;

@Severity(SeverityLevel.CRITICAL)
public class StepsDefinition {
    public WebDriver driver = new ChromeDriver();
    public User user = PageFactory.initElements(driver, User.class);
    ;
    public LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    ;


    @Given("I go to login page")
    public void iGoToLoginPage() {
        driver.manage().window().maximize();
        loginPage.goToLogin();
    }

    @When("I login as user {string} with password {string}")
    public void iLoginAsUserWithPassword(String email, String password) {
        user.checkAllElementsOnPagePresent()
                .fillInEmail(email)
                .fillInPassword(password)
                .loginButtonClick();
    }

    @Then("I should (see|not see) MY DASHBOARD message$")
    public void iShouldSeeMessage(String visibility) {
        if (visibility.equals("see")) {
            user.isLoginCorrect();
        } else {
            user.isLoginWrong();
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}