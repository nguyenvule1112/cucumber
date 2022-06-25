package stepdeginitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Loginpage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class loginStepDefinitions {
    Loginpage loginpage;

    public loginStepDefinitions()
    {
        this.loginpage = new Loginpage(Hooks.driver);
    }

    @Given("^The login page is show$")
    public void the_login_page_is_showed()  {
        this.loginpage.open();
    }

    @When("^The user attempt to login with the username \"([^\"]*)\" and wrong password \"([^\"]*)\"$")
    public void the_user_attempt_to_login_with_the_username_and_wrong_password(String username, String password)  {
        this.loginpage.loginwithUsernameandPassword(username,password);
    }

    @Then("^The popup with message \"([^\"]*)\" will be show$")
    public void the_popup_with_message_will_be_show(String errorMsg)  {
        assertThat(this.loginpage.getPopupMsg(), equalTo(errorMsg));
    }
}
