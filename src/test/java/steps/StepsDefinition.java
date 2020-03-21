package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import tests.TestBase;

public class StepsDefinition extends TestBase {

    @Before
    public void setUp() {
        start();
    }

    @Given("I go to login page")
    public void iGoToLoginPage() {
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
    @Severity(SeverityLevel.CRITICAL)
    public void iShouldSeeMessage(String visibility) {
        if (visibility.equals("see")) {
            user.isLoginCorrect();
        } else {
            user.isLoginWrong();
        }
    }

    @After
    public void tearDown() {
        finish();
    }

}