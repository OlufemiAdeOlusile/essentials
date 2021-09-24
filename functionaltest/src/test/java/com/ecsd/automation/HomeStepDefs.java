package com.ecsd.automation;



import com.ecsd.automation.pageobjects.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


/**
 * @author olufemi on 2021-09-22
 */
public class HomeStepDefs {

    private HomePage homePage = new HomePage();


   @Given("^i am on the home page$")
    public void i_am_on_the_home_page() {
        homePage.open();
    }

    @When("i submit the {string} answers with name {string} for the balanced array challenge")
    public void i_submit_the_correct_answers(String successKeyWord, String name) {
        homePage.renderTheChallenge().and().submitChallenge(name, successKeyWord);
    }

    @Then("i should see the message containing {string} displayed")
    public void i_should_see_the_message_(String message) {
        homePage.verifyMessage(message);
    }


}
